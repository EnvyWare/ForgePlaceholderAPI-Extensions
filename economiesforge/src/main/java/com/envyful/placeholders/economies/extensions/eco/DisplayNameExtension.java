package com.envyful.placeholders.economies.extensions.eco;

import com.envyful.economies.api.Economy;
import com.envyful.economies.forge.EconomiesForge;
import com.envyful.economies.forge.player.EconomiesAttribute;
import com.envyful.economies.forge.shade.envy.api.forge.player.ForgeEnvyPlayer;
import com.envyful.placeholders.economies.extensions.AbstractEconomiesExtension;
import com.google.common.collect.Lists;
import net.minecraft.entity.player.EntityPlayerMP;

import java.util.List;

public class DisplayNameExtension extends AbstractEconomiesExtension {

    private static final String NAME = "display";
    private static final int PRIORITY = 1;
    private static final List<String> DESCRIPTION = Lists.newArrayList("Gets the economy's displayname");
    private static final List<String> EXAMPLES = Lists.newArrayList("%economiesforge_display_coins%");

    public DisplayNameExtension() {
        super(NAME, PRIORITY, DESCRIPTION, EXAMPLES);
    }

    @Override
    protected String parse(EntityPlayerMP player, String placeholder, Economy economy) {
        return economy.getDisplayName();
    }
}
