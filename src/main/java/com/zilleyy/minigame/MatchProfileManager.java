package com.zilleyy.minigame;

import lombok.Getter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: Zilleyy
 * <br>
 * Date: 22/05/2021 @ 7:39 pm AEST
 */
public final class MatchProfileManager {

    @Getter private final List<MatchProfile> matchProfiles = new ArrayList<>();

    public MatchProfileManager() {}

    public final MatchProfile getMatchProfile(final Player player) {
        for(final MatchProfile matchProfile : this.matchProfiles) {
            if(matchProfile.getPlayer().equals(player)) return matchProfile;
        }

        return null;
    }

    public final boolean addMatchProfile(final MatchProfile matchProfile) {
        return this.matchProfiles.add(matchProfile);
    }

    public final boolean removeMatchProfile(final MatchProfile matchProfile) {
        return this.matchProfiles.remove(matchProfile);
    }

}
