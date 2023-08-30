package com.envyful.placeholders.reforged.extension.special;

import com.envyful.papi.api.manager.extensions.AbstractExtension;
import com.pixelmonmod.pixelmon.api.pokemon.species.Species;
import com.pixelmonmod.pixelmon.api.registries.PixelmonSpecies;
import net.minecraft.server.level.ServerPlayer;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class MatcherReforgedExtension extends AbstractExtension<ServerPlayer> {

    private static final Pattern DEX_MATCHER = Pattern.compile(
            "%reforged_pokedex_([a-zA-Z0-9]+)_([a-zA-Z0-9_-]+)%"
    );

    public MatcherReforgedExtension(String name, int priority, List<String> description, List<String> examples) {
        super(name, priority, description, examples);
    }

    @Override
    public boolean matches(ServerPlayer player, String placeholder) {
        Matcher matcher = DEX_MATCHER.matcher(placeholder);

        if (!matcher.matches()) {
            return false;
        }

        return matcher.group(2).equals(this.getName());
    }

    @Override
    public String parse(ServerPlayer player, String placeholder) {
        Matcher matcher = DEX_MATCHER.matcher(placeholder);
        Species species = this.getSpecies(matcher.group(1));
        return this.parse(player, placeholder, species);
    }

    private Species getSpecies(String s) {
        return PixelmonSpecies.fromNameOrDex(s).orElse(null);
    }

    protected abstract String parse(ServerPlayer player, String placeholder, Species species);
}
