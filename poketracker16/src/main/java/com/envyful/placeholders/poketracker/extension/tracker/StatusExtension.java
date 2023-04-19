package com.envyful.placeholders.poketracker.extension.tracker;

import com.envyful.placeholders.poketracker.PokeTrackerForgePlaceholders;
import com.envyful.placeholders.poketracker.extension.PokeTrackerExtension;
import com.envyful.poke.tracker.forge.PokeTrackerForge;
import com.envyful.poke.tracker.forge.tracker.data.EntityData;
import com.google.common.collect.Lists;
import net.minecraft.entity.player.ServerPlayerEntity;

import java.util.List;

public class StatusExtension extends PokeTrackerExtension {

    private static final String NAME = "status";
    private static final int PRIORITY = 1;
    private static final List<String> DESCRIPTION = Lists.newArrayList("Gets the pokemon's status");
    private static final List<String> EXAMPLES = Lists.newArrayList("%poketracker_status_legendary_1%");

    public StatusExtension() {
        super(NAME, PRIORITY, DESCRIPTION, EXAMPLES);
    }

    @Override
    public String parse(ServerPlayerEntity player, String placeholder, EntityData entityData) {
        if (entityData.isCaught()) {
            return PokeTrackerForge.getInstance().getConfig().getCaughtText();
        }

        if (entityData.getCatcher() != null && !entityData.getCatcher().isEmpty()) {
            return PokeTrackerForge.getInstance().getConfig().getDefeatedText();
        }

        if (entityData.getEntity() == null) {
            return PokeTrackerForge.getInstance().getConfig().getDespawnedText();
        }

        return PokeTrackerForge.getInstance().getConfig().getActiveText();
    }
}
