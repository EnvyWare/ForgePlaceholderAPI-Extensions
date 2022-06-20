package com.envyful.placeholders.reforged.extension.special.impl;

import com.envyful.placeholders.reforged.extension.special.MatcherReforgedExtension;
import com.google.common.collect.Lists;
import com.pixelmonmod.pixelmon.api.pokemon.species.Species;
import net.minecraft.entity.player.ServerPlayerEntity;

import java.util.Arrays;
import java.util.List;

public class SpeciesPreEvolutionsExtension extends MatcherReforgedExtension {

    private static final String NAME = "preevolutions";
    private static final int PRIORITY = 1;
    private static final List<String> DESCRIPTION = Lists.newArrayList("Gets the pokemon's pre evolutions");
    private static final List<String> EXAMPLES = Lists.newArrayList("%reforged_pokedex_bulbasaur_preevolutions%");

    public SpeciesPreEvolutionsExtension() {
        super(NAME, PRIORITY, DESCRIPTION, EXAMPLES);
    }

    @Override
    protected String parse(ServerPlayerEntity player, String placeholder, Species species) {
        if (species == null) {
            return "N/A";
        }

        return String.join(", ", Arrays.asList(species.getDefaultForm().getPreEvolutions().toString()));
    }
}
