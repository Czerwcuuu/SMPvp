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

public class Events implements Listener {

    @EventHandler
    public void SignClickEvent(PlayerInteractEvent event) {
        try {
            Location pvplocation = new Location(event.getPlayer().getWorld(), 81, 107, 86); //gdzie ma teleportować po wybraniu kitu
            Player p = event.getPlayer();
            Block b = event.getClickedBlock();
            if (b.getState() instanceof Sign) {
                event.setCancelled(true);
                PlayerInventory inv = p.getInventory();

                if (inv.isEmpty()) {
                    Sign sign = (Sign) b.getState();
                    String line1 = sign.getLine(1);

                    switch (line1) { //wybór kitów
                        case "Bestia":


                            inv.setChestplate(new ItemStack(EnchantItem(Material.DIAMOND_CHESTPLATE,Enchantment.PROTECTION_ENVIRONMENTAL,1)));
                            inv.setBoots(new ItemStack(EnchantItem(Material.DIAMOND_BOOTS,Enchantment.PROTECTION_ENVIRONMENTAL,1)));
                            inv.setLeggings(new ItemStack(EnchantItem(Material.DIAMOND_LEGGINGS,Enchantment.PROTECTION_ENVIRONMENTAL,1)));
                            inv.setHelmet(new ItemStack(EnchantItem(Material.DIAMOND_HELMET,Enchantment.PROTECTION_ENVIRONMENTAL,1)));
                            inv.addItem(new ItemStack(Material.DIAMOND_SWORD));
                            inv.addItem(new ItemStack(Material.GOLDEN_APPLE,3));
                            inv.addItem(new ItemStack(Material.BREAD, 30));
                            p.teleport(pvplocation);

                            break;
                        case "Lucznik":


                            inv.setBoots(new ItemStack(EnchantItem(Material.LEATHER_BOOTS,Enchantment.PROTECTION_ENVIRONMENTAL,3)));
                            inv.setChestplate(new ItemStack(EnchantItem(Material.LEATHER_CHESTPLATE,Enchantment.PROTECTION_ENVIRONMENTAL,3)));
                            inv.setHelmet(new ItemStack(EnchantItem(Material.LEATHER_HELMET,Enchantment.PROTECTION_ENVIRONMENTAL,3)));
                            inv.setLeggings(new ItemStack(EnchantItem(Material.LEATHER_BOOTS,Enchantment.PROTECTION_ENVIRONMENTAL,3)));
                            inv.addItem(new ItemStack(EnchantItem(Material.BOW, Enchantment.ARROW_DAMAGE, 3)));
                            inv.addItem(new ItemStack(Material.BREAD, 30));
                            inv.addItem(new ItemStack(Material.ARROW,64));
                            inv.addItem(new ItemStack(Material.GOLDEN_APPLE,3));
                            p.teleport(pvplocation);
                            break;
                        case "Drwal":

                            inv.setBoots(new ItemStack(Material.IRON_BOOTS));
                            inv.setChestplate(new ItemStack(Material.DIAMOND_CHESTPLATE));
                            inv.setLeggings(new ItemStack(EnchantItem(Material.IRON_LEGGINGS,Enchantment.PROTECTION_ENVIRONMENTAL,3)));
                            inv.addItem(new ItemStack(Material.IRON_AXE));
                            inv.addItem(new ItemStack(EnchantItem(Material.WOODEN_SWORD,Enchantment.KNOCKBACK,1)));
                            inv.addItem(new ItemStack(Material.SHIELD));
                            inv.addItem(new ItemStack(Material.GOLDEN_APPLE, 3));
                            inv.addItem(new ItemStack(Material.BREAD, 30));
                            p.teleport(pvplocation);

                            break;
                        case "Mag":

                            inv.setBoots(new ItemStack(EnchantItem(Material.LEATHER_BOOTS,Enchantment.PROTECTION_ENVIRONMENTAL,3)));
                            inv.setChestplate(new ItemStack(EnchantItem(Material.LEATHER_CHESTPLATE,Enchantment.PROTECTION_ENVIRONMENTAL,3)));
                            inv.setHelmet(new ItemStack(EnchantItem(Material.LEATHER_HELMET,Enchantment.PROTECTION_ENVIRONMENTAL,3)));
                            inv.setLeggings(new ItemStack(EnchantItem(Material.LEATHER_LEGGINGS,Enchantment.PROTECTION_ENVIRONMENTAL,3)));
                            inv.addItem(new ItemStack(EnchantItem(Material.IRON_SWORD,Enchantment.DAMAGE_ALL,1)));
                            inv.addItem(new ItemStack(Material.MILK_BUCKET));
                            inv.addItem(new ItemStack(CreatePotion(PotionType.POISON, 3, true).toItemStack(1)));
                            inv.addItem(new ItemStack(CreatePotion(PotionType.STRENGTH, 2, false).toItemStack(1)));
                            inv.addItem(new ItemStack(CreatePotion(PotionType.INSTANT_HEAL, 3, true).toItemStack(1)));
                            inv.addItem(new ItemStack(CreatePotion(PotionType.SPEED, 2, false).toItemStack(3)));
                            inv.addItem(new ItemStack(CreatePotion(PotionType.REGEN, 1, false).toItemStack(2)));
                            inv.addItem(new ItemStack(Material.GOLDEN_APPLE, 1));
                            inv.addItem(new ItemStack(Material.BREAD, 30));
                            p.teleport(pvplocation);

                            break;
                        case "Wojownik":

                            inv.setBoots(new ItemStack(Material.DIAMOND_BOOTS));
                            inv.setChestplate(new ItemStack(Material.DIAMOND_CHESTPLATE));
                            inv.setHelmet(new ItemStack(Material.DIAMOND_HELMET));
                            inv.setLeggings(new ItemStack(Material.DIAMOND_LEGGINGS));
                            inv.addItem(new ItemStack(EnchantItem(Material.DIAMOND_SWORD,Enchantment.DAMAGE_ALL,2)));
                            inv.addItem(new ItemStack(Material.BREAD, 30));
                            inv.addItem(new ItemStack(Material.GOLDEN_APPLE, 3));
                            p.teleport(pvplocation);

                            break;
                        case "Samuraj":

                            inv.setBoots(new ItemStack(EnchantItem(Material.DIAMOND_BOOTS,Enchantment.PROTECTION_ENVIRONMENTAL,3)));
                            inv.setChestplate(new ItemStack(EnchantItem(Material.LEATHER_CHESTPLATE,Enchantment.PROTECTION_ENVIRONMENTAL,3)));
                            inv.setHelmet(new ItemStack(Material.LEATHER_HELMET));
                            inv.addItem(new ItemStack(EnchantItem(Material.DIAMOND_SWORD,Enchantment.KNOCKBACK,2)));
                            inv.addItem(new ItemStack(EnchantItem(Material.DIAMOND_SWORD,Enchantment.DAMAGE_ALL,2)));
                            inv.addItem(new ItemStack(CreatePotion(PotionType.SPEED, 2, false).toItemStack(3)));
                            inv.addItem(new ItemStack(Material.BREAD, 30));
                            inv.addItem(new ItemStack(Material.GOLDEN_APPLE, 3));
                            p.teleport(pvplocation);

                            break;

                    }
                }
            }
        } catch (NullPointerException ex) {
            return;
        }
    }

    public ItemStack EnchantItem(Material item, Enchantment ench, int level) {
        ItemStack enchantedBow = new ItemStack(item, 1);
        ItemMeta meta = enchantedBow.getItemMeta();
        meta.addEnchant(ench, level, true);
        enchantedBow.setItemMeta(meta);

        return enchantedBow;
    }

    public Potion CreatePotion(PotionType Pt, int pow, boolean isSplash) {
        Potion potion = new Potion(Pt, 1);
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
