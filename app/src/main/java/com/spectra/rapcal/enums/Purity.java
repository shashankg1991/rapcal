package com.spectra.rapcal.enums;

public enum Purity {
    IF("IF"),
    VVS1("VVS1"),
    VVS2("VVS2"),
    VS1("VS1"),
    VS2("VS2"),
    SI1("SI1"),
    SI2("SI2"),
    SI3("SI3"),
    I1("I1"),
    I2("I2"),
    I3("I3");
    String purityCode;

    private Purity(String purityCode) {
        this.purityCode = purityCode;
    }

    @Override
    public String toString() {
        return purityCode;
    }
}
