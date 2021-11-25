package com.envyful.placeholders.poketracker;

import com.envyful.api.time.UtilTimeFormat;
import com.envyful.api.type.UtilParse;
import com.envyful.papi.api.PlaceholderManager;
import com.envyful.poke.tracker.forge.tracker.PokeTrackerFactory;
import com.envyful.poke.tracker.forge.tracker.data.EntityData;
import net.minecraft.entity.player.EntityPlayerMP;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class PokeTrackerForgePlaceholders implements PlaceholderManager<EntityPlayerMP> {

    private static final DateFormat DATE_FORMATTER = new SimpleDateFormat("dd/MM/yyyy");
    private static final long SECONDS_PER_MINUTE = 60;
    private static final long MINUTES_PER_HOUR = 60;
    private static final long SECONDS_PER_HOUR = SECONDS_PER_MINUTE * MINUTES_PER_HOUR;
    private static final long SECONDS_PER_DAY = SECONDS_PER_HOUR * 24;

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

        if (args.length < 3) {
            return "UNDEFINED";
        }

        List<EntityData> trackedEntities = PokeTrackerFactory.getTrackedEntities(args[1]);

        if (trackedEntities == null) {
            return "SETTING NOT FOUND";
        }

        int pos = this.parseInt(args[2]) - 1;

        if (trackedEntities.size() <= pos) {
            return "None";
        }

        EntityData entityData = trackedEntities.get(pos);

        switch(args[0]) {
            case "pokemon":
                return entityData.getPokemonName();
            case "time" :
                return getFormattedDuration(System.currentTimeMillis() - entityData.getSpawnTime());
            case "status" :
                if (entityData.isCaught()) {
                    return "Caught";
                }

                if (entityData.getEntity() == null) {
                    return "Despawned";
                }

                return "Active";
            case "catcher" :
                return entityData.getCatcher();
        }

        return "UNDEFINED";
    }

    private int parseInt(String s) {
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public String getFormattedDuration(long playTime) {
        long seconds = TimeUnit.SECONDS.convert(playTime, TimeUnit.MILLISECONDS);

        long daysPart = (seconds / SECONDS_PER_DAY);
        long hoursPart = (seconds / SECONDS_PER_HOUR) % 24;
        long minutesPart = (seconds / SECONDS_PER_MINUTE) % MINUTES_PER_HOUR;
        long secondsPart = (seconds) % SECONDS_PER_MINUTE;

        StringBuilder builder = new StringBuilder();

        if (daysPart > 0) {
            builder.append(daysPart).append("d ");
        }

        if (hoursPart > 0) {
            builder.append(hoursPart).append("h ");
        }

        if (minutesPart > 0) {
            builder.append(minutesPart).append("m ");
        }

        if (secondsPart > 0) {
            builder.append(secondsPart).append("s");
        } else {
            builder.append("0s");
        }

        return builder.toString();
    }
}
