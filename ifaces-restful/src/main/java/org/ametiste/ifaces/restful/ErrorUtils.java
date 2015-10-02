package org.ametiste.ifaces.restful;

import org.ametiste.ifaces.api.error.ApiError;
import org.springframework.web.servlet.ModelAndView;

import java.util.UUID;

// TODO: rename to ApiErrorUtils
public final class ErrorUtils {
    
    private ErrorUtils() {
        throw new UnsupportedOperationException("OOps, wtf are you doing, I'm a static!");
    }
    
    public static ModelAndView toModelAndView(final UUID requestId, final ApiError error) {
        final ModelAndView modelAndView = new ModelAndView();
        
        modelAndView.addObject("code", error.getCode());
        modelAndView.addObject("message", error.getMessage());
        modelAndView.addObject("request_id", requestId.toString());
        
        if (error.hasProperties()) {
            modelAndView.addAllObjects(error.getProperties());
        }
        
        return modelAndView;
    }
    
}
