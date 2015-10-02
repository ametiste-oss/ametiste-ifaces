package org.ametiste.ifaces.data.core;

import org.ametiste.ifaces.data.BaseTypeDescriptor;
import org.ametiste.ifaces.data.DataReader;

/**
 *
 * <p>
 *     Describe simple String data type.
 * </p>
 *
 * @since 0.2.8
 */
public class StringDataDescriptor extends BaseTypeDescriptor {

    private static final String typeName = "org.ametiste.ifacesdata.core.String";

    private final String value;

    public StringDataDescriptor(String value) {
        super(StringDataDescriptor.getTypeName());
        this.value = value;
    }

    public static final String getTypeName() {
        return typeName;
    }

    @Override
    public void writeData(DataReader dataReader) {
        dataReader.readDataType(getTypeName());
        dataReader.readDataPiece("value", value);
    }
}
