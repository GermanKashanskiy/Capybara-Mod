package dev.gitipi.capybara.init;

import dev.gitipi.capybara.Capybara;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class SoundInit {
    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, Capybara.MODID);

    public static final RegistryObject<SoundEvent> CAPY_SOUND = createSoundEvent("capy_sound");

    private static RegistryObject<SoundEvent> createSoundEvent(final String soundName) {
        return SOUNDS.register(soundName, () -> new SoundEvent(new ResourceLocation(Capybara.MODID, soundName)));
    }
}
