package com.envyful.placeholders.economies.extensions.eco;

import com.envyful.economies.api.Economy;
import com.envyful.placeholders.economies.extensions.AbstractEconomiesExtension;
import com.google.common.collect.Lists;
import net.minecraft.entity.player.EntityPlayerMP;

import java.util.List;

public class SymbolExtension extends AbstractEconomiesExtension {

    private static final String NAME = "symbol";
    private static final int PRIORITY = 1;
    private static final List<String> DESCRIPTION = Lists.newArrayList("Gets the economy's symbol");
    private static final List<String> EXAMPLES = Lists.newArrayList("%economiesforge_symbol_coins%");

    public SymbolExtension() {
        super(NAME, PRIORITY, DESCRIPTION, EXAMPLES);
    }

    @Override
    protected String parse(EntityPlayerMP player, String placeholder, Economy economy) {
        return economy.getEconomyIdentifier();
    }
}
