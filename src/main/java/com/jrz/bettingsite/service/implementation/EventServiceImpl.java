package com.jrz.bettingsite.service.implementation;

import com.jrz.bettingsite.repository.EventRepository;
import com.jrz.bettingsite.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;

public class EventServiceImpl implements TeamService {

    @Autowired
    EventRepository eventRepository;

}
