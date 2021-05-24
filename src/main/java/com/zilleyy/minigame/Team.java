package com.zilleyy.minigame;

import lombok.Getter;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Recipe;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Author: Zilleyy
 * <br>
 * Date: 22/05/2021 @ 5:54 pm AEST
 */
public final class Team {

    @Getter private final List<MatchProfile> members = new ArrayList<>();
    @Getter private final List<Recipe> completedRecipes = new ArrayList<>();

    @Getter private final Match match;
    @Getter private final ChatColor colour;

    public Team(final Match match, final ChatColor colour) {
        this.match = match;
        this.colour = colour;
    }

    public final boolean addTeamMember(final MatchProfile matchProfile) {
        return this.members.add(matchProfile);
    }

    public final boolean removeTeamMember(final MatchProfile matchProfile) {
        return this.members.remove(matchProfile);
    }

    public final boolean addCompletedRecipe(final Recipe recipe) {
        return this.completedRecipes.add(recipe);
    }

    public enum TeamColour {

        RED,
        BLUE,
        GREEN,
        YELLOW,
        ORANGE

    }

}
