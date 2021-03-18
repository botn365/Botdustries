package com.github.botn365.botdustries.loaders;

import com.github.bartimaeusnek.bartworks.system.material.WerkstoffLoader;
import gregtech.api.enums.GT_Values;
import gregtech.api.enums.Materials;
import gregtech.api.util.GT_OreDictUnificator;
import gregtech.api.util.GT_Recipe;
import gregtech.api.util.GT_Utility;
import ic2.api.item.IC2Items;
import ic2.core.Ic2Items;
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
        ItemStack C1 = GT_Utility.getIntegratedCircuit(1);
        ItemStack C2 = GT_Utility.getIntegratedCircuit(2);

        GT_Values.RA.addChemicalRecipe(Materials.Calcite.getDust(1), Materials.Empty.getCells(1),
                Materials.HydrochloricAcid.getFluid(2000), Materials.Water.getFluid(1000),
                Materials.CarbonDioxide.getCells(1), WerkstoffLoader.CalciumChloride.get(dust,3), 80,120);

        // tungsten chain
        FluidStack sodiumTungsten = SodiumTungstate.getFluidOrGas(4000);
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
        ItemStack H2WO4 = TungsticAcid.get(dust,1);
        GT_Values.RA.addChemicalRecipe(scheelite, null, Materials.HydrochloricAcid.getFluid(4000), null,
                H2WO4,Ca2Cl,200,480);

        ItemStack WO3 = TungstenTrioxide.get(dust,1);
        GT_Values.RA.addBlastRecipe(H2WO4,null, null, null, WO3, null,
                200, 480, 1200);

        ItemStack WO3Fe = TungstenSteelOxide.get(dust,2);
        GT_Values.RA.addMixerRecipe(WO3,Materials.Steel.getDust(1),null,null,null,null,
                WO3Fe,100,1920);

        WO3.stackSize = 2;
        GT_Values.RA.addBlastRecipe(WO3, Materials.Carbon.getDust(3),null, Materials.CarbonDioxide.getGas(6000),
                GT_OreDictUnificator.get(ingotHot, Materials.Tungsten,2L),null,8000, 1920, 3000);

        WO3Fe.stackSize = 4;
        GT_Values.RA.addBlastRecipe(WO3Fe, Materials.Carbon.getDust(3),Materials.Nitrogen.getGas(4000), Materials.CarbonDioxide.getGas(6000),
                GT_OreDictUnificator.get(ingotHot, Materials.TungstenSteel,4L),null,10000, 1920, 3000);

        //rocket fuels
        GT_Values.RA.addChemicalRecipe(Materials.CarbonMonoxide.getCells(1),C2,Materials.Chlorine.getGas(2000),
                null, Phosgene.get(cell,1),60,480);
        GT_Values.RA.addChemicalRecipe(Phosgene.get(cell,1),C2,Materials.Ethanol.getFluid(1000),
                Materials.HydrochloricAcid.getGas(1000), Ethylchloroformate.get(cell,1),200,1920);

        GT_Values.RA.addChemicalRecipe(Ethylchloroformate.get(cell,1),C2,Materials.Ammonia.getGas(2000),
                WerkstoffLoader.AmmoniumChloride.getFluidOrGas(1000), Ethylcarbamate.get(cell,1),200,1920);

        GT_Values.RA.addChemicalRecipe(Ethylcarbamate.get(cell,1),C2,Materials.NitricAcid.getFluid(1000),
                Materials.Water.getFluid(1000), EthylNnitrocarbamate.get(cell,1),200,1920);

        GT_Values.RA.addChemicalRecipe(EthylNnitrocarbamate.get(cell,1),C2,Materials.Ammonia.getGas(1000),
                null, AmmoniumNnitrourethane.get(cell,1),200,1920);

        GT_Values.RA.addChemicalRecipe(AmmoniumNnitrourethane.get(cell,1), DinitrogenPentoxide.get(dust,1),null,null,
                EthylDinitrocarbamate.get(cell,1), AmmoniumNitrate.get(dust,1),200,1920);

        GT_Values.RA.addChemicalRecipe(EthylDinitrocarbamate.get(cell,1),C2,Materials.Ammonia.getGas(2000),
                Ethylcarbamate.getFluidOrGas(980), AmmoniumDinitramide.get(cell,1),200,1920);

        GT_Values.RA.addMultiblockChemicalRecipe(
                new ItemStack[]{C2},
                new FluidStack[]{
                        AmmoniumDinitramide.getFluidOrGas(6000),
                        Materials.Methanol.getFluid(2000),
                        Materials.Ammonia.getGas(500),
                        Materials.Water.getFluid(1500)},
                new FluidStack[]{LMP103S.getFluidOrGas(10000)},
                null,
                2000,1920);

        GT_Values.RA.addChemicalRecipe(Materials.PhosphorousPentoxide.getDust(1),C2,Materials.NitricAcid.getFluid(12000),
                Materials.PhosphoricAcid.getFluid(4000), DinitrogenPentoxide.get(dust,6),200,1920);

        GT_Values.RA.addDistilleryRecipe(C2,Materials.PhosphoricAcid.getFluid(1000),
                Materials.Water.getFluid(500),Materials.Phosphorus.getDust(1),20,480,false);

        GT_Values.RA.addFluidHeaterRecipe(C2,WerkstoffLoader.AmmoniumChloride.getFluidOrGas(1000),
                HeatedAmmoniaChloride.getFluidOrGas(1000),50,120);

        ItemStack cells = Ic2Items.cell.copy();
        cells.stackSize = 10;
        GT_Values.RA.addChemicalRecipeForBasicMachineOnly(HeatedAmmoniaChloride.get(cell,10),C1,null,
                Materials.Ammonia.getGas(10000),Materials.HydrochloricAcid.getCells(10),null,1,30);

        GT_Values.RA.addChemicalRecipe(HeatedAmmoniaChloride.get(cell,10),C2,null,
                Materials.HydrochloricAcid.getFluid(10000),Materials.Ammonia.getCells(10),null,1,30);

        GT_Values.RA.addChemicalRecipeForBasicMachineOnly(cells,C1,HeatedAmmoniaChloride.getFluidOrGas(10000),
                Materials.Ammonia.getGas(10000),Materials.HydrochloricAcid.getCells(10),null,1,30);

        GT_Values.RA.addChemicalRecipeForBasicMachineOnly(cells,C2,HeatedAmmoniaChloride.getFluidOrGas(10000),
                Materials.HydrochloricAcid.getFluid(10000),Materials.Ammonia.getCells(10),null,1,30);


        GT_Values.RA.addChemicalRecipeForBasicMachineOnly(AmmoniumNitrate.get(dust,1),Materials.SodiumHydroxide.getDust(1),null,
                Materials.Ammonia.getGas(1000),WerkstoffLoader.SodiumNitrate.get(dust,2),null,100,480);

        GT_Values.RA.addMultiblockChemicalRecipe(
                new ItemStack[]{AmmoniumNitrate.get(dust,1),Materials.SodiumHydroxide.getDust(1),C2},
                null,
                new FluidStack[]{Materials.Ammonia.getGas(1000)},
                new ItemStack[]{WerkstoffLoader.SodiumNitrate.get(dust,2)},
                100,480
        );

        GT_Values.RA.addChemicalRecipe(WerkstoffLoader.SodiumNitrate.get(dust,4),C2,Materials.SulfuricAcid.getFluid(2000),
                Materials.NitricAcid.getFluid(2000),WerkstoffLoader.Sodiumsulfate.get(dust,1),200,120);

        GT_Values.RA.addMultiblockChemicalRecipe(
                new ItemStack[]{
                        GT_Utility.getIntegratedCircuit(24),
                        AmmoniumNitrate.get(dust,2),
                        Materials.SodiumHydroxide.getDust(2)
                },
                new FluidStack[]{
                        Materials.SulfuricAcid.getFluid(1000),
                        Materials.Hydrogen.getGas(2000)
                },
                new FluidStack[]{
                       Materials.Ammonia.getGas(2000),
                       Materials.NitricAcid.getFluid(2000)
                },
                new ItemStack[]{Materials.Sodium.getDust(2)},
                300,480
        );

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
                Materials.Tungstate.getDust(1),
                WerkstoffLoader.Ferberite.get(dust, 1),
                WerkstoffLoader.Huebnerit.get(dust, 1)};
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
