package com.envyful.placeholders.reforged.extension;

import com.envyful.papi.api.manager.extensions.type.SimpleExtension;
import com.google.common.collect.Lists;
import com.pixelmonmod.pixelmon.api.storage.PlayerPartyStorage;
import com.pixelmonmod.pixelmon.api.storage.StorageProxy;
import net.minecraft.entity.player.ServerPlayerEntity;

import java.util.List;

public class AverageLevelExtension extends SimpleExtension<ServerPlayerEntity> {

    private static final String NAME = "average_level";
    private static final int PRIORITY = 1;
    private static final List<String> DESCRIPTION = Lists.newArrayList("Gets the player's party's average level");
    private static final List<String> EXAMPLES = Lists.newArrayList("%reforged_average_level%");

    public AverageLevelExtension() {
        super(NAME, PRIORITY, DESCRIPTION, EXAMPLES);
    }

    @Override
    public String parse(ServerPlayerEntity player, String placeholder) {
        PlayerPartyStorage party = StorageProxy.getParty(player);
        return party.getAverageLevel() + "";
    }
}
