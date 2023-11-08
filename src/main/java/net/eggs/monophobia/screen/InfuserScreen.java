package net.eggs.monophobia.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.eggs.monophobia.Monophobiamod;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class InfuserScreen extends AbstractContainerScreen<InfuserMenu> {
    private static final ResourceLocation TEXTURE =
            new ResourceLocation(Monophobiamod.MOD_ID, "textures/gui/infuser_gui.png");

    public InfuserScreen(InfuserMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle);
    }

    @Override
    protected void init() {
        super.init();
        this.inventoryLabelY = 10000;
        this.titleLabelY = 10000;
    }
    @Override
    protected void renderBg(GuiGraphics guiGraphics, float pPartialTick, int pMouseX, int pMouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

        guiGraphics.blit(TEXTURE, x, y, 0, 0, imageWidth, imageHeight);

        renderProgressArrow(guiGraphics, x, y);
    }

    private void renderProgressArrow(GuiGraphics guiGraphics, int x, int y) {
        if(menu.isCrafting()) {
            // Update these coordinates to where the horizontal arrow sprite is located in your texture file
            int arrowTextureX = 150; // Assuming the horizontal arrow starts at 176 on the texture's x-axis
            int arrowTextureY = 170;  // Assuming the horizontal arrow starts at 14 on the texture's y-axis
            // This will draw the arrow horizontally by scaling the width instead of the height
            int arrowWidth = (int)(menu.getScaledProgress() * 25); // Assuming the full arrow width is 22 pixels
            int arrowHeight = 8; // Assuming the arrow's height is 16 pixels

            guiGraphics.blit(TEXTURE, x + 119, y + 40, arrowTextureX, arrowTextureY, arrowWidth, arrowHeight);
        }
    }

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float delta) {
        renderBackground(guiGraphics);
        super.render(guiGraphics, mouseX, mouseY, delta);
        renderTooltip(guiGraphics, mouseX, mouseY);
    }
}