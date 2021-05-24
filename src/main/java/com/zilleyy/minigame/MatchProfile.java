package com.zilleyy.minigame;

import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.UUID;

/**
 * Author: Zilleyy
 * <br>
 * Date: 22/05/2021 @ 7:21 pm AEST
 */
public class MatchProfile {

    @Getter private final UUID uuid;
    @Getter private final Team team;

    public MatchProfile(UUID uuid, Team team) {
        this.uuid = uuid;
        this.team = team;
    }

    /**
     * Gets the player using the profiles UUID.
     * @return the player of the profile.
     */
    public Player getPlayer() {
        return Bukkit.getPlayer(this.uuid);
    }

}
