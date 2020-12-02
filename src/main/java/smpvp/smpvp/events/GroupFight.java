package smpvp.smpvp.events;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionType;
import smpvp.smpvp.arenas.ArenaManager;
import smpvp.smpvp.kits.Kits;

public class GroupFight implements Listener {

    @EventHandler
    public void signClickEvent(PlayerInteractEvent event) {
        try {
            Location pvpLocation = new Location(event.getPlayer().getWorld(), 2, 90, 2); //gdzie ma teleportować po wybraniu kitu
            Location lobbyAllLocation = new Location(event.getPlayer().getWorld(), 113, 134, -309); //lokalizacja lobby kazdy na kazdego
            Location startLobbyLocation = new Location(event.getPlayer().getWorld(), 101, 135, -310); //lokalizacja spawnu
            Player p = event.getPlayer();
            Block b = event.getClickedBlock();
            if (b.getState() instanceof Sign) {
                event.setCancelled(true);
                PlayerInventory inv = p.getInventory();
                Sign sign = (Sign) b.getState();

                String line0 = sign.getLine(0);
                String line1 = sign.getLine(1);
                String line2 = sign.getLine(2);

                if(line0.equals("Powrót") && line1.equals("[Wcisnij]")){
                    resetPlayer(p);
                    p.teleport(startLobbyLocation);
                }
                if (inv.isEmpty()) {

                    if(line0.equals("KAZDY") && line1.equals("NA KAZDEGO") && line2.equals("[WCISNIJ]")){
                        p.teleport(lobbyAllLocation);
                    }
                    switch (line1) { //wybór kitów
                        case "TEST":
                            String players = ArenaManager.joinArena(p,"Arena1",pvpLocation,sign);
                            Kits.testKit(inv);
                            sign.setLine(2,players);
                            sign.update();
                            break;
                    }
                }
            }
        } catch (NullPointerException ex) {
            return;
        }
    }


    @EventHandler
    public void pde(PlayerDeathEvent e) {
        Player p = e.getEntity();
        /*if(p.getKiller()!=null)*/ ArenaManager.checkPlayerArenaAndRemove(p, p);
        Bukkit.broadcastMessage("§7Gracz §b" + p.getName() + " §7został zabity przez §b" + p.getKiller().getName());
    }
    @EventHandler
    public void playerRespawnevent(PlayerRespawnEvent e) {
        Player p = e.getPlayer();
        resetPlayer(p);
    }

    @EventHandler
    public void playerJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();

        resetPlayer(p);
    }
    public void resetPlayer(Player p){
        p.setHealth(20);
        p.setFoodLevel(20);
        p.getInventory().clear();
        for (PotionEffect t : p.getActivePotionEffects()) {
            p.removePotionEffect(t.getType());
        }
        Location loc = p.getWorld().getSpawnLocation();
        loc.setYaw(180);
        p.teleport(loc);

    }

    //@EventHandler
    //public void Blood(EntityDamageByEntityEvent e){
    //  if (e.isCancelled())
    //    return;
    //if (e.getEntity() instanceof Player){
    //  World world = e.getEntity().getWorld();
    //world.spawnParticle(Particle.BLOCK_CRACK, e.getEntity().getLocation().add(0.0D, 1.0D, 0.0D), 20, new MaterialData(Material.REDSTONE_BLOCK));
    // }
    //}

}
