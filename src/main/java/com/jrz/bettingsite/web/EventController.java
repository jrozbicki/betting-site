package com.jrz.bettingsite.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EventController {

    @RequestMapping(path = "/events")
    public String events(){
        return "events";
    }
}
