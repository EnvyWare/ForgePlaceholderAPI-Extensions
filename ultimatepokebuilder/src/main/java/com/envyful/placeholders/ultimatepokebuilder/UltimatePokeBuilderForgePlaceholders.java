package com.envyful.placeholders.ultimatepokebuilder;

import com.envyful.papi.api.manager.AbstractPlaceholderManager;
import com.envyful.placeholders.ultimatepokebuilder.extension.BalanceExtension;
import com.envyful.ultimate.poke.builder.forge.UltimatePokeBuilderForge;
import com.envyful.ultimate.poke.builder.forge.eco.handler.EcoFactory;
import com.envyful.ultimate.poke.builder.forge.shade.envy.api.forge.player.ForgeEnvyPlayer;
import net.minecraft.entity.player.EntityPlayerMP;

public class UltimatePokeBuilderForgePlaceholders extends AbstractPlaceholderManager<EntityPlayerMP> {

    private static final String IDENTIFIER = "upb";
    private static final String[] AUTHORS = new String[] { "Envyful" };
    private static final String VERSION = "2.8.4";
    private static final String NAME = "upb";

    public UltimatePokeBuilderForgePlaceholders() {
        super(IDENTIFIER, AUTHORS, VERSION, NAME, EntityPlayerMP.class);

        this.registerPlaceholder(new BalanceExtension());
    }
}
