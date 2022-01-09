package com.envyful.placeholders.reforged.extension;

import com.envyful.papi.api.manager.extensions.type.SimpleExtension;
import com.google.common.collect.Lists;
import com.pixelmonmod.pixelmon.pokedex.Pokedex;
import com.pixelmonmod.pixelmon.spawning.PixelmonSpawning;
import net.minecraft.entity.player.EntityPlayerMP;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class NextLegendaryExtension extends SimpleExtension<EntityPlayerMP> {

    private static final String NAME = "nextlegendary";
    private static final int PRIORITY = 1;
    private static final List<String> DESCRIPTION = Lists.newArrayList("Gets the next legendary spawn time");
    private static final List<String> EXAMPLES = Lists.newArrayList("%reforged_nextlegendary%");

    public NextLegendaryExtension() {
        super(NAME, PRIORITY, DESCRIPTION, EXAMPLES);
    }

    @Override
    public String parse(EntityPlayerMP player, String placeholder) {
        return TimeUnit.MILLISECONDS.toSeconds(PixelmonSpawning.legendarySpawner.nextSpawnTime - System.currentTimeMillis()) + "";
    }
}
