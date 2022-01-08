package com.envyful.placeholders.cmi.extensions;

import com.Zrips.CMI.CMI;
import com.Zrips.CMI.Containers.CMIUser;
import com.envyful.papi.api.manager.extensions.type.SimpleExtension;
import com.google.common.collect.Lists;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.fml.common.FMLCommonHandler;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class ServerOnlineExtension extends SimpleExtension<EntityPlayerMP> {

    private static final String NAME = "server_online";
    private static final int PRIORITY = 1;
    private static final List<String> DESCRIPTION = Lists.newArrayList("Gets the online count for the server");
    private static final List<String> EXAMPLES = Lists.newArrayList("%cmi_server_online%");

    public ServerOnlineExtension() {
        super(NAME, PRIORITY, DESCRIPTION, EXAMPLES);
    }

    @Override
    public String parse(EntityPlayerMP player, String placeholder) {
        return FMLCommonHandler.instance().getMinecraftServerInstance().getPlayerList().getPlayers().size() + "";
    }
}
