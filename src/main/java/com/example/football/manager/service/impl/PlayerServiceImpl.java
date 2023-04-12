package com.example.football.manager.service.impl;

import com.example.football.manager.model.Player;
import com.example.football.manager.repository.PlayerRepository;
import com.example.football.manager.service.PlayerService;
import java.util.List;
import java.util.NoSuchElementException;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PlayerServiceImpl implements PlayerService {
    private final PlayerRepository playerRepository;

    @Override
    public Player findById(Long id) {
        return playerRepository.findById(id).orElseThrow(
                () -> new NoSuchElementException("Can`t find player by id " + id));
    }

    @Override
    public Player save(Player player) {
        return playerRepository.save(player);
    }

    @Override
    public void delete(Long id) {
        playerRepository.deleteById(id);
    }

    @Override
    public List<Player> findAll() {
        return playerRepository.findAll();
    }

    @Override
    public void transfer(Long teamIdFrom, Long teamIdTo, Long playerId) {

    }
}
