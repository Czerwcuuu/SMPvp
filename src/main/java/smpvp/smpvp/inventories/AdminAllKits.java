package smpvp.smpvp.inventories;

import smpvp.smpvp.SMPvp;

import java.util.ArrayList;
import java.util.List;

public class AdminAllKits {
    static SMPvp plugin = SMPvp.getInstance();

    public static void AddKit(String name){
        if(plugin.kitlist.getConfig().contains("name")){
            List<String> ConfigList = plugin.kitlist.getConfig().getStringList("name");
            if(ConfigList.contains(name)){
                return;
            }
            ConfigList.add(name);
            plugin.kitlist.getConfig().set("name",ConfigList);
            plugin.kitlist.saveConfig();
        }
        else{
            List<String> ConfigList = new ArrayList<String>();
            ConfigList.add(name);
            plugin.kitlist.getConfig().set("name",ConfigList);
            plugin.kitlist.saveConfig();
        }
    }
}
