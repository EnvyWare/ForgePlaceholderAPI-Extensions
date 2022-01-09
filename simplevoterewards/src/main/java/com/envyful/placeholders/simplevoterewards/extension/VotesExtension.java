package com.envyful.placeholders.simplevoterewards.extension;

import com.envyful.papi.api.manager.extensions.type.SimpleExtension;
import com.envyful.simple.vote.rewards.forge.SimpleVoteRewardsForge;
import com.google.common.collect.Lists;
import net.minecraft.entity.player.EntityPlayerMP;

import java.util.List;

public class VotesExtension extends SimpleExtension<EntityPlayerMP> {

    private static final String NAME = "votes";
    private static final int PRIORITY = 1;
    private static final List<String> DESCRIPTION = Lists.newArrayList("Gets the vote counter");
    private static final List<String> EXAMPLES = Lists.newArrayList("%simplevoterewards_votes%");

    public VotesExtension() {
        super(NAME, PRIORITY, DESCRIPTION, EXAMPLES);
    }

    @Override
    public String parse(EntityPlayerMP player, String placeholder) {
        return SimpleVoteRewardsForge.getInstance().getVoteCounter() + "";
    }
}
