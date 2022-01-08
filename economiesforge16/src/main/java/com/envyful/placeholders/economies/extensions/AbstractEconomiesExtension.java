package com.envyful.placeholders.economies.extensions;

import com.envyful.economies.api.Economy;
import com.envyful.economies.forge.EconomiesForge;
import com.envyful.economies.forge.config.EconomiesConfig;
import com.envyful.papi.api.manager.extensions.AbstractExtension;
import net.minecraft.entity.player.ServerPlayerEntity;

import java.util.List;

public abstract class AbstractEconomiesExtension extends AbstractExtension<ServerPlayerEntity> {

    public AbstractEconomiesExtension(String name, int priority, List<String> description, List<String> examples) {
        super(name, priority, description, examples);
    }

    @Override
    public boolean matches(ServerPlayerEntity player, String placeholder) {
        return placeholder.startsWith(this.getName() + "_");
    }

    @Override
    public String parse(ServerPlayerEntity player, String placeholder) {
        String[] args = placeholder.split("_");

        if (args.length < 2) {
            return "UNDEFINED";
        }

        Economy economyFromConfig = this.getEconomyFromConfig(args[1]);

        if (economyFromConfig == null) {
            return "UNDEFINED ECONOMY";
        }

        return this.parse(player, placeholder, economyFromConfig);
    }

    private Economy getEconomyFromConfig(String name) {
        for (EconomiesConfig.ConfigEconomy value : EconomiesForge.getInstance().getConfig().getEconomies().values()) {
            if (value.getEconomy().getId().equals(name)) {
                return value.getEconomy();
            }
        }

        return null;
    }

    protected abstract String parse(ServerPlayerEntity player, String placeholder, Economy economy);
}
