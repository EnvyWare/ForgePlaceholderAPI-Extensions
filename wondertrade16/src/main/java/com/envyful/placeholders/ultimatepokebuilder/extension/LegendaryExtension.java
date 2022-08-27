package com.envyful.placeholders.ultimatepokebuilder.extension;

import com.envyful.papi.api.manager.extensions.AbstractExtension;
import com.envyful.wonder.trade.forge.WonderTradeForge;
import com.google.common.collect.Lists;
import com.pixelmonmod.pixelmon.api.pokemon.Pokemon;
import net.minecraft.entity.player.ServerPlayerEntity;

import java.util.List;

public class LegendaryExtension extends AbstractExtension<ServerPlayerEntity> {

    private static final String NAME = "legends";
    private static final int PRIORITY = 1;
    private static final List<String> DESCRIPTION = Lists.newArrayList("Gets the number of legendaries");
    private static final List<String> EXAMPLES = Lists.newArrayList("%wondertrade_legends%");

    public LegendaryExtension() {
        super(NAME, PRIORITY, DESCRIPTION, EXAMPLES);
    }

    @Override
    public boolean matches(ServerPlayerEntity player, String placeholder) {
        return true;
    }

    @Override
    public String parse(ServerPlayerEntity player, String placeholder) {
        int legendaries = 0;
        for (Pokemon pokemon : WonderTradeForge.getInstance().getManager().getTradePool()) {
            if (pokemon.isLegendary()) {
                ++legendaries;
            }
        }

        return legendaries + "";
    }
}
