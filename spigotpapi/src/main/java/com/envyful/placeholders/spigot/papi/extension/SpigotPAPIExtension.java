package com.envyful.placeholders.spigot.papi.extension;

import com.envyful.papi.api.manager.extensions.type.SimpleExtension;
import com.google.common.collect.Lists;
import me.clip.placeholderapi.PlaceholderAPI;
import net.minecraft.entity.player.EntityPlayerMP;
import org.bukkit.Bukkit;

import java.util.List;

public class SpigotPAPIExtension extends SimpleExtension<EntityPlayerMP> {

    private static final String NAME = "parse";
    private static final int PRIORITY = 1;
    private static final List<String> DESCRIPTION = Lists.newArrayList("Parses a placeholder using Spigot's PAPI");
    private static final List<String> EXAMPLES = Lists.newArrayList("%spigotpapi_parse_Advancements_listFormat%");

    public SpigotPAPIExtension() {
        super(NAME, PRIORITY, DESCRIPTION, EXAMPLES);
    }

    @Override
    public boolean matches(EntityPlayerMP player, String placeholder) {
        return placeholder.startsWith(this.getName() + "_");
    }

    @Override
    public String parse(EntityPlayerMP player, String placeholder) {
        return PlaceholderAPI.setPlaceholders(Bukkit.getPlayer(player.getUniqueID()), "%" + placeholder.replace("parse_", "") + "%");
    }
}
