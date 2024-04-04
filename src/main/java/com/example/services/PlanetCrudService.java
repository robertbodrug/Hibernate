package com.example.services;

import com.example.dao.ClientDao;
import com.example.dao.PlanetDao;
import com.example.model.Client;
import com.example.model.Planet;

import java.util.List;

public class PlanetCrudService {
    private  static final PlanetDao DAO = new PlanetDao();
    public static boolean create(Planet planet) throws RuntimeException {
        return DAO.create(planet);
    }
    public static Planet read(String id) throws RuntimeException {
        return DAO.getPlanetById(id);
    }
    public static List<Planet> readAll() throws RuntimeException {
        return DAO.listAll();
    }
    public static boolean update(Planet planet) throws RuntimeException {
        return DAO.updatePlanet(planet);
    }
    public static boolean delete(String id) throws RuntimeException {
        return DAO.deleteById(id);
    }

}
