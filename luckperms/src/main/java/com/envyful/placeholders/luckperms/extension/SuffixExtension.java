package com.envyful.placeholders.luckperms.extension;

import com.envyful.papi.api.manager.extensions.type.SimpleExtension;
import com.google.common.collect.Lists;
import net.luckperms.api.LuckPerms;
import net.luckperms.api.LuckPermsProvider;
import net.luckperms.api.model.user.User;
import net.minecraft.entity.player.EntityPlayerMP;

import java.util.List;

public class SuffixExtension extends SimpleExtension<EntityPlayerMP> {

    private static final String NAME = "suffix";
    private static final int PRIORITY = 1;
    private static final List<String> DESCRIPTION = Lists.newArrayList("Gets the player's suffix");
    private static final List<String> EXAMPLES = Lists.newArrayList("%luckperms_suffix%");

    public SuffixExtension() {
        super(NAME, PRIORITY, DESCRIPTION, EXAMPLES);
    }

    @Override
    public String parse(EntityPlayerMP player, String placeholder) {
        LuckPerms luckPerms = LuckPermsProvider.get();
        User user = luckPerms.getUserManager().getUser(player.getUniqueID());
        String suffix = user.getCachedData().getMetaData().getSuffix();

        if (suffix == null) {
            return "";
        }

        return suffix;
    }
}
