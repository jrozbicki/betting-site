package com.jrz.bettingsite.team;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface TeamService {

    public Iterable<Team> findAll();

    public Optional<Team> findById(Long id);

    public Team save(Team team);
}
