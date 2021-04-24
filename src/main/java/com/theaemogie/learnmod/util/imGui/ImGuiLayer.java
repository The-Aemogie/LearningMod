package com.theaemogie.learnmod.util.imGui;

import com.theaemogie.learnmod.References;
import com.theaemogie.learnmod.core.blocks.BlockLists;
import imgui.ImGui;
import imgui.app.Application;
import imgui.app.Configuration;
import net.minecraft.block.AbstractBlock;

import java.lang.reflect.Field;

/**
 * @author <a href="mailto:theaemogie@gmail.com"> Aemogie. </a>
 */
public class ImGuiLayer extends Application {
	float[] destroyTime = {1.5f};
	@Override
	public void process() {
		AbstractBlock.Properties modifyingProperties = BlockLists.GRAY_GLASS_LIGHT.getProperties();
		if (ImGui.dragFloat("Strength", destroyTime)) {
			modifyingProperties.strength(destroyTime[0], 6.5f);
		}
		BlockLists.GRAY_GLASS_LIGHT.setProperties(modifyingProperties);
	}
	
	protected void configure(Configuration config) {
		config.setHeight(360);
		config.setHeight(640);
		super.configure(config);
	}
}
