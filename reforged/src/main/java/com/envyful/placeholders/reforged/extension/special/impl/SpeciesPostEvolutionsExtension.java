package com.envyful.placeholders.reforged.extension.special.impl;

import com.envyful.placeholders.reforged.extension.special.MatcherReforgedExtension;
import com.google.common.collect.Lists;
import com.pixelmonmod.pixelmon.entities.pixelmon.stats.evolution.Evolution;
import com.pixelmonmod.pixelmon.enums.EnumSpecies;
import net.minecraft.entity.player.EntityPlayerMP;

import java.util.List;

public class SpeciesPostEvolutionsExtension extends MatcherReforgedExtension {

    private static final String NAME = "postevolutions";
    private static final int PRIORITY = 1;
    private static final List<String> DESCRIPTION = Lists.newArrayList("Gets the pokemon's post evolutions");
    private static final List<String> EXAMPLES = Lists.newArrayList("%reforged_pokedex_bulbasaur_postevolutions%");

    public SpeciesPostEvolutionsExtension() {
        super(NAME, PRIORITY, DESCRIPTION, EXAMPLES);
    }

    @Override
    protected String parse(EntityPlayerMP player, String placeholder, EnumSpecies species) {
        List<String> postEvolutions = Lists.newArrayList();

        for (Evolution evolution : species.getBaseStats().getEvolutions()) {
            postEvolutions.add(evolution.to.name);
        }

        return String.join(", ", postEvolutions);
    }
}
