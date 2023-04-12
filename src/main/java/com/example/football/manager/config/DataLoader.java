package com.example.football.manager.config;

import com.example.football.manager.model.Team;
import com.example.football.manager.model.Player;
import com.example.football.manager.service.PlayerService;
import com.example.football.manager.service.TeamService;
import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.Random;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DataLoader {
    private static final BigDecimal DEFAULT_BALANCE = BigDecimal.valueOf(100_000);
    private static final int MAX_COMMISSION_RATE = 20;
    private static final int MAX_PLAYER_AGE = 40;
    private static final int MIN_PLAYER_AGE = 16 ;

    private final PlayerService playerService;
    private final TeamService teamService;

    @PostConstruct
    public void init() {
        Random random = new Random();

        for (int i = 0; i < 3; i++) {
            Team team = new Team();
            team.setName("Team " + i);
            team.setAccountBalance(DEFAULT_BALANCE);
            team.setCommissionRate(BigDecimal.valueOf(random.nextInt(MAX_COMMISSION_RATE)));
            teamService.save(team);

            for (int j = 0; j < 12; j++) {
               Player player = new Player();
               player.setAge(BigDecimal.valueOf(
                       random.nextInt(MAX_PLAYER_AGE - MIN_PLAYER_AGE) + MIN_PLAYER_AGE));
               player.setTeam(team);
               player.setYearsOfExperience(BigDecimal.valueOf(
                       random.nextInt(MAX_PLAYER_AGE - MIN_PLAYER_AGE)));
               playerService.save(player);
            }
        }
    }
}
