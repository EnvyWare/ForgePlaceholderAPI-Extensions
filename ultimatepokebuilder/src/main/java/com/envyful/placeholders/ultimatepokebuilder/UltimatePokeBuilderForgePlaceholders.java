package com.envyful.placeholders.ultimatepokebuilder;

import com.envyful.papi.api.PlaceholderManager;
import com.envyful.ultimate.poke.builder.forge.UltimatePokeBuilderForge;
import com.envyful.ultimate.poke.builder.forge.eco.handler.EcoFactory;
import com.envyful.ultimate.poke.builder.forge.shade.envy.api.forge.player.ForgeEnvyPlayer;
import net.minecraft.entity.player.EntityPlayerMP;

public class UltimatePokeBuilderForgePlaceholders implements PlaceholderManager<EntityPlayerMP> {

    @Override
    public String getIdentifier() {
        return "upb";
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

        ForgeEnvyPlayer player1 = UltimatePokeBuilderForge.getInstance().getPlayerManager().getPlayer(player);

        if (player1 == null) {
            return "0";
        }

        return EcoFactory.getBalance(player1) + "";
    }
}
