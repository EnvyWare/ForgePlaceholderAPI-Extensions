package com.envyful.placeholders.forge.extensions;

import com.envyful.papi.api.manager.extensions.type.SimpleExtension;
import com.google.common.collect.Lists;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerPlayer;

import java.util.List;

public class PingExtension extends SimpleExtension<ServerPlayer> {

    private static final String NAME = "ping";
    private static final int PRIORITY = 1;
    private static final List<String> DESCRIPTION = Lists.newArrayList("Gets the player's ping");
    private static final List<String> EXAMPLES = Lists.newArrayList("%forge_ping%");

    public PingExtension() {
        super(NAME, PRIORITY, DESCRIPTION, EXAMPLES);
    }

    @Override
    public String parse(ServerPlayer player, String placeholder) {
        return player.latency + "";
    }
}
