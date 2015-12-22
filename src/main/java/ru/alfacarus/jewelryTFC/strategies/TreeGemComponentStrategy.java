package ru.alfacarus.jewelryTFC.strategies;

import com.bioxx.tfc.api.TFCItems;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import ru.alfacarus.jewelryTFC.GlobalConstants;
import ru.alfacarus.jewelryTFC.Items.ComponentType;
import ru.alfacarus.jewelryTFC.Items.JewelryComponentItem;
import ru.alfacarus.jewelryTFC.effects.AbstractEffect;
import ru.alfacarus.jewelryTFC.utils.EffectManager;
import ru.alfacarus.jewelryTFC.utils.ILoadingFactory;
import ru.alfacarus.jewelryTFC.utils.ItemManager;

import java.util.HashMap;
import java.util.List;

public class TreeGemComponentStrategy extends OneGemComponentStrategy{
    protected HashMap<Item, AbstractEffect> bonusMap;

    public TreeGemComponentStrategy(ILoadingFactory loadingFactory) {
        super(loadingFactory);
        EffectManager manager = loadingFactory.getEffectManager();
        bonusMap = new HashMap<>();
        bonusMap.put(TFCItems.gemAgate, manager.getEffectByName(GlobalConstants.REMOVE_POTION_EFFECT_NAME));
        bonusMap.put(TFCItems.gemAmethyst, manager.getEffectByName(GlobalConstants.SPEED_EFFECT_NAME));
        bonusMap.put(TFCItems.gemBeryl, null);
        bonusMap.put(TFCItems.gemDiamond, null);
        bonusMap.put(TFCItems.gemEmerald, manager.getEffectByName(GlobalConstants.MOB_PROTECTION_EFFECT_NAME));
        bonusMap.put(TFCItems.gemGarnet, null);
        bonusMap.put(TFCItems.gemJade, manager.getEffectByName(GlobalConstants.EXPERIENCE_EFFECT_NAME));
        bonusMap.put(TFCItems.gemJasper, null);
        bonusMap.put(TFCItems.gemOpal, null);
        bonusMap.put(TFCItems.gemRuby, manager.getEffectByName(GlobalConstants.HEALING_EFFECT_NAME));
        bonusMap.put(TFCItems.gemTopaz, manager.getEffectByName(GlobalConstants.SKILL_EFFECT_NAME));
        bonusMap.put(TFCItems.gemTourmaline, null);
        bonusMap.put(TFCItems.gemSapphire, null);
    }

    @Override
    protected void addRecipe(ItemManager manager, Item newItem, Item baseItem, Item gem, int damage) {
        ItemStack gemsStack = new ItemStack(gem);
        gemsStack.setItemDamage(damage);
        manager.addRecipe(new ItemStack(newItem), new Object[]{"  g", " c ", "g  ", 'g', gemsStack, 'c', new ItemStack(baseItem)});
    }

    @Override
    protected void addItems(JewelryComponentItem item, ItemManager manager, List<Item> itemList) {
        ComponentType type = getNewComponentType(item.getType());
        if(null == type) return;

        for (Item gem: bonusMap.keySet()){
            String name = (item.getUnlocalizedName() + "_"
                    + gem.getUnlocalizedName()).replaceAll("item.", "").toLowerCase();
            JewelryComponentItem newItem = new JewelryComponentItem(loadingFactory, item.getEffect(), name, type);

            if(item.getEffect() == bonusMap.get(gem)){
                newItem.setBonus(item.getBonus() + 1);
            }

            itemList.add(newItem);

            addRecipe(manager, newItem, item, gem, 1);
            addRecipe(manager, newItem, item, gem, 2);
        }
    }

    @Override
    protected ComponentType getNewComponentType(ComponentType type) {
        switch (type){
            case ONE_GEM_CLASP: return ComponentType.THREE_GEM_CLASP;
            case ONE_GEM_COULOMB: return ComponentType.THREE_GEM_COULOMB;
        }
        return null;
    }
}
