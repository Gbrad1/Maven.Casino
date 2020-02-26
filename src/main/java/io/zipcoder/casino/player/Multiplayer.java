package io.zipcoder.casino.player;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Multiplayer {
    private Map<Long, Player> playerDatabase = new HashMap<>();

    public Multiplayer(){
        loadPlayerDataBase();
    }

    public Long generateId(){
        long leftLimit = 1000;
        long rightLimit = 9999;
        long generateLong = 1000 + (long) (Math.random() * (rightLimit - leftLimit));
        if (playerDatabase.containsKey(generateLong)){
            generateId();
        }
        return generateLong;
    }

    public void add(Long key, Player value){
        playerDatabase.put(key, value);
    }

    public void loadPlayerDataBase(){
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            playerDatabase = objectMapper.readValue(new File("players.json"), new TypeReference<HashMap<Long, Player>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void savePlayerDataBase(){
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writerWithType(new TypeReference<HashMap<Long, Player>>() {}).writeValue(new File("players.json"), playerDatabase);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
