package dev.gitipi.capybara.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import dev.gitipi.capybara.Capybara;
import dev.gitipi.capybara.client.models.CapybaraModel;
import dev.gitipi.capybara.entities.CapybaraEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class CapybaraEntityRenderer extends GeoEntityRenderer<CapybaraEntity> {

    public CapybaraEntityRenderer(EntityRendererProvider.Context ctx) {
        super(ctx, new CapybaraModel());
        this.shadowRadius = 0.3f;
    }

    @Override
    public ResourceLocation getTextureLocation(CapybaraEntity instance) {
        return new ResourceLocation(Capybara.MODID, "textures/entities/capybara.png");
    }

    @Override
    public RenderType getRenderType(CapybaraEntity animatable, float partialTicks, PoseStack stack,
                                    @Nullable MultiBufferSource renderTypeBuffer,
                                    @Nullable VertexConsumer vertexBuilder, int packedLightIn,
                                    ResourceLocation textureLocation) {

        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }
}
