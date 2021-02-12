package smpvp.smpvp.arenas;


import org.bukkit.Location;
import org.bukkit.entity.Player;
import smpvp.smpvp.kits.Kit;
import smpvp.smpvp.kits.Kits;

import java.util.HashMap;
import java.util.List;

public class Arena {
    public int ID;
    public int currentPlayers;
    public String arenaName;
    public int maxPlayers;
    public List<Location> spawnLocations;
    public String kitName;
    private static HashMap<String,String> players = new HashMap<>();

    public Arena(int ID,String Name, int maxplayers, List<Location> loc, String kit){
        this.ID = ID;
        this.maxPlayers = maxplayers;
        this.arenaName = Name;
        this.spawnLocations = loc;
        this.kitName = kit;
    }

    public void reset(){
        this.currentPlayers = 0;
        players.clear();
    }



}
