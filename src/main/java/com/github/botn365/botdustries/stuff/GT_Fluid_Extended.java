package com.github.botn365.botdustries.stuff;

import com.github.botn365.botdustries.loaders.Fluids;
import gregtech.api.objects.GT_Fluid;
import gregtech.api.util.GT_LanguageManager;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;

public class GT_Fluid_Extended extends GT_Fluid {
    public GT_Fluid_Extended(String aName, String aTextureName, short[] aRGBa) {
        super(aName, aTextureName, aRGBa);
    }

    public FluidStack getFluid(int amount) {
        return new FluidStack(this,amount);
    }
}
