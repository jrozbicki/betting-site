package com.jrz.bettingsite.player;

import com.jrz.bettingsite.team.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class PlayerController {

    @Autowired
    PlayerService playerService;


    @RequestMapping(path = "/players")
    public @ResponseBody Iterable<Player> getAllTeams(){
        return playerService.findAll();
    }

    @RequestMapping(path = "/players/{id}")
    public @ResponseBody Optional<Player> findById(@PathVariable Long id){
        return playerService.findById(id);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/players")
    public @ResponseBody void savePlayer(@RequestBody Player player){
        playerService.savePlayer(player);
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/players/{id}")
    public @ResponseBody void updatePlayer(@RequestBody Player player, @PathVariable Long id){
        playerService.updatePlayer(player, id);
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/players/{id}")
    public @ResponseBody void deletePlayer(@RequestBody Player player, @PathVariable Long id){
        playerService.deleteTeam(player);
    }
}
