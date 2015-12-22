package Mock.utils;

import Mock.loggers.LoggerMock;
import com.bioxx.tfc.api.Crafting.AnvilManager;
import ru.alfacarus.jewelryTFC.logers.BaseLogger;
import ru.alfacarus.jewelryTFC.utils.EffectManager;
import ru.alfacarus.jewelryTFC.utils.ILoadingFactory;
import ru.alfacarus.jewelryTFC.utils.IRuntimeFactory;

/**
 *
 */
public class LoadingFactoryMock implements ILoadingFactory {

    /**
     * Get instance of IRuntimeFactory (RuntimeFactory by default)
     *
     * @return
     */
    @Override
    public IRuntimeFactory getRuntimeFactory() {
        return new RuntimeFactoryMock();
    }

    @Override
    public AnvilManager getAnvilManager() {
        return null;
    }

    @Override
    public EffectManager getEffectManager() {
        return null;
    }
}
