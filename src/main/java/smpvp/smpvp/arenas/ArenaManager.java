package smpvp.smpvp.arenas;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.inventory.PlayerInventory;
import smpvp.smpvp.kits.Kits;

import java.util.HashMap;

public class ArenaManager {
    public static HashMap<String,Arena> arenas = new HashMap<>();
    public static HashMap<String,Arena> playersInArenas = new HashMap<>();

    public static Arena CreateArena(String name,int maxplayers){
        Arena arena = new Arena(name,maxplayers);
        arenas.put(name,arena);
        return arena;
    }

    public static void JoinArena(Player p,String arenaName){
        Arena arena = arenas.get(arenaName);
        Bukkit.broadcastMessage("graczy:"+arena.currentPlayers);
        if(arena.currentPlayers<arena.maxPlayers){
            PlayerInventory inv = p.getInventory();
            playersInArenas.put(p.getName(),arena);
            p.teleport(new Location(p.getWorld(), 101, 135, -310));
            arena.currentPlayers++;
            Kits.TestKit(inv);
            Bukkit.broadcastMessage(p.getName()+" dołączył do areny "+arenaName+" "+arena.currentPlayers+"/"+arena.maxPlayers);
        }
        else{
            Bukkit.broadcastMessage("Arena jest pełna");
        }
        //ewentualnie return arena
    }

    public static String CheckPlayerArenaAndRemove(Player loser,Player winner){
        Arena arena  = playersInArenas.get(loser.getName());

        playersInArenas.remove(loser.getName());
        playersInArenas.remove(winner.getName());
        arena.Reset();

        return arena.arenaName;
    }

    public static boolean PlayerIsInArena(Player p, String a){
        /*String playerNameInArena = playersInArenas.get(arenas.get(a));
        if(playerNameInArena.equals(p.getName())){
            Bukkit.broadcastMessage("TESTtrue");
            return true;
        }
        else{
            Bukkit.broadcastMessage("TESTfalse");
            String arenaName = playersInArenas.get(p.getName());
            Arena arena = arenas.get(arenaName);
            playersInArenas.remove(p.getName());
            arena.Reset();
            return false;
        }*/
        return true;
    }


}
