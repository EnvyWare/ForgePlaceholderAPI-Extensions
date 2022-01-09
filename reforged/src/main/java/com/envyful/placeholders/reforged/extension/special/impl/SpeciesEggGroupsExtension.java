package com.envyful.placeholders.reforged.extension.special.impl;

import com.envyful.placeholders.reforged.extension.special.MatcherReforgedExtension;
import com.google.common.collect.Lists;
import com.pixelmonmod.pixelmon.enums.EnumEggGroup;
import com.pixelmonmod.pixelmon.enums.EnumSpecies;
import net.minecraft.entity.player.EntityPlayerMP;

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
    protected String parse(EntityPlayerMP player, String placeholder, EnumSpecies species) {
        EnumEggGroup[] eggGroups = species.getBaseStats().eggGroups;
        List<String> eggs = Lists.newArrayList();

        for (EnumEggGroup eggGroup : eggGroups) {
            eggs.add(eggGroup.name());
        }

        return String.join(", ", eggs);
    }
}
