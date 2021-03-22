package com.github.botn365.botdustries;

import com.github.bartimaeusnek.bartworks.API.WerkstoffAdderRegistry;
import com.github.botn365.botdustries.loaders.MaterialsClass;
import com.github.botn365.botdustries.loaders.Recipes;
import cpw.mods.fml.common.event.FMLLoadCompleteEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;

import static com.github.botn365.botdustries.loaders.Recipes.addFuels;

@Mod(modid = Reference.MODID, name = Reference.NAME, version = Reference.VERSION, dependencies =
        "required-after:gregtech; " +
        "required-after:bartworks; " +
        "before:miscutils")
public class Botdustries {


    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        WerkstoffAdderRegistry.addWerkstoffAdder(new MaterialsClass());
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        Recipes.addGTRecipe();
        addFuels();
    }

    @Mod.EventHandler
    public void onModLoadingComplete(FMLLoadCompleteEvent event)
    {
        Recipes.removeRecipes();
    }
}
