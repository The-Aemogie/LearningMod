package io.github.aemogie.learnmod;

import net.minecraft.item.ItemGroup;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Class used for storing variables that will be referenced often.
 *
 * @author <a href="mailto:theaemogie@gmail.com?subject=%5Blearn-mod_1.0%5D"> Aemogie. </a>
 */
public class References {
	public static final String MOD_ID = "learn-mod";
	public static final String VERSION = "1.0";
	public static final Logger LOGGER = LogManager.getLogger();
	public static final ItemGroup GLASS_LIGHT_GROUP = new LearnModGroups.LightingAndDecor(MOD_ID + ".glass_lights");
	public static final ItemGroup CHAIR_GROUP = new LearnModGroups.Furniture(MOD_ID + ".chairs");
	public static final ItemGroup MISC_GROUP = new LearnModGroups.MiscGroup(MOD_ID + ".misc");
}
