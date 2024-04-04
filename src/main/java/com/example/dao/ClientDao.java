package com.example.dao;

import com.example.model.Client;
import com.example.utils.HibernateUtil;
import com.example.utils.ValidatorUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class ClientDao {
    private  final SessionFactory sessionFactory = HibernateUtil.getInstance().getSessionFactory();
    private static final String GET_ALL_CLIENTS_QUERY = "FROM Client";
    //"SELECT id,name FROM client"
    public  boolean create(Client client) throws RuntimeException {

        if(ValidatorUtil.validate(client)) {
            try(Session session = sessionFactory.openSession();){
                Transaction transaction = session.beginTransaction();
                session.persist(client);
                transaction.commit();
                return true;
            }
        }else {
            throw new RuntimeException("Invalid name for client");
        }
    }
    public  boolean createByName(String name) throws RuntimeException {
        return  create(new Client(name));
    }
    public  Client getClientById(Long id) throws RuntimeException {
        if(id>0) {
            try(Session session = sessionFactory.openSession();){
                return session.get(Client.class,id);
            }
        }else {
            throw new RuntimeException("Invalid id for client");
        }
    }

    public  boolean updateClient(Client client) throws RuntimeException {
        if(ValidatorUtil.validate(client)) {
            try(Session session = sessionFactory.openSession();){
                Transaction transaction = session.beginTransaction();
                session.merge(client);
                transaction.commit();
                return true;
            }
        }else {
            throw new RuntimeException("Invalid client");
        }
    }
    public  boolean deleteById(Long id) throws RuntimeException {
        if(id>0) {
            try(Session session = sessionFactory.openSession();){
                Transaction transaction = session.beginTransaction();
                Client clientById = getClientById(id);
                session.remove(clientById);
                transaction.commit();
                return true;
            }
        }else {
            throw new RuntimeException("Invalid id");
        }

    }

    public List<Client> listAll(){
        try(Session session = sessionFactory.openSession();){
            return session.createQuery(GET_ALL_CLIENTS_QUERY,Client.class).list();
        }
    }
}
