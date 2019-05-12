package com.spectra.rapcal.enums;

public enum LowerLimit {
    LIMIT_0_01(0.01),
    LIMIT_0_04(0.04),
    LIMIT_0_08(0.08),
    LIMIT_0_15(0.15),
    LIMIT_0_18(0.18),
    LIMIT_0_23(0.23),
    LIMIT_0_30(0.30),
    LIMIT_0_40(0.40),
    LIMIT_0_50(0.50),
    LIMIT_0_70(0.70),
    LIMIT_0_90(0.90),
    LIMIT_1_00(1.00),
    LIMIT_1_50(1.50),
    LIMIT_2_00(2.00),
    LIMIT_3_00(3.00),
    LIMIT_4_00(4.00),
    LIMIT_5_00(5.00),
    LIMIT_10_00(10.00);

    Double lowerLimit;

    private LowerLimit(Double lowerLimit) {
        this.lowerLimit = lowerLimit;
    }

    @Override
    public String toString() {
        return lowerLimit.toString();
    }
}
