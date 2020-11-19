package smpvp.smpvp;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class SMPvp extends JavaPlugin implements Listener {


    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getPluginManager().registerEvents(new Events(), this);



    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

}
