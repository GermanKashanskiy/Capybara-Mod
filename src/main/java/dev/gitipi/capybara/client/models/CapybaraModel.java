package dev.gitipi.capybara.client.models;

import dev.gitipi.capybara.Capybara;
import dev.gitipi.capybara.entities.CapybaraEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class CapybaraModel extends AnimatedGeoModel<CapybaraEntity> {

	@Override
	public ResourceLocation getModelResource(CapybaraEntity object) {
		return new ResourceLocation(Capybara.MODID, "geo/capybara.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(CapybaraEntity object) {
		return new ResourceLocation(Capybara.MODID, "textures/entities/capybara.png");
	}

	@Override
	public ResourceLocation getAnimationResource(CapybaraEntity animatable) {
		return new ResourceLocation(Capybara.MODID, "animations/capybara.animation.json");
	}
}