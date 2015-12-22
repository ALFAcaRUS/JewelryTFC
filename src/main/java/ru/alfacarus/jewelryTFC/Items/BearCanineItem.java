package ru.alfacarus.jewelryTFC.Items;

import com.bioxx.tfc.api.Enums.EnumSize;
import com.bioxx.tfc.api.Enums.EnumWeight;
import ru.alfacarus.jewelryTFC.SettingsManager;
import ru.alfacarus.jewelryTFC.utils.ILoadingFactory;

public class BearCanineItem extends BaseItem{


    public BearCanineItem(ILoadingFactory loadingFactory){
        super(loadingFactory);
        this.setUnlocalizedName("Bear canine");
        this.setCreativeTab(runtimeFactory.getSettingsManager().getCreativeTab());
        this.setTextureName("jewelry_tfc:bear_canine");
        this.size = EnumSize.TINY;
        this.weight = EnumWeight.LIGHT;
    }

}
