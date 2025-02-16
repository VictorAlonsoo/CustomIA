package cia.victoralonso.customia.commands;

import cia.victoralonso.customia.CustomIA;
import cia.victoralonso.customia.utils.ConfigManager;
import cia.victoralonso.customia.utils.MessageUtil;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ReloadCommand implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!sender.hasPermission("customia.reload")) {
            sender.sendMessage(MessageUtil.format("<red>No tienes permiso para ejecutar este comando."));
            return true;
        }
        CustomIA.getInstance().reloadConfig();
        ConfigManager.loadConfig();
        MessageUtil.send(sender, "<green>Configuracirecargada correctamente!");
        return true;
    }
}
