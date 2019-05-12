package com.spectra.rapcal.enums;

public enum CertificateType {
    IGI("IGI"),
    GIA("GIA");

    String certificateType;

    private CertificateType(String certificateType) {
        this.certificateType = certificateType;
    }

    @Override
    public String toString() {
        return certificateType;
    }
}
