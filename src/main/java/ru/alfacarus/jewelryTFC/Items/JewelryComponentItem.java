package ru.alfacarus.jewelryTFC.Items;

import com.bioxx.tfc.api.Enums.EnumSize;
import com.bioxx.tfc.api.Enums.EnumWeight;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import ru.alfacarus.jewelryTFC.effects.AbstractEffect;
import ru.alfacarus.jewelryTFC.utils.ILoadingFactory;

import java.util.List;

public class JewelryComponentItem extends BaseItem {
    private int bonus;
    private Item material;
    private AbstractEffect effect;
    private ComponentType type;

    public JewelryComponentItem(ILoadingFactory loadingFactory, AbstractEffect effect, String name, ComponentType type) {
        super(loadingFactory);
        this.setUnlocalizedName(name);
        this.size = EnumSize.TINY;
        this.weight = EnumWeight.LIGHT;
        this.effect = effect;
        this.bonus = 0;
        this.type = type;
        this.setFolder(type.getTextureFolder());
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public Item getMaterial() {
        return material;
    }

    public void setMaterial(Item material) {
        this.material = material;
    }

    public AbstractEffect getEffect() {
        return effect;
    }

    public void setEffect(AbstractEffect effect) {
        this.effect = effect;
    }

    public ComponentType getType(){
        return this.type;
    }

    /**
     * gets the CreativeTab this bonusMaterial is displayed on
     */
    @Override
    public CreativeTabs getCreativeTab() {
        return runtimeFactory.getSettingsManager().getCreativeTab();
    }

    @Override
    public void addInformation(ItemStack is, EntityPlayer player, List arraylist, boolean flag) {
        if(null != effect){
            arraylist.add(effect.getName());
        }
        super.addInformation(is, player, arraylist, flag);
    }
}
