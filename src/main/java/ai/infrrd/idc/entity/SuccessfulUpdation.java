package ai.infrrd.idc.entity;

import ai.infrrd.idc.entity.Data;

public class SuccessfulUpdation {
    String message;
    Data data;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }
}
