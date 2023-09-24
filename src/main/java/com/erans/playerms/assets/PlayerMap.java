package com.erans.playerms.assets;
        
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.*;

/*
*  Storing the CSV in a map is more efficient than in DB, as time complexity is O(1), and only GET is being implemented
*/
@Component
public class PlayerMap {
    private static HashMap<String,PlayerItem> playerMap;

    public PlayerItem getPlayerById(String Id) {
        return playerMap.get(Id);
    }

    public ArrayList<PlayerItem> getAllPlayers() {
        return new ArrayList<>(playerMap.values());
    }

    private PlayerMap() throws IOException, ParseException {
        playerMap = new HashMap<>();
        initPlayerMap();
    }

/*
* CSV changed will not be too big, and always in same order, allowing to assume the ordering of the array, with blank cells where no data
* @throws IOException
* @throws ParseException
*/
    private void initPlayerMap() throws IOException, ParseException {
        BufferedReader br = new BufferedReader(new FileReader("player.csv"));
        String row = br.readLine();
        while((row = br.readLine()) != null){
            ArrayList<String> playerArray = new ArrayList<>();
            playerArray.addAll(Arrays.asList(row.split(",")));
            playerMap.put(playerArray.get(0),new PlayerItem(playerArray));
        }
    }
}