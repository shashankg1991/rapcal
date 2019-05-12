package com.spectra.rapcal.persistence.entity;

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
import static com.spectra.rapcal.enums.Shape.ROUND;

@Entity(tableName = "raps", indices = {@Index(value = {"color", "purity", "fromWeight", "toWeight", "shape"},
        unique = true)})
public class Rap {
    @PrimaryKey(autoGenerate = true)
    Integer id;
    String color;
    String purity;
    Double fromWeight;
    Double toWeight;
    String shape;
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

    public static Rap[] populateRaps() {
        return new Rap[]{
                new Rap(ROUND, D, IF, 0.01d, 0.03d, 7.1d),
                new Rap(ROUND, E, IF, 0.01d, 0.03d, 7.1d),
                new Rap(ROUND, F, IF, 0.01d, 0.03d, 7.1d),
                new Rap(ROUND, G, IF, 0.01d, 0.03d, 6.5d),
                new Rap(ROUND, H, IF, 0.01d, 0.03d, 6.5d),
                new Rap(ROUND, I, IF, 0.01d, 0.03d, 5.6d),
                new Rap(ROUND, J, IF, 0.01d, 0.03d, 5.6d),
                new Rap(ROUND, K, IF, 0.01d, 0.03d, 3.9d),
                new Rap(ROUND, L, IF, 0.01d, 0.03d, 3.9d),
                new Rap(ROUND, M, IF, 0.01d, 0.03d, 2.8d),
                new Rap(ROUND, N, IF, 0.01d, 0.03d, 2.8d),

                new Rap(ROUND, D, VVS1, 0.01d, 0.03d, 7.1d),
                new Rap(ROUND, E, VVS1, 0.01d, 0.03d, 7.1d),
                new Rap(ROUND, F, VVS1, 0.01d, 0.03d, 7.1d),
                new Rap(ROUND, G, VVS1, 0.01d, 0.03d, 6.5d),
                new Rap(ROUND, H, VVS1, 0.01d, 0.03d, 6.5d),
                new Rap(ROUND, I, VVS1, 0.01d, 0.03d, 5.6d),
                new Rap(ROUND, J, VVS1, 0.01d, 0.03d, 5.6d),
                new Rap(ROUND, K, VVS1, 0.01d, 0.03d, 3.9d),
                new Rap(ROUND, L, VVS1, 0.01d, 0.03d, 3.9d),
                new Rap(ROUND, M, VVS1, 0.01d, 0.03d, 2.8d),
                new Rap(ROUND, N, VVS1, 0.01d, 0.03d, 2.8d),

                new Rap(ROUND, D, VVS2, 0.01d, 0.03d, 7.1d),
                new Rap(ROUND, E, VVS2, 0.01d, 0.03d, 7.1d),
                new Rap(ROUND, F, VVS2, 0.01d, 0.03d, 7.1d),
                new Rap(ROUND, G, VVS2, 0.01d, 0.03d, 6.5d),
                new Rap(ROUND, H, VVS2, 0.01d, 0.03d, 6.5d),
                new Rap(ROUND, I, VVS2, 0.01d, 0.03d, 5.6d),
                new Rap(ROUND, J, VVS2, 0.01d, 0.03d, 5.6d),
                new Rap(ROUND, K, VVS2, 0.01d, 0.03d, 3.9d),
                new Rap(ROUND, L, VVS2, 0.01d, 0.03d, 3.9d),
                new Rap(ROUND, M, VVS2, 0.01d, 0.03d, 2.8d),
                new Rap(ROUND, N, VVS2, 0.01d, 0.03d, 2.8d),

                new Rap(ROUND, D, VS1, 0.01d, 0.03d, 6.8d),
                new Rap(ROUND, E, VS1, 0.01d, 0.03d, 6.8d),
                new Rap(ROUND, F, VS1, 0.01d, 0.03d, 6.8d),
                new Rap(ROUND, G, VS1, 0.01d, 0.03d, 6.0d),
                new Rap(ROUND, H, VS1, 0.01d, 0.03d, 6.0d),
                new Rap(ROUND, I, VS1, 0.01d, 0.03d, 5.3d),
                new Rap(ROUND, J, VS1, 0.01d, 0.03d, 5.3d),
                new Rap(ROUND, K, VS1, 0.01d, 0.03d, 3.5d),
                new Rap(ROUND, L, VS1, 0.01d, 0.03d, 3.5d),
                new Rap(ROUND, M, VS1, 0.01d, 0.03d, 2.3d),
                new Rap(ROUND, N, VS1, 0.01d, 0.03d, 2.3d),

                new Rap(ROUND, D, VS2, 0.01d, 0.03d, 6.8d),
                new Rap(ROUND, E, VS2, 0.01d, 0.03d, 6.8d),
                new Rap(ROUND, F, VS2, 0.01d, 0.03d, 6.8d),
                new Rap(ROUND, G, VS2, 0.01d, 0.03d, 6.0d),
                new Rap(ROUND, H, VS2, 0.01d, 0.03d, 6.0d),
                new Rap(ROUND, I, VS2, 0.01d, 0.03d, 5.3d),
                new Rap(ROUND, J, VS2, 0.01d, 0.03d, 5.3d),
                new Rap(ROUND, K, VS2, 0.01d, 0.03d, 3.5d),
                new Rap(ROUND, L, VS2, 0.01d, 0.03d, 3.5d),
                new Rap(ROUND, M, VS2, 0.01d, 0.03d, 2.3d),
                new Rap(ROUND, N, VS2, 0.01d, 0.03d, 2.3d),

                new Rap(ROUND, D, SI1, 0.01d, 0.03d, 5.7d),
                new Rap(ROUND, E, SI1, 0.01d, 0.03d, 5.7d),
                new Rap(ROUND, F, SI1, 0.01d, 0.03d, 5.7d),
                new Rap(ROUND, G, SI1, 0.01d, 0.03d, 5.1d),
                new Rap(ROUND, H, SI1, 0.01d, 0.03d, 5.1d),
                new Rap(ROUND, I, SI1, 0.01d, 0.03d, 4.7d),
                new Rap(ROUND, J, SI1, 0.01d, 0.03d, 4.7d),
                new Rap(ROUND, K, SI1, 0.01d, 0.03d, 3.3d),
                new Rap(ROUND, L, SI1, 0.01d, 0.03d, 3.3d),
                new Rap(ROUND, M, SI1, 0.01d, 0.03d, 2.0d),
                new Rap(ROUND, N, SI1, 0.01d, 0.03d, 2.0d),

                new Rap(ROUND, D, SI2, 0.01d, 0.03d, 4.9d),
                new Rap(ROUND, E, SI2, 0.01d, 0.03d, 4.9d),
                new Rap(ROUND, F, SI2, 0.01d, 0.03d, 4.9d),
                new Rap(ROUND, G, SI2, 0.01d, 0.03d, 4.5d),
                new Rap(ROUND, H, SI2, 0.01d, 0.03d, 4.5d),
                new Rap(ROUND, I, SI2, 0.01d, 0.03d, 4.2d),
                new Rap(ROUND, J, SI2, 0.01d, 0.03d, 4.2d),
                new Rap(ROUND, K, SI2, 0.01d, 0.03d, 2.9d),
                new Rap(ROUND, L, SI2, 0.01d, 0.03d, 2.9d),
                new Rap(ROUND, M, SI2, 0.01d, 0.03d, 1.7d),
                new Rap(ROUND, N, SI2, 0.01d, 0.03d, 1.7d),

                new Rap(ROUND, D, SI3, 0.01d, 0.03d, 3.9d),
                new Rap(ROUND, E, SI3, 0.01d, 0.03d, 3.9d),
                new Rap(ROUND, F, SI3, 0.01d, 0.03d, 3.9d),
                new Rap(ROUND, G, SI3, 0.01d, 0.03d, 3.7d),
                new Rap(ROUND, H, SI3, 0.01d, 0.03d, 3.7d),
                new Rap(ROUND, I, SI3, 0.01d, 0.03d, 3.4d),
                new Rap(ROUND, J, SI3, 0.01d, 0.03d, 3.4d),
                new Rap(ROUND, K, SI3, 0.01d, 0.03d, 2.6d),
                new Rap(ROUND, L, SI3, 0.01d, 0.03d, 2.6d),
                new Rap(ROUND, M, SI3, 0.01d, 0.03d, 1.5d),
                new Rap(ROUND, N, SI3, 0.01d, 0.03d, 1.5d),

                new Rap(ROUND, D, I1, 0.01d, 0.03d, 3.6d),
                new Rap(ROUND, E, I1, 0.01d, 0.03d, 3.6d),
                new Rap(ROUND, F, I1, 0.01d, 0.03d, 3.6d),
                new Rap(ROUND, G, I1, 0.01d, 0.03d, 3.3d),
                new Rap(ROUND, H, I1, 0.01d, 0.03d, 3.3d),
                new Rap(ROUND, I, I1, 0.01d, 0.03d, 2.8d),
                new Rap(ROUND, J, I1, 0.01d, 0.03d, 2.8d),
                new Rap(ROUND, K, I1, 0.01d, 0.03d, 2.2d),
                new Rap(ROUND, L, I1, 0.01d, 0.03d, 2.2d),
                new Rap(ROUND, M, I1, 0.01d, 0.03d, 1.3d),
                new Rap(ROUND, N, I1, 0.01d, 0.03d, 1.3d),

                new Rap(ROUND, D, I2, 0.01d, 0.03d, 3.0d),
                new Rap(ROUND, E, I2, 0.01d, 0.03d, 3.0d),
                new Rap(ROUND, F, I2, 0.01d, 0.03d, 3.0d),
                new Rap(ROUND, G, I2, 0.01d, 0.03d, 2.9d),
                new Rap(ROUND, H, I2, 0.01d, 0.03d, 2.9d),
                new Rap(ROUND, I, I2, 0.01d, 0.03d, 2.5d),
                new Rap(ROUND, J, I2, 0.01d, 0.03d, 2.5d),
                new Rap(ROUND, K, I2, 0.01d, 0.03d, 1.7d),
                new Rap(ROUND, L, I2, 0.01d, 0.03d, 1.7d),
                new Rap(ROUND, M, I2, 0.01d, 0.03d, 1.1d),
                new Rap(ROUND, N, I2, 0.01d, 0.03d, 1.1d),

                new Rap(ROUND, D, I3, 0.01d, 0.03d, 2.1d),
                new Rap(ROUND, E, I3, 0.01d, 0.03d, 2.1d),
                new Rap(ROUND, F, I3, 0.01d, 0.03d, 2.1d),
                new Rap(ROUND, G, I3, 0.01d, 0.03d, 2.3d),
                new Rap(ROUND, H, I3, 0.01d, 0.03d, 2.3d),
                new Rap(ROUND, I, I3, 0.01d, 0.03d, 2.1d),
                new Rap(ROUND, J, I3, 0.01d, 0.03d, 2.1d),
                new Rap(ROUND, K, I3, 0.01d, 0.03d, 1.3d),
                new Rap(ROUND, L, I3, 0.01d, 0.03d, 1.3d),
                new Rap(ROUND, M, I3, 0.01d, 0.03d, 0.8d),
                new Rap(ROUND, N, I3, 0.01d, 0.03d, 0.8d),
        };
    }
}
