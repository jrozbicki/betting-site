package com.jrz.bettingsite.event;

import org.springframework.beans.factory.annotation.Autowired;

public class EventServiceImpl implements EventService {

    @Autowired
    EventRepository eventRepository;

}
