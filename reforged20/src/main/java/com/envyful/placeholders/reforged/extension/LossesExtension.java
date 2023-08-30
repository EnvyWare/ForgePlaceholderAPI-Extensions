package com.envyful.placeholders.reforged.extension;

import com.envyful.papi.api.manager.extensions.type.SimpleExtension;
import com.google.common.collect.Lists;
import com.pixelmonmod.pixelmon.api.storage.PlayerPartyStorage;
import com.pixelmonmod.pixelmon.api.storage.StorageProxy;
import net.minecraft.server.level.ServerPlayer;

import java.util.List;

public class LossesExtension extends SimpleExtension<ServerPlayer> {

    private static final String NAME = "losses";
    private static final int PRIORITY = 1;
    private static final List<String> DESCRIPTION = Lists.newArrayList("Gets the player's losses");
    private static final List<String> EXAMPLES = Lists.newArrayList("%reforged_losses%");

    public LossesExtension() {
        super(NAME, PRIORITY, DESCRIPTION, EXAMPLES);
    }

    @Override
    public String parse(ServerPlayer player, String placeholder) {
        PlayerPartyStorage party = StorageProxy.getParty(player);
        
        if (party.stats == null) {
            return "0";
        }

        return party.stats.getLosses() + "";
    }
}
