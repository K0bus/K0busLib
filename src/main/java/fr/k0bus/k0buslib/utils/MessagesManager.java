package fr.k0bus.k0buslib.utils;

import fr.k0bus.k0buslib.settings.Lang;
import fr.k0bus.k0buslib.settings.Settings;

import java.util.HashMap;
import java.util.UUID;

public class MessagesManager {
    private final HashMap<UUID, Long> antiSpam = new HashMap<>();
    private final Settings settings;
    private final Lang lang;

    public MessagesManager(Settings settings, Lang lang)
    {
        this.settings = settings;
        this.lang = lang;
    }

    public HashMap<UUID, Long> getAntiSpam() {
        return antiSpam;
    }

    public Lang getLang() {
        return lang;
    }

    public Settings getSettings() {
        return settings;
    }
}
