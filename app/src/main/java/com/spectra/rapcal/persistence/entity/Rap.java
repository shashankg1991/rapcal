package com.spectra.rapcal.persistence.entity;

import com.google.gson.annotations.SerializedName;
import com.spectra.rapcal.enums.Color;
import com.spectra.rapcal.enums.Purity;
import com.spectra.rapcal.enums.Shape;

import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import static com.spectra.rapcal.enums.Color.D;
import static com.spectra.rapcal.enums.Color.E;
import static com.spectra.rapcal.enums.Color.F;
import static com.spectra.rapcal.enums.Color.G;
import static com.spectra.rapcal.enums.Color.H;
import static com.spectra.rapcal.enums.Color.I;
import static com.spectra.rapcal.enums.Color.J;
import static com.spectra.rapcal.enums.Color.K;
import static com.spectra.rapcal.enums.Color.L;
import static com.spectra.rapcal.enums.Color.M;
import static com.spectra.rapcal.enums.Color.N;
import static com.spectra.rapcal.enums.Purity.I1;
import static com.spectra.rapcal.enums.Purity.I2;
import static com.spectra.rapcal.enums.Purity.I3;
import static com.spectra.rapcal.enums.Purity.IF;
import static com.spectra.rapcal.enums.Purity.SI1;
import static com.spectra.rapcal.enums.Purity.SI2;
import static com.spectra.rapcal.enums.Purity.SI3;
import static com.spectra.rapcal.enums.Purity.VS1;
import static com.spectra.rapcal.enums.Purity.VS2;
import static com.spectra.rapcal.enums.Purity.VVS1;
import static com.spectra.rapcal.enums.Purity.VVS2;
import static com.spectra.rapcal.enums.Shape.FANCY;
import static com.spectra.rapcal.enums.Shape.ROUND;

@Entity(tableName = "raps", indices = {@Index(value = {"color", "purity", "fromWeight", "toWeight", "shape"},
        unique = true)})
public class Rap {
    @PrimaryKey(autoGenerate = true)
    Integer id;
    @SerializedName("color")
    String color;
    @SerializedName("purity")
    String purity;
    @SerializedName("from")
    Double fromWeight;
    @SerializedName("to")
    Double toWeight;
    @SerializedName("shape")
    String shape;
    @SerializedName("rap")
    Double value;

    public Rap() {
    }

    public Rap(Shape shape, Color color, Purity purity, Double fromWeight, Double toWeight, Double value) {
        this.shape = shape.toString();
        this.color = color.toString();
        this.purity = purity.toString();
        this.fromWeight = fromWeight;
        this.toWeight = toWeight;
        this.value = value;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPurity() {
        return purity;
    }

    public void setPurity(String purity) {
        this.purity = purity;
    }

    public Double getFromWeight() {
        return fromWeight;
    }

    public void setFromWeight(Double fromWeight) {
        this.fromWeight = fromWeight;
    }

    public Double getToWeight() {
        return toWeight;
    }

    public void setToWeight(Double toWeight) {
        this.toWeight = toWeight;
    }

    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

}
