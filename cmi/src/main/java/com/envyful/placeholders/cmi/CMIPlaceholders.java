package com.envyful.placeholders.cmi;

import com.Zrips.CMI.CMI;
import com.Zrips.CMI.Containers.CMIUser;
import com.envyful.papi.api.PlaceholderManager;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.fml.common.FMLCommonHandler;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class CMIPlaceholders implements PlaceholderManager<EntityPlayerMP> {

    @Override
    public String getIdentifier() {
        return "cmi";
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
        CMIUser user = CMI.getInstance().getPlayerManager().getUser(player.getUniqueID());

        switch (placeholder.toLowerCase()) {
            case "balance":
                return user.getFormatedBalance();
            case "playtime":
                long time = user.getTotalPlayTime();
                Duration duration = Duration.ofMillis(time);

                return String.format("%d day(s) %d hour(s) %02d minute(s) and %02d second(s)",
                        duration.get(ChronoUnit.SECONDS) / (60 * 60 * 24),
                        duration.get(ChronoUnit.SECONDS) / (60 * 60),
                        (duration.get(ChronoUnit.SECONDS) / 60) % 60,
                        duration.get(ChronoUnit.SECONDS) % 60);
            case "next_rank" :
                if (user.getRank() == null || user.getRank().getNextRanks().isEmpty()) {
                    return "";
                }

                return user.getRank().getNextRanks().get(0).getDisplayName();
            case "server_online":
                return FMLCommonHandler.instance().getMinecraftServerInstance().getPlayerList().getPlayers().size() + "";
        }

        return "UNDEFINED";
    }
}
