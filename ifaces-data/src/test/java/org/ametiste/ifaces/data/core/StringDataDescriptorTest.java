package org.ametiste.ifaces.data.core;

import org.ametiste.ifaces.data.DataReader;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;

public class StringDataDescriptorTest {

    private @Mock
    DataReader dataReader;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetValue() {

        final StringDataDescriptor descriptor = new StringDataDescriptor("test-data");

        descriptor.writeData(dataReader);

        verify(dataReader).readDataType("org.ametiste.ifacesdata.core.String");
        verify(dataReader).readDataPiece("value", "test-data");
    }


}
