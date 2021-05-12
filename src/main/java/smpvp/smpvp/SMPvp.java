package smpvp.smpvp;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import smpvp.smpvp.commands.*;
import smpvp.smpvp.configs.Config;
import smpvp.smpvp.data.CustomArenas;
import smpvp.smpvp.data.DataManager;
import smpvp.smpvp.data.KitLists;
import smpvp.smpvp.events.*;

public final class SMPvp extends JavaPlugin implements Listener {
    private static SMPvp plugin;
    public DataManager data;
    public KitLists kitlist;
    public CustomArenas freearenas;

    /*
    TODO:
    - mozliwosc ignorowania zaproszen
    po zaakcpetowaniu areny:




     */

    public void onEnable() {
        plugin = this;
        this.data = new DataManager(this);
        this.kitlist = new KitLists(this);
        this.freearenas = new CustomArenas(this);
        this.getCommand("smpvp").setExecutor(new setupArena());
        this.getCommand("kit").setExecutor(new openKitGui());
        this.getCommand("mojekity").setExecutor(new openMyKits());
        this.getCommand("pojedynek").setExecutor(new acceptationGUI());
        this.getCommand("pvp").setExecutor(new PvpGUI());
        this.getCommand("pojedynek").setTabCompleter(new acceptationTabCompletion());
        this.getConfig().options().copyDefaults(true);
        this.saveConfig();


        Config.setup();
        Bukkit.getPluginManager().registerEvents(new OnFightEvents(), this);
        Bukkit.getPluginManager().registerEvents(new AcceptationEvents(), this);
        Bukkit.getPluginManager().registerEvents(new KitCreationINV_Events(), this);
        Bukkit.getPluginManager().registerEvents(new MyKitsEvents(), this);
        Bukkit.getPluginManager().registerEvents(new MainGUIEvents(), this);
    }

    public void onDisable() {
    }

    public static SMPvp getInstance() {
        return plugin;
    }
}
