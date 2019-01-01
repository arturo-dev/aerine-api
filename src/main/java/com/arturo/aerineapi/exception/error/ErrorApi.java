package com.arturo.aerineapi.exception.error;

import lombok.Builder;
import lombok.Data;
import lombok.Generated;

@Data
@Builder
@Generated
public class ErrorApi {
    private String code;
    private String defaultMessage;
    private String objectName;
}