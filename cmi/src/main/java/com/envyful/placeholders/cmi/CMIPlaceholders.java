package com.envyful.placeholders.cmi;

import com.envyful.papi.api.manager.AbstractPlaceholderManager;
import com.envyful.placeholders.cmi.extensions.BalanceExtension;
import com.envyful.placeholders.cmi.extensions.NextRankExtension;
import com.envyful.placeholders.cmi.extensions.PlaytimeExtension;
import com.envyful.placeholders.cmi.extensions.ServerOnlineExtension;
import net.minecraft.entity.player.EntityPlayerMP;

public class CMIPlaceholders extends AbstractPlaceholderManager<EntityPlayerMP> {

    private static final String IDENTIFIER = "cmi";
    private static final String[] AUTHORS = new String[] { "Envyful" };
    private static final String VERSION = "2.8.4";
    private static final String NAME = "cmi";

    public CMIPlaceholders() {
        super(IDENTIFIER, AUTHORS, VERSION, NAME, EntityPlayerMP.class);

        this.registerPlaceholder(new BalanceExtension());
        this.registerPlaceholder(new NextRankExtension());
        this.registerPlaceholder(new PlaytimeExtension());
        this.registerPlaceholder(new ServerOnlineExtension());
    }


}
