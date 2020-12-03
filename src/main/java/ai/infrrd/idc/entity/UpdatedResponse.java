package ai.infrrd.idc.entity;

import ai.infrrd.idc.entity.UpdatedResponseBody;

public class UpdatedResponse {
    String message;
    UpdatedResponseBody data;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public UpdatedResponseBody getData() {
        return data;
    }

    public void setData(UpdatedResponseBody data) {
        this.data = data;
    }
}
