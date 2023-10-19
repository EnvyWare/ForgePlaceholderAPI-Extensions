package com.envyful.placeholders.reforged.extension.party;

import com.envyful.papi.api.manager.extensions.AbstractExtension;
import com.pixelmonmod.pixelmon.api.pokemon.Pokemon;
import com.pixelmonmod.pixelmon.api.storage.PlayerPartyStorage;
import com.pixelmonmod.pixelmon.api.storage.StorageProxy;
import net.minecraft.server.level.ServerPlayer;

import java.util.List;

public abstract class PartyReforgedExtension extends AbstractExtension<ServerPlayer> {

    public PartyReforgedExtension(String name, int priority, List<String> description, List<String> examples) {
        super(name, priority, description, examples);
    }

    @Override
    public boolean matches(ServerPlayer player, String placeholder) {
        int slot = this.parseInt(placeholder.replace("party_slot_", "").substring(0, 1));

        if (slot < 0 || slot > 5) {
            return false;
        }

        String data = placeholder.replace("party_slot_", "");

        if (data.isEmpty() || data.length() == 0) {
            return false;
        }

        String remainingPlaceholder = data.substring(2);

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
    public String parse(ServerPlayer player, String placeholder) {
        int slot = Integer.parseInt(placeholder.replace("party_slot_", "").substring(0, 1));

        if (slot < 0 || slot > 5) {
            return null;
        }

        PlayerPartyStorage party = StorageProxy.getPartyNow(player);
        Pokemon pokemon = party.get(slot);
        return parse(player, placeholder, pokemon);
    }

    protected abstract String parse(ServerPlayer player, String placeholder, Pokemon pokemon);
}
