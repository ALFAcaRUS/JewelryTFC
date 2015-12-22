package ru.alfacarus.jewelryTFC.utils;

import ru.alfacarus.jewelryTFC.SettingsManager;
import ru.alfacarus.jewelryTFC.logers.BaseLogger;

/**
 *
 */
public class RuntimeFactory implements IRuntimeFactory{
    private SettingsManager settingsManager;
    private BaseLogger logger;
    private ItemManager itemManager;

    public RuntimeFactory(SettingsManager settingsManager, BaseLogger logger, ItemManager itemManager){
        this.settingsManager =settingsManager;
        this.logger = logger;
        this.itemManager = itemManager;
    }

     /**
     * Constructing logger
     *
     * @return BaseLogger
     */
    @Override
    public BaseLogger getLogger() {
        return logger;
    }

    /**
     * Constructing settings manager
     *
     * @return SettingsManager
     */
    @Override
    public SettingsManager getSettingsManager() {
        return settingsManager;
    }

    /**
     * Get instance of MinecraftAdapter
     *
     * @return MinecraftAdapter
     */
    @Override
    public MinecraftAdapter getMinecraftAdapter() {
        return new MinecraftAdapter();
    }

    @Override
    public BaubleAdapter getBaubleAdapter() {
        return new BaubleAdapter();
    }

    @Override
    public ItemManager getItemManager() {
        return itemManager;
    }

    @Override
    public TFCCoreAdapter getTFCCoreAdapter() {
        return new TFCCoreAdapter();
    }
}
