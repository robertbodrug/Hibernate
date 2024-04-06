package com.example.services;

import com.example.dao.ClientDao;
import com.example.dao.TicketDao;
import com.example.model.Client;
import com.example.model.Planet;
import com.example.model.Ticket;

import java.util.List;

public class TicketCrudService {
    private  static final TicketDao DAO = new TicketDao();

    public static boolean create(Ticket ticket) throws RuntimeException {
        return DAO.createTicket(ticket);
    }
    public static Ticket read(Long id) throws RuntimeException {
        return DAO.getTicketById(id);
    }
    public static List<Ticket> readAll() throws RuntimeException {
        return DAO.listAll();
    }
    public static boolean update(Ticket ticket) throws RuntimeException {
        return DAO.updateTicket(ticket);
    }

    public static boolean delete(Ticket ticket) throws RuntimeException {
        return DAO.deleteTicket(ticket);
    }
    public static boolean delete(Long id) throws RuntimeException {
        return DAO.deleteTicketById(id);
    }


}
