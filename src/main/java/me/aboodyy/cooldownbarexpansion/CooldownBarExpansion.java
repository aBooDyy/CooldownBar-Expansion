package me.aboodyy.cooldownbarexpansion;

import me.clip.placeholderapi.PlaceholderAPI;
import me.clip.placeholderapi.expansion.Configurable;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.apache.commons.lang.math.NumberUtils;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

import static me.aboodyy.cooldownbarexpansion.Utils.*;

public class CooldownBarExpansion extends PlaceholderExpansion implements Configurable {

    private int length, cooldown, barLength, placeholder, remaining, passed;
    private double secPerSymbol;
    private String ready, passedSym, remainingSym;

    @Override
    public String getAuthor() {
        return "aBooDyy";
    }

    @Override
    public String getIdentifier() {
        return "cooldownbar";
    }

    @Override
    public String getVersion() {
        return "1.0";
    }

    @Override
    public Map<String, Object> getDefaults() {
        Map<String, Object> map = new HashMap<>();
        map.put("ready", "&aReady!");
        map.put("passed", "&a|");
        map.put("remaining", "&7|");
        map.put("length", 10);
        map.put("cooldown", 100);
        return map;
    }

    @Override
    public String onPlaceholderRequest(Player p, String identifier) {
        if (p == null) return "";

        barLength = 0;
        length = this.getInt("length", 10);
        cooldown = this.getInt("cooldown", 100);
        ready = this.getString("ready", "&aReady!");
        passedSym = this.getString("passed", "&a|");
        remainingSym = this.getString("remaining", "&7|");

        identifier = PlaceholderAPI.setBracketPlaceholders(p, identifier);
        String[] args = identifier.split("_");

        if (!NumberUtils.isNumber(args[0]) && convertToSec(args[0]) == 0) return "";

        if (NumberUtils.isNumber(args[0])) placeholder = Integer.valueOf(args[0]);
        else placeholder = convertToSec(args[0]);

        for (String argument : args) {
            if (argument.equals(args[0])) continue;
            String[] arg = argument.split(":");

            switch (arg[0]) {
                case "ready":
                case "rdy":
                    ready = arg[1];
                    break;
                case "remaining":
                case "r":
                    remainingSym = arg[1];
                    break;
                case "passed":
                case "p":
                    passedSym = arg[1];
                    break;
                case "length":
                case "l":
                    if (NumberUtils.isNumber(arg[1]))
                        length = Integer.parseInt(arg[1]);
                    break;
                case "cooldown":
                case "c":
                    if (NumberUtils.isNumber(arg[1]))
                        cooldown = Integer.parseInt(arg[1]);
            }
        }

        if (placeholder <= 0) return ready;

        StringBuilder bar = new StringBuilder();

        secPerSymbol = (double) cooldown / length; // 1
        remaining = (int) Math.floor(placeholder / secPerSymbol); // 5
        passed = length - remaining;

        while (barLength < passed) {
            bar.append(passedSym);
            barLength++;
        }
        while (barLength < length) {
            bar.append(remainingSym);
            barLength++;
        }

        return bar.toString();
    }
}
