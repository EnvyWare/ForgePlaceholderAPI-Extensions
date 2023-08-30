package com.envyful.placeholders.reforged.extension.special.impl;

import com.envyful.placeholders.reforged.extension.special.MatcherReforgedExtension;
import com.google.common.collect.Lists;
import com.pixelmonmod.api.pokemon.requirement.impl.SpeciesRequirement;
import com.pixelmonmod.pixelmon.api.pokemon.species.Species;
import com.pixelmonmod.pixelmon.api.pokemon.stats.evolution.Evolution;
import net.minecraft.server.level.ServerPlayer;

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
    protected String parse(ServerPlayer player, String placeholder, Species species) {
        if (species == null) {
            return "N/A";
        }

        List<String> postEvolutions = Lists.newArrayList();

        for (Evolution evolution : species.getDefaultForm().getEvolutions()) {
            postEvolutions.add(evolution.to.getValue(SpeciesRequirement.class).map(speciesRegistryValue -> speciesRegistryValue.getValueUnsafe().getLocalizedName()).orElse(""));
        }

        return String.join(", ", postEvolutions);
    }
}
