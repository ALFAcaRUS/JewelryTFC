package support_objects.BlockMaps;

import javafx.geometry.Point3D;
import minecraft_mocks.BlockMock;
import net.minecraft.block.Block;


/**
 *
 */
public class CubeBlockMap extends BaseBlockMap{

    public CubeBlockMap(int sizeX, int sizeY, int sizeZ) {
        super(sizeX, sizeY, sizeZ);
    }

    @Override
    public void fillMap() {
        for (int i = 0; i < mapSizeX; ++i){
            for (int j = 0; j < mapSizeX; ++j) {
                for (int k = 0; k < mapSizeX; ++k) {
                    this.setBlock(new BlockMock(), i, j, k);

                }
            }
        }
    }

    public void createCube(Point3D pos, Point3D size, Block block){
        for (int i = (int)pos.getX(); i < pos.getX() + size.getX(); ++i){
            for (int j = (int)pos.getY(); j < pos.getY() + size.getY(); ++j) {
                for (int k = (int)pos.getZ(); k < pos.getZ() + size.getZ(); ++k) {
                    this.setBlock(block, i, j, k);
                }
            }
        }

    }
}
