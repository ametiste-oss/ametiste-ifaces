package org.ametiste.ifaces.restful;

import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AMERequestIdAppenderTest {
	
	@Mock
	private RequestIdHolder requestIdHolder;
	
	@InjectMocks
	private AMERequestIdAppender AMERequestIdAppender;

	@Mock
	private HttpServletResponse response;
	
	@Test
	public void testPostHandle() throws Exception {
		
		UUID randomUUID = UUID.randomUUID();
		when(requestIdHolder.getRequestId()).thenReturn(randomUUID);
		
		assertTrue(AMERequestIdAppender.preHandle(null, response , null));
		
		verify(response).addHeader(eq(AMERequestIdAppender.HEADER_NAME), eq(randomUUID.toString()));
		
	}

}
