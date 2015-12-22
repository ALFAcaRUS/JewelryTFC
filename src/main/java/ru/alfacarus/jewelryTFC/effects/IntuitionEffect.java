package ru.alfacarus.jewelryTFC.effects;

import com.bioxx.tfc.Blocks.Terrain.BlockOre;
import com.bioxx.tfc.Items.Tools.ItemProPick;
import cpw.mods.fml.common.eventhandler.Event;
import cpw.mods.fml.common.eventhandler.EventBus;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import ru.alfacarus.jewelryTFC.logers.BaseLogger;
import ru.alfacarus.jewelryTFC.utils.ILoadingFactory;
import ru.alfacarus.jewelryTFC.utils.MinecraftAdapter;

import java.util.Arrays;

public class IntuitionEffect extends AbstractEffect {
    public IntuitionEffect(ILoadingFactory loadingFactory){
        super(loadingFactory);
    }

    @Override
    public boolean isOnTick() {
        return false;
    }

    @Override
    public void onTick(ItemStack itemStack, EntityLivingBase entityLivingBase) {

    }

    @Override
    public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int targetSide, float targetX, float targetY, float targetZ) {
        return false;
    }

    @Override
    public EventBus getEventBus() {
        return MinecraftForge.EVENT_BUS;
    }

    @Override
    public void onEquipped(ItemStack itemStack, EntityLivingBase entityLivingBase) {

    }

    @Override
    public void onUnequipped(ItemStack itemStack, EntityLivingBase entityLivingBase) {

    }

    @SubscribeEvent
    public void playerUseItem(PlayerInteractEvent event){
        World world = event.world;
        if(PlayerInteractEvent.Action.RIGHT_CLICK_BLOCK != event.action
                || Event.Result.DEFAULT != event.useItem
                || null == event.entityPlayer
                || world.isRemote
                || null == event.entityPlayer.getHeldItem()
                ){
            return;
        }

        BaseLogger logger = runtimeFactory.getLogger();
        logger.debugLogMessage( "Start of player interact event.");
        Item eventItem = event.entityPlayer.getHeldItem().getItem();

        if(null != eventItem && eventItem instanceof ItemProPick){
            logger.debugLogMessage("Used bonusMaterial is prospector pickax: %s", eventItem);
                if(null != checkInventory(event.entityPlayer)) {
                    logger.debugLogMessage("Find amulet of intuition");
                    calculateDirection(event.entityPlayer, event.x, event.y, event.z);
                }

        }
    }

    public void calculateDirection(EntityPlayer player, int posX, int posY, int posZ){
        MinecraftAdapter minecraftAdapter = this.runtimeFactory.getMinecraftAdapter();
        BaseLogger logger = this.runtimeFactory.getLogger();

        int[] sectors = new int[8];

        logger.debugLogMessage("Start calculating in pos");

        for(int i = -12; i < 12; ++i){
            for(int j = -12; j < 12; ++j) {
                for (int k = -12; k < 12; ++k) {
                    Block block = minecraftAdapter.getBlock(i + posX, j + posY, k + posZ);

                    if(block instanceof BlockOre){
                        int sector = ((i & 256) >> 8) | ((j & 256) >> 7) | ((k & 256) >> 6);
                        sectors[sector]++;
                    }
                }
            }
        }

        logger.debugLogMessage("Found ore blocks: %s", Arrays.toString(sectors));
        int max = 0;
        // Direction. For x, if x=0 go to est, x=1 west, x=2 not matter
        byte dirX = 0;
        // up, down
        byte dirY = 0;
        //south, north
        byte dirZ = 0;

        for(int i = 0; i < sectors.length; ++i){
            if(sectors[i] > max){
                dirX = (byte) ((i & 1) > 0 ? 1: 0);
                dirY = (byte) ((i & 2) > 0 ? 1: 0);
                dirZ = (byte) ((i & 4) > 0 ? 1: 0);
                max = sectors[i];
            } else if (sectors[i] != 0 && sectors[i] == max){
                dirX += (byte)(i & 1) > 0 ? 1: 0;
                dirY += (byte)(i & 2) > 0 ? 1: 0;
                dirZ += (byte)(i & 4) > 0 ? 1: 0;
            }
        }

        if(0 == max) return;
        logger.debugLogMessage("Maximum ore blocks count is: %s", max);

        String answer = "Your direction in" + choiceDirection(dirZ, " south", " north") +
                choiceDirection(dirX, " est", " west") +
                choiceDirection(dirY, " top", " down");

        player.addChatComponentMessage(new ChatComponentText(answer));
    }

    private static String choiceDirection(byte dir, String choice1, String choice2){
        if (0 == dir){ return choice1;}
        if (1 == dir){ return choice2;}
        return "";
    }
}
