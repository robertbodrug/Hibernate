package com.example.services;

import com.example.dao.ClientDao;
import com.example.model.Client;

import java.util.List;

public class ClientCrudService {
    private  static final ClientDao DAO = new ClientDao();
    public static boolean create(String name) throws RuntimeException {
        return DAO.createByName(name);
    }
    public static boolean create(Client client) throws RuntimeException {
        return DAO.create(client);
    }
    public static Client read(Long id) throws RuntimeException {
        return DAO.getClientById(id);
    }
    public static List<Client> readAll() throws RuntimeException {
        return DAO.listAll();
    }
    public static boolean update(Client client) throws RuntimeException {
        return DAO.updateClient(client);
    }
    public static boolean delete(Long id) throws RuntimeException {
        return DAO.deleteById(id);
    }

}
