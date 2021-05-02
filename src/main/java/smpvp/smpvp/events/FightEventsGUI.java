package smpvp.smpvp.events;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import smpvp.smpvp.SMPvp;
import smpvp.smpvp.Statics;
import smpvp.smpvp.arenas.Arena;
import smpvp.smpvp.arenas.NewArenas;
import smpvp.smpvp.commands.fight;
import smpvp.smpvp.inventories.InventoryData;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class FightEventsGUI implements Listener {
    SMPvp plugin = SMPvp.getInstance();

    @EventHandler
    public void onInventoryClick (InventoryClickEvent e) throws IOException {
        Inventory inv = fight.inventories.get(e.getWhoClicked());

        //anuluj przeciagnie
        if (e.getInventory() != inv) return;
        e.setCancelled(true);

        //klikniety przedmiot
        final ItemStack clickedItem = e.getCurrentItem();

        //nic nie rob jezeli przedmiot = null
        if (clickedItem == null || clickedItem.getType() == Material.AIR) return;

        //gracz ktory kliknal
        final Player p = (Player) e.getWhoClicked();


        List<String> mykits = plugin.kitlist.getConfig().getStringList(p.getName()+".name");

        //Weź przedmiot z nickiem wyzwanego gracza
        ItemStack playeritem = inv.getItem(35);
        assert playeritem != null;
        String targetName = Objects.requireNonNull(playeritem.getItemMeta()).getDisplayName();



        if(e.getRawSlot() < mykits.size()){
            p.sendMessage("Kliknąłeś slot " + e.getRawSlot());
            Player target = Bukkit.getPlayer(targetName);
            Bukkit.broadcastMessage(target.getName());
            Bukkit.broadcastMessage(p.getName());
            Bukkit.broadcastMessage(inv.getItem(1).getItemMeta().getDisplayName());

            fight.acceptationInv(target,p,inv.getItem(1).getItemMeta().getDisplayName());
            Inventory acceptinv =  fight.inventories.get(target);
            openInventory(target,acceptinv);
            p.closeInventory();
            /*
            TODO:
            -sprawdzenie czy gracz nie jest w trakcie walki
            -czy gracz nie ignoruje zaproszen
             */
            p.sendMessage("Wyzwałeś swojego przeciwnika na walke");

        }

    }

    @EventHandler
    public void onAcceptEvent (InventoryClickEvent e) throws IOException {
        Inventory inv = fight.inventories.get(e.getWhoClicked());
        if (e.getInventory() != inv) return;
        e.setCancelled(true);

        final ItemStack clickedItem = e.getCurrentItem();

        // verify current item is not null
        if (clickedItem == null || clickedItem.getType() == Material.AIR) return;
        final Player p = (Player) e.getWhoClicked();



        if(e.getRawSlot() == 5){
            p.closeInventory();
        }
        else if(e.getRawSlot() == 3){
            //Teleportuj na dostępną arene
            Bukkit.broadcastMessage("Grasz arene:"+inv.getItem(1).getItemMeta().getDisplayName());
            Bukkit.broadcastMessage("Wyzwał Cię:"+inv.getItem(0).getItemMeta().getDisplayName());

            NewArenas.CheckArenas(inv.getItem(1).getItemMeta().getDisplayName(),p,Bukkit.getPlayer(inv.getItem(0).getItemMeta().getDisplayName()));
        }


        p.sendMessage("Kliknąłeś slot " + e.getRawSlot());
    }

    public void openInventory(final HumanEntity ent, Inventory inv) {
        ent.openInventory(inv);
    }
}
