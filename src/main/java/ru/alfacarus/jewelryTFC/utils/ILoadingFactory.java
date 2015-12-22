package ru.alfacarus.jewelryTFC.utils;

import com.bioxx.tfc.api.Crafting.AnvilManager;

/**
 * Construct objects on loading.
 */
public interface ILoadingFactory {

    /**
     * Get instance of IRuntimeFactory (RuntimeFactory by default)
     *
     * @return
     */
    IRuntimeFactory getRuntimeFactory();

    AnvilManager getAnvilManager();

    EffectManager getEffectManager();
}
