package org.ametiste.ifaces.api.error;

import java.util.Map;

public interface ApiError {
    
    String getCode();
    
    String getMessage();
    
    Map<String, String> getProperties();
    
    boolean hasProperties();

}
