package com.envyful.placeholders.poketracker;

import com.envyful.papi.api.manager.AbstractPlaceholderManager;
import com.envyful.placeholders.poketracker.extension.tracker.CatcherExtension;
import com.envyful.placeholders.poketracker.extension.tracker.PokemonNameExtension;
import com.envyful.placeholders.poketracker.extension.tracker.StatusExtension;
import com.envyful.placeholders.poketracker.extension.tracker.TimeExtension;
import com.envyful.poke.tracker.forge.tracker.PokeTrackerFactory;
import com.envyful.poke.tracker.forge.tracker.data.EntityData;
import net.minecraft.entity.player.EntityPlayerMP;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class PokeTrackerForgePlaceholders extends AbstractPlaceholderManager<EntityPlayerMP> {

    private static final String IDENTIFIER = "poketracker";
    private static final String[] AUTHORS = new String[] { "Envyful" };
    private static final String VERSION = "2.8.4";
    private static final String NAME = "poketracker";

    public static final DateFormat DATE_FORMATTER = new SimpleDateFormat("dd/MM/yyyy");
    public static final long SECONDS_PER_MINUTE = 60;
    public static final long MINUTES_PER_HOUR = 60;
    public static final long SECONDS_PER_HOUR = SECONDS_PER_MINUTE * MINUTES_PER_HOUR;
    public static final long SECONDS_PER_DAY = SECONDS_PER_HOUR * 24;

    public PokeTrackerForgePlaceholders() {
        super(IDENTIFIER, AUTHORS, VERSION, NAME, EntityPlayerMP.class);

        this.registerPlaceholder(new CatcherExtension());
        this.registerPlaceholder(new PokemonNameExtension());
        this.registerPlaceholder(new StatusExtension());
        this.registerPlaceholder(new TimeExtension());
    }

    public static int parseInt(String s) {
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public static String getFormattedDuration(long playTime) {
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
