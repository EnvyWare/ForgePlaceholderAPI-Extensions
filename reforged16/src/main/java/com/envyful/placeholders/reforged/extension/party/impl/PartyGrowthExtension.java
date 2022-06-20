package com.envyful.placeholders.reforged.extension.party.impl;

import com.envyful.placeholders.reforged.extension.party.PartyReforgedExtension;
import com.google.common.collect.Lists;
import com.pixelmonmod.pixelmon.api.pokemon.Pokemon;
import net.minecraft.entity.player.ServerPlayerEntity;

import java.util.List;

public class PartyGrowthExtension extends PartyReforgedExtension {

    private static final String NAME = "growth";
    private static final int PRIORITY = 1;
    private static final List<String> DESCRIPTION = Lists.newArrayList("Gets the pokemon's growth in the given slot");
    private static final List<String> EXAMPLES = Lists.newArrayList("%reforged_party_slot_1_growth%");

    public PartyGrowthExtension() {
        super(NAME, PRIORITY, DESCRIPTION, EXAMPLES);
    }

    @Override
    protected String parse(ServerPlayerEntity player, String placeholder, Pokemon pokemon) {
        if (pokemon == null) {
            return "N/A";
        }

        return pokemon.getGrowth().getLocalizedName();
    }
}
