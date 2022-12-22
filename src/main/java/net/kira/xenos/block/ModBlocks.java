package net.kira.xenos.block;


import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.kira.xenos.XenosMod;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;


public class ModBlocks {
    public static final Block Memory_Block = registerBlock("memory_block",
            new Block(FabricBlockSettings.of(Material.ICE).luminance(10).breakInstantly()), ItemGroups.COLORED_BLOCKS);



    private static Block registerBlock(String name, Block block, ItemGroup group) {
        registerBlockItem(name, block, group);
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(block));
        return Registry.register(Registries.BLOCK, new Identifier(XenosMod.MOD_ID, name), block);
    }


    private static Item registerBlockItem(String name, Block block, ItemGroup group) {
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(block));
        return Registry.register(Registries.ITEM, new Identifier(XenosMod.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }





    public static void registerModBlocks() {
        XenosMod.LOGGER.debug("Registering ModBlocks for " + XenosMod.MOD_ID);
    }
}
