package com.pineone.so.domain;

/**
 * Created by use on 2015-09-09.
 */
public class ContextModel {

    String contextModelName;
    String domianID;

    public ContextModel() {
    }

    public ContextModel(String contextModelName, String domianID) {
        this.contextModelName = contextModelName;
        this.domianID = domianID;
    }

    public String getContextModelName() {
        return contextModelName;
    }

    public void setContextModelName(String contextModelName) {
        this.contextModelName = contextModelName;
    }

    public String getDomianID() {
        return domianID;
    }

    public void setDomianID(String domianID) {
        this.domianID = domianID;
    }
}
