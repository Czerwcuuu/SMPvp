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
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionType;
import smpvp.smpvp.arenas.Arena;
import smpvp.smpvp.arenas.ArenaManager;
import smpvp.smpvp.kits.Kits;

import java.util.ArrayList;

public class GroupFight implements Listener {

    @EventHandler
    public void signClickEvent(PlayerInteractEvent event) {
        try {

            Location lobbyAllLocation = new Location(event.getPlayer().getWorld(), 113, 134, -309);
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
                    if(line0.equals("1 VS 1") && line2.equals("[WCISNIJ]")){
                        p.teleport(lobbyAllLocation);
                    }
                    if (ArenaManager.arenas.containsKey(line1)){ //wybór kitów
                         boolean joined = ArenaManager.joinArena(p,line1,sign);
                    }
                    if (line1.equals("BESTIA")){
                        Kits.bestia(inv);
                        RandomTeleport(p);
                    }
                    if (line1.equals("ŁUCZNIK")){
                        Kits.lucznik(inv);
                        RandomTeleport(p);
                    }
                    if (line1.equals("WOJOWNIK")){
                        Kits.wojownik(inv);
                        RandomTeleport(p);
                    }
                    if (line1.equals("SAMURAJ")){
                        Kits.samuraj(inv);
                        RandomTeleport(p);
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
        if(p.getKiller()!=null) {
            try{
                ArenaManager.checkPlayerArenaAndRemove(p, p.getKiller());
            }
            catch(NullPointerException ex){

            }
        }
        else{
            try{
                ArenaManager.checkPlayerArenaAndRemove(p, p);
            }
            catch(NullPointerException ex){
                Bukkit.broadcastMessage("§7 "+p.getName() + " §7popełnił §b samobójstwo");
            }
        }
        Bukkit.broadcastMessage("§7Gracz §b" + p.getName() + " §7został zabity przez §b" + p.getKiller().getName() + "§4§l ["+(int)p.getKiller().getHealth()+"]");
        resetPlayer(p.getKiller());

    }
    @EventHandler
    public void playerRespawnevent(PlayerRespawnEvent e) {
        Player p = e.getPlayer();
        resetPlayer(p);
    }

    @EventHandler
    public void playerJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        if(ArenaManager.playerIsInArena(p)){
            resetPlayer(p);
        }
        else{
            try{
                resetPlayer(p);
                ArenaManager.checkPlayerArenaAndRemove(p,p);
            }
            catch(NullPointerException ex){};
        }
    }
    @EventHandler
    public void playerLeave(PlayerQuitEvent e) {
        Player p = e.getPlayer();
        if(ArenaManager.playerIsInArena(p)){
            resetPlayer(p);
        }
        else{
            try{
                resetPlayer(p);
                ArenaManager.checkPlayerArenaAndRemove(p,p);
            }
            catch(NullPointerException ex){};
        }

    }
    public void RandomTeleport(Player p){
        int rand =  (int) (Math.random() * (3 - 0 + 1) + 0);
        ArrayList<Location> locations = new ArrayList<>();
        locations.add(new Location(p.getWorld(), 160, 101, -288));//lokalizacja 0
        locations.add(new Location(p.getWorld(), 213, 101, -240));//lokalizacja 1
        locations.add(new Location(p.getWorld(), 130, 102, -200));//lokalizacja 2
        locations.add(new Location(p.getWorld(), 165, 102, -247));//lokalizacja 3

        p.teleport(locations.get(rand));
        //gdzie ma teleportować po wybraniu kitu
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
    @EventHandler
    public void EntityDamageByEntityEvent(EntityDamageByEntityEvent e) {
        if(e.getEntity() instanceof Player){
            if(e.getDamager().getName().equals(e.getEntity().getName())){
                e.setCancelled(true);
            }
        }
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
