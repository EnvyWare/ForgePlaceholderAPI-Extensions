package com.envyful.placeholders.simplevoterewards.extension;

import com.envyful.papi.api.manager.extensions.type.SimpleExtension;
import com.envyful.simple.vote.rewards.forge.SimpleVoteRewardsForge;
import com.google.common.collect.Lists;
import net.minecraft.entity.player.EntityPlayerMP;

import java.util.List;

public class VotePartyExtension extends SimpleExtension<EntityPlayerMP> {

    private static final String NAME = "vote_party";
    private static final int PRIORITY = 1;
    private static final List<String> DESCRIPTION = Lists.newArrayList("Gets the vote party number");
    private static final List<String> EXAMPLES = Lists.newArrayList("%simplevoterewards_vote_party%");

    public VotePartyExtension() {
        super(NAME, PRIORITY, DESCRIPTION, EXAMPLES);
    }

    @Override
    public String parse(EntityPlayerMP player, String placeholder) {
        return (SimpleVoteRewardsForge.getInstance().getConfig().getVotePartyRequired()
                - SimpleVoteRewardsForge.getInstance().getVoteCounter()) + "";
    }
}
