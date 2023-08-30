package com.envyful.placeholders.reforged.extension.special.impl;

import com.envyful.placeholders.reforged.extension.special.MatcherReforgedExtension;
import com.google.common.collect.Lists;
import com.pixelmonmod.pixelmon.api.pokemon.species.Species;
import net.minecraft.server.level.ServerPlayer;

import java.util.List;

public class SpeciesFirstTypeExtension extends MatcherReforgedExtension {

    private static final String NAME = "type_1";
    private static final int PRIORITY = 1;
    private static final List<String> DESCRIPTION = Lists.newArrayList("Gets the pokemon's first type");
    private static final List<String> EXAMPLES = Lists.newArrayList("%reforged_pokedex_bulbasaur_type_1%");

    public SpeciesFirstTypeExtension() {
        super(NAME, PRIORITY, DESCRIPTION, EXAMPLES);
    }

    @Override
    protected String parse(ServerPlayer player, String placeholder, Species species) {
        if (species == null) {
            return "N/A";
        }

        if (species.getDefaultForm().getTypes().get(0) == null) {
            return null;
        }

        return species.getDefaultForm().getTypes().get(1).getLocalizedName();
    }
}
