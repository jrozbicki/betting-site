package com.jrz.bettingsite.event;

import com.jrz.bettingsite.team.Team;
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

    @RequestMapping(method = RequestMethod.PUT, path = "/events/{id}")
    public @ResponseBody void updateEvent(@RequestBody Event event, @PathVariable Long id){
        eventService.updateEvent(event, id);
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/events/{id}")
    public @ResponseBody void deleteEvent(@RequestBody Event event, @PathVariable Long id){
        eventService.deleteEvent(event);
    }
}
