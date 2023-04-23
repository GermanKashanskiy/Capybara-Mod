package dev.gitipi.capybara.init;

import dev.gitipi.capybara.Capybara;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemInit {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Capybara.MODID);

    public static final RegistryObject<Item> EXAMPLE_ITEM = ITEMS.register("example_item",
            () -> new Item(props()));


    public static final RegistryObject<ForgeSpawnEggItem> EXAMPLE_ENTITY_SPAWN_EGG = ITEMS.register("capybara_entity_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityInit.CAPYBARA, 0xFF55AA, 0x27DA9F, props().stacksTo(16)));

    private static Item.Properties props() {
        return new Item.Properties().tab(CreativeModeTab.TAB_MISC);
    }

}
