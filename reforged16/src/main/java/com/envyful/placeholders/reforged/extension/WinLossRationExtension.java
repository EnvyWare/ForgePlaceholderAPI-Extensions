package com.envyful.placeholders.reforged.extension;

import com.envyful.papi.api.manager.extensions.type.SimpleExtension;
import com.google.common.collect.Lists;
import com.pixelmonmod.pixelmon.api.storage.PlayerPartyStorage;
import com.pixelmonmod.pixelmon.api.storage.StorageProxy;
import net.minecraft.entity.player.ServerPlayerEntity;

import java.util.List;

public class WinLossRationExtension extends SimpleExtension<ServerPlayerEntity> {

    private static final String NAME = "wl_ratio";
    private static final int PRIORITY = 1;
    private static final List<String> DESCRIPTION = Lists.newArrayList("Gets the player's win loss ratio");
    private static final List<String> EXAMPLES = Lists.newArrayList("%reforged_wl_ratio%");

    public WinLossRationExtension() {
        super(NAME, PRIORITY, DESCRIPTION, EXAMPLES);
    }

    @Override
    public String parse(ServerPlayerEntity player, String placeholder) {
        PlayerPartyStorage party = StorageProxy.getParty(player);

        if (party.stats == null || party.stats.getLosses() == 0) {
            return "0";
        }

        return String.format("%.2f", ((party.stats.getWins() + 0.000) / party.stats.getLosses()));
    }
}
