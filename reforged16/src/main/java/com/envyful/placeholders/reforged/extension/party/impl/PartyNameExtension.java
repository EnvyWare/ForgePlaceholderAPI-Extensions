package com.envyful.placeholders.reforged.extension.party.impl;

import com.envyful.placeholders.reforged.extension.party.PartyReforgedExtension;
import com.google.common.collect.Lists;
import com.pixelmonmod.pixelmon.api.pokemon.Pokemon;
import net.minecraft.entity.player.ServerPlayerEntity;

import java.util.List;

public class PartyNameExtension extends PartyReforgedExtension {

    private static final String NAME = "name";
    private static final int PRIORITY = 1;
    private static final List<String> DESCRIPTION = Lists.newArrayList("Gets the pokemon's name in the given slot");
    private static final List<String> EXAMPLES = Lists.newArrayList("%reforged_party_slot_1_name%");

    public PartyNameExtension() {
        super(NAME, PRIORITY, DESCRIPTION, EXAMPLES);
    }

    @Override
    protected String parse(ServerPlayerEntity player, String placeholder, Pokemon pokemon) {
        if (pokemon == null) {
            return "N/A";
        }

        return pokemon.getSpecies().getLocalizedName();
    }
}
