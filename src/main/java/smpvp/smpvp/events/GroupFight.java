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
import smpvp.smpvp.arenas.ArenaManager;
import smpvp.smpvp.kits.Kits;

import java.util.ArrayList;

public class GroupFight implements Listener {

    @EventHandler
    public void signClickEvent(PlayerInteractEvent event) {
        try {
            Location pvpLocation = new Location(event.getPlayer().getWorld(), 2, 90, 2); //gdzie ma teleportować po wybraniu kitu
            Location lobbyAllLocation = new Location(event.getPlayer().getWorld(), 113, 134, -309);
            Location oneVerOneLocation = new Location(event.getPlayer().getWorld(), 113, 134, -309);//lokalizacja lobby kazdy na kazdego
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
                    switch (line1) { //wybór kitów
                        /*case "DRWAL 1v1":
                            Location location = new Location(event.getPlayer().getWorld(), 24, 101, -312);
                            boolean joined = ArenaManager.joinArena(p,"areny Drwala",location,sign);
                            if(joined)Kits.drwal(inv);
                            break;
                        case "LUCZNIK 1v1":
                            location = new Location(event.getPlayer().getWorld(), 25, 101, -256);
                            joined = ArenaManager.joinArena(p,"areny Lucznika",location,sign);
                            if(joined)Kits.lucznik(inv);
                            break;
                        case "BESTIA 1v1":
                            location = new Location(event.getPlayer().getWorld(), 25, 101, -197);
                            joined = ArenaManager.joinArena(p,"areny Bestii",location,sign);
                            if(joined)Kits.bestia(inv);
                            break;
                        case "MAG 1v1":
                            location = new Location(event.getPlayer().getWorld(), 25, 101, -141);
                            joined = ArenaManager.joinArena(p,"areny Magów",location,sign);
                            if(joined)Kits.mag(inv);
                            break;
                        case "POSEJDON 1v1":
                            location = new Location(event.getPlayer().getWorld(), -34, 101, -256);
                            joined = ArenaManager.joinArena(p,"areny Posejdona",location,sign);
                            if(joined)Kits.posejdon(inv);
                            break;
                        case "WOJOWNIK 1v1":
                            location = new Location(event.getPlayer().getWorld(), -34, 101, -197);
                            joined = ArenaManager.joinArena(p,"areny Wojownika",location,sign);
                            if(joined)Kits.wojownik(inv);
                            break;
                        case "SAMURAJ 1v1":
                            location = new Location(event.getPlayer().getWorld(), -34, 101, -141);
                            joined = ArenaManager.joinArena(p,"areny Samuraja",location,sign);
                            if(joined)Kits.samuraj(inv);
                            break;
                        case "ZNIWIARZ 1v1":
                            location = new Location(event.getPlayer().getWorld(), -34, 101, -256);
                            joined = ArenaManager.joinArena(p,"areny Zniwiarza",location,sign);
                            if(joined)Kits.zniwiarz(inv);
                            break;*/
                        case "ŁOWCA 1v1":
                            Location location = new Location(event.getPlayer().getWorld(), 24, 101, -312);
                            boolean joined = ArenaManager.joinArena(p,"areny Łowcy",location,sign);
                            if(joined)Kits.lowca(inv);
                            break;
                        case "SZLACHCIC 1v1":
                            location = new Location(event.getPlayer().getWorld(), 25, 101, -256);
                            joined = ArenaManager.joinArena(p,"areny Szlachcica",location,sign);
                            if(joined)Kits.szlachic(inv);
                            break;
                        case "PALADYN 1v1":
                            location = new Location(event.getPlayer().getWorld(), 25, 101, -197);
                            joined = ArenaManager.joinArena(p,"areny Paladynów",location,sign);
                            if(joined)Kits.paladyn(inv);
                            break;
                        case "LITWIN 1v1":
                            location = new Location(event.getPlayer().getWorld(), 25, 101, -141);
                            joined = ArenaManager.joinArena(p,"areny Litwinów",location,sign);
                            if(joined)Kits.litwin(inv);
                            break;
                        case "EGZOR 1v1":
                            location = new Location(event.getPlayer().getWorld(), -34, 101, -256);
                            joined = ArenaManager.joinArena(p,"areny Egzorcysty",location,sign);
                            if(joined)Kits.egzorcysta(inv);
                            break;
                        case "TYTAN 1v1":
                            location = new Location(event.getPlayer().getWorld(), -34, 101, -197);
                            joined = ArenaManager.joinArena(p,"areny Tytanów",location,sign);
                            if(joined)Kits.tytan(inv);
                            break;
                        case "SAMURAJ 1v1":
                            location = new Location(event.getPlayer().getWorld(), -34, 101, -141);
                            joined = ArenaManager.joinArena(p,"areny Samuraja",location,sign);
                            if(joined)Kits.samuraj(inv);
                            break;
                        case "DRWAL 1v1":
                            location = new Location(event.getPlayer().getWorld(), -91, 101, -312);
                            joined = ArenaManager.joinArena(p,"areny Drwala",location,sign);
                            if(joined)Kits.drwal(inv);
                            break;
                        case "BESTIA 1v1":
                            location = new Location(event.getPlayer().getWorld(), -91, 101, -256);
                            joined = ArenaManager.joinArena(p,"areny Bestii",location,sign);
                            if(joined)Kits.bestia(inv);
                            break;
                        case "WOJOWNIK 1v1":
                            location = new Location(event.getPlayer().getWorld(), -91, 101, -141);
                            joined = ArenaManager.joinArena(p,"areny Wojowników",location,sign);
                            if(joined)Kits.wojownik(inv);
                            break;
                        case "BESTIA":
                            Kits.bestia(inv);
                            RandomTeleport(p);
                            break;
                        case "ŁUCZNIK":
                            Kits.lucznik(inv);
                            RandomTeleport(p);
                            break;
                        case "DRWAL":
                            Kits.drwal(inv);
                            RandomTeleport(p);

                            break;
                        case "MAG":
                            Kits.mag(inv);
                            RandomTeleport(p);

                            break;
                        /*case "POSEJDON":
                            Kits.posejdon(inv);
                            RandomTeleport(p);

                            break;*/
                        case "WOJOWNIK":
                            Kits.wojownik(inv);
                            RandomTeleport(p);
                            break;
                        case "SAMURAJ":
                            Kits.samuraj(inv);
                            RandomTeleport(p);
                            break;
                        case "ZNIWIARZ":
                            Kits.zniwiarz(inv);
                            RandomTeleport(p);
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

            }
        }
        resetPlayer(p.getKiller());
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
