package eu.ludimus.model;

import lombok.Getter;

@Getter
public class ErrorInfo {
    private String code;
    private String message;

    public ErrorInfo(final String code, final String message) {
        this.code = code;
        this.message = message;
    }
}
