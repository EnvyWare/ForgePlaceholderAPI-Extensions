package com.envyful.placeholders.reforged.extension.special.impl;

import com.envyful.placeholders.reforged.extension.special.MatcherReforgedExtension;
import com.google.common.collect.Lists;
import com.pixelmonmod.pixelmon.api.pokemon.species.Species;
import com.pixelmonmod.pixelmon.api.pokemon.stats.BattleStatsType;
import net.minecraft.entity.player.ServerPlayerEntity;

import java.util.List;

public class SpeciesBaseStatsAttackExtension extends MatcherReforgedExtension {

    private static final String NAME = "basestats_atk";
    private static final int PRIORITY = 1;
    private static final List<String> DESCRIPTION = Lists.newArrayList("Gets the pokemon's base stats Attack");
    private static final List<String> EXAMPLES = Lists.newArrayList("%reforged_pokedex_bulbasaur_basestats_atk%");

    public SpeciesBaseStatsAttackExtension() {
        super(NAME, PRIORITY, DESCRIPTION, EXAMPLES);
    }

    @Override
    protected String parse(ServerPlayerEntity player, String placeholder, Species species) {
        if (species == null) {
            return "N/A";
        }

        return species.getDefaultForm().getBattleStats().getStat(BattleStatsType.ATTACK) + "";
    }
}
