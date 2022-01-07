package com.envyful.placeholders.economies.extensions.eco;

import com.envyful.economies.api.Economy;
import com.envyful.economies.forge.EconomiesForge;
import com.envyful.economies.forge.player.EconomiesAttribute;
import com.envyful.economies.forge.shade.envy.api.forge.player.ForgeEnvyPlayer;
import com.envyful.placeholders.economies.extensions.AbstractEconomiesExtension;
import com.google.common.collect.Lists;
import net.minecraft.entity.player.EntityPlayerMP;

import java.util.List;

public class BalanceFormattedExtension extends AbstractEconomiesExtension {

    private static final String NAME = "balformat";
    private static final int PRIORITY = 1;
    private static final List<String> DESCRIPTION = Lists.newArrayList("Gets the formatted balance for the given player in the given economy");
    private static final List<String> EXAMPLES = Lists.newArrayList("%economiesforge_balformat_coins_Envyful%");

    public BalanceFormattedExtension() {
        super(NAME, PRIORITY, DESCRIPTION, EXAMPLES);
    }

    @Override
    protected String parse(EntityPlayerMP player, String placeholder, Economy economy) {
        String[] args = placeholder.split("_");
        ForgeEnvyPlayer target = EconomiesForge.getInstance().getPlayerManager().getPlayer(player);

        if (target == null) {
            return String.format(economy.getFormat(), 0.0);
        }

        EconomiesAttribute attribute = target.getAttribute(EconomiesForge.class);

        if (attribute == null) {
            return String.format(economy.getFormat(), 0.0);
        }

        return (economy.isPrefix() ? economy.getEconomyIdentifier() : "") +
                String.format(economy.getFormat(), attribute.getAccount(economy).getBalance()) +
                (!economy.isPrefix() ? economy.getEconomyIdentifier() : "");
    }
}
