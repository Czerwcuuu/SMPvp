package smpvp.smpvp.inventories;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import smpvp.smpvp.SMPvp;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AllKits {
     static SMPvp plugin = SMPvp.getInstance();

    public static void AddKit(String name,String PlayerName){
        if(plugin.kitlist.getConfig().contains(PlayerName+".name")){
            List<String> ConfigList = plugin.kitlist.getConfig().getStringList(PlayerName+".name");
            ConfigList.add(PlayerName+name);
            plugin.kitlist.getConfig().set(PlayerName+".name",ConfigList);
            plugin.kitlist.saveConfig();
        }
        else{
            List<String> ConfigList = new ArrayList<String>();
            ConfigList.add(PlayerName+name);
            plugin.kitlist.getConfig().set(PlayerName+".name",ConfigList);
            plugin.kitlist.saveConfig();
        }
    }
}
