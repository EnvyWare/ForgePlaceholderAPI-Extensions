package com.envyful.placeholders.reforged.extension.special;

import com.envyful.papi.api.manager.extensions.AbstractExtension;
import com.pixelmonmod.pixelmon.enums.EnumSpecies;
import net.minecraft.entity.player.EntityPlayerMP;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class MatcherReforgedExtension extends AbstractExtension<EntityPlayerMP> {

    private static final Pattern DEX_MATCHER = Pattern.compile(
            "%reforged_pokedex_([a-zA-Z0-9]+)_([a-zA-Z0-9_-]+)%"
    );

    public MatcherReforgedExtension(String name, int priority, List<String> description, List<String> examples) {
        super(name, priority, description, examples);
    }

    @Override
    public boolean matches(EntityPlayerMP player, String placeholder) {
        Matcher matcher = DEX_MATCHER.matcher(placeholder);

        if (!matcher.matches()) {
            return false;
        }

        return matcher.group(2).equals(this.getName());
    }

    @Override
    public String parse(EntityPlayerMP player, String placeholder) {
        Matcher matcher = DEX_MATCHER.matcher(placeholder);
        EnumSpecies species = this.getSpecies(matcher.group(1));

        if (species == null) {
            return null;
        }

        return this.parse(player, placeholder, species);
    }

    private EnumSpecies getSpecies(String s) {
        EnumSpecies species = EnumSpecies.getFromNameAnyCaseNoTranslate(s);

        if (species != null) {
            return species;
        }

        return EnumSpecies.getFromDex(Integer.parseInt(s));
    }

    protected abstract String parse(EntityPlayerMP player, String placeholder, EnumSpecies species);
}
