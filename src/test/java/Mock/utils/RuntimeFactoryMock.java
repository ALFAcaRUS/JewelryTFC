package Mock.utils;

import ru.alfacarus.jewelryTFC.SettingsManager;
import ru.alfacarus.jewelryTFC.logers.BaseLogger;
import ru.alfacarus.jewelryTFC.utils.*;

/**
 *
 */
public class RuntimeFactoryMock implements IRuntimeFactory {
    public MinecraftAdapter minecraftAdapter;

    /**
     * Constructing logger
     *
     * @return BaseLogger
     */
    @Override
    public BaseLogger getLogger() {
        return null;
    }

    /**
     * Constructing settings manager
     *
     * @return SettingsManager
     */
    @Override
    public SettingsManager getSettingsManager() {
        return null;
    }

    /**
     * Get instance of MinecraftAdapter
     *
     * @return MinecraftAdapter
     */
    @Override
    public MinecraftAdapter getMinecraftAdapter() {
        return minecraftAdapter;
    }

    @Override
    public BaubleAdapter getBaubleAdapter() {
        return null;
    }

    @Override
    public ItemManager getItemManager() {
        return null;
    }

    @Override
    public TFCCoreAdapter getTFCCoreAdapter() {
        return null;
    }
}
