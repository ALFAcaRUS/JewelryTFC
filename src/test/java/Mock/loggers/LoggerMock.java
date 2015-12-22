package Mock.loggers;

import ru.alfacarus.jewelryTFC.SettingsManager;
import ru.alfacarus.jewelryTFC.logers.BaseLogger;

/**
 */
public class LoggerMock extends BaseLogger{
    public LoggerMock(SettingsManager settingsManager) {
        super(settingsManager);
    }

    /**
     * Add debugLogMessage message with info level
     *
     * @param text text of the message
     * @param data some data
     */
    @Override
    public void generalLog(String text, Object data) {
    }

    /**
     * Add debugLogMessage message with info level
     *
     * @param text text of the message
     */
    @Override
    public void generalLog(String text) {
    }

    /**
     * Add debugLogMessage message with error level
     *
     * @param text text of the message
     * @param data some data
     */
    @Override
    public void errorLog(String text, Object data) {
    }

    /**
     * Add debugLogMessage message
     *  @param text  text of the message
     * @param data  some data
     */
    @Override
    public void debugLogMessage(String text, Object data) {
    }

    /**
     * Add debugLogMessage message
     *
     * @param text  text of the message
     */
    @Override
    public void debugLogMessage(String text) {
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
    }

    /**
     * Additional information.
     * Will be write only if debug is true
     *
     * @param text text of message
     */
    @Override
    public void additionalLog(String text) {
    }
}
