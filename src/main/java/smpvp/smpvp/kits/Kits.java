package smpvp.smpvp.kits;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Item;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionType;

public class Kits {
    public static void bestia(PlayerInventory inv){
        inv.setChestplate(new ItemStack(enchantItem(Material.DIAMOND_CHESTPLATE, Enchantment.PROTECTION_ENVIRONMENTAL,1)));
        inv.setBoots(new ItemStack(enchantItem(Material.DIAMOND_BOOTS,Enchantment.PROTECTION_ENVIRONMENTAL,1)));
        inv.setLeggings(new ItemStack(enchantItem(Material.DIAMOND_LEGGINGS,Enchantment.PROTECTION_ENVIRONMENTAL,1)));
        inv.setHelmet(new ItemStack(enchantItem(Material.DIAMOND_HELMET,Enchantment.PROTECTION_ENVIRONMENTAL,1)));
        inv.addItem(new ItemStack(Material.DIAMOND_SWORD));
    }
    public static void lucznik(PlayerInventory inv){
        inv.setBoots(new ItemStack(enchantItem(Material.IRON_BOOTS,Enchantment.PROTECTION_ENVIRONMENTAL,2)));
        inv.setChestplate(new ItemStack(enchantItem(Material.IRON_CHESTPLATE,Enchantment.PROTECTION_ENVIRONMENTAL,2)));
        inv.setHelmet(new ItemStack(enchantItem(Material.IRON_HELMET,Enchantment.PROTECTION_ENVIRONMENTAL,2)));
        inv.setLeggings(new ItemStack(enchantItem(Material.IRON_LEGGINGS,Enchantment.PROTECTION_ENVIRONMENTAL,2)));
        inv.addItem(new ItemStack(enchantItem(Material.BOW, Enchantment.ARROW_DAMAGE, 3)));
        inv.addItem(new ItemStack(enchantItem(Material.IRON_SWORD, Enchantment.KNOCKBACK, 1)));
        inv.addItem(new ItemStack(Material.ARROW,64));
    }
    public static void drwal(PlayerInventory inv){
        inv.setBoots(new ItemStack(Material.IRON_BOOTS));
        inv.setChestplate(new ItemStack(Material.DIAMOND_CHESTPLATE));
        inv.setLeggings(new ItemStack(enchantItem(Material.IRON_LEGGINGS,Enchantment.PROTECTION_ENVIRONMENTAL,3)));
        inv.addItem(new ItemStack(Material.IRON_AXE));
        inv.addItem(new ItemStack(enchantItem(Material.WOODEN_SWORD,Enchantment.KNOCKBACK,1)));
        inv.addItem(new ItemStack(Material.SHIELD));
    }
    public static void mag(PlayerInventory inv){
        inv.setBoots(new ItemStack(enchantItem(Material.LEATHER_BOOTS,Enchantment.PROTECTION_ENVIRONMENTAL,3)));
        inv.setChestplate(new ItemStack(enchantItem(Material.LEATHER_CHESTPLATE,Enchantment.PROTECTION_ENVIRONMENTAL,3)));
        inv.setHelmet(new ItemStack(enchantItem(Material.LEATHER_HELMET,Enchantment.PROTECTION_ENVIRONMENTAL,3)));
        inv.setLeggings(new ItemStack(enchantItem(Material.LEATHER_LEGGINGS,Enchantment.PROTECTION_ENVIRONMENTAL,3)));
        inv.addItem(new ItemStack(enchantItem(Material.IRON_SWORD,Enchantment.DAMAGE_ALL,1)));
        inv.addItem(new ItemStack(createPotion(PotionType.STRENGTH, 1, false).toItemStack(1)));
        inv.addItem(new ItemStack(createPotion(PotionType.INSTANT_HEAL, 1, true).toItemStack(2)));
        inv.addItem(new ItemStack(createPotion(PotionType.SPEED, 2, false).toItemStack(3)));
        inv.addItem(new ItemStack(createPotion(PotionType.REGEN, 1, false).toItemStack(2)));
        inv.addItem(new ItemStack(createPotion(PotionType.POISON, 2, true).toItemStack(1)));
        inv.addItem(new ItemStack(Material.GOLDEN_APPLE, 1));
    }
    /*public static void posejdon(PlayerInventory inv){
        inv.setBoots(new ItemStack(twoEnchants(Material.CHAINMAIL_BOOTS,Enchantment.PROTECTION_ENVIRONMENTAL,Enchantment.DURABILITY,3,3)));
        inv.setChestplate(new ItemStack(twoEnchants(Material.CHAINMAIL_CHESTPLATE,Enchantment.PROTECTION_ENVIRONMENTAL,Enchantment.DURABILITY,3,3)));
        inv.setHelmet(new ItemStack(twoEnchants(Material.CHAINMAIL_HELMET,Enchantment.PROTECTION_ENVIRONMENTAL,Enchantment.DURABILITY,3,3)));
        inv.setLeggings(new ItemStack(twoEnchants(Material.CHAINMAIL_LEGGINGS,Enchantment.PROTECTION_ENVIRONMENTAL,Enchantment.DURABILITY,3,3)));
        inv.addItem(new ItemStack(twoEnchants(Material.TRIDENT,Enchantment.DURABILITY,Enchantment.LOYALTY,3,3)));
        inv.addItem(new ItemStack(createPotion(PotionType.SPEED, 1, false).toItemStack(3)));
        inv.addItem(new ItemStack(createPotion(PotionType.JUMP, 2, false).toItemStack(3)));
    }*/
    public static void wojownik(PlayerInventory inv){
        inv.setBoots(new ItemStack(Material.DIAMOND_BOOTS));
        inv.setChestplate(new ItemStack(Material.DIAMOND_CHESTPLATE));
        inv.setHelmet(new ItemStack(Material.DIAMOND_HELMET));
        inv.setLeggings(new ItemStack(Material.DIAMOND_LEGGINGS));
        inv.addItem(new ItemStack(enchantItem(Material.DIAMOND_SWORD,Enchantment.DAMAGE_ALL,2)));

    }
    public static void samuraj(PlayerInventory inv){
        inv.setBoots(new ItemStack(enchantItem(Material.DIAMOND_BOOTS,Enchantment.PROTECTION_ENVIRONMENTAL,3)));
        inv.setChestplate(new ItemStack(enchantItem(Material.DIAMOND_CHESTPLATE,Enchantment.PROTECTION_ENVIRONMENTAL,3)));
        inv.setHelmet(new ItemStack(Material.IRON_HELMET));
        inv.addItem(new ItemStack(twoEnchants(Material.DIAMOND_SWORD,Enchantment.KNOCKBACK,Enchantment.DAMAGE_ALL,1,2)));
        inv.addItem(new ItemStack(twoEnchants(Material.FISHING_ROD,Enchantment.LURE,Enchantment.DURABILITY,3,3)));
        inv.addItem(new ItemStack(createPotion(PotionType.SPEED, 2, false).toItemStack(3)));
    }
    public static void zniwiarz(PlayerInventory inv){
        inv.setBoots(new ItemStack(enchantItem(Material.IRON_BOOTS,Enchantment.PROTECTION_ENVIRONMENTAL,3)));
        inv.setChestplate(new ItemStack(enchantItem(Material.IRON_CHESTPLATE,Enchantment.PROTECTION_ENVIRONMENTAL,3)));
        inv.setHelmet(new ItemStack(twoEnchants(Material.GOLDEN_HELMET,Enchantment.PROTECTION_ENVIRONMENTAL,Enchantment.DURABILITY,3,4)));
        inv.setLeggings(new ItemStack(enchantItem(Material.IRON_LEGGINGS,Enchantment.PROTECTION_ENVIRONMENTAL,3)));
        inv.addItem(new ItemStack(enchantItem(Material.NETHERITE_HOE,Enchantment.DAMAGE_ALL,5)));
        inv.addItem(new ItemStack(createPotion(PotionType.SPEED, 2, true).toItemStack(3)));
    }


    private static ItemStack enchantItem(Material item, Enchantment ench, int level) {
        ItemStack enchantedBow = new ItemStack(item, 1);
        ItemMeta meta = enchantedBow.getItemMeta();
        meta.addEnchant(ench, level, true);
        enchantedBow.setItemMeta(meta);

        return enchantedBow;
    }
    private static ItemStack twoEnchants(Material item, Enchantment ench,Enchantment ench2, int level,int level2) {//Do przerobienia na liste
        ItemStack enchantedItem = new ItemStack(item, 1);
        ItemMeta meta = enchantedItem.getItemMeta();
        meta.addEnchant(ench, level, true);
        meta.addEnchant(ench2, level2, true);
        enchantedItem.setItemMeta(meta);

        return enchantedItem;
    }

    private static Potion createPotion(PotionType Pt, int pow, boolean isSplash) {
        Potion potion = new Potion(Pt, pow);
        potion.toItemStack(3);
        potion.setSplash(isSplash);


        return potion;
    }

}
