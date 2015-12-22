package ru.alfacarus.jewelryTFC.utils;

import com.bioxx.tfc.api.Crafting.AnvilManager;
import ru.alfacarus.jewelryTFC.SettingsManager;
import ru.alfacarus.jewelryTFC.logers.BaseLogger;
import ru.alfacarus.jewelryTFC.logers.DebugLogger;

import java.io.File;

/**
 *  Create objects at mod loading
 */
public class LoadingFactory implements ILoadingFactory {
    private IRuntimeFactory runtimeFactory;
    private EffectManager effectManager;

    public LoadingFactory(String modId, File settingsFile){
        SettingsManager settingsManager = new SettingsManager(modId, settingsFile, this);
        BaseLogger logger;
        if (settingsManager.isDebug()) {
            logger = new DebugLogger(settingsManager);
        } else {
            logger = new BaseLogger(settingsManager);
        }
        this.runtimeFactory = new RuntimeFactory(settingsManager, logger, new ItemManager(this));
        this.effectManager = new EffectManager();
    }

    /**
     * Get instance of IRuntimeFactory (RuntimeFactory by default)
     *
     * @return
     */
    @Override
    public IRuntimeFactory getRuntimeFactory() {
        return runtimeFactory;
    }

    @Override
    public AnvilManager getAnvilManager() {
        return AnvilManager.getInstance();
    }

    @Override
    public EffectManager getEffectManager() {
        return this.effectManager;
    }
}
