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
    public static HashMap<Arena,Sign> arenasSigns = new HashMap<>();

    public static Arena createArena(String name,int maxplayers){
        Arena arena = new Arena(name,maxplayers);
        arenas.put(name,arena);
        return arena;
    }

    public static boolean joinArena(Player p, String arenaName, Location loc, Sign sign_){
        Arena arena = arenas.get(arenaName);
        arenasSigns.put(arena,sign_);
        Sign sign = sign_;
        if(arena.currentPlayers<arena.maxPlayers){
            PlayerInventory inv = p.getInventory();
            playersInArenas.put(p.getName(),arena);
            p.teleport(loc);
            arena.currentPlayers++;
            Bukkit.broadcastMessage("§b"+p.getName()+"§7 dołączył do §b"+arenaName+"§4 "+arena.currentPlayers+"/"+arena.maxPlayers);
            sign.setLine(2,arena.currentPlayers+"/"+arena.maxPlayers);
            sign.update();
            return true;
        }
        else{
            p.sendMessage("§4&lNie udało się dołączyć do areny! :c");
            sign.setLine(2,"PEŁNA");
            sign.update();
            return false;
            //return "PEŁNA";
        }
    }

    public static String checkPlayerArenaAndRemove(Player loser,Player winner){//Zwraca arene gracza  i czyści jego dane.
        Arena arena  = playersInArenas.get(loser.getName());

        Sign sign = arenasSigns.get(arena);
        sign.setLine(2,"0/"+arena.maxPlayers);
        sign.update();
        arenasSigns.remove(sign);
        playersInArenas.remove(loser.getName());
        playersInArenas.remove(winner.getName());
        arena.reset();

        return arena.arenaName;
    }

    public static boolean playerIsInArena(Player p){
        Arena arena = playersInArenas.get(p.getName());
        if(arena==null){
            return true;//jezeli arena pusta zwraca true
        }
        else{
            return false;
        }
    }


}
