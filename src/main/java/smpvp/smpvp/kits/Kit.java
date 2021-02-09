package smpvp.smpvp.kits;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.potion.PotionType;

import java.util.List;

public class Kit {
    PlayerInventory inv;
    ItemStack boots,chestplate,helmet,leggins,hand;
    List<ItemStack> items;


    public Kit(PlayerInventory inventory,ItemStack boots,ItemStack helmet,ItemStack chestplate,ItemStack leggins,ItemStack hand,List<ItemStack> items){
        this.inv = inventory;
        this.boots = boots;
        this.chestplate = chestplate;
        this.helmet = helmet;
        this.leggins = leggins;
        this.hand = hand;
        this.items = items;

        giveItems();
    }

    public void giveItems(){
        inv.setBoots(boots);
        inv.setChestplate(chestplate);
        inv.setHelmet(helmet);
        inv.setLeggings(leggins);
        inv.addItem(hand);
        for(ItemStack i:items ){
            inv.addItem(i);
        }
    }
}
