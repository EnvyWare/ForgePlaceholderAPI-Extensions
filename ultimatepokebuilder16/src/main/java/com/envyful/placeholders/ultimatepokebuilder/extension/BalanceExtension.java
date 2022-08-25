package com.envyful.placeholders.ultimatepokebuilder.extension;

import com.envyful.papi.api.manager.extensions.AbstractExtension;
import com.envyful.ultimate.poke.builder.forge.UltimatePokeBuilderForge;
import com.envyful.ultimate.poke.builder.forge.eco.handler.EcoFactory;
import com.envyful.ultimate.poke.builder.forge.shade.envy.api.forge.player.ForgeEnvyPlayer;
import com.google.common.collect.Lists;
import net.minecraft.entity.player.ServerPlayerEntity;

import java.util.List;

public class BalanceExtension extends AbstractExtension<ServerPlayerEntity> {

    private static final String NAME = "balance";
    private static final int PRIORITY = 1;
    private static final List<String> DESCRIPTION = Lists.newArrayList("Gets the token balance");
    private static final List<String> EXAMPLES = Lists.newArrayList("%upb_balance%");

    public BalanceExtension() {
        super(NAME, PRIORITY, DESCRIPTION, EXAMPLES);
    }

    @Override
    public boolean matches(ServerPlayerEntity player, String placeholder) {
        return true;
    }

    @Override
    public String parse(ServerPlayerEntity player, String placeholder) {
        ForgeEnvyPlayer player1 = UltimatePokeBuilderForge.getInstance().getPlayerManager().getPlayer(player);

        if (player1 == null) {
            return null;
        }

        return EcoFactory.getBalance(player1) + "";
    }
}
