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

import java.util.*;

public class OneGemComponentStrategy extends AbstractStrategy {
    protected List<Container> gemContainers;

    public OneGemComponentStrategy(ILoadingFactory loadingFactory) {
        super(loadingFactory);
        EffectManager effectManager = loadingFactory.getEffectManager();
        gemContainers = new ArrayList<>();
        gemContainers.add(new Container(TFCItems.gemAgate, effectManager.getEffectByName(GlobalConstants.SPEED_EFFECT_NAME), TFCItems.silverIngot));
        gemContainers.add(new Container(TFCItems.gemAmethyst, effectManager.getEffectByName(GlobalConstants.REMOVE_POTION_EFFECT_NAME), TFCItems.silverIngot));
        gemContainers.add(new Container(TFCItems.gemBeryl, null, TFCItems.goldIngot));
        gemContainers.add(new Container(TFCItems.gemDiamond, null, null));
        gemContainers.add(new Container(TFCItems.gemEmerald, null, TFCItems.silverIngot));
        gemContainers.add(new Container(TFCItems.gemGarnet, null, TFCItems.silverIngot));
        gemContainers.add(new Container(TFCItems.gemJade, effectManager.getEffectByName(GlobalConstants.SKILL_EFFECT_NAME), TFCItems.goldIngot));
        gemContainers.add(new Container(TFCItems.gemJasper, null, TFCItems.goldIngot));
        gemContainers.add(new Container(TFCItems.gemOpal, effectManager.getEffectByName(GlobalConstants.MOB_PROTECTION_EFFECT_NAME), TFCItems.goldIngot));
        gemContainers.add(new Container(TFCItems.gemRuby, null, TFCItems.goldIngot));
        gemContainers.add(new Container(TFCItems.gemSapphire, effectManager.getEffectByName(GlobalConstants.HEALING_EFFECT_NAME), TFCItems.silverIngot));
        gemContainers.add(new Container(TFCItems.gemTopaz, effectManager.getEffectByName(GlobalConstants.EXPERIENCE_EFFECT_NAME), TFCItems.goldIngot));
        gemContainers.add(new Container(TFCItems.gemTourmaline, null, TFCItems.goldIngot));
    }

    @Override
    public void createItems(ItemManager manager) {
        List<Item> itemList = new LinkedList();
        Collection items = manager.getItems();
        for(Object item: items){
            if(item instanceof JewelryComponentItem){
                addItems((JewelryComponentItem) item, manager, itemList);
            }
        }

        for (Item item: itemList){
            manager.addItem(item);
        }
    }

    protected void addRecipe(ItemManager manager, Item newItem, Item baseItem, Item gem, int damage){
        ItemStack gemIS = new ItemStack(gem);
        gemIS.setItemDamage(damage);
        manager.addShapedRecipe(new ItemStack(newItem), new Object[] {new ItemStack(baseItem), gemIS});
    }

    protected void addItems(JewelryComponentItem item, ItemManager manager, List<Item> itemList){
        ComponentType newType = getNewComponentType(item.getType());
        if (null == newType) return;

        for(Container container: gemContainers){
            String name = (item.getUnlocalizedName() + "_"
                    + container.gem.getUnlocalizedName()).replaceAll("item.", "").toLowerCase();
            JewelryComponentItem newItem = new JewelryComponentItem(loadingFactory, container.effect, name, newType);
            newItem.setMaterial(item.getMaterial());
            itemList.add(newItem);

            if(container.bonusMaterial == item.getMaterial()){
                newItem.setBonus(1);
            }

            addRecipe(manager, newItem, item, container.gem, 3);
            addRecipe(manager, newItem, item, container.gem, 4);
        }
    }

    @Override
    public void registerAnvilRecipes(ItemManager manager) {

    }

    protected ComponentType getNewComponentType(ComponentType type){
        switch (type){
            case CLASP: return ComponentType.ONE_GEM_CLASP;
            case RING: return ComponentType.ONE_GEM_RING;
            case COULOMB: return ComponentType.ONE_GEM_COULOMB;
        }
        return null;
    }

    protected class Container{
        public Item gem;
        public AbstractEffect effect;
        public Item bonusMaterial;

        public Container(Item gem, AbstractEffect effect, Item bonusMaterial){
            this.gem = gem;
            this.effect = effect;
            this.bonusMaterial = bonusMaterial;
        }
    }
}
