package com.erans.playerms.assets;
        
import io.micrometer.common.util.StringUtils;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class PlayerService {
    private PlayerMap playerMap = null;

    @Autowired
    public PlayerService(PlayerMap playerMap) {
                this.playerMap = playerMap;
            }

    public JSONObject getPlayerById(String Id) {
        return playerItemToJSON(playerMap.getPlayerById(Id));
    }

    /**
    * return array list of json objects. JSON allows results to be processed more easily than plain strings, as they are mapped objects
    */
    public ArrayList<JSONObject> getAllPlayers() {
        ArrayList<JSONObject> allPlayersJson = new ArrayList<>();
        for(PlayerItem player : playerMap.getAllPlayers()) {
                allPlayersJson.add(playerItemToJSON(player));
            }
        return allPlayersJson;
    }

    /**
    * return single JSON of given item
    */
    private JSONObject playerItemToJSON(PlayerItem player) {
        JSONObject playerJSON = new JSONObject();

        if(StringUtils.isNotBlank(player.getPlayerId()))
            playerJSON.append("Player ID",player.getPlayerId());

        if(null != (player.getBirthYear()))
            playerJSON.append("Birth Year",player.getBirthYear());
        if(null != (player.getBirthMonth()))
            playerJSON.append("Birth Month",player.getBirthMonth());
        if(null != (player.getBirthDay()))
            playerJSON.append("Birth Day",player.getBirthDay());

        if(null != (player.getDeathYear()))
            playerJSON.append("Death Year",player.getDeathYear());
        if(null != (player.getDeathMonth()))
            playerJSON.append("Death Month",player.getDeathMonth());
        if(null != (player.getDeathDay()))
            playerJSON.append("Death Day",player.getDeathDay());

        if(StringUtils.isNotBlank(player.getBirthCountry()))
            playerJSON.append("Birth Country",player.getBirthCountry());
        if(StringUtils.isNotBlank(player.getBirthState()))
            playerJSON.append("Birth State",player.getBirthState());
        if(StringUtils.isNotBlank(player.getBirthCity()))
            playerJSON.append("Birth City",player.getBirthCity());

        if(StringUtils.isNotBlank(player.getDeathCountry()))
            playerJSON.append("Death Country",player.getDeathCountry());
        if(StringUtils.isNotBlank(player.getDeathState()))
                playerJSON.append("Death State",player.getDeathState());
        if(StringUtils.isNotBlank(player.getDeathCity()))
                playerJSON.append("Death City",player.getDeathCity());

        if(StringUtils.isNotBlank(player.getNameFirst()))
            playerJSON.append("First Name",player.getNameFirst());
        if(StringUtils.isNotBlank(player.getNameLast()))
            playerJSON.append("Last Name",player.getNameLast());
        if(StringUtils.isNotBlank(player.getNameGiven()))
            playerJSON.append("Given Name",player.getNameGiven());

        if(null != (player.getWeight()))
            playerJSON.append("Weight",player.getWeight());
        if(null != (player.getHeight()))
            playerJSON.append("Height",player.getHeight());

        if(StringUtils.isNotBlank(player.getBatSide()))
            playerJSON.append("Batting Arm",player.getBatSide());
        if(StringUtils.isNotBlank(player.getThrowSide()))
            playerJSON.append("Throwing Arm",player.getThrowSide());

        if(player.getDebut() != null){
            playerJSON.append("Debut", player.getDateFormat().format(player.getDebut()));
        }

        if(player.getFinalGame() != null){
            playerJSON.append("Final Game", player.getDateFormat().format(player.getFinalGame()));
        }

        if(StringUtils.isNotBlank(player.getRetroId()))
            playerJSON.append("Player Retro ID",player.getRetroId());
        if(StringUtils.isNotBlank(player.getBbrefId()))
            playerJSON.append("Player BBRef ID",player.getBbrefId());

        return playerJSON;
    }
}