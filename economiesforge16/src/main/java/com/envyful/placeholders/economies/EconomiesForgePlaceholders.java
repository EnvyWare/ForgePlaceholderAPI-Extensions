package com.envyful.placeholders.economies;

import com.envyful.papi.api.manager.AbstractPlaceholderManager;
import com.envyful.placeholders.economies.extensions.eco.*;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;

public class EconomiesForgePlaceholders extends AbstractPlaceholderManager<ServerPlayerEntity> {

    private static final String IDENTIFIER = "forgeeconomies";
    private static final String[] AUTHORS = new String[] { "Envyful" };
    private static final String VERSION = "3.0.2";
    private static final String NAME = "forgeeconomies";

    public EconomiesForgePlaceholders() {
        super(IDENTIFIER, AUTHORS, VERSION, NAME, ServerPlayerEntity.class);

        this.registerPlaceholder(new BalanceExtension());
        this.registerPlaceholder(new BalanceFormattedExtension());
        this.registerPlaceholder(new BaltopExtension());
        this.registerPlaceholder(new DisplayNameExtension());
        this.registerPlaceholder(new PluralDisplayNameExtension());
        this.registerPlaceholder(new SymbolExtension());
    }
}
