package net.kira.xenos.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.kira.xenos.XenosMod;
import net.kira.xenos.block.ModBlocks;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItems {

    private static Item registerItem(String name, Item item, ItemGroup group) {
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
        return Registry.register(Registries.ITEM, new Identifier(XenosMod.MOD_ID, name), item);
    }

    public static final Item Memory_Shard = registerItem("memory_shard",
            new Item(new Item.Settings()),
            ItemGroups.INGREDIENTS
            );

    public static final ItemGroup Xenos = FabricItemGroup.builder(new Identifier(XenosMod.MOD_ID))
            .displayName(Text.literal("Xenos Universe"))
            .icon(()-> new ItemStack(ModItems.Memory_Shard))
            .entries((enabledFeatures, entries, operatorEnabled) -> {
                entries.add(ModItems.Memory_Shard);
                entries.add(ModBlocks.Memory_Block);
            })
            .build();






    public static void registerModItems() {
        XenosMod.LOGGER.debug("Registering Mod Items for " + XenosMod.MOD_ID);
    }
}
