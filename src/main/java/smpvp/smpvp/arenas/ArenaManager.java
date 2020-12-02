package smpvp.smpvp.arenas;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.inventory.PlayerInventory;
import smpvp.smpvp.kits.Kits;
import org.bukkit.block.Sign;
import java.util.HashMap;

public class ArenaManager {
    public static HashMap<String,Arena> arenas = new HashMap<>();
    public static HashMap<String,Arena> playersInArenas = new HashMap<>();

    public static Arena createArena(String name,int maxplayers){
        Arena arena = new Arena(name,maxplayers);
        arenas.put(name,arena);
        return arena;
    }

    public static String joinArena(Player p, String arenaName, Location loc, Sign sign_){
        Arena arena = arenas.get(arenaName);
        Sign sign = sign_;
        Bukkit.broadcastMessage("graczy:"+arena.currentPlayers);
        if(arena.currentPlayers<arena.maxPlayers){
            PlayerInventory inv = p.getInventory();
            playersInArenas.put(p.getName(),arena);
            p.teleport(loc);
            arena.currentPlayers++;
            Bukkit.broadcastMessage(p.getName()+" dołączył do areny "+arenaName+" "+arena.currentPlayers+"/"+arena.maxPlayers);
            return arena.currentPlayers+"/"+arena.maxPlayers;
        }
        else{
            Bukkit.broadcastMessage("Nie udało się dołączyć do areny!");
            return "BLAD";
        }
    }

    public static String checkPlayerArenaAndRemove(Player loser,Player winner){
        Arena arena  = playersInArenas.get(loser.getName());

        playersInArenas.remove(loser.getName());
        playersInArenas.remove(winner.getName());
        arena.reset();

        return arena.arenaName;
    }

    /*public static boolean playerIsInArena(Player p, String a){
        Arena arena = playersInArenas.get(p.getName());
        if(arena.equals(arenas.get(a))){
            Bukkit.broadcastMessage("TESTtrue");
            return true;
        }
        else{
            Bukkit.broadcastMessage("TESTfalse");
            return false;
        }
    }*/


}
