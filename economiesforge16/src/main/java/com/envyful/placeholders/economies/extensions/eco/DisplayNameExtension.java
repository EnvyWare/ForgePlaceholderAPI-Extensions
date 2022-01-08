package com.envyful.placeholders.economies.extensions.eco;

import com.envyful.economies.api.Economy;
import com.envyful.placeholders.economies.extensions.AbstractEconomiesExtension;
import com.google.common.collect.Lists;
import net.minecraft.entity.player.ServerPlayerEntity;

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
    protected String parse(ServerPlayerEntity player, String placeholder, Economy economy) {
        return economy.getDisplayName();
    }
}
