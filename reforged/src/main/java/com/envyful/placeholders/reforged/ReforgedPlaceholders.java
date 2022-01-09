package com.envyful.placeholders.reforged;

import com.envyful.papi.api.PlaceholderManager;
import com.envyful.papi.api.manager.AbstractPlaceholderManager;
import com.google.common.collect.Lists;
import com.pixelmonmod.pixelmon.Pixelmon;
import com.pixelmonmod.pixelmon.api.pokemon.Pokemon;
import com.pixelmonmod.pixelmon.api.storage.PCStorage;
import com.pixelmonmod.pixelmon.entities.pixelmon.stats.StatsType;
import com.pixelmonmod.pixelmon.entities.pixelmon.stats.evolution.Evolution;
import com.pixelmonmod.pixelmon.enums.EnumEggGroup;
import com.pixelmonmod.pixelmon.enums.EnumSpecies;
import com.pixelmonmod.pixelmon.pokedex.Pokedex;
import com.pixelmonmod.pixelmon.spawning.PixelmonSpawning;
import com.pixelmonmod.pixelmon.storage.PlayerPartyStorage;
import net.minecraft.entity.player.EntityPlayerMP;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReforgedPlaceholders extends AbstractPlaceholderManager<EntityPlayerMP> {

    private static final String IDENTIFIER = "reforged";
    private static final String[] AUTHORS = new String[] { "Envyful" };
    private static final String VERSION = "2.0.0";
    private static final String NAME = "reforged";

    private static final Pattern DEX_MATCHER = Pattern.compile(
            "(pokdex_)(([a-zA-Z0-9!@#$&()`.+,\\/\"-]+)?([0-9]+)?)(_)([a-zA-Z0-9!@#$&()`.+,\\/\"-_]+)"
    );

    public ReforgedPlaceholders() {
        super(IDENTIFIER, AUTHORS, VERSION, NAME);
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
            case "wins" : {
                if (party.stats == null) {
                    return "0";
                }

                return party.stats.getWins() + "";
            }
            case "loses" :  {
                if (party.stats == null) {
                    return "0";
                }

                return party.stats.getLosses() + "";
            }
            case "wl_ratio" : {
                if (party.stats == null || party.stats.getLosses() == 0) {
                    return "0";
                }

                return String.format(
                        "%.2f",
                        ((party.stats.getWins() + 0.000) / party.stats.getLosses()) * 100);
            }
            case "balance" : return party.getMoney() + "";
            case "highest_level" : return party.getHighestLevel() + "";
            case "average_level" : return party.getAverageLevel() + "";
            case "lowest_level" : return party.getLowestLevel() + "";
            case "dexsize" : return Pokedex.pokedexSize + "";
            case "dexsizeall" : return EnumSpecies.values().length + "";
            case "nextlegendary" : return TimeUnit.MILLISECONDS.toSeconds(PixelmonSpawning.legendarySpawner.nextSpawnTime - System.currentTimeMillis()) + "";
        }

        Matcher matcher = DEX_MATCHER.matcher(placeholder);

        if (matcher.matches()) {
            String group = matcher.group(3);
            EnumSpecies species = this.getSpecies(matcher.group(2));

            if (species == null) {
                return "Species not found";
            }

            switch(group) {
                case "name" : return species.getPokemonName();
                case "catchrate" : return species.getBaseStats().getCatchRate() + "";
                case "nationalid" : return species.getNationalPokedexNumber();
                case "postevolutions" : {
                    List<String> postEvolutions = Lists.newArrayList();

                    for (Evolution evolution : species.getBaseStats().getEvolutions()) {
                        postEvolutions.add(evolution.to.name);
                    }

                    return String.join(", ", postEvolutions);
                }
                case "preevolutions" : {
                    List<String> preEvolutions = Lists.newArrayList();

                    for (String evolution : species.getBaseStats().preEvolutions) {
                        preEvolutions.add(evolution);
                    }

                    return String.join(", ", preEvolutions);
                }
                case "evolutions" : {
                    List<String> evolutions = Lists.newArrayList();

                    for (String evolution : species.getBaseStats().preEvolutions) {
                        evolutions.add(evolution);
                    }

                    for (Evolution evolution : species.getBaseStats().getEvolutions()) {
                        evolutions.add(evolution.to.name);
                    }

                    return String.join(", ", evolutions);
                }
                case "ability_1" : return species.getBaseStats().getAbilitiesArray()[0];
                case "ability_2" : return species.getBaseStats().getAbilitiesArray()[1];
                case "ability_H" : return species.getBaseStats().getAbilitiesArray()[2];
                case "type" : return species.getBaseStats().getType1().getLocalizedName();
                case "basestats_hp" : return species.getBaseStats().get(StatsType.HP) + "";
                case "basestats_atk" : return species.getBaseStats().get(StatsType.Attack) + "";
                case "basestats_def" : return species.getBaseStats().get(StatsType.Defence) + "";
                case "basestats_spa" : return species.getBaseStats().get(StatsType.SpecialAttack) + "";
                case "basestats_spd" : return species.getBaseStats().get(StatsType.SpecialDefence) + "";
                case "basestats_spe" : return species.getBaseStats().get(StatsType.Speed) + "";
                case "egggroups" : {
                    EnumEggGroup[] eggGroups = species.getBaseStats().eggGroups;
                    List<String> eggs = Lists.newArrayList();

                    for (EnumEggGroup eggGroup : eggGroups) {
                        eggs.add(eggGroup.name());
                    }

                    return String.join(", ", eggs);
                }
            }
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
                case "ball" : return pokemon.getCaughtBall().getLocalizedName();
                case "growth" : return pokemon.getGrowth().getLocalizedName();
                case "form" : return pokemon.getFormEnum().getLocalizedName();
                case "shiny" : return pokemon.isShiny() ? "shiny" : "non-shiny";
                case "exptolevelup" : return pokemon.getExperienceToLevelUp() + "";
                case "stats_hp" : return pokemon.getStats().get(StatsType.HP) + "";
                case "stats_atk" : return pokemon.getStats().get(StatsType.Attack) + "";
                case "stats_def" : return pokemon.getStats().get(StatsType.Defence) + "";
                case "stats_spa" : return pokemon.getStats().get(StatsType.SpecialAttack) + "";
                case "stats_spd" : return pokemon.getStats().get(StatsType.SpecialDefence) + "";
                case "stats_spe" : return pokemon.getStats().get(StatsType.Speed) + "";
                case "stats_ivs_hp" : return pokemon.getIVs().get(StatsType.HP) + "";
                case "stats_ivs_atk" : return pokemon.getIVs().get(StatsType.Attack) + "";
                case "stats_ivs_def" : return pokemon.getIVs().get(StatsType.Defence) + "";
                case "stats_ivs_spa" : return pokemon.getIVs().get(StatsType.SpecialAttack) + "";
                case "stats_ivs_spd" : return pokemon.getIVs().get(StatsType.SpecialDefence) + "";
                case "stats_ivs_spe" : return pokemon.getIVs().get(StatsType.Speed) + "";
                case "stats_ivs_totalpercentage" : return pokemon.getIVs().getPercentageString(2) + "";
                case "stats_evs_hp" : return pokemon.getEVs().get(StatsType.HP) + "";
                case "stats_evs_atk" : return pokemon.getEVs().get(StatsType.Attack) + "";
                case "stats_evs_def" : return pokemon.getEVs().get(StatsType.Defence) + "";
                case "stats_evs_spa" : return pokemon.getEVs().get(StatsType.SpecialAttack) + "";
                case "stats_evs_spd" : return pokemon.getEVs().get(StatsType.SpecialDefence) + "";
                case "stats_evs_spe" : return pokemon.getEVs().get(StatsType.Speed) + "";
                case "originaltrainer_uuid" : return pokemon.getOriginalTrainerUUID() + "";
                case "originaltrainer_name" : return pokemon.getOriginalTrainer();
            }
        }

        return "UNDEFINED";
    }

    private EnumSpecies getSpecies(String s) {
        EnumSpecies species = EnumSpecies.getFromNameAnyCaseNoTranslate(s);

        if (species != null) {
            return species;
        }

        return EnumSpecies.getFromDex(Integer.parseInt(s));
    }
}
