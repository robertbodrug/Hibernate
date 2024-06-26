package com.example.utils;

import com.example.model.Client;
import com.example.model.Planet;
import com.example.model.Ticket;

public class ValidatorUtil {
    public static boolean validate(Planet planet){
        String id = planet.getId();
        return  id.equals(id.toUpperCase()) && !planet.getName().isEmpty() && planet.getName().length() <= 500;
    }
    public static boolean validate(Client client) {
        return client.getName().length() >= 3 && client.getName().length() <= 200;
    }
    public static boolean validate(String planetId){
        return  planetId.equals(planetId.toUpperCase());
    }
    public static boolean validate(Ticket ticket){
        return validate(ticket.getClient())&&
                validate(ticket.getPlanetTo())&&
                validate(ticket.getPlanetFrom());
    }



}
