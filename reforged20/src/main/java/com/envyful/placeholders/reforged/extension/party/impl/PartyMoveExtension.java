package com.envyful.placeholders.reforged.extension.party.impl;

import com.envyful.placeholders.reforged.extension.party.PartyReforgedExtension;
import com.google.common.collect.Lists;
import com.pixelmonmod.pixelmon.api.pokemon.Pokemon;
import com.pixelmonmod.pixelmon.battles.attacks.Attack;
import net.minecraft.server.level.ServerPlayer;

import java.util.List;

public class PartyMoveExtension extends PartyReforgedExtension {

    private static final String NAME = "move";
    private static final int PRIORITY = 1;
    private static final List<String> DESCRIPTION = Lists.newArrayList("Gets the pokemon's move in the given slot");
    private static final List<String> EXAMPLES = Lists.newArrayList("%reforged_party_slot_1_move_1%");

    private final int move;

    public PartyMoveExtension(int move) {
        super(NAME + "_" + move, PRIORITY, DESCRIPTION, EXAMPLES);

        this.move = move;
    }

    @Override
    protected String parse(ServerPlayer player, String placeholder, Pokemon pokemon) {
        if (pokemon == null) {
            return "N/A";
        }

        Attack attack = pokemon.getMoveset().get(this.move - 1);
        return attack == null ? "N/A" : attack.getMove().getLocalizedName();
    }
}
