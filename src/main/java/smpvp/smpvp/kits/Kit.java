package smpvp.smpvp.kits;

import java.util.Iterator;
import java.util.List;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

public class Kit {
    PlayerInventory inv;
    ItemStack boots;
    ItemStack chestplate;
    ItemStack helmet;
    ItemStack leggins;
    ItemStack hand;
    List<ItemStack> items;

    public Kit(PlayerInventory inventory, ItemStack boots, ItemStack helmet, ItemStack chestplate, ItemStack leggins, ItemStack hand, List<ItemStack> items) {
        this.inv = inventory;
        this.boots = boots;
        this.chestplate = chestplate;
        this.helmet = helmet;
        this.leggins = leggins;
        this.hand = hand;
        this.items = items;
        this.giveItems();
    }

    public void giveItems() {
        this.inv.setBoots(this.boots);
        this.inv.setChestplate(this.chestplate);
        this.inv.setHelmet(this.helmet);
        this.inv.setLeggings(this.leggins);
        this.inv.addItem(new ItemStack[]{this.hand});
        Iterator var1 = this.items.iterator();

        while(var1.hasNext()) {
            ItemStack i = (ItemStack)var1.next();
            this.inv.addItem(new ItemStack[]{i});
        }

    }
}