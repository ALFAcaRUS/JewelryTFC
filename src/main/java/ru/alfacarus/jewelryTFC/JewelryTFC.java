package ru.alfacarus.jewelryTFC;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.MinecraftForge;
import ru.alfacarus.jewelryTFC.effects.*;
import ru.alfacarus.jewelryTFC.eventHandlers.ForgeEventHandler;
import ru.alfacarus.jewelryTFC.strategies.*;
import ru.alfacarus.jewelryTFC.utils.*;
import ru.alfacarus.jewelryTFC.eventHandlers.VanillaEventsHandler;
import ru.alfacarus.jewelryTFC.logers.BaseLogger;
import ru.alfacarus.jewelryTFC.tabs.JewelryCreativeTab;

@Mod(modid = JewelryTFC.MODID, version = JewelryTFC.VERSION)
public class JewelryTFC {
    public static final String MODID = "jewelry_tfc";
    public static final String VERSION = "1.0";
    private ILoadingFactory loadingFactory;

    @EventHandler
    public void preLoad(FMLPreInitializationEvent event)
    {
        loadingFactory = new LoadingFactory(MODID, event.getSuggestedConfigurationFile());
        IRuntimeFactory runtimeFactory = loadingFactory.getRuntimeFactory();
        BaseLogger logger = runtimeFactory .getLogger();
        logger.generalLog("Start mod loading.");

        EffectManager effectManager = loadingFactory.getEffectManager();
        effectManager.addEffect(GlobalConstants.INTUITION_EFFECT_NAME, new IntuitionEffect(loadingFactory));
        effectManager.addEffect(GlobalConstants.MOB_PROTECTION_EFFECT_NAME, new MobProtectionEffect(loadingFactory));
        effectManager.addEffect(GlobalConstants.SPEED_EFFECT_NAME, new SpeedEffect(loadingFactory));
        effectManager.addEffect(GlobalConstants.REMOVE_POTION_EFFECT_NAME, new RemovePotionEffect(loadingFactory));
        effectManager.addEffect(GlobalConstants.HEALING_EFFECT_NAME, new HealingEffect(loadingFactory));
        effectManager.addEffect(GlobalConstants.EXPERIENCE_EFFECT_NAME, new ExperienceEffect(loadingFactory));
        effectManager.addEffect(GlobalConstants.SKILL_EFFECT_NAME, new SkillEffect(loadingFactory));
        effectManager.addEffect(GlobalConstants.WATER_EFFECT_NAME, new WaterEffect(loadingFactory));

        //Register event handlers
        MinecraftForge.EVENT_BUS.register(new VanillaEventsHandler());
        MinecraftForge.EVENT_BUS.register(new ForgeEventHandler(runtimeFactory));
        effectManager.registryEffects();

        runtimeFactory.getSettingsManager().setCreativeTab(new JewelryCreativeTab("Jewelry", runtimeFactory.getItemManager()));

        // For finish
        logger.generalLog("Jewelry craft successful loaded");
    }

    @EventHandler
    public void load(FMLInitializationEvent event){

        IRuntimeFactory runtimeFactory = loadingFactory.getRuntimeFactory();

        // loading items
        runtimeFactory.getLogger().additionalLog("Loading items");
        ItemManager itemManager = runtimeFactory.getItemManager();

        //add strategies
        itemManager.addStrategy(new BaseComponentsStrategy(loadingFactory));
        itemManager.addStrategy(new OneGemComponentStrategy(loadingFactory));
        itemManager.addStrategy(new TreeGemComponentStrategy(loadingFactory));
        itemManager.addStrategy(new RingsStrategy(loadingFactory));
        itemManager.addStrategy(new AmuletStrategy(loadingFactory));
        itemManager.addStrategy(new BeltStrategy(loadingFactory));

        //fill items
        itemManager.fillItemsByStrategies();
        itemManager.registerItems();
        itemManager.registerRecipes();
    }
}
