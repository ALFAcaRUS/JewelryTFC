package ru.alfacarus.jewelryTFC.eventHandlers;

import com.bioxx.tfc.Entities.Mobs.EntityBear;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import ru.alfacarus.jewelryTFC.utils.ItemManager;
import ru.alfacarus.jewelryTFC.SettingsManager;
import ru.alfacarus.jewelryTFC.logers.BaseLogger;

/**
 * Intercept vanilla minecratf events
 */
public class VanillaEventsHandler {

    @SubscribeEvent
    public void livigDeath(LivingDeathEvent event){
//        BaseLogger loger = SettingsManager.getInstance().getLogger();
//        loger.additionalLog("Intercept living dead event for entity %s", event.entityLiving);
//        if (event.entityLiving instanceof EntityBear){
//            loger.additionalLog("Entity is bear. Try to drop items");
//            event.entityLiving.dropItem(ItemManager.getInstanse().bearCanine, 2);
//        }
    }
}
