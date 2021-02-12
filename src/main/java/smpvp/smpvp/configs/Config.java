package smpvp.smpvp.configs;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import smpvp.smpvp.SMPvp;
import smpvp.smpvp.arenas.ArenaManager;

import java.util.ArrayList;
import java.util.List;

public class Config {
    public static void setup(){
        SMPvp plugin = SMPvp.getInstance();
        for(int i=0; i<plugin.getConfig().getKeys(false).size(); i++){
                int ID = i;
                String name = plugin.getConfig().getString(i + ".name");
                Bukkit.getLogger().info(name);
                String kit = plugin.getConfig().getString(i + ".kit");
                Bukkit.getLogger().info(kit);
                World world = Bukkit.getWorld("world");
                List<Location> allSpawnLocations = new ArrayList<Location>();
                List<String> locationList = plugin.getConfig().getStringList(i + ".location");
                for(String s:locationList){
                    String x = s.split("\\.")[0];
                    String y = s.split("\\.")[1];
                    String z = s.split("\\.")[2];

                    allSpawnLocations.add(new Location(
                            world,
                            Integer.parseInt(x),
                            Integer.parseInt(y),
                            Integer.parseInt(z)
                    ));
                    Bukkit.getLogger().info(x+" "+y+" "+z);
                }

                int maxPlayers = plugin.getConfig().getInt(i + ".maxplayers");

                Bukkit.getLogger().info(world.toString());
                Bukkit.getLogger().info(String.valueOf(maxPlayers));
                ArenaManager.createArena(ID,name, maxPlayers,
                        allSpawnLocations, kit);
            }
        }
    }



