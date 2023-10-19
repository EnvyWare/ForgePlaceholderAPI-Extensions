package com.envyful.placeholders.reforged.extension;

import com.envyful.papi.api.manager.extensions.type.SimpleExtension;
import com.google.common.collect.Lists;
import com.pixelmonmod.pixelmon.api.storage.PlayerPartyStorage;
import com.pixelmonmod.pixelmon.api.storage.StorageProxy;
import net.minecraft.server.level.ServerPlayer;

import java.util.List;

public class DexCountExtension extends SimpleExtension<ServerPlayer> {

    private static final String NAME = "dex_count";
    private static final int PRIORITY = 1;
    private static final List<String> DESCRIPTION = Lists.newArrayList("Gets the player's dex caught count");
    private static final List<String> EXAMPLES = Lists.newArrayList("%reforged_dex_count%");

    public DexCountExtension() {
        super(NAME, PRIORITY, DESCRIPTION, EXAMPLES);
    }

    @Override
    public String parse(ServerPlayer player, String placeholder) {
        PlayerPartyStorage party = StorageProxy.getPartyNow(player);
        return party.playerPokedex.countCaught() + "";
    }
}
