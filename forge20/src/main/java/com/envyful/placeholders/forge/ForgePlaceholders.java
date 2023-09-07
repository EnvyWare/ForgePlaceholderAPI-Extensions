package com.envyful.placeholders.forge;

import com.envyful.papi.api.manager.AbstractPlaceholderManager;
import com.envyful.placeholders.forge.extensions.*;
import net.minecraft.server.level.ServerPlayer;

public class ForgePlaceholders extends AbstractPlaceholderManager<ServerPlayer> {

    private static final String IDENTIFIER = "forge";
    private static final String[] AUTHORS = new String[] { "Envyful" };
    private static final String VERSION = "3.0.3";
    private static final String NAME = "forge";

    public ForgePlaceholders() {
        super(IDENTIFIER, AUTHORS, VERSION, NAME, ServerPlayer.class);

        this.registerPlaceholder(new NameExtension());
        this.registerPlaceholder(new DisplayNameExtension());
        this.registerPlaceholder(new HealthExtension());
        this.registerPlaceholder(new FoodExtension());
        this.registerPlaceholder(new OnlineExtension());
        this.registerPlaceholder(new MaxOnlineExtension());
        this.registerPlaceholder(new TPSExtension());
        this.registerPlaceholder(new PingExtension());
    }
}
