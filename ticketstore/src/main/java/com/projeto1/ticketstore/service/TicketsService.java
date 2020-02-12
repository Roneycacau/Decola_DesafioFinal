package com.projeto1.ticketstore.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.projeto1.ticketstore.domain.dto.response.FrontTicketsResponse;
import com.projeto1.ticketstore.domain.entities.Tickets;
import com.projeto1.ticketstore.repository.TicketRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketsService {

    private final TicketRepository ticketstore;

    @Autowired
    public TicketsService(TicketRepository ticketstore) {
        this.ticketstore = ticketstore;
    }

    public List<Tickets> listTickets() {

        return ticketstore.findAll();
    }

    public Tickets findById(Integer id) {

        Optional<Tickets> ticket = ticketstore.findById(id);
        return ticket.orElseThrow(() -> new IllegalArgumentException("Ticket not found"));
    }

    public List<Tickets> findTicketsUser(Integer idUser) {
        return ticketstore.findByIdUser_id(idUser);
    }

    public List<Tickets> findTicketsSession(Integer idSession) {

        return ticketstore.findByIdSessionMovie_id(idSession);

    }

    public Tickets createTicket(Tickets model) {
        return ticketstore.save(model);
    }

}