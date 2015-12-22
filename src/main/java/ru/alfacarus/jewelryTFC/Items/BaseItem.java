package ru.alfacarus.jewelryTFC.Items;

import com.bioxx.tfc.Items.ItemTerra;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import ru.alfacarus.jewelryTFC.utils.ILoadingFactory;
import ru.alfacarus.jewelryTFC.utils.IRuntimeFactory;

/**
 * Correct some flubs in terrafirmacraft API
 */
public class BaseItem extends ItemTerra{
    protected IRuntimeFactory runtimeFactory;

    public BaseItem(ILoadingFactory loadingFactory){
        this.runtimeFactory = loadingFactory.getRuntimeFactory();
    }

    @Override
    public void registerIcons(IIconRegister registerer) {
        if(this.metaNames == null) {
            if(this.iconString != null) {
                this.itemIcon = registerer.registerIcon(this.getIconString());
            } else {
                if (null != this.textureFolder && "" != this.textureFolder) {
                    this.itemIcon = registerer.registerIcon("jewelry_tfc:" + this.textureFolder + "/" + this.getUnlocalizedName().replace("item.", ""));
                } else {
                    this.itemIcon = registerer.registerIcon("jewelry_tfc:" + this.getUnlocalizedName().replace("item.", ""));
                }
            }
        } else {
            this.metaIcons = new IIcon[this.metaNames.length];

            for(int i = 0; i < this.metaNames.length; ++i) {
                if (null != this.textureFolder && "" != this.textureFolder) {
                    this.metaIcons[i] = registerer.registerIcon("jewelry_tfc:" + this.textureFolder + "/" + this.metaNames[i]);
                } else {
                    this.metaIcons[i] = registerer.registerIcon("jewelry_tfc:" + this.metaNames[i]);
                }
            }

            this.itemIcon = this.metaIcons[0];
        }

    }
}
