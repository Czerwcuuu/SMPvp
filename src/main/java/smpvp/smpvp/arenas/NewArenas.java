package smpvp.smpvp.arenas;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import smpvp.smpvp.SMPvp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class NewArenas {
    static SMPvp  plugin = SMPvp.getInstance();
    public static HashMap<Player,Arena> customArenas = new HashMap<>();

    public static void CheckArenas(String arenaName,Player p,Player t){
        for(int i = 0; i < plugin.freearenas.getConfig().getKeys(false).size(); i++) {
            Bukkit.broadcastMessage("Sprawdzam arene:"+i);
            int currentPlayer = plugin.freearenas.getConfig().getInt(i + ".currentplayer");
            Bukkit.broadcastMessage("Aktualnie graczy na arenie"+i+":"+currentPlayer);
            float yaw = (float)plugin.freearenas.getConfig().getLong(i + ".look");
            World world = Bukkit.getWorld("world");
            List<Location> allSpawnLocations = new ArrayList();
            List<String> locationList = plugin.freearenas.getConfig().getStringList(i + ".location");

            for(String s: locationList) {

                String x = s.split("\\.")[0];
                String y = s.split("\\.")[1];
                String z = s.split("\\.")[2];
                allSpawnLocations.add(new Location(world, (double)Integer.parseInt(x), (double)Integer.parseInt(y), (double)Integer.parseInt(z), yaw, 0.0F));
                yaw = -yaw;
                Bukkit.getLogger().info("NOWE"+x + " " + y + " " + z);
            }
            int maxPlayers = plugin.freearenas.getConfig().getInt(i + ".maxplayers");
            if(currentPlayer<maxPlayers){
                    Arena arena = ArenaManager.createArena(i,arenaName,currentPlayer,maxPlayers,allSpawnLocations,p,t);
                    plugin.freearenas.getConfig().set(i + ".currentplayer",2);
                    Bukkit.broadcastMessage("Ustawiam aktualnych graczy na 2 dla areny:"+i);
                    plugin.freearenas.saveConfig();
                    customArenas.put(p,arena);
                    customArenas.put(t,arena);
                    return;
            }
            else{
                Bukkit.broadcastMessage("Arena jest zajęta");
            }


        }

    }

    public static Arena playerIsInCustomArena(Player p) {
        if((Arena)customArenas.get(p)!= null)
        {
            Bukkit.broadcastMessage(customArenas.get(p).arenaName);
            return customArenas.get(p);
        }
        return null;



    }
}
