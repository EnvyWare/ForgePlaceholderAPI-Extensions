package com.envyful.placeholders.reforged.extension.party.impl;

import com.envyful.placeholders.reforged.extension.party.PartyReforgedExtension;
import com.google.common.collect.Lists;
import com.pixelmonmod.pixelmon.api.pokemon.Pokemon;
import com.pixelmonmod.pixelmon.entities.pixelmon.stats.StatsType;
import net.minecraft.entity.player.EntityPlayerMP;

import java.util.List;

public class PartyStatsAttackExtension extends PartyReforgedExtension {

    private static final String NAME = "stats_atk";
    private static final int PRIORITY = 1;
    private static final List<String> DESCRIPTION = Lists.newArrayList("Gets the pokemon's attack stat in the given slot");
    private static final List<String> EXAMPLES = Lists.newArrayList("%reforged_party_1_stats_atk%");

    public PartyStatsAttackExtension() {
        super(NAME, PRIORITY, DESCRIPTION, EXAMPLES);
    }

    @Override
    protected String parse(EntityPlayerMP player, String placeholder, Pokemon pokemon) {
        return pokemon.getStats().get(StatsType.Attack) + "";
    }
}