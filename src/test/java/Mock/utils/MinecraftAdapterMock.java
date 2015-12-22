package Mock.utils;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.world.World;
import ru.alfacarus.jewelryTFC.utils.MinecraftAdapter;
import support_objects.BlockMaps.BaseBlockMap;

/**
 *
 */
public class MinecraftAdapterMock extends MinecraftAdapter {

    public BaseBlockMap blockMap;

    public MinecraftAdapterMock() {
    }

    public MinecraftAdapterMock(BaseBlockMap blockMap) {
        this.blockMap = blockMap;
    }

    /**
     * @return Mincraft
     */
    @Override
    public Minecraft getMinecraft() {
        return null;
    }

    /**
     * Get block by cords
     *
     * @param posX
     * @param posY
     * @param posZ
     * @return Block
     */
    @Override
    public Block getBlock(int posX, int posY, int posZ) {
        if (null == blockMap) return null;
        return blockMap.getBlock(posX, posY, posZ);
    }

    @Override
    public World getWorld() {
        return null;
    }
}
