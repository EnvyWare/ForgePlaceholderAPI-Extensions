package com.envyful.placeholders.luckperms;

import com.envyful.papi.api.manager.AbstractPlaceholderManager;
import com.envyful.placeholders.luckperms.extension.PrefixExtension;
import com.envyful.placeholders.luckperms.extension.SuffixExtension;
import net.minecraft.entity.player.EntityPlayerMP;

public class LuckPermsPlaceholders extends AbstractPlaceholderManager<EntityPlayerMP> {

    private static final String IDENTIFIER = "forge";
    private static final String[] AUTHORS = new String[] { "Envyful" };
    private static final String VERSION = "2.8.4";
    private static final String NAME = "forge";

    public LuckPermsPlaceholders() {
        super(IDENTIFIER, AUTHORS, VERSION, NAME, EntityPlayerMP.class);

        this.registerPlaceholder(new PrefixExtension());
        this.registerPlaceholder(new SuffixExtension());
    }
}
