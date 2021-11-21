package com.envyful.placeholders.poketracker;

import com.envyful.api.time.UtilTimeFormat;
import com.envyful.api.type.UtilParse;
import com.envyful.papi.api.PlaceholderManager;
import com.envyful.poke.tracker.forge.tracker.PokeTrackerFactory;
import com.envyful.poke.tracker.forge.tracker.data.EntityData;
import net.minecraft.entity.player.EntityPlayerMP;

import java.util.List;

public class PokeTrackerForgePlaceholders implements PlaceholderManager<EntityPlayerMP> {

    @Override
    public String getIdentifier() {
        return "poketracker";
    }

    @Override
    public String[] getAuthors() {
        return new String[] { "Envyful" };
    }

    @Override
    public String getVersion() {
        return "1.0.0";
    }

    @Override
    public String getName() {
        return getIdentifier();
    }

    @Override
    public String onPlaceholderRequest(EntityPlayerMP player, String placeholder) {
        String[] args = placeholder.split("_");

        if (args.length < 4) {
            return "UNDEFINED";
        }

        List<EntityData> trackedEntities = PokeTrackerFactory.getTrackedEntities(args[2]);

        if (trackedEntities == null) {
            return "SETTING NOT FOUND";
        }

        int pos = UtilParse.parseInteger(args[3]).orElse(0);

        if (trackedEntities.size() <= pos) {
            return "None";
        }

        EntityData entityData = trackedEntities.get(pos);

        switch(args[1]) {
            case "pokemon":
                return entityData.getPokemonName();
            case "time" :
                return UtilTimeFormat.getFormattedDuration(System.currentTimeMillis() - entityData.getSpawnTime());
            case "status" :
                if (entityData.isCaught()) {
                    return "Caught";
                }

                if (entityData.getEntity() == null) {
                    return "Despawned";
                }

                return "Active";
        }

        return "UNDEFINED";
    }
}
