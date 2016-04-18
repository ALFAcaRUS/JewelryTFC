package ru.alfacarus.jewelryTFC.strategies;

import com.bioxx.tfc.api.TFCItems;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import ru.alfacarus.jewelryTFC.GlobalConstants;
import ru.alfacarus.jewelryTFC.Items.ComponentType;
import ru.alfacarus.jewelryTFC.Items.JewelryComponentItem;
import ru.alfacarus.jewelryTFC.Items.jewelrys.AmuletJewelry;
import ru.alfacarus.jewelryTFC.effects.AbstractEffect;
import ru.alfacarus.jewelryTFC.utils.EffectManager;
import ru.alfacarus.jewelryTFC.utils.ILoadingFactory;
import ru.alfacarus.jewelryTFC.utils.ItemManager;

import java.util.HashMap;
import java.util.LinkedList;

public class AmuletStrategy extends AbstractStrategy{

    public AmuletStrategy(ILoadingFactory loadingFactory) {
        super(loadingFactory);
    }

    @Override
    public void createItems(ItemManager manager) {
        HashMap<AbstractEffect, Item> bonusMap = getBonusMap();
        LinkedList<JewelryComponentItem> chains = new LinkedList<>();
        LinkedList<JewelryComponentItem> coulombs = new LinkedList<>();

        for (Item item: manager.getItems()){
            if(item instanceof JewelryComponentItem){
                if(((JewelryComponentItem) item).getType() == ComponentType.CHAIN){
                    chains.add((JewelryComponentItem) item);
                }
                if(((JewelryComponentItem) item).getType() == ComponentType.THREE_GEM_COULOMB){
                    coulombs.add((JewelryComponentItem) item);
                }
            }
        }

        for(JewelryComponentItem chain: chains){
            for(JewelryComponentItem coulomb: coulombs){
                String name = (coulomb.getUnlocalizedName() + "_"
                    + chain.getUnlocalizedName()).replaceAll("item.", "").toLowerCase();
                AmuletJewelry newItem = new AmuletJewelry(loadingFactory, coulomb.getEffect(), name);
                newItem.setBonus(coulomb.getBonus());

                if(bonusMap.get(newItem.getEffect()) == chain.getMaterial()){
                    newItem.setBonus(newItem.getBonus() + 1);
                }

                manager.addItem(newItem);
                manager.addShapedRecipe(new ItemStack(newItem), new Object[]{chain, coulomb});
            }
        }
    }

    protected HashMap<AbstractEffect, Item> getBonusMap(){
        EffectManager effectManager = loadingFactory.getEffectManager();
        HashMap<AbstractEffect, Item> map = new HashMap<>();
        map.put(effectManager.getEffectByName(GlobalConstants.MOB_PROTECTION_EFFECT_NAME), TFCItems.goldIngot);
        map.put(effectManager.getEffectByName(GlobalConstants.SPEED_EFFECT_NAME), TFCItems.silverIngot);
        map.put(effectManager.getEffectByName(GlobalConstants.REMOVE_POTION_EFFECT_NAME), TFCItems.silverIngot);
        map.put(effectManager.getEffectByName(GlobalConstants.HEALING_EFFECT_NAME), TFCItems.silverIngot);
        map.put(effectManager.getEffectByName(GlobalConstants.EXPERIENCE_EFFECT_NAME), TFCItems.goldIngot);
        map.put(effectManager.getEffectByName(GlobalConstants.SKILL_EFFECT_NAME), TFCItems.goldIngot);
        return map;
    }

    @Override
    public void registerAnvilRecipes(ItemManager manager) {

    }
}
