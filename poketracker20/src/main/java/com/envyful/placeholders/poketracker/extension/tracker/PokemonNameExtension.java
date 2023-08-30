package com.envyful.placeholders.poketracker.extension.tracker;

import com.envyful.placeholders.poketracker.extension.PokeTrackerExtension;
import com.envyful.poke.tracker.forge.tracker.data.EntityData;
import com.google.common.collect.Lists;
import net.minecraft.server.level.ServerPlayer;

import java.util.List;

public class PokemonNameExtension extends PokeTrackerExtension {

    private static final String NAME = "pokemon";
    private static final int PRIORITY = 1;
    private static final List<String> DESCRIPTION = Lists.newArrayList("Gets the pokemon's name");
    private static final List<String> EXAMPLES = Lists.newArrayList("%poketracker_pokemon_legendary_1%");

    public PokemonNameExtension() {
        super(NAME, PRIORITY, DESCRIPTION, EXAMPLES);
    }

    @Override
    public String parse(ServerPlayer player, String placeholder, EntityData entityData) {
        return entityData.getPokemonName();
    }
}
