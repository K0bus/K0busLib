package fr.k0bus.akuralib.utils;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;

public class Messages {
    public static void log(JavaPlugin plugin, String text)
    {
        log(plugin, text, Level.INFO);
    }
    public static void log(JavaPlugin plugin, String text, Level level)
    {
        plugin.getLogger().log(level, Formater.formatColor(text));
    }
}
