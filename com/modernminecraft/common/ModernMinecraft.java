package com.modernminecraft.common;

import com.modernminecraft.handlers.PCHandler;
import com.modernminecraft.tileentitys.TileEntityPC;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = "mmc", name = "Modern Minecraft", version = "1.0 Alpha")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class ModernMinecraft{

public static Item pBlob;
public static Item pSheet;
public static Block blockpc;
public static Block Steel;
public static Object instance;

@Init
public void load(FMLInitializationEvent events){


	
blockpc = new BlockPlasticChest(240).setCreativeTab(CreativeTabs.tabBlock);
pBlob = new ItemPBlob(400).setUnlocalizedName("pBlob").setCreativeTab(CreativeTabs.tabMaterials);
pSheet = new ItemPSheet(401).setUnlocalizedName("pSheet").setCreativeTab(CreativeTabs.tabMaterials);
GameRegistry.registerTileEntity(TileEntityPC.class, "PCHandler");
LanguageRegistry.addName(blockpc, "Plastic Chest");
NetworkRegistry.instance().registerGuiHandler(this, new PCHandler());
GameRegistry.registerItem(pBlob, "pBlob");
GameRegistry.registerBlock(blockpc, ItemBlock.class, "Block PC");

LanguageRegistry.addName(pBlob, "Plastic Clump");
LanguageRegistry.addName(pSheet, "Plastic Sheet");

}

}