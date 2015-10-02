package org.ametiste.ifaces.si.api.error.transformer;

import org.ametiste.ifaces.api.error.ApiErrorMappingStrategy;
import org.ametiste.ifaces.api.error.ErrorRender;
import org.ametiste.ifaces.api.error.http.HttpError;
import org.ametiste.ifaces.api.error.http.HttpErrorView;
import org.ametiste.ifaces.api.error.http.StatusMappingStrategy;

import org.springframework.integration.http.HttpHeaders;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessagingException;

public class ErrorTransformer {

	private ApiErrorMappingStrategy mapperStrategy;
	private StatusMappingStrategy statusMapperStrategy;

	public void setMapperStrategy(ApiErrorMappingStrategy mapperStrategy) {
		this.mapperStrategy = mapperStrategy;

	}

    public void setStatusMappingStrategy(StatusMappingStrategy strategy) {
		this.statusMapperStrategy = strategy;
	}

    /**
     *
     * Transformer for Spring-Integration based applications to transform any kind of exceptions
	 * happened in scheme during work to error message displayed to client.
     * Impelemented to get rid of exception stacktrace on client's side and control information available to display
     *
     * @param message
     * @return
     */
    public Message<ErrorRender> transform(Message<MessagingException> message) {

		// TODO: move to Constraint holder
        if(!message.getPayload().getFailedMessage().getHeaders().containsKey("requestId")) {
            throw new IllegalArgumentException(
					"Any message in AME stack should contain 'requestId' header by convension");
        }

        String requestId = message.getPayload().getFailedMessage().getHeaders().get("requestId").toString();

		HttpErrorView view = new HttpErrorView(requestId, statusMapperStrategy);

		Throwable e = message.getPayload();
		if (e.getCause() != null) {
			e = e.getCause();
		}

		mapperStrategy.map(view, e);

		HttpError error = view.build();

		return MessageBuilder.withPayload(error.getBody())
				.copyHeaders(message.getHeaders())
				.copyHeadersIfAbsent(message.getPayload().getFailedMessage().getHeaders())
				.setHeader(HttpHeaders.STATUS_CODE, error.getStatus()).build();

	}

}
