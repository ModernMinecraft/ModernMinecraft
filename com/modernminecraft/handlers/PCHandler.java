package com.modernminecraft.handlers;

import cpw.mods.fml.common.network.IGuiHandler;
import com.modernminecraft.tileentitys.TileEntityPC;
import com.modernminecraft.containers.PCContainer;
import com.modernminecraft.guis.PCGui;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class PCHandler implements IGuiHandler {
    //returns an instance of the Container you made earlier
    @Override
    public Object getServerGuiElement(int id, EntityPlayer player, World world,
                    int x, int y, int z) {
            TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
            if(tileEntity instanceof TileEntityPC){
                    return new PCContainer(player.inventory, (TileEntityPC) tileEntity);
            }
            return null;
    }

    //returns an instance of the Gui you made earlier
    @Override
    public Object getClientGuiElement(int id, EntityPlayer player, World world,
                    int x, int y, int z) {
            TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
            if(tileEntity instanceof TileEntityPC){
                    return new PCGui(player.inventory, (TileEntityPC) tileEntity);
            }
            return null;

    }

}