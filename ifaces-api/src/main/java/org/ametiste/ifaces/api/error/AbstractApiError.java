package org.ametiste.ifaces.api.error;

import java.util.Collections;
import java.util.Map;
import java.util.Map.Entry;

// TODO: add AbstractError(String, String) constructor which will create an error with 
// the empty properties map.
public class AbstractApiError implements ApiError {
    
    private final String code;
    
    private final String message;
    
    private final Map<String, String> properties;
    
    public AbstractApiError(final String code, final String message, final Map<String, String> properties) {
        this.code = code;
        this.properties = properties;
        this.message = evaluteMessageString(message);
    }
    
    public AbstractApiError(final String code, final String message, final String propertyName, final String propertyValue) {
        this(code, message, Collections.singletonMap(propertyName, propertyValue));
    }
    
    @Override
    public String getCode() {
        return code;
    }
    
    @Override
    public String getMessage() {
        return message;
    }
    
    @Override
    public Map<String, String> getProperties() {
        return properties;
    }
    
    @Override
    public boolean hasProperties() {
        return !properties.isEmpty();
    }
    
    private String evaluteMessageString(final String messageString) {
        if (messageString.startsWith("{") && messageString.endsWith("}")) {
            String evaluted = messageString.substring(1, messageString.length() - 1);
            for (final Entry<String, String> keyValue : properties.entrySet()) {
                evaluted = evaluted.replaceAll("(\\{" + keyValue.getKey() + "\\})", keyValue.getValue());
            }
            return evaluted;
        } else {
            return messageString;
        }
    }
    
}
