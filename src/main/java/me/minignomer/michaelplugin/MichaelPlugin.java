package me.minignomer.michaelplugin;

import me.minignomer.michaelplugin.commands.ToggleGamemodeCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class MichaelPlugin extends JavaPlugin {

    private void registerCommands() {
        getCommand("togglegamemode").setExecutor(new ToggleGamemodeCommand());
    }

    @Override
    public void onEnable() {

        registerCommands();
    }
}
