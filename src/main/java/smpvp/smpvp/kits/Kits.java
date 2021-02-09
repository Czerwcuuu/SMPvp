package smpvp.smpvp.kits;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionType;

import java.util.ArrayList;
import java.util.List;

public class Kits {
    public static Kit bestia(PlayerInventory inv){

        List<ItemStack> list = new ArrayList<>();

        return new Kit(inv,
                //Główne sety
                new ItemStack(enchantItem(Material.DIAMOND_BOOTS,Enchantment.PROTECTION_ENVIRONMENTAL,1)),
                new ItemStack(enchantItem(Material.DIAMOND_HELMET,Enchantment.PROTECTION_ENVIRONMENTAL,1)),
                new ItemStack(enchantItem(Material.DIAMOND_CHESTPLATE, Enchantment.PROTECTION_ENVIRONMENTAL,1)),
                new ItemStack(enchantItem(Material.DIAMOND_LEGGINGS,Enchantment.PROTECTION_ENVIRONMENTAL,1)),
                new ItemStack(Material.DIAMOND_SWORD),//miecz
                list);
    }
    public static Kit lucznik(PlayerInventory inv){

        List<ItemStack> list = new ArrayList<>();

        list.add(new ItemStack(enchantItem(Material.IRON_SWORD, Enchantment.KNOCKBACK, 1)));
        list.add(new ItemStack(Material.ARROW,64));

        return new Kit(inv,
                //Główne sety
                new ItemStack(enchantItem(Material.IRON_BOOTS,Enchantment.PROTECTION_ENVIRONMENTAL,2)),
                new ItemStack(enchantItem(Material.IRON_HELMET,Enchantment.PROTECTION_ENVIRONMENTAL,2)),
                new ItemStack(enchantItem(Material.IRON_CHESTPLATE,Enchantment.PROTECTION_ENVIRONMENTAL,2)),
                new ItemStack(enchantItem(Material.IRON_LEGGINGS,Enchantment.PROTECTION_ENVIRONMENTAL,2)),
                new ItemStack(enchantItem(Material.BOW, Enchantment.ARROW_DAMAGE, 3)),//miecz
                list);
    }
    public static Kit drwal(PlayerInventory inv){

        List<ItemStack> list = new ArrayList<>();

        return new Kit(inv,
                //Główne sety
                new ItemStack(Material.IRON_BOOTS),
                new ItemStack(Material.DIAMOND_HELMET),
                new ItemStack(Material.DIAMOND_CHESTPLATE),
                new ItemStack(enchantItem(Material.IRON_LEGGINGS,Enchantment.PROTECTION_ENVIRONMENTAL,3)),
                new ItemStack(Material.IRON_AXE),
                list);
    }
    public static Kit wojownik(PlayerInventory inv){
        List<ItemStack> list = new ArrayList<>();

        return new Kit(inv,
                //Główne sety
                new ItemStack(Material.DIAMOND_BOOTS),
                new ItemStack(Material.DIAMOND_HELMET),
                new ItemStack(Material.DIAMOND_CHESTPLATE),
                new ItemStack(Material.DIAMOND_LEGGINGS),
                new ItemStack(enchantItem(Material.DIAMOND_SWORD,Enchantment.DAMAGE_ALL,2)),//miecz
                list);

    }
    public static Kit samuraj(PlayerInventory inv){

        List<ItemStack> list = new ArrayList<>();
        list.add(new ItemStack(twoEnchants(Material.FISHING_ROD,Enchantment.LURE,Enchantment.DURABILITY,3,3)));
        list.add(new ItemStack(createPotion(PotionType.SPEED, 2, false).toItemStack(3)));

        return new Kit(inv,
                //Główne sety
                new ItemStack(enchantItem(Material.DIAMOND_BOOTS,Enchantment.PROTECTION_ENVIRONMENTAL,3)),//buty
                new ItemStack(twoEnchants(Material.GOLDEN_HELMET,Enchantment.PROTECTION_ENVIRONMENTAL,Enchantment.DURABILITY,3,4)),
                new ItemStack(enchantItem(Material.DIAMOND_CHESTPLATE,Enchantment.PROTECTION_ENVIRONMENTAL,3)),//hełm
                new ItemStack(Material.LEATHER_LEGGINGS),//spodnie
                new ItemStack(twoEnchants(Material.DIAMOND_SWORD,Enchantment.KNOCKBACK,Enchantment.DAMAGE_ALL,1,2)),//miecz
                list);


    }
    public static Kit lowca(PlayerInventory inv){

        List<ItemStack> list = new ArrayList<>();

        list.add(new ItemStack(enchantItem(Material.BOW, Enchantment.ARROW_DAMAGE, 2)));
        list.add(new ItemStack(Material.ARROW,32));
        list.add(new ItemStack(Material.GOLDEN_APPLE,2));

        //Reszta itemków

        return new Kit(inv,
                //Główne sety
                new ItemStack(enchantItem(Material.DIAMOND_BOOTS,Enchantment.PROTECTION_ENVIRONMENTAL,1)),
                new ItemStack(enchantItem(Material.DIAMOND_HELMET,Enchantment.PROTECTION_ENVIRONMENTAL,1)),
                new ItemStack(enchantItem(Material.DIAMOND_CHESTPLATE,Enchantment.PROTECTION_ENVIRONMENTAL,1)),
                new ItemStack(enchantItem(Material.DIAMOND_LEGGINGS,Enchantment.PROTECTION_ENVIRONMENTAL,1)),
                new ItemStack(enchantItem(Material.IRON_SWORD,Enchantment.DAMAGE_ALL,2)),
                list);

    }
    public static Kit szlachic(PlayerInventory inv){
        List<ItemStack> list = new ArrayList<>();

        list.add(new ItemStack(createPotion(PotionType.SPEED, 1, false).toItemStack(2)));
        list.add(new ItemStack(Material.GOLDEN_APPLE,1));
        list.add(new ItemStack(Material.ARROW,1));

        //Reszta itemków

        return new Kit(inv,
                //Główne sety
                new ItemStack(Material.DIAMOND_BOOTS),
                new ItemStack(Material.DIAMOND_HELMET),
                new ItemStack(Material.DIAMOND_CHESTPLATE),
                new ItemStack(Material.DIAMOND_LEGGINGS),
                new ItemStack(twoEnchants(Material.BOW,Enchantment.ARROW_INFINITE,Enchantment.ARROW_DAMAGE,1,3)),//miecz
                list);


    }
    public static Kit paladyn(PlayerInventory inv){
        List<ItemStack> list = new ArrayList<>();

        //Reszta itemków
        list.add(new ItemStack(enchantItem(Material.DIAMOND_SWORD,Enchantment.DAMAGE_ALL,5)));
        for(int i=0; i<17; i++){
            list.add(new ItemStack(createPotion(PotionType.INSTANT_HEAL, 2, true).toItemStack(1)));
        }
        return new Kit(inv,
                //Główne sety
                new ItemStack(enchantItem(Material.DIAMOND_BOOTS,Enchantment.PROTECTION_ENVIRONMENTAL,3)),
                new ItemStack(enchantItem(Material.DIAMOND_HELMET,Enchantment.PROTECTION_ENVIRONMENTAL,3)),
                new ItemStack(enchantItem(Material.DIAMOND_CHESTPLATE,Enchantment.PROTECTION_ENVIRONMENTAL,3)),
                new ItemStack(enchantItem(Material.DIAMOND_LEGGINGS,Enchantment.PROTECTION_ENVIRONMENTAL,3)),
                new ItemStack(twoEnchants(Material.NETHERITE_SWORD,Enchantment.DAMAGE_ALL,Enchantment.FIRE_ASPECT,5,2)),//miecz
                list);



    }
    public static Kit litwin(PlayerInventory inv){
        List<ItemStack> list = new ArrayList<>();

        //Reszta itemków

        list.add(new ItemStack(enchantItem(Material.DIAMOND_SWORD,Enchantment.DAMAGE_ALL,5)));
        list.add(new ItemStack(Material.ENCHANTED_GOLDEN_APPLE,5));
        list.add(new ItemStack(Material.COOKED_BEEF,16));
        list.add(new ItemStack(createPotion(PotionType.STRENGTH, 2, false).toItemStack(4)));

        return new Kit(inv,
                //Główne sety
                new ItemStack(enchantItem(Material.IRON_BOOTS,Enchantment.PROTECTION_ENVIRONMENTAL,4)),
                new ItemStack(enchantItem(Material.IRON_HELMET,Enchantment.PROTECTION_ENVIRONMENTAL,4)),
                new ItemStack(enchantItem(Material.IRON_CHESTPLATE,Enchantment.PROTECTION_ENVIRONMENTAL,4)),
                new ItemStack(enchantItem(Material.IRON_LEGGINGS,Enchantment.PROTECTION_ENVIRONMENTAL,4)),
                new ItemStack(twoEnchants(Material.NETHERITE_SWORD,Enchantment.DAMAGE_ALL,Enchantment.FIRE_ASPECT,5,2)),//miecz
                list);


    }
    public static Kit egzorcysta(PlayerInventory inv){
        List<ItemStack> list = new ArrayList<>();

        //Reszta itemków
        list.add(new ItemStack(Material.GOLDEN_APPLE,3));
        list.add(new ItemStack(Material.ENDER_PEARL,16));
        list.add(new ItemStack(createPotion(PotionType.SPEED, 2, false).toItemStack(3)));
        list.add(new ItemStack(createPotion(PotionType.STRENGTH, 2, false).toItemStack(3)));
        list.add(new ItemStack(createPotion(PotionType.POISON, 1, true).toItemStack(2)));
        list.add(new ItemStack(Material.COOKED_BEEF,64));
        for(int i=0; i<22; i++){
            list.add(new ItemStack(createPotion(PotionType.INSTANT_HEAL, 2, true).toItemStack(1)));
        }
        list.add(new ItemStack(createPotion(PotionType.FIRE_RESISTANCE, 1, false).toItemStack(2)));


        return new Kit(inv,
                //Główne sety
                new ItemStack(twoEnchants(Material.NETHERITE_BOOTS,Enchantment.PROTECTION_ENVIRONMENTAL,Enchantment.DURABILITY,4,3)),//buty
                new ItemStack(twoEnchants(Material.NETHERITE_HELMET,Enchantment.PROTECTION_ENVIRONMENTAL,Enchantment.DURABILITY,4,3)),//hełm
                new ItemStack(twoEnchants(Material.NETHERITE_CHESTPLATE,Enchantment.PROTECTION_ENVIRONMENTAL,Enchantment.DURABILITY,4,3)),//klata
                new ItemStack(twoEnchants(Material.NETHERITE_LEGGINGS,Enchantment.PROTECTION_ENVIRONMENTAL,Enchantment.DURABILITY,4,3)),//spodnie
                new ItemStack(twoEnchants(Material.NETHERITE_SWORD,Enchantment.DAMAGE_ALL,Enchantment.FIRE_ASPECT,5,2)),//miecz
                list);

    }

    public static Kit getKit(String kitName,PlayerInventory inv){
        switch(kitName){
            case "lucznik":
                return lucznik(inv);
            case "bestia":
                return bestia(inv);
            case "wojownik":
                return wojownik(inv);
            case "samuraj":
                return samuraj(inv);
            case "szlachic":
                return szlachic(inv);
            case "lowca":
                return lowca(inv);
            case "litwin":
                return litwin(inv);
            case "egzorcysta":
                return egzorcysta(inv);
            case "paladyn":
                return paladyn(inv);
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
