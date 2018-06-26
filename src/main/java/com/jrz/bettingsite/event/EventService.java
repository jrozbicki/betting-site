package com.jrz.bettingsite.event;

import com.jrz.bettingsite.team.Team;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface EventService {

    Iterable<Event> findAll();

    Optional<Event> findById(Long id);

    void saveEvent(Event event);

    void updateEvent(Event event, Long id);

    void deleteEvent(Event event);
}
