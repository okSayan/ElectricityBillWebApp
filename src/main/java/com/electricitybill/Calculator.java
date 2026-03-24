package com.electricitybill;

import java.util.List;

// This is YOUR original logic, cleaned up for web use.
// No more file reading — the web form sends us the kWh directly!
public class Calculator {

    // Slab rates hardcoded from your slabs.txt
    // Each entry is: { slabLimit, ratePerUnit }
    private static final double[][] SLAB_RATES = {
        {102,        5.00},
        {78,         6.24},
        {120,        6.89},
        {300,        7.44},
        {300,        7.43},
        {2147483647, 9.22}
    };

    // This is your calculateBill() method — exactly the same logic!
    public double calculateBill(int wattHour) {
        double billAmount = 0;
        int unitsLeft = wattHour;

        for (double[] slab : SLAB_RATES) {
            double slabLimit = slab[0];
            double slabRate  = slab[1];

            if (unitsLeft > 0) {
                double unitsInThisSlab = Math.min(unitsLeft, slabLimit);
                billAmount += unitsInThisSlab * slabRate;
                unitsLeft  -= unitsInThisSlab;
            } else {
                break;
            }
        }

        return billAmount;
    }
}
