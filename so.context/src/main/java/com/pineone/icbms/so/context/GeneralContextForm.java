package com.pineone.icbms.so.context;

import com.pineone.icbms.so.context.concept.ConceptService;

import java.util.List;

/**
 * Created by melvin on 2016. 7. 8..
 */
public class GeneralContextForm {
    List<ConceptService> conceptServiceList;
    int minValue;
    int maxValue;

    public List<ConceptService> getConceptServiceList() {
        return conceptServiceList;
    }

    public void setConceptServiceList(List<ConceptService> conceptServiceList) {
        this.conceptServiceList = conceptServiceList;
    }

    public int getMinValue() {
        return minValue;
    }

    public void setMinValue(int minValue) {
        this.minValue = minValue;
    }

    public int getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(int maxValue) {
        this.maxValue = maxValue;
    }
}
