package ru.alfacarus.jewelryTFC.utils;

import cpw.mods.fml.common.eventhandler.EventBus;
import ru.alfacarus.jewelryTFC.effects.AbstractEffect;

import java.util.HashMap;

public class EffectManager {
    private HashMap<String, AbstractEffect> effects;

    public EffectManager(){
        this.effects = new HashMap();
    }

    public void addEffect(String name, AbstractEffect effect){
        effects.put(name, effect);
        effect.setName(name);
    }

    public AbstractEffect getEffectByName(String name){
        return effects.get(name);
    }

    public void registryEffects(){
        for(AbstractEffect effect: effects.values()){
            EventBus eventBus = effect.getEventBus();
            if(null != eventBus){
                eventBus.register(effect);
            }
        }
    }
}
