package com.github.botn365.botdustries.loaders;

import cpw.mods.fml.common.Loader;
import gregtech.api.enums.GT_Values;
import gregtech.api.enums.Materials;
import gregtech.api.util.*;
import ic2.core.Ic2Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.HashSet;

import static com.github.bartimaeusnek.bartworks.system.material.WerkstoffLoader.*;
import static com.github.botn365.botdustries.loaders.MaterialsBot.*;
import static gregtech.api.enums.OrePrefixes.*;

public class Recipes
{
    public static void addGTRecipe() {
        ItemStack C1 = GT_Utility.getIntegratedCircuit(1);
        ItemStack C2 = GT_Utility.getIntegratedCircuit(2);
        ItemStack C24 = GT_Utility.getIntegratedCircuit(24);

        GT_Values.RA.addChemicalRecipe(Materials.Calcite.getDust(1), Materials.Empty.getCells(1),
                Materials.HydrochloricAcid.getFluid(2000), Materials.Water.getFluid(1000),
                Materials.CarbonDioxide.getCells(1), CalciumChloride.get(dust, 3), 80, 120);

        // tungsten chain
        FluidStack sodiumTungsten = SodiumTungstate.getFluidOrGas(4000);
        ItemStack scheelite = Materials.Scheelite.getDust(7);

        GT_Values.RA.addAutoclaveRecipe(Materials.Tungstate.getDust(7), Materials.SodiumHydroxide.getDust(4),
                Materials.Water.getFluid(4000), sodiumTungsten, Materials.Lithium.getDust(2), 10000, 100, 1920, false);

//        GT_Values.RA.addAutoclaveRecipe(WerkstoffLoader.Huebnerit.get(dust, 5), Materials.SodiumHydroxide.getDust(4),
//                Materials.Water.getFluid(4000), sodiumTungsten, Materials.Manganese.getDust(1), 10000, 100, 1920, false);
//
//        GT_Values.RA.addAutoclaveRecipe(WerkstoffLoader.Ferberite.get(dust, 5), Materials.SodiumHydroxide.getDust(4),
//                Materials.Water.getFluid(4000), sodiumTungsten, Materials.Iron.getDust(1), 10000, 100, 1920, false);

        ItemStack Ca2Cl = CalciumChloride.get(dust, 6);
        GT_Values.RA.addChemicalRecipe(Ca2Cl, null, sodiumTungsten, null,
                scheelite, Materials.Salt.getDust(8), 100, 480);

        Ca2Cl.stackSize = 6;
        ItemStack H2WO4 = TungsticAcid.get(dust, 1);
        GT_Values.RA.addChemicalRecipe(scheelite, null, Materials.HydrochloricAcid.getFluid(4000), null,
                H2WO4, Ca2Cl, 50, 1920);

        ItemStack WO3 = TungstenTrioxide.get(dust, 1);
        GT_Values.RA.addBlastRecipe(H2WO4, null, null, null, WO3, null,
                200, 480, 1200);

        ItemStack WO3Fe = TungstenSteelOxide.get(dust, 2);
        GT_Values.RA.addMixerRecipe(WO3, Materials.Steel.getDust(1), null, null, null, null,
                WO3Fe, 100, 1920);

        GT_Values.RA.addBlastRecipe(WO3,C2,Materials.Hydrogen.getGas(3000),
                null,Materials.Tungsten.getDust(1),null,100,1920,1000);

        WO3.stackSize = 2;
        GT_Values.RA.addBlastRecipe(WO3, Materials.Carbon.getDust(3), null, Materials.CarbonDioxide.getGas(6000),
                GT_OreDictUnificator.get(ingotHot, Materials.Tungsten, 2L), null, 8000, 1920, 3000);

        WO3Fe.stackSize = 4;
        GT_Values.RA.addBlastRecipe(WO3Fe, Materials.Carbon.getDust(3), Materials.Nitrogen.getGas(4000), Materials.CarbonDioxide.getGas(6000),
                GT_OreDictUnificator.get(ingotHot, Materials.TungstenSteel, 4L), null, 10000, 1920, 3000);

        GT_Values.RA.addElectrolyzerRecipe(Materials.Ammonia.getCells(1), null,Materials.SulfuricAcid.getFluid(2000),null,AmmoniaPersulfate.get(dust),Materials.Empty.getCells(1),null,null,null,null,null,60,480 );


        //region bartworks recipes
//        GT_Values.RA.addChemicalRecipe(Sodiumsulfate.get(dust, 1), Materials.Hydrogen.getCells(2), null, Materials.SulfuricAcid.getFluid(1000), Materials.Sodium.getDust(2), Materials.Empty.getCells(2), 30);
//        GT_Values.RA.addChemicalRecipe(Materials.Ammonia.getCells(1), GT_Utility.getIntegratedCircuit(1), Materials.HydrochloricAcid.getFluid(1000), null, AmmoniumChloride.get(cell, 1), null, 15);
//        GT_Values.RA.addChemicalRecipe(Materials.HydrochloricAcid.getCells(1), GT_Utility.getIntegratedCircuit(1), Materials.Ammonia.getGas(1000), AmmoniumChloride.getFluidOrGas(1000), Materials.Empty.getCells(1), null, 15);
        //endregion

    }
    public static void addFuels()
    {
        try {
            if (Loader.isModLoaded(GT_Values.MOD_ID_GC_CORE)) {
                Class<?> rocket = Class.forName("micdoodle8.mods.galacticraft.api.recipe.RocketFuelRecipe");
                Method addFuel = rocket.getMethod("addFuel", Fluid.class, int.class);
                addFuel.invoke(null, LMP103S.getFluidOrGas(1).getFluid(), 4);
                addFuel.invoke(null, MonomethylhydrazineFuelMix.getFluidOrGas(1).getFluid(), 6);
                addFuel.invoke(null, UnsymmetricalDimethylhydrazineFuelMix.getFluidOrGas(1).getFluid(), 8);
            }
            if (Loader.isModLoaded("miscutils"))
            {
                Class gtppRecipeMap = Class.forName("gregtech.api.util.GTPP_Recipe$GTPP_Recipe_Map");
                Field rocketFuels = gtppRecipeMap.getDeclaredField("sRocketFuels");
                rocketFuels.setAccessible(true);
                Class rocketFuelsClass = rocketFuels.getType();
                Object rocketFuelsObject = rocketFuels.get(null);
                Method addFuel = rocketFuelsClass.getDeclaredMethod("addFuel",FluidStack.class,FluidStack.class,int.class);
                addFuel.invoke(rocketFuelsObject,LMP103S.getFluidOrGas(1000),null,666);
                addFuel.invoke(rocketFuelsObject,MonomethylhydrazineFuelMix.getFluidOrGas(1000),null,1500);
                addFuel.invoke(rocketFuelsObject,UnsymmetricalDimethylhydrazineFuelMix.getFluidOrGas(1000),null,3000);
            }
        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InvocationTargetException | NoSuchFieldException e) {
            e.printStackTrace();
        }
        GT_Recipe.GT_Recipe_Map.sTurbineFuels.addFuel(TertButylbenzene.get(cell,1),null,420);
    }

    public static void removeRecipes()
    {
        Recipes.removeTungstenElectro();
    }

    public static void removeTungstenElectro() {
        Collection<GT_Recipe> electroRecipeMap = GT_Recipe.GT_Recipe_Map.sElectrolyzerRecipes.mRecipeList;
        HashSet<GT_Recipe> toDel = new HashSet<>();
        ItemStack[] toRemove = {
                Materials.Scheelite.getDust(1),
                Materials.Tungstate.getDust(1)
//                WerkstoffLoader.Ferberite.get(dust, 1),
//                WerkstoffLoader.Huebnerit.get(dust, 1)};
        };
        for (GT_Recipe tRecipe : electroRecipeMap) {
            if (tRecipe.mFakeRecipe)
                continue;
            for (int i = 0; i < tRecipe.mInputs.length; i++) {
                ItemStack tItem = tRecipe.mInputs[i];
                if (item == null || !GT_Utility.isStackValid(tItem))
                    continue;
                for (ItemStack tStack : toRemove) {
                    if (GT_Utility.areStacksEqual(tItem, tStack)) {
                        toDel.add(tRecipe);
                        continue;
                    }
                }
            }
        }
        electroRecipeMap.removeAll(toDel);
        GT_Recipe.GT_Recipe_Map.sElectrolyzerRecipes.reInit();
    }
}
