package com.jrz.bettingsite.player;

import com.jrz.bettingsite.team.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlayerServiceImpl implements PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    @Override
    public Iterable<Player> findAll() {
        return playerRepository.findAll();
    }

    @Override
    public Optional<Player> findById(Long id) {
        return playerRepository.findById(id);
    }

    @Override
    public void savePlayer(Player player) {
        playerRepository.save(player);
    }

    @Override
    public void updatePlayer(Player player, Long id) {
        playerRepository.save(player);
    }

    @Override
    public void deleteTeam(Player player) {
        playerRepository.delete(player);
    }
}
