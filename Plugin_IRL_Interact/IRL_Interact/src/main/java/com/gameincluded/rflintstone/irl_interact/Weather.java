package com.gameincluded.rflintstone.irl_interact;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.async.Callback;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.bukkit.plugin.java.JavaPlugin;

public class Weather extends JavaPlugin {

    public void WeatherAPI() {
        // Plugin startup logic
        getServer().getScheduler().runTaskTimer(this, () -> Unirest.get("https://data.buienradar.nl/2.0/feed/json").asJsonAsync(new Callback<JsonNode>() {
            @Override
            public void completed(HttpResponse<JsonNode> response) {
                getServer().broadcastMessage(response.getBody().toString());
                getLogger().info(response.getBody().toString());
            }

            @Override
            public void failed(UnirestException e) {
                e.printStackTrace();
            }

            @Override
            public void cancelled() {

            }
        }), 0, 20 * 30);
    }
}