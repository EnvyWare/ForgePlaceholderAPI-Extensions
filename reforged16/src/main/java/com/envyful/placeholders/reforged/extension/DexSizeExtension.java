package com.envyful.placeholders.reforged.extension;

import com.envyful.papi.api.manager.extensions.type.SimpleExtension;
import com.google.common.collect.Lists;
import com.pixelmonmod.pixelmon.api.pokemon.species.Pokedex;
import net.minecraft.entity.player.ServerPlayerEntity;

import java.util.List;

public class DexSizeExtension extends SimpleExtension<ServerPlayerEntity> {

    private static final String NAME = "dexsize";
    private static final int PRIORITY = 1;
    private static final List<String> DESCRIPTION = Lists.newArrayList("Gets the dex size excluding MissingNo");
    private static final List<String> EXAMPLES = Lists.newArrayList("%reforged_dexsize%");

    public DexSizeExtension() {
        super(NAME, PRIORITY, DESCRIPTION, EXAMPLES);
    }

    @Override
    public String parse(ServerPlayerEntity player, String placeholder) {
        return Pokedex.pokedexSize + "";
    }
}
