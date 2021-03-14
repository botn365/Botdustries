package com.github.botn365.botdustries.loaders;

import com.github.bartimaeusnek.bartworks.system.material.WerkstoffLoader;
import gregtech.api.enums.GTNH_ExtraMaterials;
import gregtech.api.enums.GT_Values;
import gregtech.api.enums.Materials;
import gregtech.api.util.GT_OreDictUnificator;
import gregtech.api.util.GT_Recipe;
import gregtech.api.util.GT_Utility;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

import java.util.Collection;
import java.util.HashSet;

import static com.github.botn365.botdustries.loaders.MaterialsClass.*;
import static gregtech.api.enums.OrePrefixes.*;

public class Recipes
{
    public static void addGTRecipe()
    {

        GT_Values.RA.addChemicalRecipe(Materials.Calcite.getDust(1), Materials.Empty.getCells(1),
                Materials.HydrochloricAcid.getFluid(2000), Materials.Water.getFluid(1000),
                Materials.CarbonDioxide.getCells(1), WerkstoffLoader.CalciumChloride.get(dust,3), 80,120);

        // tungsten chain
        FluidStack sodiumTungsten = new FluidStack(LoadFluids.sodiumTungstate,4000);
        ItemStack scheelite = Materials.Scheelite.getDust(7);

        GT_Values.RA.addAutoclaveRecipe(Materials.Tungstate.getDust(7), Materials.SodiumHydroxide.getDust(4),
                Materials.Water.getFluid(4000),sodiumTungsten, Materials.Lithium.getDust(2),10000, 100, 1920, false);

        GT_Values.RA.addAutoclaveRecipe(WerkstoffLoader.Huebnerit.get(dust, 5), Materials.SodiumHydroxide.getDust(4),
                Materials.Water.getFluid(4000),sodiumTungsten, Materials.Manganese.getDust(1),10000, 100, 1920, false);

        GT_Values.RA.addAutoclaveRecipe(WerkstoffLoader.Ferberite.get(dust, 5), Materials.SodiumHydroxide.getDust(4),
                Materials.Water.getFluid(4000),sodiumTungsten, Materials.Iron.getDust(1),10000, 100, 1920, false);

        ItemStack Ca2Cl =  WerkstoffLoader.CalciumChloride.get(dust,6);
        GT_Values.RA.addChemicalRecipe(Ca2Cl,null ,sodiumTungsten, null,
                scheelite, Materials.Salt.getDust(8),100, 480);

        Ca2Cl.stackSize = 6;
        ItemStack H2WO4 = tungsticAcid.get(dust,1);
        GT_Values.RA.addChemicalRecipe(scheelite, null, Materials.HydrochloricAcid.getFluid(4000), null,
                H2WO4,Ca2Cl,200,480);

        ItemStack WO3 = tungstenTrioxide.get(dust,1);
        GT_Values.RA.addBlastRecipe(H2WO4,null, null, null, WO3, null,
                200, 480, 1200);

        ItemStack WO3Fe = tungstenSteelOxide.get(dust,2);
        GT_Values.RA.addMixerRecipe(WO3,Materials.Steel.getDust(1),null,null,null,null,
                WO3Fe,100,1920);

        WO3.stackSize = 2;
        GT_Values.RA.addBlastRecipe(WO3, Materials.Carbon.getDust(3),null, Materials.CarbonDioxide.getGas(6000),
                GT_OreDictUnificator.get(ingotHot, Materials.Tungsten,2L),null,8000, 1920, 3000);

        WO3Fe.stackSize = 4;
        GT_Values.RA.addBlastRecipe(WO3Fe, Materials.Carbon.getDust(3),Materials.Nitrogen.getGas(4000), Materials.CarbonDioxide.getGas(6000),
                GT_OreDictUnificator.get(ingotHot, Materials.TungstenSteel,4L),null,5000, 1920, 6000);

    }

    public static void removeRecipes()
    {
        Recipes.removeTungstenElectro();

    }

    public static void removeTungstenElectro()
    {
        Collection<GT_Recipe> electroRecipeMap = GT_Recipe.GT_Recipe_Map.sElectrolyzerRecipes.mRecipeList;
        HashSet<GT_Recipe> toDel = new HashSet<>();
        ItemStack[] toRemove = {
                Materials.Scheelite.getDust(1),
                Materials.Tungstate.getDust(1),
                WerkstoffLoader.Ferberite.get(dust,1),
                WerkstoffLoader.Huebnerit.get(dust,1)};
        for (GT_Recipe tRecipe : electroRecipeMap)
        {
            if (tRecipe.mFakeRecipe)
                continue;
            for (int i = 0; i < tRecipe.mInputs.length; i++) {
                ItemStack tItem = tRecipe.mInputs[i];
                if (item == null || !GT_Utility.isStackValid(tItem))
                    continue;
                for (ItemStack tStack: toRemove)
                {
                    if (GT_Utility.areStacksEqual(tItem,tStack))
                    {
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
