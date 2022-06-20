package com.envyful.placeholders.reforged.extension;

import com.envyful.papi.api.manager.extensions.type.SimpleExtension;
import com.google.common.collect.Lists;
import com.pixelmonmod.pixelmon.api.economy.BankAccount;
import com.pixelmonmod.pixelmon.api.economy.BankAccountProxy;
import net.minecraft.entity.player.ServerPlayerEntity;

import java.math.BigDecimal;
import java.util.List;

public class BalanceExtension extends SimpleExtension<ServerPlayerEntity> {

    private static final String NAME = "balance";
    private static final int PRIORITY = 1;
    private static final List<String> DESCRIPTION = Lists.newArrayList("Gets the player's balance");
    private static final List<String> EXAMPLES = Lists.newArrayList("%reforged_balance%");

    public BalanceExtension() {
        super(NAME, PRIORITY, DESCRIPTION, EXAMPLES);
    }

    @Override
    public String parse(ServerPlayerEntity player, String placeholder) {
        return BankAccountProxy.getBankAccount(player).map(BankAccount::getBalance).orElse(BigDecimal.ZERO).toPlainString();
    }
}
