package io.github.aemogie.learnmod.common.block;

import net.minecraft.block.Block;

/**
 * @author <a href="mailto:theaemogie@gmail.com"> Aemogie. </a>
 */
public class ModBlock extends Block {
	public final String RENDER_MODE;
	public ModBlock(Properties properties, String renderMode) {
		super(properties);
		this.RENDER_MODE = renderMode;
	}
}
