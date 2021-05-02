package smpvp.smpvp;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import smpvp.smpvp.commands.*;
import smpvp.smpvp.configs.Config;
import smpvp.smpvp.data.CustomArenas;
import smpvp.smpvp.data.DataManager;
import smpvp.smpvp.data.KitLists;
import smpvp.smpvp.events.FightEventsGUI;
import smpvp.smpvp.events.GroupFight;
import smpvp.smpvp.events.InventoryEvents;
import smpvp.smpvp.events.MyKitsEvents;

public final class SMPvp extends JavaPlugin implements Listener {
    private static SMPvp plugin;
    public DataManager data;
    public KitLists kitlist;
    public CustomArenas freearenas;

    /*
    TODO:
    - sprawdz czy gracz jest na arenie podczas wysylania zaproszenia
    - mozliwosc ignorowania zaproszen
    - mozliwosc wybrania areny pod wybraniu kitu
    po zaakcpetowaniu areny:
        - znajdz dostepna arene z listy
        - teleportuje na spawny na arenie
        - dodaj do listy graczy na arenach
        - walka
        - po zakonczeniu usun z listy graczy na arenach
        - ustaw arene na dostepna




     */

    public void onEnable() {
        plugin = this;
        this.data = new DataManager(this);
        this.kitlist = new KitLists(this);
        this.freearenas = new CustomArenas(this);
        this.getCommand("pvp").setExecutor(new setupArena());
        this.getCommand("kit").setExecutor(new openKitGui());
        this.getCommand("mojekity").setExecutor(new openMyKits());
        this.getCommand("pojedynek").setExecutor(new fight());
        this.getCommand("pojedynek").setTabCompleter(new fightTabCompletion());
        this.getConfig().options().copyDefaults(true);
        this.saveConfig();


        Config.setup();
        Bukkit.getPluginManager().registerEvents(new GroupFight(), this);
        Bukkit.getPluginManager().registerEvents(new FightEventsGUI(), this);
        Bukkit.getPluginManager().registerEvents(new InventoryEvents(), this);
        Bukkit.getPluginManager().registerEvents(new MyKitsEvents(), this);
    }

    public void onDisable() {
    }

    public static SMPvp getInstance() {
        return plugin;
    }
}
