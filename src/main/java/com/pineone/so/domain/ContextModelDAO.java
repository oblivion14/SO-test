package com.pineone.so.domain;

import java.util.ArrayList;

/**
 * Created by use on 2015-09-14.
 */
public interface ContextModelDAO {
    ArrayList<ContextModel> getContextModels();
    void inserContextModel(ContextModel contextModel);
    ContextModel updateContextModel(ContextModel contextModel);
    void deleteContextModel(ContextModel contextModel);
    ContextModel getContextModel(ContextModel contextModel);
}
