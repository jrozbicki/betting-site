package com.jrz.bettingsite.player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping(path = "/player")
public class PlayerController {

    @Autowired
    PlayerService playerService;


    @RequestMapping(path = "/all")
    public @ResponseBody Iterable<Player> getAllTeams(){
        return playerService.findAll();
    }

    @RequestMapping(path = "/{id}")
    public @ResponseBody Optional<Player> findById(@PathVariable Long id){
        return playerService.findById(id);
    }

    @RequestMapping(path = "/add", method = RequestMethod.POST)
    public void saveTeam(@RequestBody Player player){
            playerService.savePlayer(player);
        }
}
