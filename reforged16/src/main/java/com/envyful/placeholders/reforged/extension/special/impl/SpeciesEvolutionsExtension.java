package com.envyful.placeholders.reforged.extension.special.impl;

import com.envyful.placeholders.reforged.extension.special.MatcherReforgedExtension;
import com.google.common.collect.Lists;
import com.pixelmonmod.api.pokemon.requirement.impl.SpeciesRequirement;
import com.pixelmonmod.pixelmon.api.pokemon.species.Species;
import com.pixelmonmod.pixelmon.api.pokemon.stats.evolution.Evolution;
import net.minecraft.entity.player.ServerPlayerEntity;

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
    protected String parse(ServerPlayerEntity player, String placeholder, Species species) {
        if (species == null) {
            return "N/A";
        }

        List<String> evolutions = Lists.newArrayList();

        evolutions.addAll(Arrays.asList(species.getDefaultForm().getPreEvolutions().toString()));

        for (Evolution evolution : species.getDefaultForm().getEvolutions()) {
            evolutions.add(evolution.to.getValue(SpeciesRequirement.class).map(speciesRegistryValue -> speciesRegistryValue.getValueUnsafe().getLocalizedName()).orElse(""));
        }

        return String.join(", ", evolutions);
    }
}
