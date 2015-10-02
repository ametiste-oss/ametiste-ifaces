package org.ametiste.ifaces.facade;

import java.util.UUID;

public class OperationUnexpectedException extends OperationException {
    
    private static final long serialVersionUID = -4889674209356725023L;
    
    public OperationUnexpectedException(final UUID operationId, final String message, final Throwable e) {
        super(operationId, message, e);
    }
    
}
