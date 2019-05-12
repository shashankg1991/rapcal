package com.spectra.rapcal.enums;

public enum UpperLimit {
    LIMIT_0_03(0.03),
    LIMIT_0_07(0.07),
    LIMIT_0_14(0.14),
    LIMIT_0_17(0.17),
    LIMIT_0_22(0.22),
    LIMIT_0_29(0.29),
    LIMIT_0_39(0.39),
    LIMIT_0_49(0.49),
    LIMIT_0_69(0.69),
    LIMIT_0_89(0.89),
    LIMIT_0_99(0.99),
    LIMIT_1_49(1.49),
    LIMIT_1_99(1.99),
    LIMIT_2_99(2.99),
    LIMIT_3_99(3.99),
    LIMIT_4_99(4.99),
    LIMIT_5_99(5.99),
    LIMIT_10_99(10.99);

    Double upperLimit;

    private UpperLimit(Double upperLimit) {
        this.upperLimit = upperLimit;
    }

    @Override
    public String toString() {
        return upperLimit.toString();
    }
}
