package com.zilleyy.minigame;

import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;

import java.util.*;

/**
 * Author: Zilleyy
 * <br>
 * Date: 22/05/2021 @ 6:26 pm AEST
 */
public final class Match {

    @Getter private MatchState state;
    @Getter private final MatchProfileManager matchProfileManager;
    @Getter private final Recipe[] recipes = new Recipe[3];
    @Getter private final List<Team> teams = new ArrayList<>();

    @Getter private final Arena arena;

    public Match(final Arena arena, final UUID... members) {
        this.arena = arena;

        this.matchProfileManager = new MatchProfileManager();
        for(UUID uuid : members) {
            this.matchProfileManager.addMatchProfile(new MatchProfile(uuid, null /* TODO Team */));
        }

        final Random random = new Random();
        for(int i = 0; i < 3; i++) {
            this.recipes[i] = Bukkit.getRecipesFor(new ItemStack(Material.values()[random.nextInt(Material.values().length)])).get(0);
        }

        this.createTeams();
    }

    public final void createTeams() {
        for(final ChatColor chatColor : ChatColor.values()) {
            this.teams.add(new Team(this, chatColor));
        }
    }

    public final void handleCrafting(final Recipe recipe, final MatchProfile matchProfile) {
        matchProfile.getTeam().getCompletedRecipes().add(recipe);

        for(final MatchProfile value : this.matchProfileManager.getMatchProfiles()) {
            value.getPlayer().sendMessage(matchProfile.getPlayer() + " crafted a " + recipe.getResult().getType().name());
        }
    }

    public final void broadcastMessage(String message) {
        for(final MatchProfile matchProfile : this.matchProfileManager.getMatchProfiles()) {
            matchProfile.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', message));
        }
    }

    public final void startMatch() {

    }

    public final void finishMatch() {

    }

}
