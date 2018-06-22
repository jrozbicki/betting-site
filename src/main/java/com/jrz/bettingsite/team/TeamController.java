package com.jrz.bettingsite.team;


import com.jrz.bettingsite.player.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path = "/team")
public class TeamController {

    @Autowired
    TeamService teamService;


    @RequestMapping(path = "/all")
    public @ResponseBody Iterable<Team> getAllTeams(){
        return teamService.findAll();
    }

    @RequestMapping(path = "/{id}")
    public @ResponseBody Optional<Team> findById(@PathVariable Long id){
        return teamService.findById(id);
    }

    @RequestMapping(path = "/add", method = RequestMethod.POST)
    public void saveTeam(@RequestBody Team team){
            teamService.saveTeam(team);
        }
}
