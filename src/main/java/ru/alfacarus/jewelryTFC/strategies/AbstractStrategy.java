package ru.alfacarus.jewelryTFC.strategies;

import ru.alfacarus.jewelryTFC.utils.ILoadingFactory;
import ru.alfacarus.jewelryTFC.utils.ItemManager;

/**
 *
 */
public abstract class AbstractStrategy {
   protected ILoadingFactory loadingFactory;

   public AbstractStrategy(ILoadingFactory loadingFactory){
      this.loadingFactory = loadingFactory;
   }

   public abstract void createItems(ItemManager manager);
   public abstract void registerAnvilRecipes(ItemManager manager);
}
