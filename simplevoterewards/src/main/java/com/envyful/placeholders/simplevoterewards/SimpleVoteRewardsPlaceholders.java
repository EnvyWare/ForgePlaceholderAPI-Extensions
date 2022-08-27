package com.envyful.placeholders.simplevoterewards;

import com.envyful.papi.api.manager.AbstractPlaceholderManager;
import com.envyful.placeholders.simplevoterewards.extension.VotePartyExtension;
import com.envyful.placeholders.simplevoterewards.extension.VotePartyTotalExtension;
import com.envyful.placeholders.simplevoterewards.extension.VotesExtension;
import net.minecraft.entity.player.EntityPlayerMP;

public class SimpleVoteRewardsPlaceholders extends AbstractPlaceholderManager<EntityPlayerMP> {

    private static final String IDENTIFIER = "simplevoterewards";
    private static final String[] AUTHORS = new String[] { "Envyful" };
    private static final String VERSION = "2.9.5";
    private static final String NAME = "simplevoterewards";

    public SimpleVoteRewardsPlaceholders() {
        super(IDENTIFIER, AUTHORS, VERSION, NAME, EntityPlayerMP.class);

        this.registerPlaceholder(new VotePartyExtension());
        this.registerPlaceholder(new VotePartyTotalExtension());
        this.registerPlaceholder(new VotesExtension());
    }
}
