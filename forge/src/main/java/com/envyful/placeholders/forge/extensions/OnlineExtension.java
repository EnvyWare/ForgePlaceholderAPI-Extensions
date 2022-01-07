package com.envyful.placeholders.forge.extensions;

import com.envyful.papi.api.manager.extensions.type.SimpleExtension;
import com.google.common.collect.Lists;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.fml.common.FMLCommonHandler;

import java.util.List;

public class OnlineExtension extends SimpleExtension<EntityPlayerMP> {

    private static final String NAME = "online";
    private static final int PRIORITY = 1;
    private static final List<String> DESCRIPTION = Lists.newArrayList("Gets the number of online players");
    private static final List<String> EXAMPLES = Lists.newArrayList("%forge_online%");

    public OnlineExtension() {
        super(NAME, PRIORITY, DESCRIPTION, EXAMPLES);
    }

    @Override
    public String parse(EntityPlayerMP player, String placeholder) {
        return FMLCommonHandler.instance().getMinecraftServerInstance().getPlayerList().getPlayers().size() + "";
    }
}
