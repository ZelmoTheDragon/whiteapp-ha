package com.github.zelmothedragon.whiteapp.infrastructure;

import javax.json.bind.annotation.JsonbProperty;
import javax.json.bind.annotation.JsonbPropertyOrder;
import javax.json.bind.config.PropertyOrderStrategy;

/**
 *
 * @author MOSELLE Maxime
 */
@JsonbPropertyOrder(PropertyOrderStrategy.LEXICOGRAPHICAL)
public class ErrorMessage {

    @JsonbProperty(value = "error", nillable = false)
    private String error;

    @JsonbProperty(value = "message", nillable = false)
    private String message;

    public ErrorMessage() {
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
