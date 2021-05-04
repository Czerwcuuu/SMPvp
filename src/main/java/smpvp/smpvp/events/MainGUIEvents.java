package smpvp.smpvp.events;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import smpvp.smpvp.SMPvp;
import smpvp.smpvp.Statics;
import smpvp.smpvp.commands.MainGUI;
import smpvp.smpvp.commands.openKitGui;
import smpvp.smpvp.inventories.InventoryData;

import java.io.IOException;
import java.util.List;

public class MainGUIEvents implements Listener {
    SMPvp plugin = SMPvp.getInstance();
    //cancel drag
    @EventHandler
    public void onInventoryDrag (InventoryDragEvent e){
        Inventory inv = openKitGui.inventories.get(e.getWhoClicked());
        if(e.getInventory() == inv){
            if(Integer.parseInt(e.getInventorySlots().toString()) > 0){
                e.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onInventoryClick (InventoryClickEvent e) throws IOException {
        Inventory inv = MainGUI.inventories.get(e.getWhoClicked());
        if (e.getInventory() != inv) return;
        e.setCancelled(true);

        final ItemStack clickedItem = e.getCurrentItem();

        // verify current item is not null
        if (clickedItem == null || clickedItem.getType() == Material.AIR) return;
        final Player p = (Player) e.getWhoClicked();




        if(e.getRawSlot() == 11){
            //Przenieś do trybu tworzenia
        }
        if(e.getRawSlot() == 12){
            ((Player) e.getWhoClicked()).performCommand("kit");
        }
        if(e.getRawSlot() == 13){
            ((Player) e.getWhoClicked()).performCommand("mojekity");
        }
        if(e.getRawSlot() == 14){
            ((Player) e.getWhoClicked()).sendMessage("§a§lWpisz §4§l/pojedynek <nick>");
        }
        else if(e.getRawSlot() == 26){
            p.closeInventory();
        }


        p.sendMessage("Kliknąłeś slot " + e.getRawSlot());
    }

    public void getKit(String kitName,Player p){

    }


    boolean IsEquipable(ItemStack i)
    {
        ItemStack test = new ItemStack(i.getType());

        try
        {
            test.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
        }
        catch(IllegalArgumentException e)
        {
            return false;
        }

        return true;
    }
}
