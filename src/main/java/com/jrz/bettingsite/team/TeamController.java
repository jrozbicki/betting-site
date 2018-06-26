package com.jrz.bettingsite.team;


import com.jrz.bettingsite.player.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class TeamController {

    @Autowired
    TeamService teamService;


    @RequestMapping(path = "/teams")
    public @ResponseBody Iterable<Team> getAllTeams(){
        return teamService.findAll();
    }

    @RequestMapping(path = "teams/{id}")
    public @ResponseBody Optional<Team> findById(@PathVariable Long id){
        return teamService.findById(id);
    }

    @RequestMapping(path = "teams/{id}/players")
    public @ResponseBody Iterable<Player> getPlayersFromTeam(@PathVariable Long id){
        return teamService.findPlayersFromTeam(id);
    }
    @RequestMapping(method = RequestMethod.POST, path = "/teams")
    public void saveTeam(@RequestBody Team team){
            teamService.saveTeam(team);
    }
}
