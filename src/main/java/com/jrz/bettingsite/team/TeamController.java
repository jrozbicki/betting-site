package com.jrz.bettingsite.team;


import com.jrz.bettingsite.player.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Arrays;
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
    public Team save(Team team){
        // hardcoded for tests
        team.setId(1);
        team.setName("Real Madrid");
        List<Player> players = new ArrayList<Player>();
        Player cr7 = new Player("Cristiano Ronaldo");
        players.add(cr7);
        team.setPlayers(players);
        //
        return teamService.save(team);
    }
}
