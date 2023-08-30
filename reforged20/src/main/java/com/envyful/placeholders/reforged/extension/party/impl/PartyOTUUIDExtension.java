package com.envyful.placeholders.reforged.extension.party.impl;

import com.envyful.placeholders.reforged.extension.party.PartyReforgedExtension;
import com.google.common.collect.Lists;
import com.pixelmonmod.pixelmon.api.pokemon.Pokemon;
import net.minecraft.server.level.ServerPlayer;

import java.util.List;

public class PartyOTUUIDExtension extends PartyReforgedExtension {

    private static final String NAME = "originaltrainer_uuid";
    private static final int PRIORITY = 1;
    private static final List<String> DESCRIPTION = Lists.newArrayList("Gets the pokemon's OT uuid");
    private static final List<String> EXAMPLES = Lists.newArrayList("%reforged_party_slot_1_originaltrainer_uuid%");

    public PartyOTUUIDExtension() {
        super(NAME, PRIORITY, DESCRIPTION, EXAMPLES);
    }

    @Override
    protected String parse(ServerPlayer player, String placeholder, Pokemon pokemon) {
        if (pokemon == null) {
            return "N/A";
        }

        return pokemon.getOriginalTrainerUUID() + "";
    }
}
