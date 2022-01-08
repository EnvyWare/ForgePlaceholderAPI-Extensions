package com.envyful.placeholders.economies.extensions.eco;

import com.envyful.economies.api.Economy;
import com.envyful.placeholders.economies.extensions.AbstractEconomiesExtension;
import com.google.common.collect.Lists;
import net.minecraft.entity.player.ServerPlayerEntity;

import java.util.List;

public class BaltopExtension extends AbstractEconomiesExtension {

    private static final String NAME = "baltop";
    private static final int PRIORITY = 1;
    private static final List<String> DESCRIPTION = Lists.newArrayList("Gets the baltop for the given economy");
    private static final List<String> EXAMPLES = Lists.newArrayList("%economiesforge_baltop_coins_1%");

    public BaltopExtension() {
        super(NAME, PRIORITY, DESCRIPTION, EXAMPLES);
    }

    @Override
    protected String parse(ServerPlayerEntity player, String placeholder, Economy economy) {
        String[] args = placeholder.split("_");

        if (args.length != 3) {
            return "UNDEFINED";
        }

        int index = Integer.parseInt(args[2]);

        return economy.getLeaderboard().getPage(index / 10).get(index % 10);
    }
}
