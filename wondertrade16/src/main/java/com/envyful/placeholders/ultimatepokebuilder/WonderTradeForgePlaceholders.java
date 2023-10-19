package com.envyful.placeholders.ultimatepokebuilder;

import com.envyful.papi.api.manager.AbstractPlaceholderManager;
import com.envyful.placeholders.ultimatepokebuilder.extension.LegendaryExtension;
import com.envyful.placeholders.ultimatepokebuilder.extension.ShinyExtension;
import com.envyful.placeholders.ultimatepokebuilder.extension.UltraBeastExtension;
import net.minecraft.entity.player.ServerPlayerEntity;

public class WonderTradeForgePlaceholders extends AbstractPlaceholderManager<ServerPlayerEntity> {

    private static final String IDENTIFIER = "wondertrade";
    private static final String[] AUTHORS = new String[] { "Envyful" };
    private static final String VERSION = "3.1.0";
    private static final String NAME = "wondertrade";

    public WonderTradeForgePlaceholders() {
        super(IDENTIFIER, AUTHORS, VERSION, NAME, ServerPlayerEntity.class);

        this.registerPlaceholder(new ShinyExtension());
        this.registerPlaceholder(new UltraBeastExtension());
        this.registerPlaceholder(new LegendaryExtension());
    }
}
