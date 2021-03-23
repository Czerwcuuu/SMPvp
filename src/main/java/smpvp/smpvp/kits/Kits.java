package smpvp.smpvp.kits;

import java.util.ArrayList;
import java.util.List;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionType;

public class Kits {
    public static Kit bestia(PlayerInventory inv) {
        List<ItemStack> list = new ArrayList();
        return new Kit(inv, new ItemStack(enchantItem(Material.DIAMOND_BOOTS, Enchantment.PROTECTION_ENVIRONMENTAL, 1)), new ItemStack(enchantItem(Material.DIAMOND_HELMET, Enchantment.PROTECTION_ENVIRONMENTAL, 1)), new ItemStack(enchantItem(Material.DIAMOND_CHESTPLATE, Enchantment.PROTECTION_ENVIRONMENTAL, 1)), new ItemStack(enchantItem(Material.DIAMOND_LEGGINGS, Enchantment.PROTECTION_ENVIRONMENTAL, 1)), new ItemStack(Material.DIAMOND_SWORD), list);
    }

    public static Kit lucznik(PlayerInventory inv) {
        List<ItemStack> list = new ArrayList();
        list.add(new ItemStack(enchantItem(Material.IRON_SWORD, Enchantment.KNOCKBACK, 1)));
        list.add(new ItemStack(Material.ARROW, 64));
        return new Kit(inv, new ItemStack(enchantItem(Material.IRON_BOOTS, Enchantment.PROTECTION_ENVIRONMENTAL, 2)), new ItemStack(enchantItem(Material.IRON_HELMET, Enchantment.PROTECTION_ENVIRONMENTAL, 2)), new ItemStack(enchantItem(Material.IRON_CHESTPLATE, Enchantment.PROTECTION_ENVIRONMENTAL, 2)), new ItemStack(enchantItem(Material.IRON_LEGGINGS, Enchantment.PROTECTION_ENVIRONMENTAL, 2)), new ItemStack(enchantItem(Material.BOW, Enchantment.ARROW_DAMAGE, 3)), list);
    }

    public static Kit drwal(PlayerInventory inv) {
        List<ItemStack> list = new ArrayList();
        return new Kit(inv, new ItemStack(Material.IRON_BOOTS), new ItemStack(Material.DIAMOND_HELMET), new ItemStack(Material.DIAMOND_CHESTPLATE), new ItemStack(enchantItem(Material.IRON_LEGGINGS, Enchantment.PROTECTION_ENVIRONMENTAL, 3)), new ItemStack(Material.IRON_AXE), list);
    }

    public static Kit wojownik(PlayerInventory inv) {
        List<ItemStack> list = new ArrayList();
        return new Kit(inv, new ItemStack(Material.DIAMOND_BOOTS), new ItemStack(Material.DIAMOND_HELMET), new ItemStack(Material.DIAMOND_CHESTPLATE), new ItemStack(Material.DIAMOND_LEGGINGS), new ItemStack(enchantItem(Material.DIAMOND_SWORD, Enchantment.DAMAGE_ALL, 2)), list);
    }

    public static Kit samuraj(PlayerInventory inv) {
        List<ItemStack> list = new ArrayList();
        list.add(new ItemStack(twoEnchants(Material.FISHING_ROD, Enchantment.LURE, Enchantment.DURABILITY, 3, 3)));
        list.add(new ItemStack(createPotion(PotionType.SPEED, 2, false).toItemStack(3)));
        return new Kit(inv, new ItemStack(enchantItem(Material.DIAMOND_BOOTS, Enchantment.PROTECTION_ENVIRONMENTAL, 3)), new ItemStack(twoEnchants(Material.GOLDEN_HELMET, Enchantment.PROTECTION_ENVIRONMENTAL, Enchantment.DURABILITY, 3, 4)), new ItemStack(enchantItem(Material.DIAMOND_CHESTPLATE, Enchantment.PROTECTION_ENVIRONMENTAL, 3)), new ItemStack(Material.LEATHER_LEGGINGS), new ItemStack(twoEnchants(Material.DIAMOND_SWORD, Enchantment.KNOCKBACK, Enchantment.DAMAGE_ALL, 1, 2)), list);
    }

    public static Kit lowca(PlayerInventory inv) {
        List<ItemStack> list = new ArrayList();
        list.add(new ItemStack(enchantItem(Material.BOW, Enchantment.ARROW_DAMAGE, 2)));
        list.add(new ItemStack(Material.ARROW, 32));
        list.add(new ItemStack(Material.GOLDEN_APPLE, 2));
        return new Kit(inv, new ItemStack(enchantItem(Material.DIAMOND_BOOTS, Enchantment.PROTECTION_ENVIRONMENTAL, 1)), new ItemStack(enchantItem(Material.DIAMOND_HELMET, Enchantment.PROTECTION_ENVIRONMENTAL, 1)), new ItemStack(enchantItem(Material.DIAMOND_CHESTPLATE, Enchantment.PROTECTION_ENVIRONMENTAL, 1)), new ItemStack(enchantItem(Material.DIAMOND_LEGGINGS, Enchantment.PROTECTION_ENVIRONMENTAL, 1)), new ItemStack(enchantItem(Material.IRON_SWORD, Enchantment.DAMAGE_ALL, 2)), list);
    }

    public static Kit szlachic(PlayerInventory inv) {
        List<ItemStack> list = new ArrayList();
        list.add(new ItemStack(createPotion(PotionType.SPEED, 1, false).toItemStack(2)));
        list.add(new ItemStack(Material.GOLDEN_APPLE, 1));
        list.add(new ItemStack(Material.ARROW, 1));
        return new Kit(inv, new ItemStack(Material.DIAMOND_BOOTS), new ItemStack(Material.DIAMOND_HELMET), new ItemStack(Material.DIAMOND_CHESTPLATE), new ItemStack(Material.DIAMOND_LEGGINGS), new ItemStack(twoEnchants(Material.BOW, Enchantment.ARROW_INFINITE, Enchantment.ARROW_DAMAGE, 1, 3)), list);
    }

    public static Kit paladyn(PlayerInventory inv) {
        List<ItemStack> list = new ArrayList();
        list.add(new ItemStack(enchantItem(Material.DIAMOND_SWORD, Enchantment.DAMAGE_ALL, 5)));

        for(int i = 0; i < 17; ++i) {
            list.add(new ItemStack(createPotion(PotionType.INSTANT_HEAL, 2, true).toItemStack(1)));
        }

        return new Kit(inv, new ItemStack(enchantItem(Material.DIAMOND_BOOTS, Enchantment.PROTECTION_ENVIRONMENTAL, 3)), new ItemStack(enchantItem(Material.DIAMOND_HELMET, Enchantment.PROTECTION_ENVIRONMENTAL, 3)), new ItemStack(enchantItem(Material.DIAMOND_CHESTPLATE, Enchantment.PROTECTION_ENVIRONMENTAL, 3)), new ItemStack(enchantItem(Material.DIAMOND_LEGGINGS, Enchantment.PROTECTION_ENVIRONMENTAL, 3)), new ItemStack(twoEnchants(Material.NETHERITE_SWORD, Enchantment.DAMAGE_ALL, Enchantment.FIRE_ASPECT, 5, 2)), list);
    }

    public static Kit litwin(PlayerInventory inv) {
        List<ItemStack> list = new ArrayList();
        list.add(new ItemStack(enchantItem(Material.DIAMOND_SWORD, Enchantment.DAMAGE_ALL, 5)));
        list.add(new ItemStack(Material.ENCHANTED_GOLDEN_APPLE, 5));
        list.add(new ItemStack(Material.COOKED_BEEF, 16));
        list.add(new ItemStack(createPotion(PotionType.STRENGTH, 2, false).toItemStack(4)));
        return new Kit(inv, new ItemStack(enchantItem(Material.IRON_BOOTS, Enchantment.PROTECTION_ENVIRONMENTAL, 4)), new ItemStack(enchantItem(Material.IRON_HELMET, Enchantment.PROTECTION_ENVIRONMENTAL, 4)), new ItemStack(enchantItem(Material.IRON_CHESTPLATE, Enchantment.PROTECTION_ENVIRONMENTAL, 4)), new ItemStack(enchantItem(Material.IRON_LEGGINGS, Enchantment.PROTECTION_ENVIRONMENTAL, 4)), new ItemStack(twoEnchants(Material.NETHERITE_SWORD, Enchantment.DAMAGE_ALL, Enchantment.FIRE_ASPECT, 5, 2)), list);
    }

    public static Kit egzorcysta(PlayerInventory inv) {
        List<ItemStack> list = new ArrayList();
        list.add(new ItemStack(Material.GOLDEN_APPLE, 3));
        list.add(new ItemStack(Material.ENDER_PEARL, 16));
        list.add(new ItemStack(createPotion(PotionType.SPEED, 2, false).toItemStack(3)));
        list.add(new ItemStack(createPotion(PotionType.STRENGTH, 2, false).toItemStack(3)));
        list.add(new ItemStack(createPotion(PotionType.POISON, 1, true).toItemStack(2)));
        list.add(new ItemStack(Material.COOKED_BEEF, 64));

        for(int i = 0; i < 22; ++i) {
            list.add(new ItemStack(createPotion(PotionType.INSTANT_HEAL, 2, true).toItemStack(1)));
        }

        list.add(new ItemStack(createPotion(PotionType.FIRE_RESISTANCE, 1, false).toItemStack(2)));
        return new Kit(inv, new ItemStack(twoEnchants(Material.NETHERITE_BOOTS, Enchantment.PROTECTION_ENVIRONMENTAL, Enchantment.DURABILITY, 4, 3)), new ItemStack(twoEnchants(Material.NETHERITE_HELMET, Enchantment.PROTECTION_ENVIRONMENTAL, Enchantment.DURABILITY, 4, 3)), new ItemStack(twoEnchants(Material.NETHERITE_CHESTPLATE, Enchantment.PROTECTION_ENVIRONMENTAL, Enchantment.DURABILITY, 4, 3)), new ItemStack(twoEnchants(Material.NETHERITE_LEGGINGS, Enchantment.PROTECTION_ENVIRONMENTAL, Enchantment.DURABILITY, 4, 3)), new ItemStack(twoEnchants(Material.NETHERITE_SWORD, Enchantment.DAMAGE_ALL, Enchantment.FIRE_ASPECT, 5, 2)), list);
    }

    public static Kit getKit(String kitName, PlayerInventory inv) {
        byte var3 = -1;
        switch(kitName.hashCode()) {
            case -1649392549:
                if (kitName.equals("szlachic")) {
                    var3 = 4;
                }
                break;
            case -1392494084:
                if (kitName.equals("bestia")) {
                    var3 = 1;
                }
                break;
            case -1102475803:
                if (kitName.equals("litwin")) {
                    var3 = 6;
                }
                break;
            case -799045229:
                if (kitName.equals("paladyn")) {
                    var3 = 8;
                }
                break;
            case -189451818:
                if (kitName.equals("wojownik")) {
                    var3 = 2;
                }
                break;
            case 95865748:
                if (kitName.equals("drwal")) {
                    var3 = 9;
                }
                break;
            case 103164594:
                if (kitName.equals("lowca")) {
                    var3 = 5;
                }
                break;
            case 510932560:
                if (kitName.equals("lucznik")) {
                    var3 = 0;
                }
                break;
            case 1104784079:
                if (kitName.equals("egzorcysta")) {
                    var3 = 7;
                }
                break;
            case 1864997861:
                if (kitName.equals("samuraj")) {
                    var3 = 3;
                }
        }

        switch(var3) {
            case 0:
                return lucznik(inv);
            case 1:
                return bestia(inv);
            case 2:
                return wojownik(inv);
            case 3:
                return samuraj(inv);
            case 4:
                return szlachic(inv);
            case 5:
                return lowca(inv);
            case 6:
                return litwin(inv);
            case 7:
                return egzorcysta(inv);
            case 8:
                return paladyn(inv);
            case 9:
                return drwal(inv);
            default:
                return bestia(inv);
        }
    }

    private static ItemStack enchantItem(Material item, Enchantment ench, int level) {
        ItemStack enchantedBow = new ItemStack(item, 1);
        ItemMeta meta = enchantedBow.getItemMeta();
        meta.addEnchant(ench, level, true);
        enchantedBow.setItemMeta(meta);
        return enchantedBow;
    }

    private static ItemStack twoEnchants(Material item, Enchantment ench, Enchantment ench2, int level, int level2) {
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