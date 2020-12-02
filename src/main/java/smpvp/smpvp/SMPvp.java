package smpvp.smpvp;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import smpvp.smpvp.arenas.ArenaManager;
import smpvp.smpvp.events.GroupFight;

public final class SMPvp extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getPluginManager().registerEvents(new GroupFight(), this);
        ArenaManager.CreateArena("Arena1",2);


    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

}
