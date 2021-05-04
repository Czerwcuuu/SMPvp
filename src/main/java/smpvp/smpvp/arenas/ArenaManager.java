package smpvp.smpvp.arenas;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.potion.PotionEffect;
import smpvp.smpvp.kits.Kits;

public class ArenaManager {
    public static HashMap<String, Arena> arenas = new HashMap();
    public static HashMap<String, Arena> playersInArenas = new HashMap();
    public static HashMap<Arena, Sign> arenasSigns = new HashMap();

    public static Arena createArena(int ID, String name, int maxPlayers, List<Location> loc, String kit) {
        Arena arena = new Arena(ID, name, maxPlayers, loc, kit);
        arenas.put(name, arena);
        return arena;
    }

    public static Arena createArena(int ID, String name,int currentPlayers, int maxPlayers, List<Location> loc,Player p, Player t) {
        Arena arena = new Arena(ID, name,currentPlayers,maxPlayers,loc, p, t);
        arenas.put(name, arena);
        return arena;
    }


    public static boolean joinArena(Player p, String arenaName, Sign sign_){
        Arena arena = (Arena)arenas.get(arenaName);
        if(arena.status == ArenaStatus.STARTED){
            p.sendMessage("§4§lArena jest już pełna!");
            return false;
        }
        else{
            if(arena.players.size() == 0){
                //Bukkit.broadcastMessage("WARUNEK1:");
                //Bukkit.broadcastMessage("Liczba graczy na arenie:"+arena.players.size());
                arena.status = ArenaStatus.WAITING;
                arenasSigns.put(arena,sign_);
                arena.players.add(p.getName());
                ++arena.currentPlayers;
                //Bukkit.broadcastMessage(String.valueOf(arena.currentPlayers));

                //player conf
                Kits.getKit(arena.kitName, p.getInventory());
                playersInArenas.put(p.getName(), arena);
                if (arena.spawnLocations.size() < arena.maxPlayers -1) {
                    p.sendMessage(String.valueOf(arena.spawnLocations.size()));
                    p.sendMessage("Brak dostępnych spawnów");
                    return false;}
                 else {
                    p.teleport((Location)arena.spawnLocations.get(arena.currentPlayers-1));
                    p.setHealth(20.0D);
                    /*Bukkit.broadcastMessage("Na arenie są:");
                    for (int i=0; i<arena.players.size(); i++){
                        Bukkit.broadcastMessage(arena.players.get(i));
                    }*/
                    Bukkit.broadcastMessage("§b" + p.getName() + "§7 dołączył do §b" + arenaName + "§4 " + arena.players.size() + "/" + arena.maxPlayers);
                    sign_.setLine(2, arena.players.size() + "/" + arena.maxPlayers);
                    sign_.update();

                }
            }
            else if(arena.players.size() < arena.maxPlayers){
                //Bukkit.broadcastMessage("WARUNEK2:");
                //Bukkit.broadcastMessage("Liczba graczy na arenie:"+arena.players.size());
                Kits.getKit(arena.kitName, p.getInventory());
                arena.players.add(p.getName());
                playersInArenas.put(p.getName(), arena);

                ++arena.currentPlayers;
                //Bukkit.broadcastMessage(String.valueOf(arena.currentPlayers));
                if (arena.spawnLocations.size() < arena.maxPlayers - 1) {
                    p.sendMessage(String.valueOf(arena.spawnLocations.size()));
                    p.sendMessage("Brak dostępnych spawnów");
                    return false;}
                else {
                    p.teleport((Location)arena.spawnLocations.get(arena.currentPlayers-1));
                    p.setHealth(20.0D);
                    /*Bukkit.broadcastMessage("Na arenie są:");
                    for (int i=0; i<arena.players.size(); i++){
                        Bukkit.broadcastMessage(arena.players.get(i));
                    }*/
                    Bukkit.broadcastMessage("§b" + p.getName() + "§7 dołączył do §b" + arenaName + "§4 " + arena.players.size() + "/" + arena.maxPlayers);
                    sign_.setLine(2, arena.players.size() + "/" + arena.maxPlayers);
                    sign_.update();

                if (arena.currentPlayers == arena.maxPlayers) {
                    arena.status = ArenaStatus.STARTED;
                }
            }
    }return true;
        }
            }

    public static String arenaUpdate(Player p) {
        Arena arena = (Arena)playersInArenas.get(p.getName());
        if (arena.players.size() > 0){
            for (int i=0; i<arena.players.size(); i++){
                //Bukkit.broadcastMessage("Restartuje itemki gracza:"+arena.players.get(i));
                try {
                    resetPlayer(Bukkit.getPlayer(arena.players.get(i)));
                    Bukkit.broadcastMessage(Bukkit.getPlayer(arena.players.get(i)).getName());
                    playersInArenas.remove(Bukkit.getPlayer(arena.players.get(i)).getName());
                }
                catch(NullPointerException err){
                    //Bukkit.broadcastMessage("Nie wykryto gracza");
                }

                //resetPlayer(Bukkit.getPlayer(arena.players.get(i)));
            }
            arena.reset();
            //Bukkit.broadcastMessage("Powinno ustawic 0 dla areny"+arena.arenaName);
            Sign sign = (Sign)arenasSigns.get(arena);
            sign.setLine(2, arena.currentPlayers + "/" + arena.maxPlayers);
            sign.update();
            return arena.arenaName;
        }
        return arena.arenaName;
    }

    public static String customArenaUpdate(Player p) {
        Arena arena = NewArenas.customArenas.get(p);
        Bukkit.broadcastMessage("Restartuje customową arene");
        if (arena.players.size() > 0){
            for (int i=0; i<arena.players.size(); i++){
                //Bukkit.broadcastMessage("Restartuje itemki gracza:"+arena.players.get(i));
                try {
                    resetPlayer(Bukkit.getPlayer(arena.players.get(i)));
                    Bukkit.broadcastMessage(Bukkit.getPlayer(arena.players.get(i)).getName());
                    NewArenas.customArenas.remove(Bukkit.getPlayer(arena.players.get(i)),arena);
                }
                catch(NullPointerException err){
                    //Bukkit.broadcastMessage("Nie wykryto gracza");
                }

                //resetPlayer(Bukkit.getPlayer(arena.players.get(i)));
            }
            arena.reset();
            //Bukkit.broadcastMessage("Powinno ustawic 0 dla areny"+arena.arenaName);
            return arena.arenaName;
        }
        return arena.arenaName;
    }

    public static void resetPlayer(Player p) {
        p.setHealth(20.0D);
        p.setFoodLevel(20);
        //Bukkit.broadcastMessage(p.getName()+"został zabity");
        p.getInventory().clear();
        Iterator var2 = p.getActivePotionEffects().iterator();

        while(var2.hasNext()) {
            PotionEffect t = (PotionEffect)var2.next();
            p.removePotionEffect(t.getType());
        }

        Location loc = p.getWorld().getSpawnLocation();
        loc.setYaw(180.0F);
        p.teleport(loc);
    }


    public static boolean playerIsInArena(Player p) {
        Bukkit.broadcastMessage("ZWYKLA:");
        for (Map.Entry me : playersInArenas.entrySet()) {
            Bukkit.broadcastMessage("Key: "+me.getKey() + " & Value: " + me.getValue());
        }

        if(playersInArenas.get(p.getName())!= null)
        {
            return true;
        }
        else return false;



    }
}