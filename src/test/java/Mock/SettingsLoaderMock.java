package Mock;

import Mock.utils.RuntimeFactoryMock;
import net.minecraft.creativetab.CreativeTabs;
import ru.alfacarus.jewelryTFC.SettingsManager;
import ru.alfacarus.jewelryTFC.utils.ILoadingFactory;
import ru.alfacarus.jewelryTFC.utils.IRuntimeFactory;

import java.io.File;

public class SettingsLoaderMock extends SettingsManager {

    public RuntimeFactoryMock runtimeFactory;

    public SettingsLoaderMock() {
    }

    public SettingsLoaderMock(String modid, File file, ILoadingFactory loadingFactory) {
    }

    @Override
    public String getModId(){
        return "jewelry_tfc";
    }

    /**
     * Get current creative tab
     *
     * @return CreativeTab
     */
    @Override
    public CreativeTabs getCreativeTab() {
        return super.getCreativeTab();
    }

    @Override
    public boolean checkRecipe(String recipeName) {
        return false;
    }

    @Override
    public IRuntimeFactory getRuntimeFactory() {
        if (this.runtimeFactory == null) this.runtimeFactory = new RuntimeFactoryMock();
        return this.runtimeFactory;
    }

    @Override
    public void setCreativeTab(CreativeTabs ct) {
        super.setCreativeTab(ct);
    }
}
