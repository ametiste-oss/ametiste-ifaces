package org.ametiste.ifaces.facade;

import java.util.UUID;


public abstract class OperationException extends RuntimeException {
    
    private static final long serialVersionUID = -1535838409328036580L;
    private final UUID operationId;
    
    public OperationException(final UUID operationId, final String message, final Throwable cause) {
        super(message, cause);
        this.operationId = operationId;
    }
    
    public OperationException(final UUID operationId, final String message) {
        this(operationId, message, null);
    }
    
    public UUID getOperationId() {
        return operationId;
    }
    
}
