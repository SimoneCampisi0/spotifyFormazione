package com.simonecampisi.spotifyFormazione.dto.response;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class ErrorsResponse {
    private Map<String, String> errorStatus;

    public ErrorsResponse(String error) {
        errorStatus = new HashMap<>();
        errorStatus.put("Status: ",error);
    }
}
