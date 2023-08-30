package com.envyful.placeholders.reforged.extension.special.impl;

import com.envyful.placeholders.reforged.extension.special.MatcherReforgedExtension;
import com.google.common.collect.Lists;
import com.pixelmonmod.pixelmon.api.pokemon.egg.EggGroup;
import com.pixelmonmod.pixelmon.api.pokemon.species.Species;
import net.minecraft.server.level.ServerPlayer;

import java.util.List;

public class SpeciesEggGroupsExtension extends MatcherReforgedExtension {

    private static final String NAME = "egggroups";
    private static final int PRIORITY = 1;
    private static final List<String> DESCRIPTION = Lists.newArrayList("Gets the pokemon's egg groups");
    private static final List<String> EXAMPLES = Lists.newArrayList("%reforged_pokedex_bulbasaur_egggroups%");

    public SpeciesEggGroupsExtension() {
        super(NAME, PRIORITY, DESCRIPTION, EXAMPLES);
    }

    @Override
    protected String parse(ServerPlayer player, String placeholder, Species species) {
        if (species == null) {
            return "N/A";
        }

        List<EggGroup> eggGroups = species.getDefaultForm().getEggGroups();
        List<String> eggs = Lists.newArrayList();

        for (EggGroup eggGroup : eggGroups) {
            eggs.add(eggGroup.getLocalizedName());
        }

        return String.join(", ", eggs);
    }
}
