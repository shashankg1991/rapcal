package com.spectra.rapcal.persistence.service;

import com.spectra.rapcal.activity.LoginActivity;
import com.spectra.rapcal.persistence.entity.Rap;
import com.spectra.rapcal.persistence.entity.Stone;
import com.spectra.rapcal.persistence.service.PersistanceService;
import com.spectra.rapcal.util.StringUtil;

import java.util.List;

public class StoneService {
    private static StoneService stoneService = null;


    private StoneService() {
    }

    public static StoneService getInstance() {
        if (null == stoneService) {
            stoneService = new StoneService();
        }
        return stoneService;
    }

    public void addStone(String shape, String color, String purity, String weight, String discount, String certificateType, String party, String reportId, String comments) {
        Stone stone = new Stone();
        stone.setShape(shape);
        stone.setColor(color);
        stone.setPurity(purity);
        stone.setWeight(null != weight ? Double.valueOf(weight) : 0d);
        stone.setValue(calculate(shape, color, purity, weight, discount));
        stone.setParty(party);
        stone.setReportId(reportId);
        stone.setCertificateType(certificateType);
        stone.setComments(comments);
        stone.setDiscountPercentage(null != discount ? Double.valueOf(discount) : 0d);
        PersistanceService.getInstance().getDb().stoneDao().addStone(stone);
    }

    public void updateStone(Integer id, String shape, String color, String purity, String weight, String discount, String certificateType, String party, String reportId, String comments) {
        Stone stone = new Stone();
        stone.setId(id);
        stone.setShape(shape);
        stone.setColor(color);
        stone.setPurity(purity);
        stone.setWeight(Double.valueOf(weight));
        stone.setValue(calculate(shape, color, purity, weight, discount));
        stone.setParty(party);
        stone.setReportId(reportId);
        stone.setCertificateType(certificateType);
        stone.setComments(comments);
        PersistanceService.getInstance().getDb().stoneDao().addStone(stone);
    }

    public void deleteStone(Integer id) {
        PersistanceService.getInstance().getDb().stoneDao().deleteStone(id);
    }

    public List<Stone> getAllStones() {
        return PersistanceService.getInstance().getDb().stoneDao().findAllStones();
    }

    public Stone getStoneById(Integer id) {
        return PersistanceService.getInstance().getDb().stoneDao().findStoneById(id);
    }

    public Double calculate(String shape, String color, String purity, String weight, String discount) {
        Rap rap = RapService.getInstance().getRap(shape, color, purity, getDoubleValueFromString(weight));
        if (null == rap) {
            return 0.0d;
        } else {
            return (double)Math.round(rap.getValue() * (1 - (getDoubleValueFromString(discount) / 100)) * getDoubleValueFromString(weight) * LoginActivity.dollarRate);
        }
    }

    private double getDoubleValueFromString(String value) {
        if (StringUtil.isEmpty(value)) {
            return 0.0d;
        } else {
            return Double.valueOf(value);
        }
    }
}
