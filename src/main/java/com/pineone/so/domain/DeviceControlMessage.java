package com.pineone.so.domain;

/**
 * Created by use on 2015-09-23.
 */
public class DeviceControlMessage {

    String _uri;
    String _command;
    String cnf;
    String con;

    public DeviceControlMessage() {
    }

    public DeviceControlMessage(String _uri, String _command, String cnf, String con) {
        this._uri = _uri;
        this._command = _command;
        this.cnf = cnf;
        this.con = con;
    }

    public String get_uri() {
        return _uri;
    }

    public void set_uri(String _uri) {
        this._uri = _uri;
    }

    public String get_command() {
        return _command;
    }

    public void set_command(String _command) {
        this._command = _command;
    }

    public String getCnf() {
        return cnf;
    }

    public void setCnf(String cnf) {
        this.cnf = cnf;
    }

    public String getCon() {
        return con;
    }

    public void setCon(String con) {
        this.con = con;
    }

}
