package com.zilleyy.minigame;

import lombok.Getter;
import lombok.SneakyThrows;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class Central extends JavaPlugin {

    @Getter private static Central instance;

    public Central() {
        Central.instance = this;
    }

    @Override
    public void onEnable() {
        this.registerEvents();

        final Match match = null;
        final CountdownTimer timer = new CountdownTimer(60, 5);
        timer.setEveryUpdate((every) ->  match.broadcastMessage(timer.getSecondsLeft() + "..."));
        timer.setBeforeTimer((before) ->  match.broadcastMessage("&aStarting countdown..."));
        timer.setAfterTimer((after) -> match.broadcastMessage("&aThe match has begun!"));
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    @SneakyThrows
    private void registerEvents() {
        Class<Listener>[] listeners = new Class[]{
                PlayerListener.class
        };

        for(Class<Listener> clazz : listeners) {
            Bukkit.getPluginManager().registerEvents(clazz.newInstance(), this);
        }
    }

}
