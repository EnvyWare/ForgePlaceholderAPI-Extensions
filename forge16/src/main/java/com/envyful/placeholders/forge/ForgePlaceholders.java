package com.envyful.placeholders.forge;

import com.envyful.papi.api.manager.AbstractPlaceholderManager;
import com.envyful.placeholders.forge.extensions.*;
import net.minecraft.entity.player.ServerPlayerEntity;
import org.apache.logging.log4j.core.jmx.Server;

public class ForgePlaceholders extends AbstractPlaceholderManager<ServerPlayerEntity> {

    private static final String IDENTIFIER = "forge";
    private static final String[] AUTHORS = new String[] { "Envyful" };
    private static final String VERSION = "2.8.6";
    private static final String NAME = "forge";

    public ForgePlaceholders() {
        super(IDENTIFIER, AUTHORS, VERSION, NAME, ServerPlayerEntity.class);

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
