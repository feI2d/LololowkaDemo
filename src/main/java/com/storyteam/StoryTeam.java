package com.storyteam;

import com.storyteam.custom.CustomEntityManager;
import com.storyteam.custom.CustomGroup;
import com.storyteam.custom.CustomItemsManager;
import com.storyteam.custom.renderer.RenderManager;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StoryTeam implements ModInitializer, MinecraftWrapper {

	public static final String MOD_ID = "storyteam";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize()
	{

		RenderManager.register();
		CustomEntityManager.register();

		CustomGroup.init();
		CustomItemsManager.init();


	}
}