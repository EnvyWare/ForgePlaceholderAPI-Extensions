package com.envyful.placeholders.reforged.extension.party;

import com.envyful.papi.api.manager.extensions.AbstractExtension;
import com.pixelmonmod.pixelmon.Pixelmon;
import com.pixelmonmod.pixelmon.api.pokemon.Pokemon;
import com.pixelmonmod.pixelmon.storage.PlayerPartyStorage;
import net.minecraft.entity.player.EntityPlayerMP;

import java.text.NumberFormat;
import java.util.List;

public abstract class PartyReforgedExtension extends AbstractExtension<EntityPlayerMP> {

    public PartyReforgedExtension(String name, int priority, List<String> description, List<String> examples) {
        super(name, priority, description, examples);
    }

    @Override
    public boolean matches(EntityPlayerMP player, String placeholder) {
        int slot = this.parseInt(placeholder.replace("party_slot_", "").substring(0, 1));

        if (slot < 0 || slot > 5) {
            return false;
        }

        PlayerPartyStorage party = Pixelmon.storageManager.getParty(player);
        String data = placeholder.replace("party_slot_", "");

        if (data.isEmpty() || data.length() == 0) {
            return false;
        }

        String remainingPlaceholder = data.substring(2);
        Pokemon pokemon = party.get(slot);

        if (pokemon == null) {
            return false;
        }

        return placeholder.startsWith("party_slot_") && remainingPlaceholder.equals(this.getName());
    }

    private int parseInt(String s) {
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    @Override
    public String parse(EntityPlayerMP player, String placeholder) {
        int slot = Integer.parseInt(placeholder.replace("party_slot_", "").substring(0, 1));

        if (slot < 0 || slot > 5) {
            return null;
        }

        PlayerPartyStorage party = Pixelmon.storageManager.getParty(player);
        Pokemon pokemon = party.get(slot);

        if (pokemon == null) {
            return null;
        }

        return parse(player, placeholder, pokemon);
    }

    protected abstract String parse(EntityPlayerMP player, String placeholder, Pokemon pokemon);
}
