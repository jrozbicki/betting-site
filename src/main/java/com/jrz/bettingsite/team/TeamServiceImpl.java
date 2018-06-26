package com.jrz.bettingsite.team;

import com.jrz.bettingsite.player.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TeamServiceImpl implements TeamService {

    @Autowired
    private TeamRepository teamRepository;

    @Override
    public Iterable<Team> findAll(){
        return teamRepository.findAll();
    }

    @Override
    public Optional<Team> findById(Long id){
        return teamRepository.findById(id);
    }

    // TODO throwing exception
    @Override
    public void saveTeam(Team team){
        teamRepository.save(team);
    }

    @Override
    public Iterable<Player> findPlayersFromTeam(Long id) {
        return teamRepository.findById(id).get().getPlayers();
    }

    @Override
    public void updateTeam(Team team, Long id) {
        teamRepository.save(team);
    }

    @Override
    public void deleteTeam(Team team) {
        teamRepository.delete(team);
    }

}
