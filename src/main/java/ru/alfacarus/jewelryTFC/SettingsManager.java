package ru.alfacarus.jewelryTFC;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.config.Configuration;
import ru.alfacarus.jewelryTFC.utils.ILoadingFactory;
import ru.alfacarus.jewelryTFC.utils.IRuntimeFactory;

import java.io.File;

/** 
 * 
 * Class for settings work 
 *
 */
public class SettingsManager {
	private static Configuration conf;
	private String modId;
	private boolean debug;
	private CreativeTabs creativeTab;
	private IRuntimeFactory runtimeFactory;

	protected SettingsManager(){

	}
	
	public SettingsManager(String modId, File file, ILoadingFactory loadingFactory){
		this.modId = modId;
		conf = new Configuration(file);

		this.debug = conf.getBoolean("debug", Categories.Main.getName(), false, "");
		this.runtimeFactory = loadingFactory.getRuntimeFactory();

		conf.save();
	}

	/**
	 * @return Mod Id. Mod class don't mast contain settings when have
	 * special class for it.
	 */
	public String getModId() {
		return this.modId;
	}

	public boolean isDebug(){
		return debug;
	}

	/**
	 * Get current creative tab
	 *
	 * @return CreativeTab
	 */
	public CreativeTabs getCreativeTab() {
		return creativeTab;
	}

	public boolean checkRecipe(String recipeName){
		return conf.getBoolean(recipeName, Categories.Recipes.getName(), true, "");
	}

	public IRuntimeFactory getRuntimeFactory(){
		return this.runtimeFactory;
	}

	public void setCreativeTab(CreativeTabs ct){
		this.creativeTab = ct;
	}

	/**
	 * Categories of settings
	 */
	private enum Categories{
		Main("Main"),
		Recipes("Recipes");

		private String name;

		Categories(String name) {
			this.name = name;
		}

		public String getName(){
			return name;
		}
	}
}
