package dev.gitipi.capybara.init;

import dev.gitipi.capybara.Capybara;
import dev.gitipi.capybara.entities.CapybaraEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.Level;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class EntityInit {
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, Capybara.MODID);

    public static final RegistryObject<EntityType<CapybaraEntity>> CAPYBARA = ENTITIES.register("capybara_entity",
                () -> EntityType.Builder.of((EntityType<CapybaraEntity> type, Level level) -> new CapybaraEntity(type, level), MobCategory.CREATURE).sized(1.0f, 1.0f).build(Capybara.MODID + ":capybara_entity"));
}
