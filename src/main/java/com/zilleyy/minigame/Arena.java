package com.zilleyy.minigame;

import lombok.Getter;
import lombok.Setter;

/**
 * Author: Zilleyy
 * <br>
 * Date: 22/05/2021 @ 5:48 pm AEST
 */
public final class Arena {

    @Getter private final String name;
    @Getter private final Cuboid cuboid;
    @Getter @Setter private Match match;

    public Arena(final String name, String worldName, final int x1, final int y1, final int z1, final int x2, final int y2, final int z2) {
        this.name = name;
        this.cuboid = new Cuboid(worldName, x1, y1, z1, x2, y2, z2);
    }

}
