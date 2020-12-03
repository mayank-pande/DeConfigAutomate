package ai.infrrd.idc.entity;

import ai.infrrd.idc.entity.DeconfigResponseData;

public class FinalizedDeconfigResponse {
    String message;

    DeconfigResponseData data;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DeconfigResponseData getData() {
        return data;
    }

    public void setData(DeconfigResponseData data) {
        this.data = data;
    }
}
