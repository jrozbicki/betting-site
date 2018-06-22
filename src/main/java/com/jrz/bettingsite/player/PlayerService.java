package com.jrz.bettingsite.player;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface PlayerService {

    public Iterable<Player> findAll();

    public Optional<Player> findById(Long id);

    public void savePlayer(Player player);
}
