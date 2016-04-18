package ru.alfacarus.jewelryTFC.strategies;

import com.bioxx.tfc.api.Crafting.AnvilManager;
import com.bioxx.tfc.api.Crafting.AnvilRecipe;
import com.bioxx.tfc.api.Crafting.AnvilReq;
import com.bioxx.tfc.api.Crafting.PlanRecipe;
import com.bioxx.tfc.api.Enums.RuleEnum;
import com.bioxx.tfc.api.TFCItems;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import ru.alfacarus.jewelryTFC.Items.ComponentType;
import ru.alfacarus.jewelryTFC.Items.JewelryComponentItem;
import ru.alfacarus.jewelryTFC.tabs.JewelryCreativeTab;
import ru.alfacarus.jewelryTFC.utils.ILoadingFactory;
import ru.alfacarus.jewelryTFC.utils.ItemManager;

import java.util.LinkedList;
import java.util.List;

public class BaseComponentsStrategy extends AbstractStrategy{
    private final static String COULOMB_PLAN_NAME = "coulomb";
    private final static String CHAIN_PLAN_NAME = "chain";
    private final static String CLASP_PLAN_NAME = "clasp";
    private final static String RING_PLAN_NAME = "ring";
    private List<String> recipes;

    public BaseComponentsStrategy(ILoadingFactory loadingFactory) {
        super(loadingFactory);
        recipes = new LinkedList();
    }

    @Override
    public void createItems(ItemManager manager) {
        // metal items
        registryMetalItem(manager, new JewelryComponentItem(loadingFactory , null, "gold_coulomb", ComponentType.COULOMB), TFCItems.goldIngot);
        registryMetalItem(manager, new JewelryComponentItem(loadingFactory , null, "silver_coulomb", ComponentType.COULOMB), TFCItems.silverIngot);
        registryMetalItem(manager, new JewelryComponentItem(loadingFactory , null, "gold_chain", ComponentType.CHAIN), TFCItems.goldIngot);
        registryMetalItem(manager, new JewelryComponentItem(loadingFactory , null, "silver_chain", ComponentType.CHAIN), TFCItems.silverIngot);
        registryMetalItem(manager, new JewelryComponentItem(loadingFactory , null, "gold_clasp", ComponentType.CLASP), TFCItems.goldIngot);
        registryMetalItem(manager, new JewelryComponentItem(loadingFactory , null, "silver_clasp", ComponentType.CLASP), TFCItems.silverIngot);
        registryMetalItem(manager, new JewelryComponentItem(loadingFactory , null, "gold_ring", ComponentType.RING), TFCItems.goldIngot);
        registryMetalItem(manager, new JewelryComponentItem(loadingFactory , null, "silver_ring", ComponentType.RING), TFCItems.silverIngot);

        // other items
        JewelryComponentItem newItem;

        newItem = new JewelryComponentItem(loadingFactory, null, "jute_rope", ComponentType.CHAIN);
        registryItem(manager, newItem, TFCItems.juteFiber);
        manager.addRecipe(new ItemStack(newItem), new Object[] {" m ", "m m", " m ", 'm', newItem.getMaterial()});

        newItem = new JewelryComponentItem(loadingFactory, null, "wool_rope", ComponentType.CHAIN);
        registryItem(manager, newItem, TFCItems.woolYarn);
        manager.addRecipe(new ItemStack(newItem), new Object[] {" m ", "m m", " m ", 'm', newItem.getMaterial()});

        newItem = new JewelryComponentItem(loadingFactory, null, "belt", ComponentType.BELT);
        registryItem(manager, newItem, TFCItems.leather);
        manager.addRecipe(new ItemStack(newItem), new Object[] {"mmm", "www", "mmm", 'm', newItem.getMaterial(), 'w', TFCItems.woolCloth});

        JewelryCreativeTab creativeTab = (JewelryCreativeTab) loadingFactory.getRuntimeFactory().getSettingsManager().getCreativeTab();
        creativeTab.setItemName(newItem.getUnlocalizedName());
    }

    @Override
    public void registerAnvilRecipes(ItemManager manager) {
        AnvilManager anvilManager = loadingFactory.getAnvilManager();
        anvilManager.addPlan(COULOMB_PLAN_NAME, new PlanRecipe(new RuleEnum[] {RuleEnum.HITANY, RuleEnum.HITANY, RuleEnum.HITANY}));
        anvilManager.addPlan(CHAIN_PLAN_NAME, new PlanRecipe(new RuleEnum[] {RuleEnum.HITANY, RuleEnum.HITANY, RuleEnum.HITANY}));
        anvilManager.addPlan(CLASP_PLAN_NAME, new PlanRecipe(new RuleEnum[] {RuleEnum.HITANY, RuleEnum.HITANY, RuleEnum.HITANY}));
        anvilManager.addPlan(RING_PLAN_NAME, new PlanRecipe(new RuleEnum[] {RuleEnum.HITANY, RuleEnum.HITANY, RuleEnum.HITANY}));
        anvilManager.addPlan("just_do_it", new PlanRecipe(new RuleEnum[] {RuleEnum.HITANY, RuleEnum.HITANY, RuleEnum.HITANY}));

        for(String recipe: recipes){
            JewelryComponentItem item = (JewelryComponentItem) manager.getItemByName(recipe);
            Item material = item.getMaterial();
            anvilManager.addRecipe(new AnvilRecipe(new ItemStack(material) , null, getPlanName(item.getType()), false, AnvilReq.BRONZE, new ItemStack(item)).addRecipeSkill("skill.toolsmith"));
        }
    }

    private void registryMetalItem(ItemManager manager, JewelryComponentItem newItem, Item material){
        newItem.setMaterial(material);
        manager.addItem(newItem);

        recipes.add(newItem.getUnlocalizedName());
    }

    private void registryItem(ItemManager manager, JewelryComponentItem newItem, Item material){
        newItem.setMaterial(material);
        manager.addItem(newItem);
    }

    private String getPlanName(ComponentType type){
        switch (type){
            case COULOMB: return COULOMB_PLAN_NAME;
            case CLASP: return CLASP_PLAN_NAME;
            case CHAIN: return CHAIN_PLAN_NAME;
            case RING: return RING_PLAN_NAME;
		default:
			break;
        }
        return "just_do_it";
    }
}
