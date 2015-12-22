package ru.alfacarus.jewelryTFC.Items.jewelrys;

import baubles.api.BaubleType;
import net.minecraft.item.ItemStack;
import ru.alfacarus.jewelryTFC.effects.AbstractEffect;
import ru.alfacarus.jewelryTFC.utils.ILoadingFactory;

public class AmuletJewelry extends Jewelry {
    private static final String TEXTURE_FOLDER_NAME = "amulets";

    public AmuletJewelry(ILoadingFactory loadingFactory, AbstractEffect effect, String name) {
        super(loadingFactory, effect, name);
        this.setFolder(TEXTURE_FOLDER_NAME);
    }

    @Override
    public BaubleType getBaubleType(ItemStack itemStack) {
        return BaubleType.AMULET;
    }


}
