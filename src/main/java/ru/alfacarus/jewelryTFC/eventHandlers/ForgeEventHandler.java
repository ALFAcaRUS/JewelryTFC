package ru.alfacarus.jewelryTFC.eventHandlers;

import cpw.mods.fml.common.eventhandler.Event;
import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.event.world.WorldEvent;
import ru.alfacarus.jewelryTFC.utils.IRuntimeFactory;
import ru.alfacarus.jewelryTFC.utils.ItemManager;

/**
 *
 */
public class ForgeEventHandler {
    private IRuntimeFactory runtimeFactory;

    public ForgeEventHandler(IRuntimeFactory runtimeFactory){
        this.runtimeFactory = runtimeFactory;
    }

    @SubscribeEvent(priority = EventPriority.LOWEST, receiveCanceled = true)
    public void onWorldLoad(WorldEvent.Load event){
        if(!event.world.isRemote && event.world.provider.dimensionId == 0) {
            ItemManager itemManager = runtimeFactory.getItemManager();
            itemManager.registerAnvilRecipes();
        }
    }
}
