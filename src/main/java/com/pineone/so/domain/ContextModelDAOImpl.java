package com.pineone.so.domain;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
/**
 * Created by use on 2015-09-14.
 */
public class ContextModelDAOImpl implements ContextModelDAO {

    @Autowired
    MongoTemplate mongoTemplate;

    private static String COLLECTION_NAME = "contextcollect";

    @Override
    public ArrayList<ContextModel> getContextModels() {
        return (ArrayList<ContextModel>) mongoTemplate.findAll(ContextModel.class, COLLECTION_NAME);
    }

    @Override
    public void inserContextModel(ContextModel contextModel) {
        mongoTemplate.insert(contextModel, COLLECTION_NAME);
    }

    @Override
    public ContextModel updateContextModel(ContextModel contextModel) {
        Query query = new Query(new Criteria("id").is(contextModel.getDomianID()));
        Update update = new Update();
        update.set("domianID", contextModel.getDomianID());
        update.set("contextModelName", contextModel.getContextModelName());
        mongoTemplate.updateFirst(query, update, COLLECTION_NAME);
        return contextModel;

    }

    @Override
    public void deleteContextModel(ContextModel contextModel) {
        Query query = new Query(new Criteria("id").is(contextModel.getDomianID()));
        mongoTemplate.remove(query, COLLECTION_NAME);

    }

    @Override
    public ContextModel getContextModel(ContextModel contextModel) {
        return mongoTemplate.findById(contextModel.getDomianID(), ContextModel.class, COLLECTION_NAME);
    }
}
