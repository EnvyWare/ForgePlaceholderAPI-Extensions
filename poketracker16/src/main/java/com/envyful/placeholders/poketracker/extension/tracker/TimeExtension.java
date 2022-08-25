package com.envyful.placeholders.poketracker.extension.tracker;

import com.envyful.placeholders.poketracker.PokeTrackerForgePlaceholders;
import com.envyful.placeholders.poketracker.extension.PokeTrackerExtension;
import com.envyful.poke.tracker.forge.tracker.data.EntityData;
import com.google.common.collect.Lists;
import net.minecraft.entity.player.ServerPlayerEntity;

import java.util.List;

public class TimeExtension extends PokeTrackerExtension {

    private static final String NAME = "time";
    private static final int PRIORITY = 1;
    private static final List<String> DESCRIPTION = Lists.newArrayList("Gets the pokemon's last spawn time");
    private static final List<String> EXAMPLES = Lists.newArrayList("%poketracker_time_legendary_1%");

    public TimeExtension() {
        super(NAME, PRIORITY, DESCRIPTION, EXAMPLES);
    }

    @Override
    public String parse(ServerPlayerEntity player, String placeholder, EntityData entityData) {
        return PokeTrackerForgePlaceholders.getFormattedDuration(System.currentTimeMillis() - entityData.getSpawnTime());
    }
}
