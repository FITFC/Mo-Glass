/*
 * Copyright (C) 2019 - 2020 | Alexander01998 | All rights reserved.
 *
 * This source code is subject to the terms of the GNU General Public
 * License, version 3. If a copy of the GPL was not distributed with this
 * file, You can obtain one at: https://www.gnu.org/licenses/gpl-3.0.txt
 */
package net.wurstclient.glass;

import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.block.Stainable;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.entity.EntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.Item.Settings;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.BlockView;

public enum MoGlass
{
	INSTANCE;
	
	private boolean client;
	
	public static final Block GLASS_SLAB =
		new GlassSlabBlock(AbstractBlock.Settings.of(Material.GLASS)
			.strength(0.3F).sounds(BlockSoundGroup.GLASS).nonOpaque()
			.allowsSpawning(MoGlass::never).solidBlock(MoGlass::never)
			.suffocates(MoGlass::never).blockVision(MoGlass::never));
	
	public static final StainedGlassSlabBlock WHITE_STAINED_GLASS_SLAB =
		createStainedGlassSlab(DyeColor.WHITE);
	public static final StainedGlassSlabBlock ORANGE_STAINED_GLASS_SLAB =
		createStainedGlassSlab(DyeColor.ORANGE);
	public static final StainedGlassSlabBlock MAGENTA_STAINED_GLASS_SLAB =
		createStainedGlassSlab(DyeColor.MAGENTA);
	public static final StainedGlassSlabBlock LIGHT_BLUE_STAINED_GLASS_SLAB =
		createStainedGlassSlab(DyeColor.LIGHT_BLUE);
	public static final StainedGlassSlabBlock YELLOW_STAINED_GLASS_SLAB =
		createStainedGlassSlab(DyeColor.YELLOW);
	public static final StainedGlassSlabBlock LIME_STAINED_GLASS_SLAB =
		createStainedGlassSlab(DyeColor.LIME);
	public static final StainedGlassSlabBlock PINK_STAINED_GLASS_SLAB =
		createStainedGlassSlab(DyeColor.PINK);
	public static final StainedGlassSlabBlock GRAY_STAINED_GLASS_SLAB =
		createStainedGlassSlab(DyeColor.GRAY);
	public static final StainedGlassSlabBlock LIGHT_GRAY_STAINED_GLASS_SLAB =
		createStainedGlassSlab(DyeColor.LIGHT_GRAY);
	public static final StainedGlassSlabBlock CYAN_STAINED_GLASS_SLAB =
		createStainedGlassSlab(DyeColor.CYAN);
	public static final StainedGlassSlabBlock PURPLE_STAINED_GLASS_SLAB =
		createStainedGlassSlab(DyeColor.PURPLE);
	public static final StainedGlassSlabBlock BLUE_STAINED_GLASS_SLAB =
		createStainedGlassSlab(DyeColor.BLUE);
	public static final StainedGlassSlabBlock BROWN_STAINED_GLASS_SLAB =
		createStainedGlassSlab(DyeColor.BROWN);
	public static final StainedGlassSlabBlock GREEN_STAINED_GLASS_SLAB =
		createStainedGlassSlab(DyeColor.GREEN);
	public static final StainedGlassSlabBlock RED_STAINED_GLASS_SLAB =
		createStainedGlassSlab(DyeColor.RED);
	public static final StainedGlassSlabBlock BLACK_STAINED_GLASS_SLAB =
		createStainedGlassSlab(DyeColor.BLACK);
	
	public static final StainedGlassSlabBlock[] STAINED_GLASS_SLABS =
		{WHITE_STAINED_GLASS_SLAB, ORANGE_STAINED_GLASS_SLAB,
			MAGENTA_STAINED_GLASS_SLAB, LIGHT_BLUE_STAINED_GLASS_SLAB,
			YELLOW_STAINED_GLASS_SLAB, LIME_STAINED_GLASS_SLAB,
			PINK_STAINED_GLASS_SLAB, GRAY_STAINED_GLASS_SLAB,
			LIGHT_GRAY_STAINED_GLASS_SLAB, CYAN_STAINED_GLASS_SLAB,
			PURPLE_STAINED_GLASS_SLAB, BLUE_STAINED_GLASS_SLAB,
			BROWN_STAINED_GLASS_SLAB, GREEN_STAINED_GLASS_SLAB,
			RED_STAINED_GLASS_SLAB, BLACK_STAINED_GLASS_SLAB};
	
	public static final Block GLASS_STAIRS =
		new GlassStairsBlock(AbstractBlock.Settings.of(Material.GLASS)
			.strength(0.3F).sounds(BlockSoundGroup.GLASS).nonOpaque()
			.allowsSpawning(MoGlass::never).solidBlock(MoGlass::never)
			.suffocates(MoGlass::never).blockVision(MoGlass::never));
	
	public static final StainedGlassStairsBlock WHITE_STAINED_GLASS_STAIRS =
		createStainedGlassStairs(DyeColor.WHITE);
	public static final StainedGlassStairsBlock ORANGE_STAINED_GLASS_STAIRS =
		createStainedGlassStairs(DyeColor.ORANGE);
	public static final StainedGlassStairsBlock MAGENTA_STAINED_GLASS_STAIRS =
		createStainedGlassStairs(DyeColor.MAGENTA);
	public static final StainedGlassStairsBlock LIGHT_BLUE_STAINED_GLASS_STAIRS =
		createStainedGlassStairs(DyeColor.LIGHT_BLUE);
	public static final StainedGlassStairsBlock YELLOW_STAINED_GLASS_STAIRS =
		createStainedGlassStairs(DyeColor.YELLOW);
	public static final StainedGlassStairsBlock LIME_STAINED_GLASS_STAIRS =
		createStainedGlassStairs(DyeColor.LIME);
	public static final StainedGlassStairsBlock PINK_STAINED_GLASS_STAIRS =
		createStainedGlassStairs(DyeColor.PINK);
	public static final StainedGlassStairsBlock GRAY_STAINED_GLASS_STAIRS =
		createStainedGlassStairs(DyeColor.GRAY);
	public static final StainedGlassStairsBlock LIGHT_GRAY_STAINED_GLASS_STAIRS =
		createStainedGlassStairs(DyeColor.LIGHT_GRAY);
	public static final StainedGlassStairsBlock CYAN_STAINED_GLASS_STAIRS =
		createStainedGlassStairs(DyeColor.CYAN);
	public static final StainedGlassStairsBlock PURPLE_STAINED_GLASS_STAIRS =
		createStainedGlassStairs(DyeColor.PURPLE);
	public static final StainedGlassStairsBlock BLUE_STAINED_GLASS_STAIRS =
		createStainedGlassStairs(DyeColor.BLUE);
	public static final StainedGlassStairsBlock BROWN_STAINED_GLASS_STAIRS =
		createStainedGlassStairs(DyeColor.BROWN);
	public static final StainedGlassStairsBlock GREEN_STAINED_GLASS_STAIRS =
		createStainedGlassStairs(DyeColor.GREEN);
	public static final StainedGlassStairsBlock RED_STAINED_GLASS_STAIRS =
		createStainedGlassStairs(DyeColor.RED);
	public static final StainedGlassStairsBlock BLACK_STAINED_GLASS_STAIRS =
		createStainedGlassStairs(DyeColor.BLACK);
	
	public static final StainedGlassStairsBlock[] STAINED_GLASS_STAIRS =
		{WHITE_STAINED_GLASS_STAIRS, ORANGE_STAINED_GLASS_STAIRS,
			MAGENTA_STAINED_GLASS_STAIRS, LIGHT_BLUE_STAINED_GLASS_STAIRS,
			YELLOW_STAINED_GLASS_STAIRS, LIME_STAINED_GLASS_STAIRS,
			PINK_STAINED_GLASS_STAIRS, GRAY_STAINED_GLASS_STAIRS,
			LIGHT_GRAY_STAINED_GLASS_STAIRS, CYAN_STAINED_GLASS_STAIRS,
			PURPLE_STAINED_GLASS_STAIRS, BLUE_STAINED_GLASS_STAIRS,
			BROWN_STAINED_GLASS_STAIRS, GREEN_STAINED_GLASS_STAIRS,
			RED_STAINED_GLASS_STAIRS, BLACK_STAINED_GLASS_STAIRS};
	
	public void initialize(boolean client)
	{
		this.client = client;
		System.out.println("Starting Mo Glass...");
		
		String[] colors = {"white", "orange", "magenta", "light_blue", "yellow",
			"lime", "pink", "gray", "light_gray", "cyan", "purple", "blue",
			"brown", "green", "red", "black"};
		
		registerBlock(GLASS_SLAB, "glass_slab", ItemGroup.BUILDING_BLOCKS);
		
		for(int i = 0; i < 16; i++)
			registerBlock(STAINED_GLASS_SLABS[i],
				colors[i] + "_stained_glass_slab", ItemGroup.BUILDING_BLOCKS);
		
		registerBlock(GLASS_STAIRS, "glass_stairs", ItemGroup.BUILDING_BLOCKS);
		
		for(int i = 0; i < 16; i++)
			registerBlock(STAINED_GLASS_STAIRS[i],
				colors[i] + "_stained_glass_stairs", ItemGroup.BUILDING_BLOCKS);
	}
	
	private void registerBlock(Block block, String idPath, ItemGroup itemGroup)
	{
		Identifier identifier = new Identifier("mo_glass", idPath);
		Registry.register(Registry.BLOCK, identifier, block);
		
		Settings itemSettings = new Item.Settings().group(itemGroup);
		BlockItem blockItem = new BlockItem(block, itemSettings);
		Registry.register(Registry.ITEM, identifier, blockItem);
		
		if(client)
			BlockRenderLayerMap.INSTANCE.putBlock(block,
				block instanceof Stainable ? RenderLayer.getTranslucent()
					: RenderLayer.getCutoutMipped());
	}
	
	private static StainedGlassSlabBlock createStainedGlassSlab(DyeColor color)
	{
		return new StainedGlassSlabBlock(color,
			AbstractBlock.Settings.of(Material.GLASS, color).strength(0.3F)
				.sounds(BlockSoundGroup.GLASS).nonOpaque()
				.allowsSpawning(MoGlass::never).solidBlock(MoGlass::never)
				.suffocates(MoGlass::never).blockVision(MoGlass::never));
	}
	
	private static StainedGlassStairsBlock createStainedGlassStairs(
		DyeColor color)
	{
		return new StainedGlassStairsBlock(color,
			AbstractBlock.Settings.of(Material.GLASS, color).strength(0.3F)
				.sounds(BlockSoundGroup.GLASS).nonOpaque()
				.allowsSpawning(MoGlass::never).solidBlock(MoGlass::never)
				.suffocates(MoGlass::never).blockVision(MoGlass::never));
	}
	
	// Copies of the Blocks.never() methods because the originals are not
	// accessible from here.
	
	private static Boolean never(BlockState blockState, BlockView blockView,
		BlockPos blockPos, EntityType<?> entityType)
	{
		return false;
	}
	
	private static boolean never(BlockState blockState, BlockView blockView,
		BlockPos blockPos)
	{
		return false;
	}
}
