package support_objects.BlockMaps;

import net.minecraft.block.Block;

/**
 *
 */
public abstract class BaseBlockMap {
    protected Block [] map;
    protected int mapSizeX;
    protected int mapSizeY;
    protected int mapSizeZ;

    public BaseBlockMap(int sizeX, int sizeY, int sizeZ){
        this.mapSizeX = sizeX;
        this.mapSizeY = sizeY;
        this.mapSizeZ = sizeZ;
        map = new Block[sizeX*sizeY*sizeZ];
    }

    public abstract void fillMap();

    public final Block getBlock(int x, int y, int z){
        return map[z * mapSizeX * mapSizeY + y * mapSizeX + x];
    }

    public final void setBlock(Block block, int x, int y, int z){
        map[z * mapSizeX * mapSizeY + y * mapSizeX + x] = block;
    }
}
