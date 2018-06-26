package com.jrz.bettingsite.team;

import com.jrz.bettingsite.player.Player;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface TeamService {

    Iterable<Team> findAll();

    Optional<Team> findById(Long id);

    void saveTeam(Team team);

    Iterable<Player> findPlayersFromTeam(Long id);

    void updateTeam(Team team, Long id);

    void deleteTeam(Team team);
}
