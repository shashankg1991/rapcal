package com.spectra.rapcal.enums;

public enum Shape {
    ROUND("ROUND"),
    FANCY("FANCY");

    String shapeCode;

    private Shape(String shapeCode) {
        this.shapeCode = shapeCode;
    }

    @Override
    public String toString() {
        return shapeCode;
    }
}
