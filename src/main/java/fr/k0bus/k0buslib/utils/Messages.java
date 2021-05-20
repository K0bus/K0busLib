package fr.k0bus.k0buslib.utils;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;

public class Messages {
    public static void sendMessage(MessagesManager mm, Player player, String string)
    {
        sendMessageText(mm, player, mm.getLang().getString(string));
    }
    public static void sendMessage(MessagesManager mm, Player player, String string, HashMap<String, String> replace)
    {
        String text = mm.getLang().getString(string);
        for (Map.Entry<String, String> entry : replace.entrySet()) {
            text = text.replace(entry.getKey(), entry.getValue());
        }
        sendMessageText(mm, player, text);
    }
    public static void sendMessageText(MessagesManager mm, Player player, String text)
    {
        if(mm.getAntiSpam().containsKey(player.getUniqueId())) {
            if (mm.getAntiSpam().get(player.getUniqueId()) < System.currentTimeMillis()) {
                mm.getAntiSpam().remove(player.getUniqueId());
                mm.getAntiSpam().put(player.getUniqueId(), System.currentTimeMillis() + 100);
                player.sendMessage(Formater.formatColor( mm.getSettings().getTag() + text));
            }
        }
        else {
            mm.getAntiSpam().put(player.getUniqueId(), System.currentTimeMillis() + 100);
            player.sendMessage(Formater.formatColor(mm.getSettings().getTag() + text));
        }
    }
    public static void sendMessage(MessagesManager mm, CommandSender sender, String string)
    {
        sendMessageText(mm, sender, mm.getLang().getString(string));
    }
    public static void sendMessage(MessagesManager mm, CommandSender sender, String string, HashMap<String, String> replace)
    {
        String text = mm.getLang().getString(string);
        for (Map.Entry<String, String> entry : replace.entrySet()) {
            text = text.replace(entry.getKey(), entry.getValue());
        }
        sendMessageText(mm, sender, text);
    }
    public static void sendMessageText(MessagesManager mm, CommandSender sender, String text)
    {
        sender.sendMessage(Formater.formatColor( mm.getSettings().getTag() + text));
    }

    public static void log(JavaPlugin plugin, String text)
    {
        log(plugin, text, Level.INFO);
    }
    public static void log(JavaPlugin plugin, String text, Level level)
    {
        plugin.getLogger().log(level, Formater.formatColor(text));
    }
}
