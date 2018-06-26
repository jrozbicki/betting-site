package com.jrz.bettingsite.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class EventController {

    @Autowired
    private EventService eventService;

    @RequestMapping(path = "/events")
    public @ResponseBody Iterable<Event> getAllEvents() {
        return eventService.findAll();
    }

    @RequestMapping(path = "/events/{id}")
    public @ResponseBody Optional<Event> getEventById(@PathVariable Long id){
        return eventService.findById(id);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/events")
    public void saveEvent(@RequestBody Event event){
        eventService.saveEvent(event);
    }
}
