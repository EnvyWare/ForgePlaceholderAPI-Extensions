package com.envyful.placeholders.reforged.extension;

import com.envyful.papi.api.manager.extensions.type.SimpleExtension;
import com.google.common.collect.Lists;
import com.pixelmonmod.pixelmon.Pixelmon;
import com.pixelmonmod.pixelmon.storage.PlayerPartyStorage;
import net.minecraft.entity.player.EntityPlayerMP;

import java.util.List;

public class PartySizeExtension extends SimpleExtension<EntityPlayerMP> {

    private static final String NAME = "partysize";
    private static final int PRIORITY = 1;
    private static final List<String> DESCRIPTION = Lists.newArrayList("Gets the player's party's size");
    private static final List<String> EXAMPLES = Lists.newArrayList("%reforged_partysize%");

    public PartySizeExtension() {
        super(NAME, PRIORITY, DESCRIPTION, EXAMPLES);
    }

    @Override
    public String parse(EntityPlayerMP player, String placeholder) {
        PlayerPartyStorage party = Pixelmon.storageManager.getParty(player);
        return party.getTeam().size() + "";
    }
}
