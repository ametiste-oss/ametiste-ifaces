package org.ametiste.ifaces.data;

/**
 *
 * @since 0.2.8
 *
 */
public abstract class BaseTypeDescriptor {

    private String type;

    protected BaseTypeDescriptor(String type) {
        this.type = type;
    }

    public abstract void writeData(DataReader dataReader);

}
