package com.spectra.rapcal.persistence.service;

import com.spectra.rapcal.persistence.entity.Rap;
import com.spectra.rapcal.util.StringUtil;

import java.util.List;

public class RapService {
    private static RapService rapService = null;

    private RapService() {
    }

    public static RapService getInstance() {
        if (null == rapService) {
            rapService = new RapService();
        }
        return rapService;
    }

    public void addRap(String shape, String color, String purity, String lowerLimit, String upperLimit, String value) {
        Rap rap = new Rap();
        rap.setShape(shape);
        rap.setColor(color);
        rap.setPurity(purity);
        rap.setFromWeight(StringUtil.getDoubleValue(lowerLimit));
        rap.setToWeight(StringUtil.getDoubleValue(upperLimit));
        rap.setValue(StringUtil.getDoubleValue(value));
        PersistanceService.getInstance().getDb().rapDao().addRap(rap);
    }

    public void updateRap(Integer id, String shape, String color, String purity, String lowerLimit, String upperLimit, String value) {
        Rap rap = new Rap();
        rap.setId(id);
        rap.setShape(shape);
        rap.setColor(color);
        rap.setPurity(purity);
        rap.setFromWeight(StringUtil.getDoubleValue(lowerLimit));
        rap.setToWeight(StringUtil.getDoubleValue(upperLimit));
        rap.setValue(StringUtil.getDoubleValue(value));
        PersistanceService.getInstance().getDb().rapDao().addRap(rap);
    }

    public void deleteRap(Integer id) {
        PersistanceService.getInstance().getDb().rapDao().deleteRap(id);
    }

    public List<Rap> getAllRaps() {
        return PersistanceService.getInstance().getDb().rapDao().findAllRaps();
    }

    public Rap getRapById(Integer id) {
        return PersistanceService.getInstance().getDb().rapDao().findRapById(id);
    }

    public Rap getRap(String shape, String color, String purity, Double weight) {
        return PersistanceService.getInstance().getDb().rapDao().findRap(color, purity, shape, weight);
    }
}
