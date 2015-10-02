package org.ametiste.ifaces.data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @since 0.2.8
 *
 */
public class MapDataReader implements DataReader {

    private final HashMap<String, Object> dataMap;

    public MapDataReader(HashMap<String, Object> dataMap) {
        this.dataMap = dataMap;
    }

    public MapDataReader() {
        this(new HashMap<String, Object>());
    }

    @Override
    public void readDataType(String dataTypeName) {
        dataMap.put("type", dataTypeName);
    }

    @Override
    public void readDataPiece(String field, String data) {
        dataMap.put(field, data);
    }

    @Override
    public void readDataPiece(String field, long data) {
        dataMap.put(field, Long.toString(data));
    }

    @Override
    public void readDataPiece(String field, int data) {
        dataMap.put(field, Integer.toString(data));
    }

    @Override
    public void readDataPiece(String field, float data) {
        dataMap.put(field, Float.toString(data));
    }

    @Override
    public void readDataPiece(String field, Collection<? extends BaseTypeDescriptor> data) {

        final ArrayList<Object> objects = new ArrayList<>(data.size());

        for (BaseTypeDescriptor descriptor : data) {
            final MapDataReader reader = new MapDataReader();
            descriptor.writeData(reader);
            objects.add(reader.getDataMap());
        }

        dataMap.put(field, objects);
    }

    @Override
    public void readDataPiece(String field, BaseTypeDescriptor data) {
        final MapDataReader reader = new MapDataReader();
        data.writeData(reader);
        dataMap.put(field, reader.getDataMap());
    }

    public Map<String, Object> getDataMap() {
        return dataMap;
    }

}
