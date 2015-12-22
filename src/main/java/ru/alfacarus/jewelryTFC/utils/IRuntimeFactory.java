package ru.alfacarus.jewelryTFC.utils;

import ru.alfacarus.jewelryTFC.SettingsManager;
import ru.alfacarus.jewelryTFC.logers.BaseLogger;

/**
 * Construct objects on runtime.
 * (default implementation RuntimeFactory)
 */
public interface IRuntimeFactory {
   /**
    *  Constructing logger
    * @return BaseLogger
    */
   BaseLogger getLogger();

    /**
     * Constructing settings manager
     * @return SettingsManager
     */
    SettingsManager getSettingsManager();

    /**
     * Get instance of MinecraftAdapter
     *
     * @return MinecraftAdapter
     */
    MinecraftAdapter getMinecraftAdapter();

    BaubleAdapter getBaubleAdapter();

    ItemManager getItemManager();

    TFCCoreAdapter getTFCCoreAdapter();
}
