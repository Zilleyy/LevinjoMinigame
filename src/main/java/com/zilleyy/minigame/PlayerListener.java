package com.zilleyy.minigame;

import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.inventory.Recipe;

/**
 * Author: Zilleyy
 * <br>
 * Date: 22/05/2021 @ 6:39 pm AEST
 */
public class PlayerListener implements Listener {

    public PlayerListener() {}

    @EventHandler
    public void onCraft(final CraftItemEvent event) {
        final Player player = (Player) event.getWhoClicked();
        final Match match = MatchManager.getMatch(player);
        final Recipe[] recipes = MatchManager.getMatch(player).getRecipes();
        for(Recipe recipe : recipes) {
            if(recipe.equals(event.getRecipe())) match.handleCrafting(recipe, match.getMatchProfileManager().getMatchProfile(player));
        }
    }

}
