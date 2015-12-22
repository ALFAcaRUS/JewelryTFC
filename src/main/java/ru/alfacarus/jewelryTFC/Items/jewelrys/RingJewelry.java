package ru.alfacarus.jewelryTFC.Items.jewelrys;

import baubles.api.BaubleType;
import net.minecraft.item.ItemStack;
import ru.alfacarus.jewelryTFC.effects.AbstractEffect;
import ru.alfacarus.jewelryTFC.utils.ILoadingFactory;

public class RingJewelry extends Jewelry{
    public RingJewelry(ILoadingFactory loadingFactory, AbstractEffect effect, String name) {
        super(loadingFactory, effect, name);
        this.setFolder("three_gem_rings");
    }

    @Override
    public BaubleType getBaubleType(ItemStack itemStack) {
        return BaubleType.RING;
    }
}
