package com.envyful.placeholders.reforged;

import com.envyful.papi.api.PlaceholderManager;
import com.pixelmonmod.pixelmon.Pixelmon;
import com.pixelmonmod.pixelmon.api.pokemon.Pokemon;
import com.pixelmonmod.pixelmon.api.storage.PCStorage;
import com.pixelmonmod.pixelmon.pokedex.Pokedex;
import com.pixelmonmod.pixelmon.storage.PlayerPartyStorage;
import net.minecraft.entity.player.EntityPlayerMP;

public class ReforgedPlaceholders implements PlaceholderManager<EntityPlayerMP> {

    @Override
    public String getIdentifier() {
        return "reforged";
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
        PlayerPartyStorage party = Pixelmon.storageManager.getParty(player);
        PCStorage pc = Pixelmon.storageManager.getPCForPlayer(player);

        switch (placeholder.toLowerCase()) {
            case "dex_percent":
                return String.format(
                        "%.2f",
                        ((party.pokedex.countCaught() + 0.000) / Pokedex.pokedexSize) * 100
                ) + "%";
            case "dex_count" : return party.pokedex.countCaught() + "";
            case "seen_count" : return party.pokedex.countSeen() + "";
            case "wins" : return party.stats.getWins() + "";
            case "loses" : return party.stats.getLosses() + "";
            case "wl_ratio" : return String.format(
                    "%.2f",
                    ((party.stats.getWins() + 0.000) / party.stats.getLosses()) * 100);
            case "balance" : return party.getMoney() + "";
            case "highest_level" : return party.getHighestLevel() + "";
            case "average_level" : return party.getAverageLevel() + "";
            case "lowest_level" : return party.getLowestLevel() + "";
        }

        if (placeholder.startsWith("party_slot_")) {
            int slot = Integer.parseInt(placeholder.replace("party_slot_", "").substring(0, 1));

            if (slot < 0 || slot > 5) {
                return "UNDEFINED";
            }

            String remainingPlaceholder = placeholder.replace("party_slot_", "").substring(2);
            Pokemon pokemon = party.get(slot);

            if (pokemon == null) {
                return "";
            }

            switch (remainingPlaceholder) {
                case "name" : return pokemon.getSpecies().getLocalizedName();
                case "nickname" : return pokemon.getNickname();
                case "level" : return pokemon.getLevel() + "";
                case "exp" : return pokemon.getExperience() + "";
                case "ability" : return pokemon.getAbilityName();
                case "gender" : return pokemon.getGender().getLocalizedName();
                case "nature" : return pokemon.getNature().getLocalizedName();
                case "form" : return pokemon.getFormEnum().getLocalizedName();
                case "shiny" : return pokemon.isShiny() ? "shiny" : "non-shiny";
            }
        }

        return "UNDEFINED";
    }
}
