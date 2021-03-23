package smpvp.smpvp.arenas;

import java.util.HashMap;
import java.util.List;
import org.bukkit.Location;

public class Arena {
    public int ID;
    public int currentPlayers;
    public String arenaName;
    public int maxPlayers;
    public List<Location> spawnLocations;
    public String kitName;
    public ArenaStatus status;
    private static HashMap<String, String> players = new HashMap();

    public Arena(int ID, String Name, int maxplayers, List<Location> loc, String kit) {
        this.ID = ID;
        this.maxPlayers = maxplayers;
        this.arenaName = Name;
        this.spawnLocations = loc;
        this.kitName = kit;
        this.status = ArenaStatus.NOTSTARTED;
    }

    public void reset() {
        this.currentPlayers = 0;
        players.clear();
        this.status = ArenaStatus.NOTSTARTED;
    }
}