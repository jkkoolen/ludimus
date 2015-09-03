package eu.ludimus.ws.interceptor;

import org.springframework.ws.context.MessageContext;
import org.springframework.ws.soap.server.endpoint.interceptor.SoapEnvelopeLoggingInterceptor;

public class SoapFaultLoggingInterceptor extends SoapEnvelopeLoggingInterceptor {
        @Override
        public boolean handleFault(MessageContext messageContext, Object endpoint)
                        throws Exception {
                if (logger.isDebugEnabled())
                        logMessageSource("Request: ", getSource(messageContext.getRequest()));

                return super.handleFault(messageContext, endpoint);
        }
}
