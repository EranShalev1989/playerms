package com.erans.playerms.assets;
        
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlayerController {
    private final PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping(path = "/api/players")
    public String getAllPlayers(){
        return playerService.getAllPlayers().toString();
    }

    @GetMapping(path = "/api/players/{playerId}")
    public String getPlayerById(@PathVariable String playerId){
        return playerService.getPlayerById(playerId).toString();
    }
}