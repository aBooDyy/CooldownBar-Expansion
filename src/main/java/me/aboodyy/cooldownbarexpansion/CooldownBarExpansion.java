package me.aboodyy.cooldownbarexpansion;

import me.clip.placeholderapi.PlaceholderAPI;
import me.clip.placeholderapi.expansion.Configurable;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.apache.commons.lang.math.NumberUtils;
import org.bukkit.entity.Player;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

import static me.aboodyy.cooldownbarexpansion.Utils.*;

public class CooldownBarExpansion extends PlaceholderExpansion implements Configurable {

    private int length, cooldown, barLength, placeholder, remaining, passed, decimal;
    private double secPerSymbol, percentage;
    private String ready, passedSym, remainingSym, inProgress;

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
        map.put("in_progress", "&e|");
        map.put("remaining", "&7|");
        map.put("length", 10);
        map.put("cooldown", 100);
        map.put("decimal", 2);
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
        inProgress = this.getString("in_progress", "&e|");
        remainingSym = this.getString("remaining", "&7|");
        decimal = this.getInt("decimal", 2);

        identifier = PlaceholderAPI.setBracketPlaceholders(p, identifier);
        String[] args = identifier.split("_");

        if (args[0].equalsIgnoreCase("percentage")) {

            if (!NumberUtils.isNumber(args[1]) && convertToSec(args[1]) == 0) return "";

            if (NumberUtils.isNumber(args[1])) placeholder = Integer.valueOf(args[1]);
            else placeholder = convertToSec(args[1]);

            for (String argument : args) {
                if (argument.equalsIgnoreCase("percentage") || argument.equals(args[1])) continue;
                String[] arg = argument.split(":");

                switch (arg[0]) {
                    case "cooldown":
                    case "c":
                        if (!NumberUtils.isNumber(arg[1]) && convertToSec(arg[1]) == 0) continue;

                        if (NumberUtils.isNumber(arg[1])) cooldown = Integer.parseInt(arg[1]);
                        else cooldown = convertToSec(arg[1]);
                        break;
                    case "decimal":
                    case "d":
                        if (NumberUtils.isNumber(arg[1]))
                            decimal = Integer.parseInt(arg[1]);
                }
            }

            if (placeholder <= 0) return "100";

            StringBuilder f = new StringBuilder("#");
            if (decimal > 0) {
                f.append(".");
                for (int i = 0; i < decimal; i++) {
                    f.append("0");
                }
            }

            percentage = ((cooldown - placeholder) / cooldown) * 100;
            DecimalFormat format = new DecimalFormat(f.toString());

            return format.format(percentage);
        }

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
