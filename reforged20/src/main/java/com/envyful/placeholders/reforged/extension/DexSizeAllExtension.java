package com.envyful.placeholders.reforged.extension;

import com.envyful.papi.api.manager.extensions.type.SimpleExtension;
import com.google.common.collect.Lists;
import com.pixelmonmod.pixelmon.api.registries.PixelmonSpecies;
import net.minecraft.server.level.ServerPlayer;

import java.util.List;

public class DexSizeAllExtension extends SimpleExtension<ServerPlayer> {

    private static final String NAME = "dexsizeall";
    private static final int PRIORITY = 1;
    private static final List<String> DESCRIPTION = Lists.newArrayList("Gets the dex size");
    private static final List<String> EXAMPLES = Lists.newArrayList("%reforged_dexsizeall%");

    public DexSizeAllExtension() {
        super(NAME, PRIORITY, DESCRIPTION, EXAMPLES);
    }

    @Override
    public String parse(ServerPlayer player, String placeholder) {
        return PixelmonSpecies.getAll().size() + "";
    }
}
