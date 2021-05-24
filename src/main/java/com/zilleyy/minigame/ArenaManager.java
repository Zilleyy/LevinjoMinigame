package com.zilleyy.minigame;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: Zilleyy
 * <br>
 * Date: 22/05/2021 @ 5:48 pm AEST
 */
public class ArenaManager {

    private static final List<Arena> arenas = new ArrayList<>();

    public static Arena getArena(String name) {
        for(Arena arena : ArenaManager.arenas) {
            if(arena.getName().equals(name)) return arena;
        }

        return null;
    }

}
