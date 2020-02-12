package com.projeto1.ticketstore.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.projeto1.ticketstore.domain.dto.response.SessionsMovieModelResponse;
import com.projeto1.ticketstore.domain.entities.SessionsMovie;
import com.projeto1.ticketstore.exception.DataNotFoundException;
import com.projeto1.ticketstore.repository.SessionsMovieRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SessionsMovieService {

    private final SessionsMovieRepository sessionsmovieRepository;

    @Autowired
    public SessionsMovieService(SessionsMovieRepository sessionsmovieRepository) {
        this.sessionsmovieRepository = sessionsmovieRepository;
    }

    public SessionsMovie findById(Integer id) {
        Optional<SessionsMovie> status = sessionsmovieRepository.findById(id);
        return status.orElseThrow(() -> new DataNotFoundException("Sessão não encontrada!"));
    }

    public List<SessionsMovie> findByIdMovie_id(Integer id) {
        
        return sessionsmovieRepository.findByIdMovie_id(id);
    }

    public List<SessionsMovie> listTickets() {

        return sessionsmovieRepository.findAll();
    }

    public SessionsMovie createSessionsMovie(SessionsMovie model) {
        return sessionsmovieRepository.save(model);
    }

    public static String formataData(Date data) {

        Calendar dateCalendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        dateCalendar.setTime(data);

        String dataDia = dateFormat.format(dateCalendar.getTime());

        return dataDia;
    }

    public static String formataHora(Date data) {

        Calendar dateCalendar = Calendar.getInstance();
        SimpleDateFormat formatMinutes = new SimpleDateFormat("mm");

        SimpleDateFormat formatHours = new SimpleDateFormat("HH");

        dateCalendar.setTime(data);

        String hora = formatHours.format(dateCalendar.getTime());
        String minutos = formatMinutes.format(dateCalendar.getTime());

        String horaMinutos = hora + ":" + minutos;

        return horaMinutos;
    }

}