package com.erans.playerms.assets;
        
import io.micrometer.common.util.StringUtils;
import lombok.Getter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@Getter
public class PlayerItem {
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyymmdd");

    private String playerId;
    private Integer birthYear;
    private Integer birthMonth;
    private Integer birthDay;
    private String birthCountry;
    private String birthState;
    private String birthCity;
    private Integer deathYear;
    private Integer deathMonth;
    private Integer deathDay;
    private String deathCountry;
    private String deathState;
    private String deathCity;
    private String nameFirst;
    private String nameLast;
    private String nameGiven;
    private Integer weight;
    private Integer height;
    private String batSide;
    private String throwSide;
    private Date debut;
    private Date finalGame;
    private String retroId;
    private String bbrefId;

            /**
      * Array list of values from each CSV row is parsed, knowing that the order is always the same.
      * The only problem is when a row ends early (only the first number of cells have data), and therefore the row ends with too few cells.
      * to overcome this, the array list is augmented with empty cells if required.
      * @param playerFieldsArray
      * @throws ParseException
      */
    public PlayerItem(ArrayList<String> playerFieldsArray) throws ParseException {
        try {
            completeArray(playerFieldsArray);
            this.playerId = playerFieldsArray.get(0);
            this.birthYear = StringUtils.isNotBlank(playerFieldsArray.get(1)) ? Integer.valueOf(playerFieldsArray.get(1)) : null;
            this.birthMonth = StringUtils.isNotBlank(playerFieldsArray.get(2)) ? Integer.valueOf(playerFieldsArray.get(2)) : null;
            this.birthDay = StringUtils.isNotBlank(playerFieldsArray.get(3)) ? Integer.valueOf(playerFieldsArray.get(3)) : null;
            this.birthCountry = playerFieldsArray.get(4);
            this.birthState = playerFieldsArray.get(5);
            this.birthCity = playerFieldsArray.get(6);
            this.deathYear = StringUtils.isNotBlank(playerFieldsArray.get(7)) ? Integer.valueOf(playerFieldsArray.get(7)) : null;
            this.deathMonth = StringUtils.isNotBlank(playerFieldsArray.get(8)) ? Integer.valueOf(playerFieldsArray.get(8)) : null;
            this.deathDay = StringUtils.isNotBlank(playerFieldsArray.get(9)) ? Integer.valueOf(playerFieldsArray.get(9)) : null;
            this.deathCountry = playerFieldsArray.get(10);
            this.deathState = playerFieldsArray.get(11);
            this.deathCity = playerFieldsArray.get(12);
            this.nameFirst = playerFieldsArray.get(13);
            this.nameLast = playerFieldsArray.get(14);
            this.nameGiven = playerFieldsArray.get(15);
            this.weight = StringUtils.isNotBlank(playerFieldsArray.get(16)) ? Integer.valueOf(playerFieldsArray.get(16)) : null;
            this.height = StringUtils.isNotBlank(playerFieldsArray.get(17)) ? Integer.valueOf(playerFieldsArray.get(17)) : null;
            this.batSide = playerFieldsArray.get(18);
            this.throwSide = playerFieldsArray.get(19);
            this.debut = StringUtils.isNotBlank(playerFieldsArray.get(20)) ? dateFormat.parse(playerFieldsArray.get(20)) : null;
            this.finalGame = StringUtils.isNotBlank(playerFieldsArray.get(21)) ? dateFormat.parse(playerFieldsArray.get(21)) : null;
            this.retroId = playerFieldsArray.get(22);
            this.bbrefId = playerFieldsArray.get(23);
        } catch (Exception ex) {
            System.out.println(playerFieldsArray.toString());
            throw ex;
        }
    }

    private void completeArray(ArrayList<String> playerFieldsArray) {
        if(playerFieldsArray.size() < 24) {
                for(int i= playerFieldsArray.size(); i < 24; i++){
                        playerFieldsArray.add("");
                    }
            }
    }
}