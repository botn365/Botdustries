package com.github.botn365.botdustries.loaders;

import com.github.bartimaeusnek.bartworks.system.material.Werkstoff;
import com.github.bartimaeusnek.bartworks.util.Pair;
import gregtech.api.enums.TextureSet;

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
    public static final Werkstoff TungsticAcid = new Werkstoff(
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
    public static final Werkstoff TungstenTrioxide = new Werkstoff(
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
    public static final Werkstoff TungstenSteelOxide = new Werkstoff(
            new short[]{0x1f,0x27,0x69},
            "Tungstensteel Oxide",
            new Werkstoff.Stats(),
            COMPOUND,
            new Werkstoff.GenerationFeatures().onlyDust(),
            29902,
            SET_FINE,
            new Pair<>(Tungsten, 1),
            new Pair<>(Oxygen,3),
            new Pair<>(Steel,1)
    );
    public static final Werkstoff AmmoniumNitrate = new Werkstoff(
            new short[]{0x81,0xcc,0x00},
            "Ammonium Nitrate",
            new Werkstoff.Stats(),
            COMPOUND,
            new Werkstoff.GenerationFeatures().onlyDust(),
            29903,
            SET_FINE,
            new Pair<>(Nitrogen,1),
            new Pair<>(Hydrogen,4),
            new Pair<>(Nitrogen,1),
            new Pair<>(Oxygen,3)
    );
    public static final Werkstoff SodiumTungstate = new Werkstoff(
            new short[]{0xc, 0xed, 0xd7,0},
            "Sodium Tungstate",
            new Werkstoff.Stats(),
            COMPOUND,
            new Werkstoff.GenerationFeatures().disable().addCells(),
            29904,
            SET_FINE
    );
    public static final Werkstoff Phosgene = new Werkstoff(
            new short[]{0x15,0xa1,0x1a},
            "Phosgene",
            new Werkstoff.Stats(),
            COMPOUND,
            new Werkstoff.GenerationFeatures().disable().addCells(),
            29905,
            SET_FINE
    );
    public static final Werkstoff Ethylchloroformate = new Werkstoff(
            new short[]{0x0a,0xc2,0xcc},
            "Ethyl Chloroformate",
            new Werkstoff.Stats(),
            COMPOUND,
            new Werkstoff.GenerationFeatures().disable().addCells(),
            29906,
            SET_FINE
    );
    public static final Werkstoff Ethylcarbamate = new Werkstoff(
            new short[]{0x0d,0xa9,0xb8},
            "Ethyl Carbamate",
            new Werkstoff.Stats(),
            COMPOUND,
            new Werkstoff.GenerationFeatures().disable().addCells(),
            29907,
            SET_FINE
    );
    public static final Werkstoff EthylNnitrocarbamate = new Werkstoff(
            new short[]{0x0d,0x85,0xb8},
            "Ethyl N-nitrocarbamate",
            new Werkstoff.Stats(),
            COMPOUND,
            new Werkstoff.GenerationFeatures().disable().addCells(),
            29908,
            SET_FINE
    );
    public static final Werkstoff AmmoniumNnitrourethane = new Werkstoff(
            new short[]{0x0d,0x54,0xb8},
            "Ammonium N-nitrourethane",
            new Werkstoff.Stats(),
            COMPOUND,
            new Werkstoff.GenerationFeatures().disable().addCells(),
            29909,
            SET_FINE
    );
    public static final Werkstoff EthylDinitrocarbamate = new Werkstoff(
            new short[]{0x39,0x08,0xc2},
            "Ethyl Dinitrocarbamate",
            new Werkstoff.Stats(),
            COMPOUND,
            new Werkstoff.GenerationFeatures().disable().addCells(),
            29910,
            SET_FINE
    );
    public static final Werkstoff DinitrogenPentoxide = new Werkstoff(
            new short[]{0xcf,0xeb,0x34},
            "Dinitrogen Pentoxide",
            new Werkstoff.Stats(),
            COMPOUND,
            new Werkstoff.GenerationFeatures().onlyDust(),
            29911,
            SET_FINE
    );
    public static final Werkstoff AmmoniumDinitramide = new Werkstoff(
            new short[]{0x8a,0x0f,0xd1},
            "Ammonium Dinitramide",
            new Werkstoff.Stats(),
            COMPOUND,
            new Werkstoff.GenerationFeatures().disable().addCells(),
            29912,
            SET_FINE
    );
    public static final Werkstoff LMP103S = new Werkstoff(
            new short[]{0xbf,0x2f,0xc2},
            "LMP-103S",
            new Werkstoff.Stats(),
            COMPOUND,
            new Werkstoff.GenerationFeatures().disable().addCells(),
            29913,
            SET_FINE
    );
    public static final Werkstoff HeatedAmmoniaChloride = new Werkstoff(
            new short[]{0x59,0x5f,0x69},
            "Heated Ammonia Chloride",
            new Werkstoff.Stats(),
            COMPOUND,
            new Werkstoff.GenerationFeatures().disable().addCells(),
            29914,
            SET_FINE
    );
    public static final Werkstoff OExylene = new Werkstoff(
            new short[]{0x88,0x94,0xa8},
            "O-Exylene",
            new Werkstoff.Stats().setGas(true),
            COMPOUND,
            new Werkstoff.GenerationFeatures().disable().addCells(),
            29915,
            SET_FINE
    );
    public static final Werkstoff PhthalicAnhydride = new Werkstoff(
            new short[]{0x7c,0x99,0x42},
            "Phthalic Anhydride",
            new Werkstoff.Stats(),
            COMPOUND,
            new Werkstoff.GenerationFeatures().onlyDust(),
            29916,
            SET_METALLIC
    );
    public static final Werkstoff  VanadiumPentoxide = new Werkstoff(
            new short[]{0x69,0x69,0x69},
            " Vanadium Pentoxide",
            new Werkstoff.Stats(),
            COMPOUND,
            new Werkstoff.GenerationFeatures().onlyDust(),
            29917,
            SET_METALLIC
    );
    public static final Werkstoff  TertButylbenzene = new Werkstoff(
            new short[]{0,0,0},
            "Tert-Butylbenzene",
            new Werkstoff.Stats(),
            COMPOUND,
            new Werkstoff.GenerationFeatures().disable().addCells(),
            29918,
            SET_METALLIC
    );
    public static final Werkstoff  TwoTertButylAnthraquinone = new Werkstoff(
            new short[]{0xcc,0x86,0x5a},
            "2-tert-butyl-anthraquinone",
            new Werkstoff.Stats(),
            COMPOUND,
            new Werkstoff.GenerationFeatures().disable().addCells(),
            29919,
            SET_METALLIC
    );
    public static final Werkstoff  TwoTertButylAnthrahydroquinone = new Werkstoff(
            new short[]{0xad,0x53,0x1a},
            "2-tert-butyl-anthrahydroquinone",
            new Werkstoff.Stats(),
            COMPOUND,
            new Werkstoff.GenerationFeatures().disable().addCells(),
            29920,
            SET_METALLIC
    );
    public static final Werkstoff  HydrogenPeroxide = new Werkstoff(
            new short[]{0xad,0x53,0x1a},
            "Hydrogen Peroxide",
            new Werkstoff.Stats(),
            COMPOUND,
            new Werkstoff.GenerationFeatures().disable().addCells(),
            29921,
            SET_METALLIC
    );
    public static final Werkstoff  Hydrazine = new Werkstoff(
            new short[]{0xb5,0x07,0x07},
            "hydrazine",
            new Werkstoff.Stats(),
            COMPOUND,
            new Werkstoff.GenerationFeatures().disable().addCells(),
            29922,
            SET_METALLIC
    );
    public static final Werkstoff  DimethylSulfate = new Werkstoff(
            new short[]{0xff,0xfb,0x00},
            "Dimethyl Sulfate",
            new Werkstoff.Stats(),
            COMPOUND,
            new Werkstoff.GenerationFeatures().disable().addCells(),
            29923,
            SET_METALLIC
    );
    public static final Werkstoff  Monomethylhydrazine = new Werkstoff(
            new short[]{0xff,0x61,0x00},
            "Monomethylhydrazine",
            new Werkstoff.Stats(),
            COMPOUND,
            new Werkstoff.GenerationFeatures().disable().addCells(),
            29924,
            SET_METALLIC
    );
    public static final Werkstoff  Formaldehyde = new Werkstoff(
            new short[]{0x2e,0xd9,0x83},
            "Formaldehyde",
            new Werkstoff.Stats(),
            COMPOUND,
            new Werkstoff.GenerationFeatures().disable().addCells(),
            29925,
            SET_METALLIC
    );
    public static final Werkstoff  EthylAcetate = new Werkstoff(
            new short[]{0x0c,0xfb,0x32b},
            "Ethyl Acetate",
            new Werkstoff.Stats(),
            COMPOUND,
            new Werkstoff.GenerationFeatures().disable().addCells(),
            29926,
            SET_METALLIC
    );
    public static final Werkstoff  Acetylhydrazine = new Werkstoff(
            new short[]{0xd1,0x5c,0x5c},
            "Acetylhydrazine",
            new Werkstoff.Stats(),
            COMPOUND,
            new Werkstoff.GenerationFeatures().disable().addCells(),
            29927,
            SET_METALLIC
    );
    public static final Werkstoff  UnsymmetricalDimethylhydrazine = new Werkstoff(
            new short[]{0x80,0x06,0x00},
            "Unsymmetrical Dimethylhydrazine",
            new Werkstoff.Stats(),
            COMPOUND,
            new Werkstoff.GenerationFeatures().disable().addCells(),
            29928,
            SET_METALLIC
    );



    @Override
    public void run()
    {
    }
}
