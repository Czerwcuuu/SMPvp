package smpvp.smpvp.configs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import smpvp.smpvp.SMPvp;
import smpvp.smpvp.arenas.ArenaManager;

public class Config {
    public static void setup() {
        SMPvp plugin = SMPvp.getInstance();

        for(int i = 0; i < plugin.getConfig().getKeys(false).size(); ++i) {
            String name = plugin.getConfig().getString(i + ".name");
            Bukkit.getLogger().info(name);
            String kit = plugin.getConfig().getString(i + ".kit");
            Bukkit.getLogger().info(kit);
            World world = Bukkit.getWorld("world");
            List<Location> allSpawnLocations = new ArrayList();
            List<String> locationList = plugin.getConfig().getStringList(i + ".location");
            Iterator var8 = locationList.iterator();

            while(var8.hasNext()) {
                String s = (String)var8.next();
                String x = s.split("\\.")[0];
                String y = s.split("\\.")[1];
                String z = s.split("\\.")[2];
                allSpawnLocations.add(new Location(world, (double)Integer.parseInt(x), (double)Integer.parseInt(y), (double)Integer.parseInt(z)));
                Bukkit.getLogger().info(x + " " + y + " " + z);
            }

            int maxPlayers = plugin.getConfig().getInt(i + ".maxplayers");
            Bukkit.getLogger().info(world.toString());
            Bukkit.getLogger().info(String.valueOf(maxPlayers));
            ArenaManager.createArena(i, name, maxPlayers, allSpawnLocations, kit);
        }

    }
}