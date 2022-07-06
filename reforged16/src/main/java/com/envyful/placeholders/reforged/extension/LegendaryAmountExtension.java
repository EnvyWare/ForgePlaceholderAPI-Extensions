package com.envyful.placeholders.reforged.extension;

import com.envyful.papi.api.manager.extensions.type.SimpleExtension;
import com.google.common.collect.Lists;
import com.pixelmonmod.pixelmon.api.pokemon.Pokemon;
import com.pixelmonmod.pixelmon.api.storage.PCStorage;
import com.pixelmonmod.pixelmon.api.storage.PlayerPartyStorage;
import com.pixelmonmod.pixelmon.api.storage.StorageProxy;
import net.minecraft.entity.player.ServerPlayerEntity;

import java.util.List;

public class LegendaryAmountExtension extends SimpleExtension<ServerPlayerEntity> {

    private static final String NAME = "legendary_amount";
    private static final int PRIORITY = 1;
    private static final List<String> DESCRIPTION = Lists.newArrayList("Gets the player's legendary amount");
    private static final List<String> EXAMPLES = Lists.newArrayList("%reforged_legendary_amount%");

    public LegendaryAmountExtension() {
        super(NAME, PRIORITY, DESCRIPTION, EXAMPLES);
    }

    @Override
    public String parse(ServerPlayerEntity player, String placeholder) {
        PlayerPartyStorage party = StorageProxy.getParty(player);
        PCStorage pc = StorageProxy.getPCForPlayer(player);

        int leg = 0;

        for (Pokemon pokemon : party.getAll()) {
            if (pokemon != null && pokemon.isLegendary()) {
                leg += 1;
			}
        }

        for (Pokemon pokemon : pc.getAll()) {
            if (pokemon != null && pokemon.isLegendary()) {
                leg += 1;
			}
        }

        return leg + "";
    }
}