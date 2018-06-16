package com.jrz.bettingsite.team;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

    @Override
    public Team save(Team team){
        return teamRepository.save(team);
    }

}
