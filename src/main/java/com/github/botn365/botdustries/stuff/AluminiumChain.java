package com.github.botn365.botdustries.stuff;

import com.github.botn365.botdustries.loaders.Fluids;
import com.github.botn365.botdustries.loaders.MaterialsBot;
import gregtech.api.enums.GT_Values;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GT_Recipe;
import gregtech.api.util.GT_Utility;
import lombok.val;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

import static gregtech.api.enums.OrePrefixes.*;
import static gregtech.api.util.GT_Utility.getIntegratedCircuit;

public class AluminiumChain {
    public static void add() {
        val circuit1 = GT_Utility.getIntegratedCircuit(1);
        FluidStack moltenCryolite = Fluids.MOLTEN_CRYOLITE.getFluid(144);
        FluidStack nahosol = MaterialsBot.SodiumHydroxideSolution.getFluidOrGas(4000);
        ItemStack cryoliteDust = gregtech.api.enums.Materials.Cryolite.getDust(1);
        GT_Recipe.GT_Recipe_Map.sBlastRecipes.addRecipe(false,new ItemStack[]{cryoliteDust},null,null,null,null,new FluidStack[]{moltenCryolite},100,480,1100);
        GT_Values.RA.addFluidSolidifierRecipe(null,moltenCryolite,cryoliteDust,100,30);
        GT_Values.RA.addFluidHeaterRecipe(Materials.SodiumHydroxide.getDust(1),Materials.Water.getFluid(4000),nahosol,20,120);
        val bauxiteSolution = MaterialsBot.BauxiteSolution.getFluidOrGas(1000);
        nahosol.amount = 1000;
        GT_Recipe.GT_Recipe_Map.sAutoclaveRecipes.addRecipe(false,new ItemStack[]{Materials.Bauxite.getDust(1)},null,null,new FluidStack[]{nahosol},new FluidStack[]{bauxiteSolution},200,30,0);
        bauxiteSolution.amount = 2500;
        val aluminaSolution = Fluids.ALUMINA_SOLUTION.getFluid(1000);
        GT_Recipe.GT_Recipe_Map.sChemicalBathRecipes.addRecipe(false,new ItemStack[]{circuit1},new ItemStack[]{MaterialsBot.RedMud.get(dust)},null,new FluidStack[]{bauxiteSolution},new FluidStack[]{aluminaSolution},2400,16,0);
        val alumina = MaterialsBot.Alumina.get(dust);
        GT_Recipe.GT_Recipe_Map.sDistilleryRecipes.addRecipe(false,null,new ItemStack[]{alumina},null,new FluidStack[]{aluminaSolution},new FluidStack[]{nahosol},200,30,0);
        cryoliteDust.stackSize = 63;
        moltenCryolite.amount = 9216;
        alumina.stackSize = 12;
        GT_Recipe.GT_Recipe_Map.sArcFurnaceRecipes.addRecipe(false,new ItemStack[]{alumina},new ItemStack[]{cryoliteDust},null,new FluidStack[]{moltenCryolite},new FluidStack[]{Materials.Aluminium.getMolten(1728)},480,360,0);

        GT_Values.RA.addChemicalRecipe(Materials.HydrofluoricAcid.getCells(2),null,Fluids.ALUMINA_SOLUTION.getFluid(1000 ),null,Materials.Cryolite.getDust(1),Materials.Empty.getCells(2),240,480 );


        GT_Values.RA.addChemicalRecipe(Materials.Propene.getCells(1),Materials.Oxygen.getCells(2),Materials.Ammonia.getGas(1000),MaterialsBot.Acrylonitrile.getFluidOrGas(1000),Materials.Water.getCells(3),80,480);
        GT_Values.RA.addChemicalRecipe(Materials.Water.getCells(1),Materials.Copper.getDustTiny(1),MaterialsBot.Acrylonitrile.getFluidOrGas(1000),null,MaterialsBot.Acrylamide.get(dust),Materials.Empty.getCells(1),40,30 );

        GT_Values.RA.addMultiblockChemicalRecipe(
                new ItemStack[]{Materials.Tin.getDust(1)}
                ,new FluidStack[]{MaterialsBot.Nitromethane.getFluidOrGas(4000),Materials.HydrochloricAcid.getFluid(2000),Materials.Methanol.getFluid(4000)},
                new FluidStack[]{MaterialsBot.TMEDA.getFluidOrGas(1000)},
                null,500,480);

        GT_Values.RA.addMultiblockChemicalRecipe(
                new ItemStack[]{MaterialsBot.AmmoniaPersulfate.get(dust,2),MaterialsBot.Acrylamide.get(dust,9)}
                ,new FluidStack[]{Materials.Water.getFluid(8000),MaterialsBot.TMEDA.getFluidOrGas(100)},
                null,
                new ItemStack[]{MaterialsBot.polyAcrylamide.get(dust,9)},600,1920);

        bauxiteSolution.amount = 27000;
        aluminaSolution.amount = 18000;
        GT_Recipe.GT_Recipe_Map.sChemicalBathRecipes.addRecipe(false,new ItemStack[]{MaterialsBot.polyAcrylamide.get(dust)},new ItemStack[]{MaterialsBot.RedMud.get(dust,18)},null,new FluidStack[]{bauxiteSolution},new FluidStack[]{aluminaSolution},2700,480,0);


    }
}
