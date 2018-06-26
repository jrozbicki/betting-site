package com.jrz.bettingsite.team;

import com.jrz.bettingsite.player.Player;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface TeamService {

    public Iterable<Team> findAll();

    public Optional<Team> findById(Long id);

    public void saveTeam(Team team);

    public Iterable<Player> findPlayersFromTeam(Long id);
}
