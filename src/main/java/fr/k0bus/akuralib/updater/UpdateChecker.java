package fr.k0bus.akuralib.updater;

import org.apache.maven.artifact.versioning.ComparableVersion;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;

public class UpdateChecker {

    private final JavaPlugin plugin;
    private final ComparableVersion version;
    private final ComparableVersion spigotVersion;
    private final int resourceId;

    public UpdateChecker(JavaPlugin plugin, int resourceId) {
        this.plugin = plugin;
        this.version = new ComparableVersion(this.plugin.getDescription().getVersion());
        this.resourceId = resourceId;
        this.spigotVersion = getVersion();
    }

    public ComparableVersion getVersion() {
        try (InputStream inputStream = new URL("https://api.spigotmc.org/legacy/update.php?resource=" + this.resourceId).openStream(); Scanner scanner = new Scanner(inputStream)) {
            if (scanner.hasNext()) {
                return new ComparableVersion(scanner.next());
            }
        } catch (IOException exception) {
            this.plugin.getLogger().info("Cannot look for updates: " + exception.getMessage());
        }
        return null;
    }
    public boolean isUpToDate()
    {
        return spigotVersion.compareTo(this.version)<0;
    }
}
