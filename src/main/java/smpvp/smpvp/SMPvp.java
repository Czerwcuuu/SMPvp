package smpvp.smpvp;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import smpvp.smpvp.commands.setupArena;
import smpvp.smpvp.configs.Config;
import smpvp.smpvp.data.DataManager;
import smpvp.smpvp.events.GroupFight;

public final class SMPvp extends JavaPlugin implements Listener {
    private static SMPvp plugin;
    public DataManager data;

    public void onEnable() {
        plugin = this;
        this.data = new DataManager(this);
        this.getCommand("pvp").setExecutor(new setupArena());
        this.getConfig().options().copyDefaults(true);
        this.saveConfig();
        Config.setup();
        Bukkit.getPluginManager().registerEvents(new GroupFight(), this);
    }

    public void onDisable() {
    }

    public static SMPvp getInstance() {
        return plugin;
    }
}
