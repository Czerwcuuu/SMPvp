package smpvp.smpvp;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.entity.SplashPotion;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.material.MaterialData;
import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.potion.PotionType;

public class Events implements Listener {

    @EventHandler
    public void SignClickEvent(PlayerInteractEvent event){
        try {
            Player player = (Player) event.getPlayer();
            Block b = event.getClickedBlock();
            if (b.getState() instanceof Sign) {
                Sign sign = (Sign) b.getState();
                String line1 = sign.getLine(1);
                if (line1.equals("Paladyn")) {
                    if (!event.getPlayer().getInventory().isEmpty()) {
                        player.sendMessage("Nie możesz odebrać więcej kitów");
                    } else {
                        event.getPlayer().getInventory().setChestplate(new ItemStack(Material.GOLDEN_CHESTPLATE));
                        event.getPlayer().getInventory().setBoots(new ItemStack(Material.GOLDEN_BOOTS));
                        event.getPlayer().getInventory().setLeggings(new ItemStack(Material.GOLDEN_LEGGINGS));
                        event.getPlayer().getInventory().setHelmet(new ItemStack(EnchantItem(Material.LEATHER_HELMET,Enchantment.PROTECTION_ENVIRONMENTAL,3)));
                        event.getPlayer().getInventory().addItem(new ItemStack(EnchantItem(Material.STONE_SWORD,Enchantment.DAMAGE_ALL,1)));
                        event.getPlayer().getInventory().addItem(new ItemStack(Material.BREAD, 30));
                        event.getPlayer().teleport(new Location(event.getPlayer().getWorld(), 81, 107, 86));
                    }
                } else if (line1.equals("Lowca")) {
                    if (!event.getPlayer().getInventory().isEmpty()) {
                        player.sendMessage("Nie możesz odebrać więcej kitów");
                    } else {
                        event.getPlayer().getInventory().setBoots(new ItemStack(Material.LEATHER_BOOTS));
                        event.getPlayer().getInventory().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE));
                        event.getPlayer().getInventory().setHelmet(new ItemStack(Material.LEATHER_HELMET));
                        event.getPlayer().getInventory().setLeggings(new ItemStack(Material.LEATHER_LEGGINGS));
                        event.getPlayer().getInventory().addItem(new ItemStack(EnchantItem(Material.BOW,Enchantment.ARROW_INFINITE,1)));
                        event.getPlayer().getInventory().addItem(new ItemStack(Material.BREAD, 30));
                        event.getPlayer().getInventory().addItem(new ItemStack(Material.ARROW));
                        event.getPlayer().teleport(new Location(event.getPlayer().getWorld(), 81, 107, 86));
                    }
                } else if (line1.equals("Drwal")) {
                    if (!event.getPlayer().getInventory().isEmpty()) {
                        player.sendMessage("Nie możesz odebrać więcej kitów");
                    } else {
                        event.getPlayer().getInventory().setBoots(new ItemStack(Material.LEATHER_BOOTS));
                        event.getPlayer().getInventory().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE));
                        event.getPlayer().getInventory().setLeggings(new ItemStack(Material.LEATHER_LEGGINGS));
                        event.getPlayer().getInventory().addItem(new ItemStack(Material.STONE_AXE));
                        event.getPlayer().getInventory().addItem(new ItemStack(Material.GOLDEN_APPLE,1));
                        event.getPlayer().getInventory().addItem(new ItemStack(Material.BREAD, 30));
                        event.getPlayer().teleport(new Location(event.getPlayer().getWorld(), 81, 107, 86));
                    }
                } else if (line1.equals("Niszczyciel")) {
                    if (!event.getPlayer().getInventory().isEmpty()) {
                        player.sendMessage("Nie możesz odebrać więcej kitów");
                    } else {
                        event.getPlayer().getInventory().setBoots(new ItemStack(Material.DIAMOND_BOOTS));
                        event.getPlayer().getInventory().setChestplate(new ItemStack(Material.DIAMOND_CHESTPLATE));
                        event.getPlayer().getInventory().setHelmet(new ItemStack(Material.DIAMOND_HELMET));
                        event.getPlayer().getInventory().setLeggings(new ItemStack(Material.DIAMOND_LEGGINGS));
                        event.getPlayer().getInventory().addItem(new ItemStack(Material.WOODEN_SWORD));
                        event.getPlayer().teleport(new Location(event.getPlayer().getWorld(), 81, 107, 86));
                    }
                }
                else if (line1.equals("Mag")) {
                    if (!event.getPlayer().getInventory().isEmpty()) {
                        player.sendMessage("Nie możesz odebrać więcej kitów");
                    } else {
                        event.getPlayer().getInventory().setBoots(new ItemStack(Material.LEATHER_BOOTS));
                        event.getPlayer().getInventory().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE));
                        event.getPlayer().getInventory().setHelmet(new ItemStack(Material.GOLDEN_HELMET));
                        event.getPlayer().getInventory().setLeggings(new ItemStack(Material.LEATHER_LEGGINGS));
                        event.getPlayer().getInventory().addItem(new ItemStack(EnchantItem(Material.STICK,Enchantment.KNOCKBACK,3)));
                        event.getPlayer().getInventory().addItem(new ItemStack(EnchantItem(Material.STICK,Enchantment.DAMAGE_ALL,1)));
                        event.getPlayer().getInventory().addItem(new ItemStack(CreatePotion(PotionType.INSTANT_DAMAGE,1,true).toItemStack(10)));
                        event.getPlayer().getInventory().addItem(new ItemStack(CreatePotion(PotionType.INSTANT_HEAL,2,true).toItemStack(5)));
                        event.getPlayer().getInventory().addItem(new ItemStack(CreatePotion(PotionType.POISON,1,true).toItemStack(3)));
                        event.getPlayer().getInventory().addItem(new ItemStack(CreatePotion(PotionType.SLOWNESS,1,true).toItemStack(3)));
                        event.getPlayer().getInventory().addItem(new ItemStack(CreatePotion(PotionType.REGEN,1,false).toItemStack(3)));
                        event.getPlayer().getInventory().addItem(new ItemStack(Material.BREAD, 30));
                        event.getPlayer().teleport(new Location(event.getPlayer().getWorld(), 81, 107, 86));
                    }
                }
            }
        }
        catch (NullPointerException ex){
            return;
        }
    }
    public ItemStack EnchantItem(Material item,Enchantment ench,int level){
        ItemStack enchantedBow = new ItemStack(item,1);
        ItemMeta meta = enchantedBow.getItemMeta();
        meta.addEnchant(ench,level,true);
        meta.addEnchant(ench,level,true);
        enchantedBow.setItemMeta(meta);

        return enchantedBow;
    }

    public Potion CreatePotion(PotionType Pt,int pow,boolean isSplash){
        Potion potion = new Potion(Pt,1);
        potion.toItemStack(3);
        potion.setSplash(isSplash);


        return potion;
    }


    @EventHandler
    public void PlayerDeath(PlayerDeathEvent e){
        e.getEntity().setHealth(20.0);
        e.getEntity().setFoodLevel(20);
        e.getEntity().getInventory().clear();
        e.getEntity().getActivePotionEffects().clear();
        e.getEntity().teleport(new Location(e.getEntity().getWorld(),82,105,160));
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
    public void PlayerDeath(PlayerJoinEvent e){
        e.getPlayer().setHealth(20);
        e.getPlayer().setFoodLevel(20);
        e.getPlayer().getInventory().clear();
        e.getPlayer().teleport(new Location(e.getPlayer().getWorld(),82,105,160));
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
