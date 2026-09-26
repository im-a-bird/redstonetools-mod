package tools.redstone.redstonetools.mixin.features;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.LevelRenderer;
//? if >=26.1.2 {
/*import net.minecraft.client.renderer.state.level.BlockOutlineRenderState;
*///? } else if >=1.21.10
import net.minecraft.client.renderer.state.BlockOutlineRenderState;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

// LevelRenderer.renderHitOutline was removed in 26.3, replaced by the submit-node pipeline's
// SubmitNodeCollector.submitShapeOutline(...), which is a public API and needs no invoker mixin.
// This interface is intentionally empty on >=26.3; see AirPlaceFeature for the call site.
@Mixin(LevelRenderer.class)
public interface WorldRendererInvoker {
	//? if <26.3 {
	@Invoker
	//? if <=1.21.8 {
	/*void invokeRenderHitOutline(PoseStack matrices, VertexConsumer vertexConsumer, Entity entity, double cameraX, double cameraY, double cameraZ, BlockPos pos, BlockState state, int color);
	*///?} else if <=1.21.10 {
	/*void invokeRenderHitOutline(PoseStack matrices, VertexConsumer vertexConsumer, double x, double y, double z, BlockOutlineRenderState state, int color);
	*///?} else {
	void invokeRenderHitOutline(PoseStack matrices, VertexConsumer vertexConsumer, double x, double y, double z, BlockOutlineRenderState state, int color, float lineWidth);
	//?}
	//? }
}
