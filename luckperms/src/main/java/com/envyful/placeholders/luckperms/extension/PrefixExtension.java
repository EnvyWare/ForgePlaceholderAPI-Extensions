package com.envyful.placeholders.luckperms.extension;

import com.envyful.papi.api.manager.extensions.type.SimpleExtension;
import com.google.common.collect.Lists;
import net.luckperms.api.LuckPerms;
import net.luckperms.api.LuckPermsProvider;
import net.luckperms.api.model.user.User;
import net.minecraft.entity.player.EntityPlayerMP;

import java.util.List;

public class PrefixExtension extends SimpleExtension<EntityPlayerMP> {

    private static final String NAME = "prefix";
    private static final int PRIORITY = 1;
    private static final List<String> DESCRIPTION = Lists.newArrayList("Gets the player's prefix");
    private static final List<String> EXAMPLES = Lists.newArrayList("%luckperms_prefix%");

    public PrefixExtension() {
        super(NAME, PRIORITY, DESCRIPTION, EXAMPLES);
    }

    @Override
    public String parse(EntityPlayerMP player, String placeholder) {
        LuckPerms luckPerms = LuckPermsProvider.get();
        User user = luckPerms.getUserManager().getUser(player.getUniqueID());
        String prefix = user.getCachedData().getMetaData().getPrefix();

        if (prefix == null) {
            return "";
        }

        return prefix;
    }
}
