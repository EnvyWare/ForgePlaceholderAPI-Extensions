package com.envyful.placeholders.reforged.extension.special.impl;

import com.envyful.placeholders.reforged.extension.special.MatcherReforgedExtension;
import com.google.common.collect.Lists;
import com.pixelmonmod.pixelmon.api.pokemon.species.Species;
import net.minecraft.entity.player.ServerPlayerEntity;

import java.util.List;

public class SpeciesAbilityOneExtension extends MatcherReforgedExtension {

    private static final String NAME = "ability_1";
    private static final int PRIORITY = 1;
    private static final List<String> DESCRIPTION = Lists.newArrayList("Gets the pokemon's first ability");
    private static final List<String> EXAMPLES = Lists.newArrayList("%reforged_pokedex_bulbasaur_ability_1%");

    public SpeciesAbilityOneExtension() {
        super(NAME, PRIORITY, DESCRIPTION, EXAMPLES);
    }

    @Override
    protected String parse(ServerPlayerEntity player, String placeholder, Species species) {
        if (species == null) {
            return "N/A";
        }

        return species.getDefaultForm().getAbilities().getAbilities()[0].getLocalizedName();
    }
}
