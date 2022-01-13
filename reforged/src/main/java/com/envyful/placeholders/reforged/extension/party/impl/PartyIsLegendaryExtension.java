package com.envyful.placeholders.reforged.extension.party.impl;

import com.envyful.placeholders.reforged.extension.party.PartyReforgedExtension;
import com.google.common.collect.Lists;
import com.pixelmonmod.pixelmon.api.pokemon.Pokemon;
import com.pixelmonmod.pixelmon.entities.pixelmon.stats.StatsType;
import net.minecraft.entity.player.EntityPlayerMP;

import java.util.List;

public class PartyIsLegendaryExtension extends PartyReforgedExtension {

    private static final String NAME = "is_legendary";
    private static final int PRIORITY = 1;
    private static final List<String> DESCRIPTION = Lists.newArrayList("Gets if the pokemon is legendary");
    private static final List<String> EXAMPLES = Lists.newArrayList("%reforged_party_slot_1_is_legendary%");

    public PartyIsLegendaryExtension() {
        super(NAME, PRIORITY, DESCRIPTION, EXAMPLES);
    }

    @Override
    protected String parse(EntityPlayerMP player, String placeholder, Pokemon pokemon) {
        return pokemon.isLegendary() + "";
    }
}
