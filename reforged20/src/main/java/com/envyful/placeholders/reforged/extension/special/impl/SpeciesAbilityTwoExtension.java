package com.envyful.placeholders.reforged.extension.special.impl;

import com.envyful.placeholders.reforged.extension.special.MatcherReforgedExtension;
import com.google.common.collect.Lists;
import com.pixelmonmod.pixelmon.api.pokemon.species.Species;
import net.minecraft.server.level.ServerPlayer;

import java.util.List;

public class SpeciesAbilityTwoExtension extends MatcherReforgedExtension {

    private static final String NAME = "ability_2";
    private static final int PRIORITY = 1;
    private static final List<String> DESCRIPTION = Lists.newArrayList("Gets the pokemon's second ability");
    private static final List<String> EXAMPLES = Lists.newArrayList("%reforged_pokedex_bulbasaur_ability_2%");

    public SpeciesAbilityTwoExtension() {
        super(NAME, PRIORITY, DESCRIPTION, EXAMPLES);
    }

    @Override
    protected String parse(ServerPlayer player, String placeholder, Species species) {
        if (species == null) {
            return "N/A";
        }

        return species.getDefaultForm().getAbilities().getAbilities()[0].getLocalizedName();
    }
}
