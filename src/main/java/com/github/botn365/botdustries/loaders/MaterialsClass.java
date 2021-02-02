package com.github.botn365.botdustries.loaders;

import com.github.bartimaeusnek.bartworks.system.material.Werkstoff;
import com.github.bartimaeusnek.bartworks.util.Pair;
import gregtech.api.enums.*;
import gregtech.api.items.GT_MetaGenerated_Item;
import gregtech.api.enums.Materials;
import java.util.Arrays;

import static gregtech.api.enums.Materials.*;
import static gregtech.api.enums.TextureSet.*;

import static com.github.bartimaeusnek.bartworks.system.material.Werkstoff.Types.*;

public class MaterialsClass implements Runnable
{
     //reserved material ids 29_899-29_999
//    public static final Werkstoff calciumTungstate = new Werkstoff(
//            new short[]{0xc, 0xed, 0xd7},
//            "Calcium Tungstate",
//            new Werkstoff.Stats(),
//            COMPOUND,
//            new Werkstoff.GenerationFeatures().onlyDust().enforceUnification(),
//            29899,
//            SET_FINE,
//            new Pair<>(Sodium, 2),
//            new Pair<>(Tungsten, 1),
//            new Pair<>(Oxygen, 4)
//    );

    public static final Werkstoff tungsticAcid = new Werkstoff(
            new short[]{0xf5, 0xf1, 0x16},
            "Tungstic Acid",
            new Werkstoff.Stats(),
            COMPOUND,
            new Werkstoff.GenerationFeatures().onlyDust().enforceUnification(),
            29900,
            SET_SHINY,
            new Pair<>(Hydrogen,2),
            new Pair<>(Tungsten,1),
            new Pair<>(Oxygen,4)
    );

    public static final Werkstoff tungstenTrioxide = new Werkstoff(
            new short[]{0x0f,0x5,0x16},
            "Tungsten Trioxide",
            new Werkstoff.Stats(),
            COMPOUND,
            new Werkstoff.GenerationFeatures().onlyDust().enforceUnification(),
            29901,
            SET_SHINY,
            new Pair<>(Tungsten, 1),
            new Pair<>(Oxygen,3)
    );

    @Override
    public void run()
    {
    }
}
