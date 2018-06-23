package com.jrz.bettingsite.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

@Controller
@RequestMapping(path = "/event")
public class EventController {

    @Autowired
    private EventService eventService;

    @RequestMapping(path = "/all")
    public @ResponseBody Iterable<Event> getAllEvents() {
        return eventService.findAll();
    }

    @RequestMapping(path = "/{id}")
    public @ResponseBody Optional<Event> getEventById(@PathVariable Long id){
        return eventService.findById(id);
    }
}
