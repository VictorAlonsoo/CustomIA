package cia.victoralonso.customia.utils;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.command.CommandSender;

public class MessageUtil {
    private static final MiniMessage miniMessage = MiniMessage.miniMessage();

    public static Component format(String message) {
        return miniMessage.deserialize(message);
    }

    public static void send(CommandSender sender, String message) {
        sender.sendMessage(format(message));
    }
}
