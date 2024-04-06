package com.example;

import com.example.dao.ClientDao;
import com.example.model.Client;
import com.example.model.Planet;
import com.example.model.Ticket;
import com.example.services.ClientCrudService;
import com.example.services.PlanetCrudService;
import com.example.services.TicketCrudService;
import com.example.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {


        String beforeClient = ClientCrudService.readAll().stream().map(Client::toString).collect(Collectors.joining("\n"));
        Client client = new Client("Boby");
        ClientCrudService.create(client);
        Client readed = ClientCrudService.read(1L);
        readed.setName("Tomasss");
        ClientCrudService.update(readed);
        ClientCrudService.delete(10L);
        String afterClient = ClientCrudService.readAll().stream().map(Client::toString).collect(Collectors.joining("\n"));

        String beforePlanet = PlanetCrudService.readAll().stream().map(Planet::toString).collect(Collectors.joining("\n"));
        Planet planet = new Planet("GOL","Golden");
        PlanetCrudService.create(planet);
        Planet planetRead = PlanetCrudService.read("EAR");
        planetRead.setName("people home");
        PlanetCrudService.update(planetRead);
        PlanetCrudService.delete("DEL");
        String afterPlanet = PlanetCrudService.readAll().stream().map(Planet::toString).collect(Collectors.joining("\n"));




        String beforeTicket = TicketCrudService.readAll().stream().map(Ticket::toString).collect(Collectors.joining("\n"));
        Client clientForTicket = new Client("Boby");
        clientForTicket.setId(5L);
        Ticket ticket = new Ticket(clientForTicket,planet,planetRead);
        TicketCrudService.create(ticket);
        Ticket readedTicket = TicketCrudService.read(2L);
        readedTicket.setPlanetTo(new Planet("MER","Silver"));
        TicketCrudService.update(readedTicket);
        TicketCrudService.delete(3L);
        Ticket ticketToDelete = TicketCrudService.read(7L);
        TicketCrudService.delete(ticketToDelete);
        String afterTicket = TicketCrudService.readAll().stream().map(Ticket::toString).collect(Collectors.joining("\n"));


        System.out.println("==================ClientService=======================================");
        System.out.println(beforeClient);
        System.out.println("=========================================================");
        System.out.println(afterClient);
        System.out.println("=======================PlanetService==================================");
        System.out.println(beforePlanet);
        System.out.println("=========================================================");
        System.out.println(afterPlanet);
        System.out.println("=======================TicketService==================================");
        System.out.println(beforeTicket);
        System.out.println("=========================================================");
        System.out.println(afterTicket);
    }


}