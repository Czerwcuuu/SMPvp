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
        ArenaManager.createArena("areny Drwala",2);
        ArenaManager.createArena("areny Lucznika",2);
        ArenaManager.createArena("areny Bestii",2);
        ArenaManager.createArena("areny Magów",2);
        //ArenaManager.createArena("areny Posejdona",2);
        ArenaManager.createArena("areny Wojownika",2);
        ArenaManager.createArena("areny Samuraja",2);
        ArenaManager.createArena("areny Zniwiarza",2);


    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

}
