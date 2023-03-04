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

import static gregtech.api.enums.OrePrefixes.dust;
import static gregtech.api.util.GT_Utility.getIntegratedCircuit;

public class AluminiumChain {
    public static void add() {
        val circuit1 = GT_Utility.getIntegratedCircuit(1);
        FluidStack moltenCryolite = Fluids.MOLTEN_CRYOLITE.getFluid(144);
        FluidStack nahosol = MaterialsBot.SodiumHydroxideSolution.getFluidOrGas(1000);
        ItemStack cryoliteDust = gregtech.api.enums.Materials.Cryolite.getDust(1);
        GT_Recipe.GT_Recipe_Map.sBlastRecipes.addRecipe(false,new ItemStack[]{cryoliteDust},null,null,null,null,new FluidStack[]{moltenCryolite},100,480,1100);
        GT_Values.RA.addFluidSolidifierRecipe(null,moltenCryolite,cryoliteDust,100,30);
        GT_Values.RA.addFluidHeaterRecipe(Materials.SodiumHydroxide.getDust(1),Materials.Water.getFluid(1000),nahosol,20,120);
        val bauxiteSolution = MaterialsBot.BauxiteSolution.getFluidOrGas(1000);
        GT_Recipe.GT_Recipe_Map.sAutoclaveRecipes.addRecipe(false,new ItemStack[]{Materials.Bauxite.getDust(1)},null,null,new FluidStack[]{nahosol},new FluidStack[]{bauxiteSolution},200,30,0);
        bauxiteSolution.amount = 4000;
        val aluminaSolution = Fluids.ALUMINA_SOLUTION.getFluid(1000);
        GT_Recipe.GT_Recipe_Map.sChemicalBathRecipes.addRecipe(false,new ItemStack[]{circuit1},new ItemStack[]{MaterialsBot.RedMud.get(dust)},null,new FluidStack[]{bauxiteSolution},new FluidStack[]{aluminaSolution},2400,16,0);
        val alumina = MaterialsBot.Alumina.get(dust);
        GT_Recipe.GT_Recipe_Map.sDistilleryRecipes.addRecipe(false,null,new ItemStack[]{alumina},null,new FluidStack[]{aluminaSolution},new FluidStack[]{nahosol},200,30,0);
        cryoliteDust.stackSize = 8;
        moltenCryolite.amount = 1296;
        GT_Recipe.GT_Recipe_Map.sArcFurnaceRecipes.addRecipe(false,new ItemStack[]{alumina},new ItemStack[]{cryoliteDust},null,new FluidStack[]{moltenCryolite},new FluidStack[]{Materials.Aluminium.getMolten(144)},40,480,0);
    }
}
