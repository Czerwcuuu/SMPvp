package smpvp.smpvp;

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

import java.util.ArrayList;

public class Events implements Listener {

    @EventHandler
    public void SignClickEvent(PlayerInteractEvent event) {
        try {
            Location lobby_all_location = new Location(event.getPlayer().getWorld(), 113, 134, -309); //lokalizacja lobby kazdy na kazdego
            Location start_lobby_location = new Location(event.getPlayer().getWorld(), 101, 135, -310); //lokalizacja spawnu
            Player p = event.getPlayer();
            Block b = event.getClickedBlock();
            if (b.getState() instanceof Sign) {
                event.setCancelled(true);
                PlayerInventory inv = p.getInventory();
                Sign sign = (Sign) b.getState();
                String line0 = sign.getLine(0);
                String line1 = sign.getLine(1);
                String line2 = sign.getLine(2);
                String line3 = sign.getLine(3);
                if(line0.equals("Powrót") && line1.equals("[Wcisnij]")){
                    resetplayer(p);
                    p.teleport(start_lobby_location);
                }

                if (inv.isEmpty()) {

                    if(line0.equals("KAZDY") && line1.equals("NA KAZDEGO") && line2.equals("[WCISNIJ]")){
                        p.teleport(lobby_all_location);
                    }


                    switch (line1) { //wybór kitów
                        case "BESTIA":


                            inv.setChestplate(new ItemStack(EnchantItem(Material.DIAMOND_CHESTPLATE,Enchantment.PROTECTION_ENVIRONMENTAL,1)));
                            inv.setBoots(new ItemStack(EnchantItem(Material.DIAMOND_BOOTS,Enchantment.PROTECTION_ENVIRONMENTAL,1)));
                            inv.setLeggings(new ItemStack(EnchantItem(Material.DIAMOND_LEGGINGS,Enchantment.PROTECTION_ENVIRONMENTAL,1)));
                            inv.setHelmet(new ItemStack(EnchantItem(Material.DIAMOND_HELMET,Enchantment.PROTECTION_ENVIRONMENTAL,1)));
                            inv.addItem(new ItemStack(Material.DIAMOND_SWORD));
                            //inv.addItem(new ItemStack(Material.GOLDEN_APPLE,3));
                            RandomTeleport(p);

                            break;
                        case "ŁUCZNIK":


                            inv.setBoots(new ItemStack(EnchantItem(Material.IRON_BOOTS,Enchantment.PROTECTION_ENVIRONMENTAL,2)));
                            inv.setChestplate(new ItemStack(EnchantItem(Material.IRON_CHESTPLATE,Enchantment.PROTECTION_ENVIRONMENTAL,2)));
                            inv.setHelmet(new ItemStack(EnchantItem(Material.IRON_HELMET,Enchantment.PROTECTION_ENVIRONMENTAL,2)));
                            inv.setLeggings(new ItemStack(EnchantItem(Material.IRON_LEGGINGS,Enchantment.PROTECTION_ENVIRONMENTAL,2)));
                            inv.addItem(new ItemStack(EnchantItem(Material.BOW, Enchantment.ARROW_DAMAGE, 3)));
                            inv.addItem(new ItemStack(EnchantItem(Material.IRON_SWORD, Enchantment.KNOCKBACK, 1)));
                            inv.addItem(new ItemStack(Material.ARROW,64));
                            //inv.addItem(new ItemStack(Material.GOLDEN_APPLE,3));
                            RandomTeleport(p);
                            break;
                        case "DRWAL":

                            inv.setBoots(new ItemStack(Material.IRON_BOOTS));
                            inv.setChestplate(new ItemStack(Material.DIAMOND_CHESTPLATE));
                            inv.setLeggings(new ItemStack(EnchantItem(Material.IRON_LEGGINGS,Enchantment.PROTECTION_ENVIRONMENTAL,3)));
                            inv.addItem(new ItemStack(Material.IRON_AXE));
                            inv.addItem(new ItemStack(EnchantItem(Material.WOODEN_SWORD,Enchantment.KNOCKBACK,1)));
                            inv.addItem(new ItemStack(Material.SHIELD));
                            //inv.addItem(new ItemStack(Material.GOLDEN_APPLE, 3));
                            RandomTeleport(p);

                            break;
                        case "MAG":

                            inv.setBoots(new ItemStack(EnchantItem(Material.LEATHER_BOOTS,Enchantment.PROTECTION_ENVIRONMENTAL,3)));
                            inv.setChestplate(new ItemStack(EnchantItem(Material.LEATHER_CHESTPLATE,Enchantment.PROTECTION_ENVIRONMENTAL,3)));
                            inv.setHelmet(new ItemStack(EnchantItem(Material.LEATHER_HELMET,Enchantment.PROTECTION_ENVIRONMENTAL,3)));
                            inv.setLeggings(new ItemStack(EnchantItem(Material.LEATHER_LEGGINGS,Enchantment.PROTECTION_ENVIRONMENTAL,3)));
                            inv.addItem(new ItemStack(EnchantItem(Material.IRON_SWORD,Enchantment.DAMAGE_ALL,1)));
                            inv.addItem(new ItemStack(CreatePotion(PotionType.STRENGTH, 1, false).toItemStack(1)));
                            inv.addItem(new ItemStack(CreatePotion(PotionType.INSTANT_HEAL, 1, true).toItemStack(2)));
                            inv.addItem(new ItemStack(CreatePotion(PotionType.SPEED, 2, false).toItemStack(3)));
                            inv.addItem(new ItemStack(CreatePotion(PotionType.REGEN, 1, false).toItemStack(2)));
                            inv.addItem(new ItemStack(CreatePotion(PotionType.POISON, 2, true).toItemStack(1)));
                            inv.addItem(new ItemStack(CreatePotion(PotionType.INSTANT_DAMAGE, 1, true).toItemStack(3)));
                            inv.addItem(new ItemStack(Material.GOLDEN_APPLE, 1));
                            RandomTeleport(p);

                            break;
                        case "WOJOWNIK":

                            inv.setBoots(new ItemStack(Material.DIAMOND_BOOTS));
                            inv.setChestplate(new ItemStack(Material.DIAMOND_CHESTPLATE));
                            inv.setHelmet(new ItemStack(Material.DIAMOND_HELMET));
                            inv.setLeggings(new ItemStack(Material.DIAMOND_LEGGINGS));
                            inv.addItem(new ItemStack(EnchantItem(Material.DIAMOND_SWORD,Enchantment.DAMAGE_ALL,2)));
                            //inv.addItem(new ItemStack(Material.GOLDEN_APPLE, 3));
                            RandomTeleport(p);

                            break;
                        case "SAMURAJ":

                            inv.setBoots(new ItemStack(EnchantItem(Material.DIAMOND_BOOTS,Enchantment.PROTECTION_ENVIRONMENTAL,3)));
                            inv.setChestplate(new ItemStack(EnchantItem(Material.DIAMOND_CHESTPLATE,Enchantment.PROTECTION_ENVIRONMENTAL,3)));
                            inv.setHelmet(new ItemStack(Material.IRON_HELMET));
                            inv.addItem(new ItemStack(TwoEnchants(Material.DIAMOND_SWORD,Enchantment.KNOCKBACK,Enchantment.DAMAGE_ALL,1,2)));
                            inv.addItem(new ItemStack(TwoEnchants(Material.FISHING_ROD,Enchantment.LURE,Enchantment.DURABILITY,3,3)));
                            inv.addItem(new ItemStack(CreatePotion(PotionType.SPEED, 2, false).toItemStack(3)));
                            //inv.addItem(new ItemStack(Material.GOLDEN_APPLE, 3));
                            RandomTeleport(p);

                            break;

                    }
                }
            }
        } catch (NullPointerException ex) {
            return;
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

    public ItemStack EnchantItem(Material item, Enchantment ench, int level) {
        ItemStack enchantedBow = new ItemStack(item, 1);
        ItemMeta meta = enchantedBow.getItemMeta();
        meta.addEnchant(ench, level, true);
        enchantedBow.setItemMeta(meta);

        return enchantedBow;
    }
    public ItemStack TwoEnchants(Material item, Enchantment ench,Enchantment ench2, int level,int level2) {//Do przerobienia na liste
        ItemStack enchantedItem = new ItemStack(item, 1);
        ItemMeta meta = enchantedItem.getItemMeta();
        meta.addEnchant(ench, level, true);
        meta.addEnchant(ench2, level2, true);
        enchantedItem.setItemMeta(meta);

        return enchantedItem;
    }

    public Potion CreatePotion(PotionType Pt, int pow, boolean isSplash) {
        Potion potion = new Potion(Pt, pow);
        potion.toItemStack(3);
        potion.setSplash(isSplash);


        return potion;
    }


    //@EventHandler
    //public void onDamage(EntityDamageByEntityEvent event){
    //  if(event.getEntity() instanceof Player){
    //    if(event.getFinalDamage() >= ((Player) event.getEntity()).getHealth()){
    //      event.setCancelled(true);
    //    ((Player) event.getEntity()).getInventory().clear();
    //  ((Player) event.getEntity()).setHealth(20);
    //((Player) event.getEntity()).setFoodLevel(20);
    //((Player) event.getEntity()).getActivePotionEffects().clear();
    //event.getEntity().teleport(new Location(event.getEntity().getWorld(),82,105,160));
    // }
    // }
    //}
    @EventHandler
    public void pde(PlayerDeathEvent e) {
        Player p = e.getEntity();
        Bukkit.broadcastMessage("§7Gracz §b" + p.getName() + " §7został zabity przez §b" + p.getKiller().getName());
    }
    @EventHandler
    public void playerrespawnevent(PlayerRespawnEvent e) {
        Player p = e.getPlayer();
        resetplayer(p);
    }

    @EventHandler
    public void PlayerJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();

        resetplayer(p);
    }
    public void resetplayer(Player p){
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
