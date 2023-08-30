package com.envyful.placeholders.poketracker.extension;

import com.envyful.papi.api.manager.extensions.AbstractExtension;
import com.envyful.placeholders.poketracker.PokeTrackerForgePlaceholders;
import com.envyful.poke.tracker.forge.tracker.PokeTrackerFactory;
import com.envyful.poke.tracker.forge.tracker.data.EntityData;
import net.minecraft.server.level.ServerPlayer;

import java.util.List;

public abstract class PokeTrackerExtension extends AbstractExtension<ServerPlayer> {

    public PokeTrackerExtension(String name, int priority, List<String> description, List<String> examples) {
        super(name, priority, description, examples);
    }

    @Override
    public boolean matches(ServerPlayer player, String placeholder) {
        return placeholder.startsWith(this.getName() + "_");
    }

    @Override
    public String parse(ServerPlayer player, String placeholder) {
        String[] args = placeholder.split("_");

        if (args.length < 3) {
            return null;
        }

        List<EntityData> trackedEntities = PokeTrackerFactory.getTrackedEntities(args[1]);

        if (trackedEntities == null) {
            return null;
        }

        int pos = PokeTrackerForgePlaceholders.parseInt(args[2]) - 1;

        if (trackedEntities.size() <= pos) {
            return null;
        }

        return this.parse(player, placeholder, trackedEntities.get(pos));
    }

    public abstract String parse(ServerPlayer player, String placeholder, EntityData entityData);
}
