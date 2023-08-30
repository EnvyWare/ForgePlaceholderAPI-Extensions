package com.envyful.placeholders.forge.extensions;

import com.envyful.papi.api.manager.extensions.type.SimpleExtension;
import com.google.common.collect.Lists;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.fml.server.ServerLifecycleHooks;

import java.util.List;

public class OnlineExtension extends SimpleExtension<ServerPlayer> {

    private static final String NAME = "online";
    private static final int PRIORITY = 1;
    private static final List<String> DESCRIPTION = Lists.newArrayList("Gets the number of online players");
    private static final List<String> EXAMPLES = Lists.newArrayList("%forge_online%");

    public OnlineExtension() {
        super(NAME, PRIORITY, DESCRIPTION, EXAMPLES);
    }

    @Override
    public String parse(ServerPlayer player, String placeholder) {
        return ServerLifecycleHooks.getCurrentServer().getPlayerList().getPlayers().size() + "";
    }
}
