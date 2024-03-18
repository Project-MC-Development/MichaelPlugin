package me.minignomer.michaelplugin.commands;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ToggleGamemodeCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Only players can use this command!");
            return true;
        }
        Player p = (Player) sender;
        switch (p.getGameMode()) {
            case CREATIVE:
                p.setGameMode(GameMode.SURVIVAL);
                break;
            case SURVIVAL:
                p.setGameMode(GameMode.CREATIVE);
                break;
            case SPECTATOR:
            case ADVENTURE:
                if (p.getPreviousGameMode() == null) {
                    p.setGameMode(GameMode.CREATIVE);
                    break;
                }
                p.setGameMode(p.getPreviousGameMode());
                break;
        }
        return true;
    }
}
