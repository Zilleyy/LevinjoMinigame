package com.zilleyy.minigame;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Author: Zilleyy
 * <br>
 * Date: 22/05/2021 @ 6:54 pm AEST
 */
public final class MatchManager {

    private static final List<Match> matches = new ArrayList<>();

    public static Match getMatch(final UUID uuid) {
        for(final Match match : MatchManager.matches) {
            for(final MatchProfile matchProfile : match.getMatchProfileManager().getMatchProfiles()) {
                if(uuid.equals(matchProfile.getUuid())) {
                    return match;
                }
            }
        }
        return null;
    }

    public static Match getMatch(final Player player) {
        return MatchManager.getMatch(player.getUniqueId());
    }

}
