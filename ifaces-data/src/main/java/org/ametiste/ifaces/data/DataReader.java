package org.ametiste.ifaces.data;

import java.util.Collection;

/**
 *
 * @since
 */
public interface DataReader {

    void readDataType(String dataTypeName);

    void readDataPiece(String field, String data);

    void readDataPiece(String field, long data);

    void readDataPiece(String field, int data);

    void readDataPiece(String field, float data);

    void readDataPiece(String field, Collection<? extends BaseTypeDescriptor> data);

    void readDataPiece(String field, BaseTypeDescriptor data);
}
