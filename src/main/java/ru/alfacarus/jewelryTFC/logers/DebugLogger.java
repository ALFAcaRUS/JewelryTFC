package ru.alfacarus.jewelryTFC.logers;

import cpw.mods.fml.common.FMLLog;
import org.apache.logging.log4j.Level;
import ru.alfacarus.jewelryTFC.SettingsManager;

public class DebugLogger extends BaseLogger {

	public DebugLogger(SettingsManager settingsManager) {
		super(settingsManager);
	}

	@Override
	public void debugLogMessage(String text, Object data){
		FMLLog.log(settingsManager.getModId(), Level.INFO, text, data);
	}

	@Override
	public void debugLogMessage(String text){
		FMLLog.log(settingsManager.getModId(), Level.INFO, text, null);
	}

	/**
	 * Additional information.
	 * Will be write only if debug is true
	 *
	 * @param text text of message
	 * @param data some data
	 */
	@Override
	public void additionalLog(String text, Object data) {
		FMLLog.log(settingsManager.getModId(), Level.INFO, text, data);
	}

	/**
	 * Additional information.
	 * Will be write only if debug is true
	 *
	 * @param text text of message
	 */
	@Override
	public void additionalLog(String text) {
		FMLLog.log(settingsManager.getModId(), Level.INFO, text, null);
	}

}
