package com.envyful.placeholders.cmi.extensions;

import com.Zrips.CMI.CMI;
import com.Zrips.CMI.Containers.CMIUser;
import com.envyful.papi.api.manager.extensions.type.SimpleExtension;
import com.google.common.collect.Lists;
import net.minecraft.entity.player.EntityPlayerMP;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class PlaytimeExtension extends SimpleExtension<EntityPlayerMP> {

    private static final String NAME = "playtime";
    private static final int PRIORITY = 1;
    private static final List<String> DESCRIPTION = Lists.newArrayList("Gets the player's playtime");
    private static final List<String> EXAMPLES = Lists.newArrayList("%cmi_playtime%");

    public PlaytimeExtension() {
        super(NAME, PRIORITY, DESCRIPTION, EXAMPLES);
    }

    @Override
    public String parse(EntityPlayerMP player, String placeholder) {
        CMIUser user = CMI.getInstance().getPlayerManager().getUser(player.getUniqueID());
        long time = user.getTotalPlayTime();
        Duration duration = Duration.ofMillis(time);

        return String.format("%d day(s) %d hour(s) %02d minute(s) and %02d second(s)",
                             duration.get(ChronoUnit.SECONDS) / (60 * 60 * 24),
                             duration.get(ChronoUnit.SECONDS) / (60 * 60),
                             (duration.get(ChronoUnit.SECONDS) / 60) % 60,
                             duration.get(ChronoUnit.SECONDS) % 60);
    }
}
