package dev.gitipi.capybara.client.renderer;

import dev.gitipi.capybara.Capybara;
import dev.gitipi.capybara.client.models.CapybaraModel;
import dev.gitipi.capybara.entities.CapybaraEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class CapybaraEntityRenderer extends MobRenderer<CapybaraEntity, CapybaraModel> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(Capybara.MODID, "textures/entities/capybara.png");

    public CapybaraEntityRenderer(EntityRendererProvider.Context ctx) {
        super(ctx, new CapybaraModel(ctx.bakeLayer(CapybaraModel.LAYER_LOCATION)), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(CapybaraEntity entity) {
        return TEXTURE;
    }
}
