# ForgePlaceholderAPI Extensions [![Discord](https://img.shields.io/discord/831966641586831431)](https://discord.gg/7vqgtrjDGw)

A repository containing some ForgePlaceholderAPI placeholder extensions.

# Installation Instructions
**This requires the use of [ForgePlaceholderAPI](https://github.com/EnvyWare/ForgePlaceholderAPI)**

Extensions Available:

 - CMI - 1.12.2 - Requires running Magma/Mohist/Other Spigot Hybrid
 - ForgeEconomies - 1.12.2 & 1.16.5 - Requires [ForgeEconomies](https://github.com/EnvyWare/ForgeEconomies)
 - ForgePlaceholders - 1.12.2 & 1.16.5
 - LuckPerms - 1.12.2 - Requires running Sponge or Magma/Mohist/Other Spigot Hybrid
 - PokeTracker - 1.12.2 - Requires [PokeTracker](https://github.com/EnvyWare/PokeTracker)
 - Reforged - 1.12.2 - Requires [Pixelmon Reforged](https://reforged.gg)
 - SimpleVoteRewards - 1.12.2 - Requires [SimpleVoteRewards](https://github.com/EnvyWare/SimpleVoteRewards)
 - SpigotPlaceholders - 1.12.2 & 1.16.5 - Requires running Magma/Mohist/Other Spigot Hybrid
 - UltimatePokeBuilder - 1.12.2 - Requires [UltimatePokeBuilder](https://github.com/EnvyWare/UltimatePokeBuilder)

Once you have downloaded the extensions you want, simply put them In `/mods/ForgePlaceholderAPI` and restart your server!

# Extension Explanation
This list may get out of date and is meant to serve as a general reference. For an up to date reference, head over to the [wiki](https://github.com/EnvyWare/ForgePlaceholderAPI-Extensions/wiki).

CMI
-   %cmi_balance% - Gets the player's balance
-   %cmi_playtime% - Gets the player's playtime
-   %cmi_playtime% - Gets the player's playtime
-   %cmi_server_online% - Gets the online count for the server

ForgeEconomies
-   %forgeeconomies_baltop__[currency]% Get the top of players, ranked by balance, on the server.
-   %forgeeconomies_balance_[currency]% Get the balance of the player. (e.g. "1234.56")
-   %forgeeconomies_balformat_[currency]% Get the balance of the player and format it. (e.g. "$1,234.56")
-   %forgeeconomies_display_[currency]% Get the singular display name for the currency. (e.g. "Dollar")
-   %forgeeconomies_pluraldisplay_[currency]% Get the plural display name for the currency. (e.g. "Dollars")
-   %forgeeconomies_symbol_[currency]% Gets the symbol for the currency. (e.g. "$")

Forge Placeholders
-   %forge_name% - Gets the player's name
-   %forge_displayname% - Gets the player's displayname
-   %forge_health% - Gets the player's health
-   %forge_food% - Gets the player's food
-   %forge_online% - Gets the number of online players
-   %forge_max_online% - Gets the maximum number of online players
-   %forge_tps% - Gets the server's TPS
-   %forge_ping% - Gets the player's ping

LuckPerms
-   %luckperms_prefix% - The player's prefix
-   %luckperms_suffix% - The player's suffix

PokeTracker
-   %poketracker_catcher_legendary_1% - Gets the pokemon's catcher
-   %poketracker_pokemon_legendary_1% - Gets the pokemon's name
-   %poketracker_status_legendary_1% - Gets the pokemon's status
-   %poketracker_time_legendary_1% - Gets the pokemon's last spawn time

Reforged
- Party Info - Change 1 to whatever party slot you want to display Information on
  - %reforged_party_slot_1_ability% - Gets the pokemon's ability in the given slot
  - %reforged_party_slot_1_ability% - Gets the pokemon's ability in the given slot
  - %reforged_party_slot_1_exp% - Gets the pokemon's exp in the given slot
  - %reforged_party_slot_1_exptolevelup% - Gets the pokemon's exp to next level in the given slot
  - %reforged_party_slot_1_form% - Gets the pokemon's form in the given slot
  - %reforged_party_slot_1_gender% - Gets the pokemon's gender in the given slot
  - %reforged_party_slot_1_growth% - Gets the pokemon's growth in the given slot
  - %reforged_party_slot_1_level% - Gets the pokemon's level in the given slot
  - %reforged_party_slot_1_name% - Gets the pokemon's name in the given slot
  - %reforged_party_slot_1_nature% - Gets the pokemon's nature in the given slot
  - %reforged_party_slot_1_nickname% - Gets the pokemon's nickname in the given slot
  - %reforged_party_slot_1_originaltrainer_name% - Gets the pokemon's OT name
  - %reforged_party_slot_1_originaltrainer_uuid% - Gets the pokemon's OT uuid
  - %reforged_party_slot_1_shiny% - Gets the pokemon's shiny status in the given slot
  - %reforged_party_slot_1_stats_evs_atk% - Gets the pokemon's attack ev stat in the given slot
  - %reforged_party_slot_1_stats_def% - Gets the pokemon's defence stat in the given slot
  - %reforged_party_slot_1_stats_evs_atk% - Gets the pokemon's attack ev stat in the given slot
  - %reforged_party_slot_1_stats_evs_def% - Gets the pokemon's defence ev stat in the given slot
  - %reforged_party_slot_1_stats_evs_hp% - Gets the pokemon's hp ev stat in the given slot
  - %reforged_party_slot_1_stats_evs_spa% - Gets the pokemon's special attack ev stat in the given slot
  - %reforged_party_slot_1_stats_evs_spd% - Gets the pokemon's special defence ev stat in the given slot
  - %reforged_party_slot_1_stats_evs_spe% - Gets the pokemon's speed ev stat in the given slot
  - %reforged_party_slot_1_stats_hp% - Gets the pokemon's hp stat in the given slot
  - %reforged_party_slot_1_stats_ivs_atk% - Gets the pokemon's attack iv stat in the given slot
  - %reforged_party_slot_1_stats_ivs_def% - Gets the pokemon's defence iv stat in the given slot
  - %reforged_party_slot_1_stats_ivs_hp% - Gets the pokemon's hp iv stat in the given slot
  - %reforged_party_slot_1_stats_ivs_spa% - Gets the pokemon's special attack iv stat in the given slot
  - %reforged_party_slot_1_stats_ivs_spd% - Gets the pokemon's special defence iv stat in the given slot
  - %reforged_party_slot_1_stats_ivs_spe% - Gets the pokemon's speed iv stat in the given slot
  - %reforged_party_slot_1_stats_ivs_totalpercentage% - Gets the pokemon's IV percentage in the given slot
  - %reforged_party_slot_1_stats_spa% - Gets the pokemon's special attack stat in the given slot
  - %reforged_party_slot_1_stats_spd% - Gets the pokemon's special defence stat in the given slot
  - %reforged_party_slot_1_stats_spe% - Gets the pokemon's speed stat in the given slot
  - %reforged_party_1_is_ub% - Gets if the pokemon is ultrabeast
  - %reforged_party_1_is_legendary% - Gets if the pokemon is legendary
- Species Info - Change bulbasaur to whatever Pokemon species you want.
  - %reforged_pokedex_bulbasaur_ability_1% - Gets the pokemon's first ability
  - %reforged_pokedex_bulbasaur_ability_2% - Gets the pokemon's second ability
  - %reforged_pokedex_bulbasaur_basestats_atk% - Gets the pokemon's base stats Attack
  - %reforged_pokedex_bulbasaur_basestats_def - Gets the pokemon's base stats Defence
  - %reforged_pokedex_bulbasaur_basestats_hp% - Gets the pokemon's base stats HP
  - %reforged_pokedex_bulbasaur_basestats_spa% - Gets the pokemon's base stats Special Attack
  - %reforged_pokedex_bulbasaur_basestats_spd - Gets the pokemon's base stats Special Defence
  - %reforged_pokedex_bulbasaur_basestats_spe% - Gets the pokemon's base stats Speed
  - %reforged_pokedex_bulbasaur_catchrate% - Gets the pokemon's catch rate
  - %reforged_pokedex_bulbasaur_egggroups% - Gets the pokemon's egg groups
  - %reforged_pokedex_bulbasaur_evolutions% - Gets the pokemon's evolutions
  - %reforged_pokedex_bulbasaur_type_1% - Gets the pokemon's first type
  - %reforged_pokedex_bulbasaur_ability_H% - Gets the pokemon's hidden ability
  - %reforged_pokedex_bulbasaur_name% - Gets the pokemon's name
  - %reforged_pokedex_bulbasaur_nationalid% - Gets the pokemon's dex number
  - %reforged_pokedex_bulbasaur_postevolutions% - Gets the pokemon's post evolutions
  - %reforged_pokedex_bulbasaur_preevolutions% - Gets the pokemon's pre evolutions
  - %reforged_pokedex_bulbasaur_type_2% - Gets the pokemon's second type
-   %reforged_average_level% - Gets the player's party's average level
-   %reforged_balance% - Gets the player's balance
-   %reforged_dex_count% - Gets the player's dex caught count
-   %reforged_dex_percentage% - Gets the player's dex completion percentage
-   %reforged_dexsizeall% - Gets the dex size
-   %reforged_dexsize% - Gets the dex size excluding MissingNo
-   %reforged_highest_level% - Gets the player's party's highest level
-   %reforged_losses% - Gets the player's losses
-   %reforged_lowest_level% - Gets the player's party's lowest level
-   %reforged_nextlegendary% - Gets the next legendary spawn time
-   %reforged_seen_count% - Gets the player's dex seen count
-   %reforged_wl_ratio% - Gets the player's win loss ratio
-   %reforged_wins% - Gets the player's wins
-   %reforged_partysize% - Gets the number of Pokemon In a player's party

SimpleVoteRewards
-   %simplevoterewards_vote_party% - Current number of votes in the vote party (required - counter)
-   %simplevoterewards_vote_party_total% - Number of votes required for a vote party
-   %simplevoterewards_votes% - Number of votes counted (resets when hits vote party)

SpigotPlaceholders
-   `%spigotpapi_parse_<placeholder>%`  - Parses the given placeholder using spigot's Placeholder API. Grab the placeholder you want to use **without % symbols** and paste It Into `<placeholder>`. For example, `%spigotpapi_parse_vault_eco_balance%` will grab the player's balance from Vault and display It In ForgeMenus.
