package smpvp.smpvp.configs;

import smpvp.smpvp.SMPvp;
import smpvp.smpvp.arenas.ArenaManager;

public class Config {
    public static void setup(){
        SMPvp plugin = SMPvp.getInstance();
        for(int i=0; i<plugin.getConfig().getKeys(false).size(); i++){
            String name = plugin.getConfig().getString(i+".name");
            String kit = plugin.getConfig().getString(i+".kit");
            int maxPlayers = plugin.getConfig().getInt(i+".maxplayers");
            ArenaManager.createArena(name,maxPlayers);
        }
    }


}
