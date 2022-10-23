package com.github.botn365.botdustries;

import com.github.bartimaeusnek.bartworks.API.WerkstoffAdderRegistry;
import com.github.botn365.botdustries.loaders.MaterialsClass;
import com.github.botn365.botdustries.loaders.Recipes;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.*;

import static com.github.botn365.botdustries.loaders.Recipes.addFuels;

public class CommonProxy {

    // preInit "Run before anything else. Read your config, create blocks, items,
    // etc, and register them with the GameRegistry."
    public void preInit(FMLPreInitializationEvent event) 	{
        WerkstoffAdderRegistry.addWerkstoffAdder(new MaterialsClass());
    }

    // load "Do your mod setup. Build whatever data structures you care about. Register recipes."
    public void init(FMLInitializationEvent event) {

    }

    // postInit "Handle interaction with other mods, complete your setup based on this."
    public void postInit(FMLPostInitializationEvent event) {
        Recipes.addGTRecipe();
        addFuels();
    }

    public void serverAboutToStart(FMLServerAboutToStartEvent event) {

    }

    // register server commands in this event handler
    public void serverStarting(FMLServerStartingEvent event) {

    }

    public void serverStarted(FMLServerStartedEvent event) {

    }

    public void serverStopping(FMLServerStoppingEvent event) {

    }

    public void serverStopped(FMLServerStoppedEvent event) {

    }

    public void onModLoadingComplete(FMLLoadCompleteEvent event) {
        Recipes.removeRecipes();
    }
}
