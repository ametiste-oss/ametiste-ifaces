package org.ametiste.ifaces.restful;


import org.ametiste.ifaces.api.error.ApiDirectErrorMappingStrategy;
import org.ametiste.ifaces.api.error.ErrorView;
import org.ametiste.ifaces.api.error.http.HttpError;
import org.ametiste.ifaces.api.error.http.StatusMappingStrategy;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ApiControllerAdviceTest {

    private UUID requestId;

    private ApiControllerMappingAdvice baseController;

    @Mock
    private RequestIdHolder mockHolder;

    @Mock
    private ApiDirectErrorMappingStrategy mappingStrategy;

    @Mock
    private StatusMappingStrategy statusMappingStrategy;

    @Mock
    private HttpServletResponse response;

    @Before
    public void setUp() throws Exception {

        baseController = mock(ApiControllerMappingAdvice.class, Mockito.CALLS_REAL_METHODS);
        baseController.setMappingStrategy(mappingStrategy);
        baseController.setStatusMappingStrategy(statusMappingStrategy);

        // note: mockito does not invoke constructor so fields is not initialized here. I just used reflection.
        ReflectionTestUtils.setField(baseController, "logger",
                LoggerFactory.getLogger(ApiControllerMappingAdvice.class));

        ReflectionTestUtils.setField(baseController, "requestIdHolder", mockHolder);

        requestId = UUID.randomUUID();

        when(mockHolder.getRequestId()).thenReturn(requestId);

    }

    @Test
    public void testHandleOperationException() throws Exception {

        Exception exception = mock(Exception.class);

        doAnswer(new Answer<Void>() {
            @Override
            public Void answer(InvocationOnMock invocation) throws Throwable {
                ((ErrorView) invocation.getArguments()[0]).addMessage("TEST MESSAGE");
                ((ErrorView) invocation.getArguments()[0]).addCode("testCode");
                return null;
            }
        }).when(mappingStrategy).map(any(ErrorView.class), eq(exception));

        doAnswer(new Answer<Void>() {
            @Override
            public Void answer(InvocationOnMock invocation) throws Throwable {
                ((HttpError) invocation.getArguments()[1]).setStatus(HttpStatus.BAD_REQUEST);
                return null;
            }
        }).when(statusMappingStrategy).mapErrorCodeToStatus(eq("testCode"), any(HttpError.class));


        ModelAndView reply = baseController.handleException(exception, response);

        assertEquals(requestId.toString(), reply.getModel().get("request_id"));
        assertEquals("testCode", reply.getModel().get("code"));
        assertEquals("TEST MESSAGE", reply.getModel().get("message"));
        verify(response).setStatus(HttpStatus.BAD_REQUEST.value());

    }

}
