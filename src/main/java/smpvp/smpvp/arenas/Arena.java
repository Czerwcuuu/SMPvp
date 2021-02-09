package smpvp.smpvp.arenas;


import org.bukkit.entity.Player;
import smpvp.smpvp.kits.Kits;

import java.util.HashMap;

public class Arena {
    public int currentPlayers;
    public String arenaName;
    public int maxPlayers;
    private static HashMap<String,String> players = new HashMap<>();

    public Arena(String Name, int maxplayers){
        this.maxPlayers = maxplayers;
        this.arenaName = Name;
    }

    public void reset(){
        this.currentPlayers = 0;
        players.clear();
    }



}
