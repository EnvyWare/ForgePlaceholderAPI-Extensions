package com.envyful.placeholders.forge.extensions;

import com.envyful.papi.api.manager.extensions.type.SimpleExtension;
import com.google.common.collect.Lists;
import net.minecraft.entity.player.ServerPlayerEntity;

import java.util.List;

public class HealthExtension extends SimpleExtension<ServerPlayerEntity> {

    private static final String NAME = "health";
    private static final int PRIORITY = 1;
    private static final List<String> DESCRIPTION = Lists.newArrayList("Gets the player's health");
    private static final List<String> EXAMPLES = Lists.newArrayList("%forge_health%");

    public HealthExtension() {
        super(NAME, PRIORITY, DESCRIPTION, EXAMPLES);
    }

    @Override
    public String parse(ServerPlayerEntity player, String placeholder) {
        return String.format("%.2f", player.getHealth());
    }
}
