package smpvp.smpvp;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import smpvp.smpvp.arenas.ArenaManager;
import smpvp.smpvp.configs.Config;
import smpvp.smpvp.events.GroupFight;

public final class SMPvp extends JavaPlugin implements Listener {

    private static SMPvp plugin;

    @Override
    public void onEnable() {
        // Plugin startup logic
        plugin = this;

        getConfig().options().copyDefaults(true);
        saveConfig();


        Config.setup();
        Bukkit.getPluginManager().registerEvents(new GroupFight(), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static SMPvp getInstance() {
        return plugin;
    }

}
