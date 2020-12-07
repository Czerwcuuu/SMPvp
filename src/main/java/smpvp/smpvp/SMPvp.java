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
        ArenaManager.createArena("areny Łowcy",2);
        ArenaManager.createArena("areny Szlachcica",2);
        ArenaManager.createArena("areny Paladynów",2);
        ArenaManager.createArena("areny Litwinów",2);
        //ArenaManager.createArena("areny Posejdona",2);
        ArenaManager.createArena("areny Egzorcysty",2);
        ArenaManager.createArena("areny Tytanów",2);
        ArenaManager.createArena("areny Samuraja",2);
        ArenaManager.createArena("areny Drwala",2);
        ArenaManager.createArena("areny Bestii",2);
        ArenaManager.createArena("areny Wojowników",2);


    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

}
