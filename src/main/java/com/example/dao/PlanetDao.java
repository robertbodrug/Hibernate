package com.example.dao;

import com.example.model.Client;
import com.example.model.Planet;
import com.example.utils.HibernateUtil;
import com.example.utils.ValidatorUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class PlanetDao {
    private  final SessionFactory sessionFactory = HibernateUtil.getInstance().getSessionFactory();
    private static final String GET_ALL_PLANETS_QUERY= "FROM Planet";
    //"SELECT id,name FROM planet"
    public  boolean create(Planet planet) throws RuntimeException {
        if(ValidatorUtil.validate(planet)) {
            try(Session session = sessionFactory.openSession();){
                Transaction transaction = session.beginTransaction();
                session.persist(planet);
                transaction.commit();
                return true;
            }
        }else {
            throw new RuntimeException("Invalid name for planet"+planet);
        }
    }
    public  Planet getPlanetById(String id) throws RuntimeException {
        if(ValidatorUtil.validate(id)) {
            try(Session session = sessionFactory.openSession();){
                return session.get(Planet.class,id);
            }
        }else {
            throw new RuntimeException("Invalid id for planet " +id);
        }
    }

    public  boolean updatePlanet(Planet planet) throws RuntimeException {
        if(ValidatorUtil.validate(planet)) {
            try(Session session = sessionFactory.openSession();){
                Transaction transaction = session.beginTransaction();
                session.merge(planet);
                transaction.commit();
                return true;
            }
        }else {
            throw new RuntimeException("Invalid planet"+planet);
        }
    }
    public  boolean deleteById(String id) throws RuntimeException {
        if(ValidatorUtil.validate(id)) {
            try(Session session = sessionFactory.openSession();){
                Transaction transaction = session.beginTransaction();
                Planet planetById = getPlanetById(id);
                session.remove(planetById);
                transaction.commit();
                return true;
            }
        }else {
            throw new RuntimeException("Invalid id " + id);
        }

    }

    public List<Planet> listAll(){
        try(Session session = sessionFactory.openSession();){
            return session.createQuery(GET_ALL_PLANETS_QUERY,Planet.class).list();
        }
    }
}
