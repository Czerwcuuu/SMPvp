package smpvp.smpvp.events;

import java.util.ArrayList;
import java.util.Iterator;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.potion.PotionEffect;
import smpvp.smpvp.arenas.Arena;
import smpvp.smpvp.arenas.ArenaManager;
import smpvp.smpvp.kits.Kits;

public class GroupFight implements Listener {
    @EventHandler
    public void signClickEvent(PlayerInteractEvent event) {
        try {
            Location lobbyAllLocation = new Location(event.getPlayer().getWorld(), 113.0D, 134.0D, -309.0D);
            Location startLobbyLocation = new Location(event.getPlayer().getWorld(), 101.0D, 135.0D, -310.0D);
            Player p = event.getPlayer();
            Block b = event.getClickedBlock();
            if (b.getState() instanceof Sign) {
                event.setCancelled(true);
                PlayerInventory inv = p.getInventory();
                Sign sign = (Sign)b.getState();
                String line0 = sign.getLine(0);
                String line1 = sign.getLine(1);
                String line2 = sign.getLine(2);
                if (line0.equals("Powrót") && line1.equals("[Wcisnij]")) {
                    this.resetPlayer(p);
                    p.teleport(startLobbyLocation);
                }

                if (inv.isEmpty()) {
                    if (line0.equals("KAZDY") && line1.equals("NA KAZDEGO") && line2.equals("[WCISNIJ]")) {
                        p.teleport(lobbyAllLocation);
                    }

                    if (line0.equals("1 VS 1") && line2.equals("[WCISNIJ]")) {
                        p.teleport(lobbyAllLocation);
                    }

                    if (ArenaManager.arenas.containsKey(line1)) {
                        ArenaManager.joinArena(p, line1, sign);
                    }

                    if (line1.equals("BESTIA")) {
                        Kits.bestia(inv);
                        this.RandomTeleport(p);
                    }

                    if (line1.equals("ŁUCZNIK")) {
                        Kits.lucznik(inv);
                        this.RandomTeleport(p);
                    }

                    if (line1.equals("WOJOWNIK")) {
                        Kits.wojownik(inv);
                        this.RandomTeleport(p);
                    }

                    if (line1.equals("SAMURAJ")) {
                        Kits.samuraj(inv);
                        this.RandomTeleport(p);
                    }
                }
            }

        } catch (NullPointerException var12) {
        }
    }

    @EventHandler
    public void pde(PlayerDeathEvent e) {
        try {
            Player p = e.getEntity();
            if (p.getKiller() != null) {
                ArenaManager.arenaUpdate(p);
                Bukkit.broadcastMessage("§7Gracz §b" + p.getName() + " §7został zabity przez §b" + p.getKiller().getName() + "§4§l [" + (int)p.getKiller().getHealth() + "]");
                this.resetPlayer(p);
                if (((Arena)ArenaManager.playersInArenas.get(p.getKiller().getName())).currentPlayers < 2) {
                    this.resetPlayer(p.getKiller());
                    ArenaManager.arenaUpdate(p.getKiller());
                }
            } else {
                ArenaManager.arenaUpdate(p);
                Bukkit.broadcastMessage("§7 " + p.getName() + " §7popełnił §b samobójstwo");
                this.resetPlayer(p);
            }
        } catch (NullPointerException var3) {
        }

    }

    @EventHandler
    public void playerRespawnevent(PlayerRespawnEvent e) {
        Player p = e.getPlayer();
        this.resetPlayer(p);
    }

    @EventHandler
    public void playerLeave(PlayerQuitEvent e) {
        Player p = e.getPlayer();
        if (ArenaManager.playerIsInArena(p)) {
            this.resetPlayer(p);
        } else {
            try {
                this.resetPlayer(p);
                ArenaManager.arenaUpdate(p);
            } catch (NullPointerException var4) {
            }
        }

    }

    public void RandomTeleport(Player p) {
        int rand = (int)(Math.random() * 4.0D + 0.0D);
        ArrayList<Location> locations = new ArrayList();
        locations.add(new Location(p.getWorld(), 160.0D, 101.0D, -288.0D));
        locations.add(new Location(p.getWorld(), 213.0D, 101.0D, -240.0D));
        locations.add(new Location(p.getWorld(), 130.0D, 102.0D, -200.0D));
        locations.add(new Location(p.getWorld(), 165.0D, 102.0D, -247.0D));
        p.teleport((Location)locations.get(rand));
    }

    public void resetPlayer(Player p) {
        p.setHealth(20.0D);
        p.setFoodLevel(20);
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

    @EventHandler
    public void EntityDamageByEntityEvent(EntityDamageByEntityEvent e) {
        if (e.getEntity() instanceof Player && e.getDamager().getName().equals(e.getEntity().getName())) {
            e.setCancelled(true);
        }

    }
}