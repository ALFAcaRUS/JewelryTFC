package ru.alfacarus.jewelryTFC.utils;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.world.World;

/**
 * Interface for incapsulation access to Minecraft.
 * Give a chance to use mock objects between Minecraft in unit test.
 */
public class MinecraftAdapter {
    /**
     * @return Mincraft
     */
    public Minecraft getMinecraft() {
        return Minecraft.getMinecraft();
    }

    /**
     * Get block by cords
     *
     * @param posX
     * @param posY
     * @param posZ
     * @return Block
     */
    public Block getBlock(int posX, int posY, int posZ) {
        return this.getMinecraft().theWorld.getBlock(posX, posY, posZ);
    }

    public World getWorld(){
        return this.getMinecraft().theWorld;
    }
}
