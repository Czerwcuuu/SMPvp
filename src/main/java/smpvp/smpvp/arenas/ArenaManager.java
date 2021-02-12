package smpvp.smpvp.arenas;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.inventory.PlayerInventory;
import smpvp.smpvp.kits.Kit;
import smpvp.smpvp.kits.Kits;
import org.bukkit.block.Sign;
import java.util.HashMap;

public class ArenaManager {
    //dostepne areny
    public static HashMap<String,Arena> arenas = new HashMap<>();
    //gracze ktorzy są na danej arenie
    public static HashMap<String,Arena> playersInArenas = new HashMap<>();
    //tabliczki aren
    public static HashMap<Arena,Sign> arenasSigns = new HashMap<>();

    //public static Player thisPlayer;

    //Tworzenie areny
    public static Arena createArena(String name,int maxPlayers,Location loc,String kit){
        Arena arena = new Arena(name,maxPlayers,loc,kit);
        arenas.put(name,arena);
        return arena;
    }

    //Dołączanie do areny
    public static boolean joinArena(Player p, String arenaName, Sign sign_){
        Arena arena = arenas.get(arenaName); //pobierz arene z mapy
        arenasSigns.put(arena,sign_); //dodaj tabliczke do listy tabliczek aren
        Sign sign = sign_;
        //thisPlayer = p; //przypisz gracza do zmiennej na której aktualnie operujemy
        if(arena.currentPlayers<arena.maxPlayers){ //Jeżeli graczy jest mniej niż maximum
            PlayerInventory inv = p.getInventory();
            Kits.getKit(arena.kitName,p.getInventory());
            playersInArenas.put(p.getName(),arena); //Dodaj gracza do listy osób na arenie
            p.teleport(arena.loc); //teleport na wybrany spawn
            p.setHealth(20); //ustawia zycie na 20
            arena.currentPlayers++; //dodaje 1 do zmiennej currentPlayers
            Bukkit.broadcastMessage("§b"+p.getName()+"§7 dołączył do §b"+arenaName+"§4 "+arena.currentPlayers+"/"+arena.maxPlayers);
            sign.setLine(2,arena.currentPlayers+"/"+arena.maxPlayers); //aktualizuje tabliczke
            sign.update();
            return true;
        }
        else{
            p.sendMessage("§4§lNie udało się dołączyć do areny! :c");
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
