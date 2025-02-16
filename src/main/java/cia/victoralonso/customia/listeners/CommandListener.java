package cia.victoralonso.customia.listeners;

import cia.victoralonso.customia.utils.ConfigManager;
import cia.victoralonso.customia.utils.MessageUtil;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class CommandListener implements Listener {
    @EventHandler
    public void onCommandPreProcess(PlayerCommandPreprocessEvent event) {
        Player sender = event.getPlayer();
        String[] args = event.getMessage().split(" ");
        String command = args[0].substring(1).toLowerCase();
        if (args.length > 1) {
            Player target = Bukkit.getPlayer(args[1]);
            if (target != null && target.isOnline()) {
                String senderWorld = sender.getWorld().getName();
                String targetWorld = target.getWorld().getName();
                if (ConfigManager.isWorldConfigured(targetWorld) && ConfigManager.isCommandBlocked(targetWorld, command)) {
                    if (sender.isOp() || sender.hasPermission("customia.bypass"))
                        return;
                    if (sender.hasPermission("customia.tp." + targetWorld))
                        return;
                    event.setCancelled(true);
                    MessageUtil.send((CommandSender)sender, ConfigManager.getBlockedMessage(targetWorld));
                }
            }
        }
    }
}
