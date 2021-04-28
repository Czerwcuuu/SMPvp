package smpvp.smpvp.arenas;

import java.util.HashMap;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.inventory.PlayerInventory;
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

    public static boolean joinArena(Player p, String arenaName, Sign sign_) {
        Arena arena = (Arena)arenas.get(arenaName);
        if (arena.status == ArenaStatus.STARTED) {
            return false;
        } else {
            arena.status = ArenaStatus.WAITING;
            arenasSigns.put(arena, sign_);
            if (arena.currentPlayers < arena.maxPlayers) {
                PlayerInventory inv = p.getInventory();
                Kits.getKit(arena.kitName, p.getInventory());
                playersInArenas.put(p.getName(), arena);
                if (arena.spawnLocations.size() < arena.maxPlayers - 1) {
                    p.sendMessage(String.valueOf(arena.spawnLocations.size()));
                    p.sendMessage("Brak dostępnych spawnów");
                    return false;
                } else {
                    p.teleport((Location)arena.spawnLocations.get(arena.currentPlayers));
                    p.setHealth(20.0D);
                    ++arena.currentPlayers;
                    Bukkit.broadcastMessage("§b" + p.getName() + "§7 dołączył do §b" + arenaName + "§4 " + arena.currentPlayers + "/" + arena.maxPlayers);
                    sign_.setLine(2, arena.currentPlayers + "/" + arena.maxPlayers);
                    sign_.update();
                    if (arena.currentPlayers == arena.maxPlayers) {
                        arena.status = ArenaStatus.STARTED;
                    }

                    return true;
                }
            } else {
                p.sendMessage("§4§lNie udało się dołączyć do areny! :c");
                sign_.setLine(2, "PEŁNA");
                sign_.update();
                return false;
            }
        }
    }

    public static String arenaUpdate(Player p) {
        Arena arena = (Arena)playersInArenas.get(p.getName());
        if (arena.currentPlayers > 1) {
            --arena.currentPlayers;
            playersInArenas.remove(p.getName());
            return arena.arenaName;
        } else if (arena.currentPlayers == 1) {
            Sign sign = (Sign)arenasSigns.get(arena);
            sign.setLine(2, "0/" + arena.maxPlayers);
            sign.update();
            arenasSigns.remove(sign);
            arena.reset();
            return arena.arenaName;
        } else {
            return arena.arenaName;
        }
    }

    public static boolean playerIsInArena(Player p) {
        Arena arena = (Arena)playersInArenas.get(p.getName());
        return arena == null;
    }
}