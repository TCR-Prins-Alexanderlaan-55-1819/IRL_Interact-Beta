package com.gameincluded.rflintstone.irl_interact;

import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {
    Messages Message = new Messages();
    Weather API = new Weather();
    @Override
    public void onEnable() {
        // Plugin startup logic
        Message.EnableMsg();
        //API.WeatherAPI();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        Message.DisableMsg();
    }
}
