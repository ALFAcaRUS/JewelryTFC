package ru.alfacarus.jewelryTFC.utils;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import ru.alfacarus.jewelryTFC.strategies.AbstractStrategy;

import java.util.*;

/**
 * Class contains all items in mod.
 */
public class ItemManager {
    private IRuntimeFactory factory;
    private List <AbstractStrategy> strategies;
    private Map<String, Item> itemMap;
    private List<Recipe> recipes;
    private List<Recipe> shapedRecipes;

    public ItemManager(ILoadingFactory factory){
        this.factory = factory.getRuntimeFactory();
        this.strategies = new ArrayList();
        this.itemMap = new LinkedHashMap();
        this.recipes = new LinkedList();
        this.shapedRecipes = new LinkedList();
    }

    public void addStrategy(AbstractStrategy strategy){
        this.strategies.add(strategy);
    }

    public void removeStrategy(AbstractStrategy strategy){
        this.strategies.remove(strategy);
    }

    public void fillItemsByStrategies(){
        for(AbstractStrategy strategy: this.strategies){
            strategy.createItems(this);
        }
    }

    public void addItem(Item item){
        this.itemMap.put(item.getUnlocalizedName(), item);
    }

    public Item getItemByName(String name){
        return this.itemMap.get(name);
    }

    public Collection<Item> getItems(){
        return this.itemMap.values();
    }

    public void registerItems(){
        for (Item item: this.itemMap.values()){
            GameRegistry.registerItem(item, item.getUnlocalizedName());
        }
    }

    public void registerAnvilRecipes(){
        for(AbstractStrategy strategy: strategies){
            strategy.registerAnvilRecipes(this);
        }
    }

    public void addRecipe(ItemStack result, Object[] craft){
        this.recipes.add(new Recipe(result, craft));
    }

    public void addRecipe(Recipe recipe){
        this.recipes.add(recipe);
    }

    public void addShapedRecipe(ItemStack result, Object[] craft){
        this.shapedRecipes.add(new Recipe(result, craft));
    }

    public void addShapedRecipe(Recipe recipe){
        this.shapedRecipes.add(recipe);
    }

    public void registerRecipes(){
        for (Recipe recipe: recipes){
            GameRegistry.addRecipe(recipe.getResult(), recipe.getCraft());
        }

        for (Recipe recipe: shapedRecipes){
            GameRegistry.addShapelessRecipe(recipe.getResult(), recipe.getCraft());
        }
    }
}
