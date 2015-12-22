package ru.alfacarus.jewelryTFC.Items.jewelrys;

import baubles.api.BaubleType;
import net.minecraft.item.ItemStack;
import ru.alfacarus.jewelryTFC.effects.AbstractEffect;
import ru.alfacarus.jewelryTFC.utils.ILoadingFactory;

public class BeltJewelry extends Jewelry{
    public BeltJewelry(ILoadingFactory loadingFactory, AbstractEffect effect, String name) {
        super(loadingFactory, effect, name);
        this.setFolder("belts");
    }

    @Override
    public BaubleType getBaubleType(ItemStack itemStack) {
        return BaubleType.BELT;
    }
}
