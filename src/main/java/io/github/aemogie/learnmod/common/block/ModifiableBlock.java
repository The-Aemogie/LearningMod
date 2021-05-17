package io.github.aemogie.learnmod.common.block;

import io.github.aemogie.learnmod.References;
import net.minecraft.block.Block;

import java.lang.reflect.Field;

/**
 * @author <a href="mailto:theaemogie@gmail.com"> Aemogie. </a>
 */
public class ModifiableBlock extends Block {
	
	public Properties tempProperties;
	
	public ModifiableBlock(Properties properties) {
		super(properties);
	}
	
	public Properties getProperties() {
		tempProperties = properties;
		try {
			return (Properties) getClass().getField("tempProperties").get(this);
		} catch (NoSuchFieldException error) {
			References.LOGGER.error("Unable to retrieve block properties for block: " + this.getClass().getSimpleName());
		} catch (IllegalAccessException e) {
			References.LOGGER.error("Unable to cast block properties for block: " + this.getClass().getSimpleName());
		}
		return null;
	}
	
	public void setProperties(Properties properties) {
		Field[] baseProperties = this.properties.getClass().getDeclaredFields();
		Field[] targetProperties = properties.getClass().getDeclaredFields();
//		References.LOGGER.error(baseProperties.length);
		try {
			for (int i = 0; i < baseProperties.length; i++) {
				
				Field baseProperty = baseProperties[i];
				Field targetProperty = targetProperties[i];
				
				targetProperty.setAccessible(true);
				baseProperty.setAccessible(true);
				
				baseProperty.set(
						this.properties,
						targetProperty.get(properties)
				);
				
				baseProperty.setAccessible(false);
				targetProperty.setAccessible(false);
			}
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}
}
