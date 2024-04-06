package com.example.dao;

import com.example.model.Ticket;
import com.example.utils.HibernateUtil;
import com.example.utils.ValidatorUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class TicketDao {
    private  final SessionFactory sessionFactory = HibernateUtil.getInstance().getSessionFactory();
    private static final String GET_ALL_TICKETS_QUERY = "FROM Ticket";
    //"SELECT id,name FROM ticket"
    public  boolean createTicket(Ticket ticket) throws RuntimeException {

        if(ValidatorUtil.validate(ticket)) {
            try(Session session = sessionFactory.openSession();){
                Transaction transaction = session.beginTransaction();
                session.persist(ticket);
                transaction.commit();
                return true;
            }
        }else {
            throw new RuntimeException("Invalid data for ticket");
        }
    }

    public  Ticket getTicketById(Long id) throws RuntimeException {
        if(id>0) {
            try(Session session = sessionFactory.openSession();){
                Ticket ticket = session.get(Ticket.class, id);
                return ticket;
            }
        }else {
            throw new RuntimeException("Invalid id for client");
        }
    }

    public  boolean updateTicket(Ticket ticket) throws RuntimeException {
        if(ValidatorUtil.validate(ticket)) {
            try(Session session = sessionFactory.openSession();){
                Transaction transaction = session.beginTransaction();
                session.merge(ticket);
                transaction.commit();
                return true;
            }
        }else {
            throw new RuntimeException("Invalid client");
        }
    }
    public  boolean deleteTicket(Ticket ticket) throws RuntimeException {
        if(ValidatorUtil.validate(ticket)) {
            try(Session session = sessionFactory.openSession();){
                Transaction transaction = session.beginTransaction();
                session.remove(ticket);
                transaction.commit();
                return true;
            }
        }else {
            throw new RuntimeException("Invalid id");
        }

    }
    public  boolean deleteTicketById(Long id) throws RuntimeException {
        if(id>0){
            Ticket ticketById = getTicketById(id);
            return deleteTicket(ticketById);
        }else {
            throw new RuntimeException("Invalid id");
        }

    }

    public List<Ticket> listAll(){
        try(Session session = sessionFactory.openSession();){
            return session.createQuery(GET_ALL_TICKETS_QUERY,Ticket.class).list();
        }
    }
}
