package com.envyful.placeholders.reforged.extension.special.impl;

import com.envyful.placeholders.reforged.extension.special.MatcherReforgedExtension;
import com.google.common.collect.Lists;
import com.pixelmonmod.pixelmon.entities.pixelmon.stats.evolution.Evolution;
import com.pixelmonmod.pixelmon.enums.EnumSpecies;
import net.minecraft.entity.player.EntityPlayerMP;

import java.util.Arrays;
import java.util.List;

public class SpeciesEvolutionsExtension extends MatcherReforgedExtension {

    private static final String NAME = "evolutions";
    private static final int PRIORITY = 1;
    private static final List<String> DESCRIPTION = Lists.newArrayList("Gets the pokemon's evolutions");
    private static final List<String> EXAMPLES = Lists.newArrayList("%reforged_pokedex_bulbasaur_evolutions%");

    public SpeciesEvolutionsExtension() {
        super(NAME, PRIORITY, DESCRIPTION, EXAMPLES);
    }

    @Override
    protected String parse(EntityPlayerMP player, String placeholder, EnumSpecies species) {
        if (species == null) {
            return "N/A";
        }

        List<String> evolutions = Lists.newArrayList();

        evolutions.addAll(Arrays.asList(species.getBaseStats().preEvolutions));

        for (Evolution evolution : species.getBaseStats().getEvolutions()) {
            evolutions.add(evolution.to.name);
        }

        return String.join(", ", evolutions);
    }
}
