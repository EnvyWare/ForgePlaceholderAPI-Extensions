package com.envyful.placeholders.reforged.extension.party.impl;

import com.envyful.placeholders.reforged.extension.party.PartyReforgedExtension;
import com.google.common.collect.Lists;
import com.pixelmonmod.pixelmon.api.pokemon.Pokemon;
import net.minecraft.entity.player.EntityPlayerMP;

import java.util.List;

public class PartyStatsEVsTotalExtension extends PartyReforgedExtension {

    private static final String NAME = "stats_evs_total";
    private static final int PRIORITY = 1;
    private static final List<String> DESCRIPTION = Lists.newArrayList("Gets the pokemon's EVs number in the given slot");
    private static final List<String> EXAMPLES = Lists.newArrayList("%reforged_party_slot_1_stats_evs_total%");

    public PartyStatsEVsTotalExtension() {
        super(NAME, PRIORITY, DESCRIPTION, EXAMPLES);
    }

    @Override
    protected String parse(EntityPlayerMP player, String placeholder, Pokemon pokemon) {
        if (pokemon == null) {
            return "N/A";
        }

        int total = 0;

        for (int i : pokemon.getEVs().getArray()) {
            total+=i;
        }

        return total + "";
    }
}