package com.envyful.placeholders.reforged.extension.special.impl;

import com.envyful.placeholders.reforged.extension.special.MatcherReforgedExtension;
import com.google.common.collect.Lists;
import com.pixelmonmod.pixelmon.api.pokemon.species.Species;
import net.minecraft.entity.player.ServerPlayerEntity;

import java.util.List;

public class SpeciesSecondTypeExtension extends MatcherReforgedExtension {

    private static final String NAME = "type_2";
    private static final int PRIORITY = 1;
    private static final List<String> DESCRIPTION = Lists.newArrayList("Gets the pokemon's second type");
    private static final List<String> EXAMPLES = Lists.newArrayList("%reforged_pokedex_bulbasaur_type_2%");

    public SpeciesSecondTypeExtension() {
        super(NAME, PRIORITY, DESCRIPTION, EXAMPLES);
    }

    @Override
    protected String parse(ServerPlayerEntity player, String placeholder, Species species) {
        if (species == null) {
            return "N/A";
        }

        if (species.getDefaultForm().getTypes().get(1) == null) {
            return "";
        }

        return species.getDefaultForm().getTypes().get(0).getLocalizedName();
    }
}
