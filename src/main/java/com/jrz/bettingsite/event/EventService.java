package com.jrz.bettingsite.event;

import com.jrz.bettingsite.team.Team;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface EventService {

    public Iterable<Event> findAll();

    public Optional<Event> findById(Long id);

    public void saveEvent(Event event);
}
