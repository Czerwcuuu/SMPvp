package smpvp.smpvp.kits;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionType;

public class Kits {
    static public void testKit(PlayerInventory inv){

        inv.setChestplate(new ItemStack(enchantItem(Material.DIAMOND_CHESTPLATE, Enchantment.PROTECTION_ENVIRONMENTAL,1)));
        inv.setBoots(new ItemStack(enchantItem(Material.DIAMOND_BOOTS,Enchantment.PROTECTION_ENVIRONMENTAL,1)));
        inv.setLeggings(new ItemStack(enchantItem(Material.DIAMOND_LEGGINGS,Enchantment.PROTECTION_ENVIRONMENTAL,1)));
        inv.setHelmet(new ItemStack(enchantItem(Material.DIAMOND_HELMET,Enchantment.PROTECTION_ENVIRONMENTAL,1)));
        inv.addItem(new ItemStack(Material.DIAMOND_SWORD));
        inv.addItem(new ItemStack(Material.GOLDEN_APPLE,3));
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
