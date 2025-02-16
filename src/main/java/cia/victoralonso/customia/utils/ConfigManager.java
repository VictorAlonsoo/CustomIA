package cia.victoralonso.customia.utils;

import cia.victoralonso.customia.CustomIA;
import java.util.List;
import org.bukkit.configuration.file.FileConfiguration;

public class ConfigManager {
    private static FileConfiguration config;

    public static void loadConfig() {
        CustomIA plugin = CustomIA.getInstance();
        plugin.saveDefaultConfig();
        config = plugin.getConfig();
    }

    public static boolean isWorldConfigured(String worldName) {
        return config.contains("worlds." + worldName);
    }

    public static boolean isCommandBlocked(String worldName, String command) {
        if (!isWorldConfigured(worldName))
            return false;
        List<String> blockedCommands = config.getStringList("worlds." + worldName + ".blocked-commands");
        return blockedCommands.contains(command.toLowerCase());
    }

    public static String getBlockedMessage(String worldName) {
        return config.getString("worlds." + worldName + ".message", "<red>No tienes permiso para teletransportarte aquí.");
    }
}
