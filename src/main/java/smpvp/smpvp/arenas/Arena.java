package smpvp.smpvp.arenas;


import org.bukkit.Location;
import org.bukkit.entity.Player;
import smpvp.smpvp.kits.Kit;
import smpvp.smpvp.kits.Kits;

import java.util.HashMap;

public class Arena {
    public int currentPlayers;
    public String arenaName;
    public int maxPlayers;
    public Location loc;
    public String kitName;
    private static HashMap<String,String> players = new HashMap<>();

    public Arena(String Name, int maxplayers, Location loc, String kit){
        this.maxPlayers = maxplayers;
        this.arenaName = Name;
        this.loc = loc;
        this.kitName = kit;
    }

    public void reset(){
        this.currentPlayers = 0;
        players.clear();
    }



}
