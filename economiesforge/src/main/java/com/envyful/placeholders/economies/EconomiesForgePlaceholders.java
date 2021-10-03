package com.envyful.placeholders.economies;

import com.envyful.economies.api.Economy;
import com.envyful.economies.forge.EconomiesForge;
import com.envyful.economies.forge.config.EconomiesConfig;
import com.envyful.economies.forge.player.EconomiesAttribute;
import com.envyful.economies.forge.shade.envy.api.forge.player.ForgeEnvyPlayer;
import com.envyful.papi.api.PlaceholderManager;
import net.minecraft.entity.player.EntityPlayerMP;

public class EconomiesForgePlaceholders implements PlaceholderManager<EntityPlayerMP> {
    @Override
    public String getIdentifier() {
        return "forgeeconomies";
    }

    @Override
    public String[] getAuthors() {
        return new String[] { "Envyful" };
    }

    @Override
    public String getVersion() {
        return "1.0.0";
    }

    @Override
    public String getName() {
        return getIdentifier();
    }

    @Override
    public String onPlaceholderRequest(EntityPlayerMP player, String placeholder) {
        String[] args = placeholder.split("_");

        if (args.length < 2) {
            return "UNDEFINED";
        }

        Economy economyFromConfig = this.getEconomyFromConfig(args[1]);

        if (economyFromConfig == null) {
            return "UNDEFINED ECONOMY";
        }

        switch (args[0].toLowerCase()) {
            case "baltop": {
                if (args.length != 3) {
                    return "UNDEFINED";
                }

                int index = Integer.parseInt(args[2]);

                return economyFromConfig.getLeaderboard().getPage(index / 10).get(index % 10);
            }
            case "balance": {
                ForgeEnvyPlayer target = EconomiesForge.getInstance().getPlayerManager().getPlayer(player);

                if (target == null) {
                    return "0.0";
                }

                EconomiesAttribute attribute = target.getAttribute(EconomiesForge.class);

                if (attribute == null) {
                    return "0.0";
                }

                return String.format(".2%f", attribute.getAccount(economyFromConfig).getBalance());
            }
            case "balformat": {
                ForgeEnvyPlayer target = EconomiesForge.getInstance().getPlayerManager().getPlayer(player);

                if (target == null) {
                    return "0.0";
                }

                EconomiesAttribute attribute = target.getAttribute(EconomiesForge.class);

                if (attribute == null) {
                    return "0.0";
                }

                return (economyFromConfig.isPrefix() ? economyFromConfig.getEconomyIdentifier() : "") +
                        String.format("%.2f", attribute.getAccount(economyFromConfig).getBalance()) +
                        (!economyFromConfig.isPrefix() ? economyFromConfig.getEconomyIdentifier() : "");
            }
            case "display" : return economyFromConfig.getDisplayName();
            case "pluraldisplay" : return economyFromConfig.getDisplayNamePlural();
            case "symbol" : return economyFromConfig.getEconomyIdentifier();
        }

        return null;
    }

    private Economy getEconomyFromConfig(String name) {
        for (EconomiesConfig.ConfigEconomy value : EconomiesForge.getInstance().getConfig().getEconomies().values()) {
            if (value.getEconomy().getId().equals(name)) {
                return value.getEconomy();
            }
        }

        return null;
    }
}
