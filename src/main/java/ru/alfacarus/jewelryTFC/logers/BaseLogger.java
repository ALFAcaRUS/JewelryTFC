package ru.alfacarus.jewelryTFC.logers;

import org.apache.logging.log4j.Level;

import ru.alfacarus.jewelryTFC.SettingsManager;
import cpw.mods.fml.common.FMLLog;

/**
 * 
 * Encapsulates logic work with loger 
 *
 */
public class BaseLogger {
	protected SettingsManager settingsManager;

	public BaseLogger(SettingsManager settingsManager){
		this.settingsManager = settingsManager;
	}

	/** 
	 * 
	 * Add debugLogMessage message with info level
	 * 
	 * @param text text of the message
	 * @param data some data
	 */
	public void generalLog(String text, Object data){
		FMLLog.log(settingsManager.getModId(), Level.INFO, text, data);
	}

	/**
	 *
	 * Add debugLogMessage message with info level
	 *
	 * @param text text of the message
	 */
	public void generalLog(String text){
		FMLLog.log(settingsManager.getModId(), Level.INFO, text, null);
	}
	
	/** 
	 * 
	 * Add debugLogMessage message with error level
	 * 
	 * @param text text of the message
	 * @param data some data
	 */
	public void errorLog(String text, Object data){
		FMLLog.log(settingsManager.getModId(), Level.ERROR, text, data);
	}
	
	/** 
	 * 
	 * Add debugLogMessage message
	 *  @param text text of the message
	 * @param data some data
	 */
	public void debugLogMessage(String text, Object data){
	}

	/**
	 *
	 * Add debugLogMessage message
	 *
	 * @param text text of the message
	 */
	public void debugLogMessage(String text){
	}

	/**
	 * Additional information.
	 * Will be write only if debug is true
	 *
	 * @param text text of message
	 * @param data some data
     */
	public void additionalLog(String text, Object data){

	}

	/**
	 * Additional information.
	 * Will be write only if debug is true
	 *
	 * @param text text of message
     */
	public void additionalLog(String text){

	}
}
