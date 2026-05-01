package cn.mcmod.corn_delight.compat.curios;

import org.joml.Quaternionf;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.client.ICurioRenderer;

public class CobpipeRenderer implements ICurioRenderer {

	@Override
	public <T extends LivingEntity, M extends EntityModel<T>> void render(ItemStack stack, SlotContext slotContext,
			PoseStack matrixStack, RenderLayerParent<T, M> renderLayerParent, MultiBufferSource renderTypeBuffer,
			int light, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw,
			float headPitch) {
		
		this.renderItem(stack, matrixStack, renderTypeBuffer, light, slotContext.entity());
	}

	public void renderItem(ItemStack item, PoseStack matrixStack, MultiBufferSource renderTypeBuffer, int light,
			LivingEntity livingEntity) {
		matrixStack.pushPose();
		
        if (livingEntity.isBaby() && !(livingEntity instanceof Villager)) {
           matrixStack.translate(0.0F, 0.03125F, 0.0F);
           matrixStack.scale(0.7F, 0.7F, 0.7F);
           matrixStack.translate(0.0F, 1.0F, 0.0F);
        }
        
    	this.followHeadRotations(livingEntity, matrixStack);
        
    	matrixStack.translate(0.0F, -0.25F, 0.0F);
    	matrixStack.mulPose(Axis.YP.rotationDegrees(180.0F));
        matrixStack.scale(0.625F, -0.625F, -0.625F);
	
		Minecraft.getInstance().getItemRenderer().renderStatic(livingEntity, item, ItemDisplayContext.HEAD, false,
				matrixStack, renderTypeBuffer, livingEntity.level(), light,
				LivingEntityRenderer.getOverlayCoords(livingEntity, 0.0F), livingEntity.getId());
		matrixStack.popPose();
		
	}
	
	  private void followHeadRotations(final LivingEntity livingEntity, PoseStack matrixStack) {

	    EntityRenderer<? super LivingEntity> render =
	        Minecraft.getInstance().getEntityRenderDispatcher().getRenderer(livingEntity);

	    if (render instanceof LivingEntityRenderer) {
	      @SuppressWarnings("unchecked")
	      LivingEntityRenderer<LivingEntity, EntityModel<LivingEntity>> livingRenderer =
	          (LivingEntityRenderer<LivingEntity, EntityModel<LivingEntity>>) render;
	      EntityModel<LivingEntity> model = livingRenderer.getModel();

	      if (model instanceof net.minecraft.client.model.HumanoidModel) {

	    	  float xRot = ((net.minecraft.client.model.HumanoidModel<LivingEntity>) model).head.xRot;
	    	  float yRot = ((net.minecraft.client.model.HumanoidModel<LivingEntity>) model).head.yRot;
	    	  float zRot = ((net.minecraft.client.model.HumanoidModel<LivingEntity>) model).head.zRot;
	    	  
	    	  matrixStack.mulPose((new Quaternionf()).rotationZYX(zRot, yRot, xRot));
	      }
	    }
	  }
}
