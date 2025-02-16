package cia.victoralonso.customia;

import cia.victoralonso.customia.commands.ReloadCommand;
import cia.victoralonso.customia.listeners.CommandListener;
import cia.victoralonso.customia.utils.ConfigManager;
import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class CustomIA extends JavaPlugin {
    private static CustomIA instance;

    public void onEnable() {
        instance = this;
        ConfigManager.loadConfig();
        getServer().getPluginManager().registerEvents((Listener)new CommandListener(), (Plugin)this);
        getCommand("customiareload").setExecutor((CommandExecutor)new ReloadCommand());
        getLogger().info("CustomIA se ha activado correctamente.");
    }

    public void onDisable() {
        getLogger().info("CustomIA se ha desactivado.");
    }

    public static CustomIA getInstance() {
        return instance;
    }
}
