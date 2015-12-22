package ru.alfacarus.jewelryTFC.Items;

import com.bioxx.tfc.Items.ItemQuiver;
import net.minecraft.client.renderer.texture.IIconRegister;

/**
 *
 */
public class BeltQuiverItem extends ItemQuiver {

    @Override
    public void registerIcons(IIconRegister registerer) {
        this.itemIcon = registerer.registerIcon("jewelry_tfc:belt_quiver");
    }
}
