package smpvp.smpvp.configs;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import smpvp.smpvp.SMPvp;
import smpvp.smpvp.arenas.ArenaManager;

import java.util.List;

public class Config {
    public static void setup(){
        SMPvp plugin = SMPvp.getInstance();
        for(int i=0; i<plugin.getConfig().getKeys(false).size(); i++){

                String name = plugin.getConfig().getString(i + ".name");
                Bukkit.getLogger().info(name);
                String kit = plugin.getConfig().getString(i + ".kit");
                Bukkit.getLogger().info(kit);
                List<String> locationList = plugin.getConfig().getStringList(i + ".location");
                Bukkit.getLogger().info(locationList.get(0)+" "+locationList.get(1)+" "+locationList.get(2));
                int maxPlayers = plugin.getConfig().getInt(i + ".maxplayers");
                World world = Bukkit.getWorld("world");
                Bukkit.getLogger().info(world.toString());
                Bukkit.getLogger().info(String.valueOf(maxPlayers));
                ArenaManager.createArena(name, maxPlayers,
                        new Location(
                                world,
                                Integer.parseInt(locationList.get(0)),
                                Integer.parseInt(locationList.get(1)),
                                Integer.parseInt(locationList.get(2))
                        ), kit);
            }
        }
    }



