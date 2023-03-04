package com.github.botn365.botdustries.stuff;

import gregtech.api.enums.GT_Values;
import gregtech.api.enums.Materials;
import gregtech.api.util.GT_Utility;
import ic2.core.Ic2Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

import static com.github.bartimaeusnek.bartworks.system.material.WerkstoffLoader.*;
import static com.github.bartimaeusnek.bartworks.system.material.WerkstoffLoader.Sodiumsulfate;
import static com.github.botn365.botdustries.loaders.MaterialsBot.*;
import static gregtech.api.enums.OrePrefixes.*;
import static gregtech.api.enums.OrePrefixes.cell;

public class RocketFuels {
    public static void add() {
        ItemStack C1 = GT_Utility.getIntegratedCircuit(1);
        ItemStack C2 = GT_Utility.getIntegratedCircuit(2);
        ItemStack C24 = GT_Utility.getIntegratedCircuit(24);
        //LMP103S
        GT_Values.RA.addChemicalRecipe(Materials.CarbonMonoxide.getCells(1), C2, Materials.Chlorine.getGas(2000),
                null, Phosgene.get(cell, 1), 50, 480);
        GT_Values.RA.addChemicalRecipe(Phosgene.get(cell, 1), C2, Materials.Ethanol.getFluid(1000),
                Materials.HydrochloricAcid.getGas(1000), Ethylchloroformate.get(cell, 1), 20, 1920);

        GT_Values.RA.addChemicalRecipe(Ethylchloroformate.get(cell, 1), C2, Materials.Ammonia.getGas(2000),
                AmmoniumChloride.getFluidOrGas(1000), Ethylcarbamate.get(cell, 1), 200, 120);

        GT_Values.RA.addChemicalRecipe(Ethylcarbamate.get(cell, 1), C2, Materials.NitricAcid.getFluid(1000),
                Materials.Water.getFluid(1000), EthylNnitrocarbamate.get(cell, 1), 40, 1024);

        GT_Values.RA.addChemicalRecipe(EthylNnitrocarbamate.get(cell, 1), C2, Materials.Ammonia.getGas(1000),
                null, AmmoniumNnitrourethane.get(cell, 1), 40, 1920);

        GT_Values.RA.addChemicalRecipe(AmmoniumNnitrourethane.get(cell, 1), DinitrogenPentoxide.get(dust, 1), null, null,
                EthylDinitrocarbamate.get(cell, 1), AmmoniumNitrate.get(dust, 1), 200, 480);

        GT_Values.RA.addChemicalRecipe(EthylDinitrocarbamate.get(cell, 1), C2, Materials.Ammonia.getGas(2000),
                Ethylcarbamate.getFluidOrGas(980), AmmoniumDinitramide.get(cell, 1), 200, 1920);

        GT_Values.RA.addMultiblockChemicalRecipe(
                new ItemStack[]{C24},
                new FluidStack[]{
                        AmmoniumDinitramide.getFluidOrGas(6000),
                        Materials.Methanol.getFluid(2000),
                        Materials.Ammonia.getGas(500),
                        Materials.Water.getFluid(1500)},
                new FluidStack[]{LMP103S.getFluidOrGas(10000)},
                null,
                1200, 1920);

        GT_Values.RA.addChemicalRecipe(Materials.PhosphorousPentoxide.getDust(1), C2, Materials.NitricAcid.getFluid(12000),
                Materials.PhosphoricAcid.getFluid(4000), DinitrogenPentoxide.get(dust, 6), 200, 1920);

        GT_Values.RA.addDistilleryRecipe(C2, Materials.PhosphoricAcid.getFluid(1000),
                Materials.Water.getFluid(500), Materials.Phosphorus.getDust(1), 20, 480, false);

        ItemStack cells = Ic2Items.cell.copy();
        cells.stackSize = 1;
        GT_Values.RA.addDistilleryRecipe(cells,AmmoniumChloride.getFluidOrGas(1000),
                Materials.HydrochloricAcid.getFluid(1000),Materials.Ammonia.getCells(1),50,120,false);

        GT_Values.RA.addChemicalRecipeForBasicMachineOnly(AmmoniumNitrate.get(dust, 1), Materials.SodiumHydroxide.getDust(1), null,
                Materials.Ammonia.getGas(1000), SodiumNitrate.get(dust, 2), null, 100, 480);

        GT_Values.RA.addMultiblockChemicalRecipe(
                new ItemStack[]{AmmoniumNitrate.get(dust, 1), Materials.SodiumHydroxide.getDust(1), C2},
                null,
                new FluidStack[]{Materials.Ammonia.getGas(1000)},
                new ItemStack[]{SodiumNitrate.get(dust, 2)},
                100, 480
        );

        GT_Values.RA.addChemicalRecipe(SodiumNitrate.get(dust, 4), C2, Materials.SulfuricAcid.getFluid(2000),
                Materials.NitricAcid.getFluid(2000), Sodiumsulfate.get(dust, 1), 200, 120);

        GT_Values.RA.addMultiblockChemicalRecipe(
                new ItemStack[]{
                        C24,
                        AmmoniumNitrate.get(dust, 2),
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
                300, 480
        );

        //Monomethylhydrazine
        cells.stackSize = 1;
        GT_Values.RA.addCrackingRecipe(1, Materials.Toluene.getFluid(1000), Materials.Methanol.getFluid(1000),
                OXylene.getFluidOrGas(1000), 600, 4096);

        GT_Values.RA.addChemicalRecipe(OXylene.get(cell, 1), VanadiumPentoxide.get(dustTiny), Materials.Oxygen.getGas(3000),
                Materials.Water.getFluid(3000), PhthalicAnhydride.get(dust, 1), 800, 1920);

        GT_Values.RA.addBlastRecipe(Materials.Vanadium.getDust(2), C2, null,
                null, VanadiumPentoxide.get(dust, 5), null, 200, 120, 700);

        GT_Values.RA.addChemicalRecipe(Materials.Benzene.getCells(1), C2, Materials.Butene.getGas(1000),
                TertButylbenzene.getFluidOrGas(1000), cells, 100, 1920);

        GT_Values.RA.addChemicalRecipe(PhthalicAnhydride.get(dust, 1), C2, TertButylbenzene.getFluidOrGas(1000),
                TwoTertButylAnthraquinone.getFluidOrGas(1000), null, 200, 7680);

        GT_Values.RA.addChemicalRecipeForBasicMachineOnly(Materials.Hydrogen.getCells(10), Materials.Palladium.getDustTiny(1),
                TwoTertButylAnthraquinone.getFluidOrGas(10000),
                TwoTertButylAnthrahydroquinone.getFluidOrGas(10000), null, null, 1200, 7680);

        GT_Values.RA.addMultiblockChemicalRecipe(
                new ItemStack[]{C2, Materials.Palladium.getDustTiny(1)},
                new FluidStack[]{
                        Materials.Hydrogen.getGas(10000),
                        TwoTertButylAnthraquinone.getFluidOrGas(10000)
                },
                new FluidStack[]{TwoTertButylAnthrahydroquinone.getFluidOrGas(10000)},
                null,
                1200, 7680
        );

        GT_Values.RA.addChemicalRecipe(Materials.Oxygen.getCells(1), C2, TwoTertButylAnthrahydroquinone.getFluidOrGas(1000),
                TwoTertButylAnthraquinone.getFluidOrGas(900), HydrogenPeroxide.get(cell, 1), 40, 1920);

        GT_Values.RA.addMultiblockChemicalRecipe(
                new ItemStack[]{
                        C24,
                        Materials.Palladium.getDustTiny(1)
                },
                new FluidStack[]{
                        Materials.Hydrogen.getGas(10000),
                        Materials.Oxygen.getGas(10000),
                        TwoTertButylAnthraquinone.getFluidOrGas(10000)
                },
                new FluidStack[]{
                        HydrogenPeroxide.getFluidOrGas(10000),
                        TwoTertButylAnthraquinone.getFluidOrGas(9000)
                },
                null,
                1400, 7680
        );

        GT_Values.RA.addChemicalRecipe(HydrogenPeroxide.get(cell, 1), C2, Materials.Ammonia.getGas(2000),
                Materials.Water.getFluid(2000), Hydrazine.get(cell, 2), 100, 120);

        GT_Values.RA.addChemicalRecipe(Materials.SulfuricAcid.getCells(1), C2, Materials.Methanol.getFluid(2000),
                null, DimethylSulfate.get(cell, 1), 50, 480);

        GT_Values.RA.addChemicalRecipeForBasicMachineOnly(Materials.SulfuricAcid.getCells(1), C1, Materials.Methanol.getFluid(2000),
                DimethylSulfate.getFluidOrGas(1000), cells, null, 50, 480);

        GT_Values.RA.addChemicalRecipe(Hydrazine.get(cell, 2), C2, DimethylSulfate.getFluidOrGas(1000),
                Materials.SulfurTrioxide.getGas(1000), Monomethylhydrazine.get(cell, 2), 80, 16000);

        GT_Values.RA.addChemicalRecipeForBasicMachineOnly(DimethylSulfate.get(cell, 1), C1, Hydrazine.getFluidOrGas(2000),
                Monomethylhydrazine.getFluidOrGas(2000), Materials.SulfurTrioxide.getCells(1), null, 80, 16000);

        GT_Values.RA.addMixerRecipe(AmmoniumDinitramide.get(cell, 1), C1, null, null, Monomethylhydrazine.getFluidOrGas(2000),
                MonomethylhydrazineFuelMix.getFluidOrGas(3000), cells, 20, 480);
        cells.stackSize = 2;

        GT_Values.RA.addMixerRecipe(Monomethylhydrazine.get(cell, 2), C2, null, null, AmmoniumDinitramide.getFluidOrGas(1000),
                MonomethylhydrazineFuelMix.getFluidOrGas(3000), cells, 20, 480);
        cells.stackSize = 1;

        //unsimetrical hydazine

        GT_Values.RA.addCrackingRecipe(2,Materials.Propane.getGas(1000),Materials.NitricAcid.getFluid(1000),
                Nitromethane.getFluidOrGas(1000),300,1920);

        GT_Values.RA.addMultiblockChemicalRecipe(
                new ItemStack[]{C2},
                new FluidStack[]{
                        Materials.HydrofluoricAcid.getFluid(1000),
                        BoronTrifluoride.getFluidOrGas(1000),
                        Nitromethane.getFluidOrGas(1000),
                        Materials.NitricAcid.getFluid(1000)},
                new FluidStack[]{
                        Materials.Methane.getGas(1000),
                        Materials.Water.getFluid(1000),
                        Materials.NitricOxide.getGas(1000)},
                new ItemStack[]{NitroniumTetrafluoroborate.get(dust,1)},
                100,7_680
        );

        GT_Values.RA.addMultiblockChemicalRecipe(
                new ItemStack[]{C2,NitroniumTetrafluoroborate.get(dust,1)},
                new FluidStack[]{AmmoniumDinitramide.getFluidOrGas(1000)},
                new FluidStack[]{
                        Trinitramid.getFluidOrGas(1000),
                        AmmoniaBoronfluorideSolution.getFluidOrGas(1000)
                },
                null,
                20,30_720
        );

        cells.stackSize = 3;
        GT_Values.RA.addChemicalRecipe(BoronTrioxide.get(dust,1),cells,Materials.HydrofluoricAcid.getFluid(6000),
                BoronTrifluoride.getFluidOrGas(2000),Materials.Water.getCells(3),50,480);

        GT_Values.RA.addChemicalRecipe(Materials.Borax.getDust(23),C2,Materials.SulfuricAcid.getFluid(1000),
                null,Sodiumsulfate.get(dust,1),BoronTrioxide.get(dust,2),400,1920);

        cells.stackSize = 1;
        GT_Values.RA.addDistilleryRecipe(cells,AmmoniaBoronfluorideSolution.getFluidOrGas(1000),
                Tetrafluoroborate.getFluidOrGas(1000),Materials.Ammonia.getCells(1),20,30_720,false);

        GT_Values.RA.addChemicalRecipe(Materials.SodiumHydroxide.getDust(1),cells,Tetrafluoroborate.getFluidOrGas(1000),
                SodiumTetrafluoroborate.getFluidOrGas(1000),Materials.Water.getCells(1),100,1920);

        GT_Values.RA.addDistilleryRecipe(C2,SodiumTetrafluoroborate.getFluidOrGas(1000),
                BoronTrifluoride.getFluidOrGas(1000),SodiumFluoride.get(dust,1),40,480,false);

        GT_Values.RA.addChemicalRecipe(SodiumFluoride.get(dust,2),C2,Materials.SulfuricAcid.getFluid(1000),
                Materials.HydrofluoricAcid.getFluid(2000),Sodiumsulfate.get(dust,1),50,1920);

        GT_Values.RA.addChemicalRecipe(Materials.Oxygen.getCells(4),Materials.Silver.getDustTiny(1),Materials.Methanol.getFluid(4000),
                Formaldehyde.getFluidOrGas(4000),cells,100,480);

        GT_Values.RA.addMultiblockChemicalRecipe(
                new ItemStack[]{C2},
                new FluidStack[]{
                        Materials.AceticAcid.getFluid(1000),
                        Materials.Ethanol.getFluid(1000),
                        Hydrazine.getFluidOrGas(1000)},
                new FluidStack[]{
                        Acetylhydrazine.getFluidOrGas(1000),
                        Materials.Ethanol.getFluid(900)},
                null,
                40,30_720
        );

        GT_Values.RA.addMultiblockChemicalRecipe(
                new ItemStack[]{C2},
                new FluidStack[]{
                        Acetylhydrazine.getFluidOrGas(1000),
                        Formaldehyde.getFluidOrGas(1000),
                        Materials.Hydrogen.getGas(2000)},
                new FluidStack[]{
                        UnsymmetricalDimethylhydrazine.getFluidOrGas(2000),
                        Materials.AceticAcid.getFluid(900)},
                null,
                20, 122_880
        );

        GT_Values.RA.addMixerRecipe(UnsymmetricalDimethylhydrazine.get(cell,2),C2,null,null,
                Trinitramid.getFluidOrGas(1000),UnsymmetricalDimethylhydrazineFuelMix.getFluidOrGas(3000),cells,10,120);

        GT_Values.RA.addMixerRecipe(Trinitramid.get(cell,1),C2,null,null,
                UnsymmetricalDimethylhydrazine.getFluidOrGas(2000),UnsymmetricalDimethylhydrazineFuelMix.getFluidOrGas(3000),cells,10,120);


    }
}
