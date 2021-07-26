package com.envyful.placeholders.luckperms;

import com.envyful.papi.api.PlaceholderManager;
import net.luckperms.api.LuckPerms;
import net.luckperms.api.LuckPermsProvider;
import net.luckperms.api.model.user.User;
import net.minecraft.entity.player.EntityPlayerMP;

public class LuckPermsPlaceholders implements PlaceholderManager<EntityPlayerMP> {

    @Override
    public String getIdentifier() {
        return "luckperms";
    }

    @Override
    public String[] getAuthors() {
        return new String[] { "Envyful" };
    }

    @Override
    public String getVersion() {
        return "1.0.0";
    }

    @Override
    public String getName() {
        return getIdentifier();
    }

    @Override
    public String onPlaceholderRequest(EntityPlayerMP player, String placeholder) {
        LuckPerms luckPerms = LuckPermsProvider.get();
        User user = luckPerms.getUserManager().getUser(player.getUniqueID());

        switch(placeholder.toLowerCase()) {
            case "prefix" : {
                String prefix = user.getCachedData().getMetaData().getPrefix();

                if (prefix == null) {
                    return "";
                }

                return prefix;
            }
            case "suffix" : {
                String suffix = user.getCachedData().getMetaData().getSuffix();

                if (suffix == null) {
                    return "";
                }

                return suffix;
            }
        }

        return "UNDEFINED";
    }
}
