package com.envyful.placeholders.reforged.extension.party.impl;

import com.envyful.placeholders.reforged.extension.party.PartyReforgedExtension;
import com.google.common.collect.Lists;
import com.pixelmonmod.pixelmon.api.pokemon.Pokemon;
import net.minecraft.entity.player.EntityPlayerMP;

import java.util.List;

public class PartyOTNameExtension extends PartyReforgedExtension {

    private static final String NAME = "originaltrainer_name";
    private static final int PRIORITY = 1;
    private static final List<String> DESCRIPTION = Lists.newArrayList("Gets the pokemon's OT name");
    private static final List<String> EXAMPLES = Lists.newArrayList("%reforged_party_slot_1_originaltrainer_name%");

    public PartyOTNameExtension() {
        super(NAME, PRIORITY, DESCRIPTION, EXAMPLES);
    }

    @Override
    protected String parse(EntityPlayerMP player, String placeholder, Pokemon pokemon) {
        return pokemon.getOriginalTrainer();
    }
}
