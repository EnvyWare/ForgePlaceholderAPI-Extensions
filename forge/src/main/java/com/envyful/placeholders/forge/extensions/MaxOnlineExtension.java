package com.envyful.placeholders.forge.extensions;

import com.envyful.papi.api.manager.extensions.type.SimpleExtension;
import com.google.common.collect.Lists;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.fml.common.FMLCommonHandler;

import java.util.List;

public class MaxOnlineExtension extends SimpleExtension<EntityPlayerMP> {

    private static final String NAME = "max_online";
    private static final int PRIORITY = 1;
    private static final List<String> DESCRIPTION = Lists.newArrayList("Gets the maximum number of online players");
    private static final List<String> EXAMPLES = Lists.newArrayList("%forge_max_online%");

    public MaxOnlineExtension() {
        super(NAME, PRIORITY, DESCRIPTION, EXAMPLES);
    }

    @Override
    public String parse(EntityPlayerMP player, String placeholder) {
        return FMLCommonHandler.instance().getMinecraftServerInstance().getPlayerList().getMaxPlayers() + "";
    }
}
