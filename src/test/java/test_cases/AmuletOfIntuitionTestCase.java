package test_cases;

import Mock.SettingsLoaderMock;
import Mock.terrafirmacraft.OreMock;
import Mock.utils.MinecraftAdapterMock;
import Mock.utils.RuntimeFactoryMock;
import javafx.geometry.Point3D;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

import ru.alfacarus.jewelryTFC.SettingsManager;
import support_objects.BlockMaps.CubeBlockMap;

/**
 *
 */
public class AmuletOfIntuitionTestCase extends Assert{

    @Before
    public void init(){
        new SettingsLoaderMock();
    }

    @Test
    public void mainTest(){
//        EntityPlayer playerMock = mock(EntityPlayer.class);
//        int mapSize = 50;
//        CubeBlockMap map = new CubeBlockMap(mapSize, mapSize, mapSize);
//        map.fillMap();
//        RuntimeFactoryMock factory = (RuntimeFactoryMock) ((SettingsLoaderMock)SettingsManager.getInstance()).getRuntimeFactory();
//
//        MinecraftAdapterMock minecraftAdapterMock = new MinecraftAdapterMock();
//        minecraftAdapterMock.blockMap = map;
//
//        factory.minecraftAdapter = minecraftAdapterMock;
//
//        .calculateDirection(playerMock, mapSize / 2, mapSize / 2, mapSize / 2);
//        verify(playerMock, times(0)).addChatComponentMessage( (ChatComponentText)anyObject());
//
//        Point3D cubeSize = new Point3D(10, 10, 10);
//        Point3D cubePos  = new Point3D(mapSize/2 - cubeSize.getX() + 1,
//                                        mapSize/2 - cubeSize.getY() + 1,
//                                        mapSize/2 - cubeSize.getZ() + 1);
//
//        OreMock ore = new OreMock();
//        map.createCube(cubePos, cubeSize, ore);
//        .calculateDirection(playerMock, mapSize/4, mapSize/4, mapSize/4);
//        verify(playerMock).addChatComponentMessage( new ChatComponentText("Your direction in south est top"));
//
//        .calculateDirection(playerMock, 3 * mapSize/4, mapSize/4, mapSize/4);
//        verify(playerMock).addChatComponentMessage( new ChatComponentText("Your direction in south west top"));
//
//        .calculateDirection(playerMock, mapSize/4, mapSize/4, 3 * mapSize/4);
//        verify(playerMock).addChatComponentMessage( new ChatComponentText("Your direction in north est top"));
//
//        .calculateDirection(playerMock, 3 * mapSize/4, mapSize/4, 3 * mapSize/4);
//        verify(playerMock).addChatComponentMessage( new ChatComponentText("Your direction in north west top"));
//
//        .calculateDirection(playerMock, mapSize/4, 3 * mapSize/4, mapSize/4);
//        verify(playerMock).addChatComponentMessage( new ChatComponentText("Your direction in south est down"));
//
//        .calculateDirection(playerMock, mapSize/4, 3 * mapSize/4, 3 * mapSize/4);
//        verify(playerMock).addChatComponentMessage( new ChatComponentText("Your direction in north est down"));
//
//        .calculateDirection(playerMock, 3 * mapSize/4, 3 * mapSize/4, mapSize/4);
//        verify(playerMock).addChatComponentMessage( new ChatComponentText("Your direction in south west down"));
//
//        .calculateDirection(playerMock, 3 * mapSize/4, 3 * mapSize/4, 3 * mapSize/4);
//        verify(playerMock).addChatComponentMessage( new ChatComponentText("Your direction in north west down"));
    }
}
