package org.ametiste.ifaces.data.core;

import org.ametiste.ifaces.data.DataReader;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;
import static org.junit.Assert.assertEquals;

public class LongDataDescriptorTest {

    private @Mock DataReader dataReader;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetValue() {

        final LongDataDescriptor descriptor = new LongDataDescriptor(100L);

        descriptor.writeData(dataReader);

        verify(dataReader).readDataType("org.ametiste.ifacesdata.core.Long");
        verify(dataReader).readDataPiece("value", 100L);
    }

}
