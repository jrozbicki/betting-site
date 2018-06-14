package com.jrz.bettingsite.event;

import com.jrz.bettingsite.team.TeamService;
import org.springframework.beans.factory.annotation.Autowired;

public class EventServiceImpl implements TeamService {

    @Autowired
    EventRepository eventRepository;

}
