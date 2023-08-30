package com.envyful.placeholders.ultimatepokebuilder;

import com.envyful.papi.api.manager.AbstractPlaceholderManager;
import com.envyful.placeholders.ultimatepokebuilder.extension.BalanceExtension;
import net.minecraft.entity.player.ServerPlayerEntity;

public class UltimatePokeBuilderForgePlaceholders extends AbstractPlaceholderManager<ServerPlayerEntity> {

    private static final String IDENTIFIER = "upb";
    private static final String[] AUTHORS = new String[] { "Envyful" };
    private static final String VERSION = "3.0.2";
    private static final String NAME = "upb";

    public UltimatePokeBuilderForgePlaceholders() {
        super(IDENTIFIER, AUTHORS, VERSION, NAME, ServerPlayerEntity.class);

        this.registerPlaceholder(new BalanceExtension());
    }
}
