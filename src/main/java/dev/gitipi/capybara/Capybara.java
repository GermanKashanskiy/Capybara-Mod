package dev.gitipi.capybara;

import dev.gitipi.capybara.init.EntityInit;
import dev.gitipi.capybara.init.ItemInit;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Capybara.MODID)
public class Capybara {
    public static final String MODID = "capybara";

    public Capybara() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        ItemInit.ITEMS.register(bus);
        EntityInit.ENTITIES.register(bus);
    }
}
