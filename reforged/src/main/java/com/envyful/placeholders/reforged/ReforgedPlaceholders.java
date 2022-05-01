package com.envyful.placeholders.reforged;

import com.envyful.papi.api.manager.AbstractPlaceholderManager;
import com.envyful.placeholders.reforged.extension.*;
import com.envyful.placeholders.reforged.extension.party.impl.*;
import com.envyful.placeholders.reforged.extension.special.impl.*;
import net.minecraft.entity.player.EntityPlayerMP;

public class ReforgedPlaceholders extends AbstractPlaceholderManager<EntityPlayerMP> {

    private static final String IDENTIFIER = "reforged";
    private static final String[] AUTHORS = new String[] { "Envyful" };
    private static final String VERSION = "2.8.5";
    private static final String NAME = "reforged";

    public ReforgedPlaceholders() {
        super(IDENTIFIER, AUTHORS, VERSION, NAME, EntityPlayerMP.class);

        this.registerPlaceholder(new PartyBallExtension());
        this.registerPlaceholder(new PartyDexNumberExtension());
        this.registerPlaceholder(new PartyAbilityExtension());
        this.registerPlaceholder(new PartyAbilityExtension());
        this.registerPlaceholder(new PartyExpExtension());
        this.registerPlaceholder(new PartyExpToLevelExtension());
        this.registerPlaceholder(new PartyFormExtension());
        this.registerPlaceholder(new PartyGenderExtension());
        this.registerPlaceholder(new PartyGrowthExtension());
        this.registerPlaceholder(new PartyLevelExtension());
        this.registerPlaceholder(new PartyNameExtension());
        this.registerPlaceholder(new PartyNatureExtension());
        this.registerPlaceholder(new PartyNicknameExtension());
        this.registerPlaceholder(new PartyOTNameExtension());
        this.registerPlaceholder(new PartyOTUUIDExtension());
        this.registerPlaceholder(new PartyShinyExtension());
        this.registerPlaceholder(new PartyStatsEVsAttackExtension());
        this.registerPlaceholder(new PartyStatsDefenceExtension());
        this.registerPlaceholder(new PartyStatsEVsAttackExtension());
        this.registerPlaceholder(new PartyStatsEVsDefenceExtension());
        this.registerPlaceholder(new PartyStatsEVsHPExtension());
        this.registerPlaceholder(new PartyStatsEVsSpecialAttackExtension());
        this.registerPlaceholder(new PartyStatsEVsSpecialDefenceExtension());
        this.registerPlaceholder(new PartyStatsEVsSpeedExtension());
        this.registerPlaceholder(new PartyStatsHPExtension());
        this.registerPlaceholder(new PartyStatsIVsAttackExtension());
        this.registerPlaceholder(new PartyStatsIVsDefenceExtension());
        this.registerPlaceholder(new PartyStatsIVsHPExtension());
        this.registerPlaceholder(new PartyStatsIVsSpecialAttackExtension());
        this.registerPlaceholder(new PartyStatsIVsSpecialDefenceExtension());
        this.registerPlaceholder(new PartyStatsIVsSpeedExtension());
        this.registerPlaceholder(new PartyStatsIVsTotalPercentageExtension());
        this.registerPlaceholder(new PartyStatsSpecialAttackExtension());
        this.registerPlaceholder(new PartyStatsSpecialDefenceExtension());
        this.registerPlaceholder(new PartyStatsSpeedExtension());
        this.registerPlaceholder(new SpeciesAbilityOneExtension());
        this.registerPlaceholder(new SpeciesAbilityTwoExtension());
        this.registerPlaceholder(new SpeciesBaseStatsAttackExtension());
        this.registerPlaceholder(new SpeciesBaseStatsDefenceExtension());
        this.registerPlaceholder(new SpeciesBaseStatsHPExtension());
        this.registerPlaceholder(new SpeciesBaseStatsSpecialAttackExtension());
        this.registerPlaceholder(new SpeciesBaseStatsSpecialDefenceExtension());
        this.registerPlaceholder(new SpeciesBaseStatsSpeedExtension());
        this.registerPlaceholder(new SpeciesCatchRateExtension());
        this.registerPlaceholder(new SpeciesEggGroupsExtension());
        this.registerPlaceholder(new SpeciesEvolutionsExtension());
        this.registerPlaceholder(new SpeciesFirstTypeExtension());
        this.registerPlaceholder(new SpeciesHiddenAbilityExtension());
        this.registerPlaceholder(new SpeciesNameExtension());
        this.registerPlaceholder(new SpeciesNationalIdExtension());
        this.registerPlaceholder(new SpeciesPostEvolutionsExtension());
        this.registerPlaceholder(new SpeciesPreEvolutionsExtension());
        this.registerPlaceholder(new SpeciesSecondTypeExtension());
        this.registerPlaceholder(new AverageLevelExtension());
        this.registerPlaceholder(new BalanceExtension());
        this.registerPlaceholder(new DexCountExtension());
        this.registerPlaceholder(new DexPercentageExtension());
        this.registerPlaceholder(new DexSizeAllExtension());
        this.registerPlaceholder(new DexSizeExtension());
        this.registerPlaceholder(new HighestLevelExtension());
        this.registerPlaceholder(new LossesExtension());
        this.registerPlaceholder(new LowestLevelExtension());
        this.registerPlaceholder(new NextLegendaryExtension());
        this.registerPlaceholder(new PartySizeExtension());
        this.registerPlaceholder(new SeenCountExtension());
        this.registerPlaceholder(new WinLossRationExtension());
        this.registerPlaceholder(new WinsExtension());
        this.registerPlaceholder(new PartyIsUltraBeastExtension());
        this.registerPlaceholder(new PartyIsLegendaryExtension());
    }
}
