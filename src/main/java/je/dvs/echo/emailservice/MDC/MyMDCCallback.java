package je.dvs.echo.emailservice.MDC;

import org.apache.camel.AsyncCallback;
import org.apache.log4j.MDC;

import static je.dvs.echo.emailservice.MDC.CustomUnitOfWork.MDC_ORDERID;
import static org.apache.camel.impl.MDCUnitOfWork.*;

/**
 * * {@link AsyncCallback} which preserves {@link org.slf4j.MDC} when the
 * asynchronous routing engine is being used. * This also includes the
 * default camel MDCs.
 */
public  final class MyMDCCallback implements AsyncCallback {
    private final AsyncCallback delegate;
    private final String breadcrumbId;
    private final String exchangeId;
    private final String messageId;
    private final String correlationId;
    private final String routeId;
    private final String camelContextId;
    private final String orderId;

    public MyMDCCallback(AsyncCallback delegate) {
        this.delegate = delegate;
        this.exchangeId = MDC.get(MDC_EXCHANGE_ID).toString();
        this.messageId = MDC.get(MDC_MESSAGE_ID).toString();
        this.breadcrumbId = MDC.get(MDC_BREADCRUMB_ID).toString();
        this.correlationId = MDC.get(MDC_CORRELATION_ID).toString();
        this.camelContextId = MDC.get(MDC_CAMEL_CONTEXT_ID).toString();
        this.routeId = MDC.get(MDC_ROUTE_ID).toString();
        this.orderId = MDC.get(MDC_ORDERID).toString();
    }


    public void done(boolean doneSync) {
        try {
            if (!doneSync) {
                // when done asynchronously then restore information from
                // previous thread
                if (breadcrumbId != null) {
                    MDC.put(MDC_BREADCRUMB_ID, breadcrumbId);
                }
                if (orderId != null) {
                    MDC.put(MDC_ORDERID, orderId);
                }
                if (exchangeId != null) {
                    MDC.put(MDC_EXCHANGE_ID, exchangeId);
                }
                if (messageId != null) {
                    MDC.put(MDC_MESSAGE_ID, messageId);
                }
                if (correlationId != null) {
                    MDC.put(MDC_CORRELATION_ID, correlationId);
                }
                if (camelContextId != null) {
                    MDC.put(MDC_CAMEL_CONTEXT_ID, camelContextId);
                }
            }
            // need to setup the routeId finally
            if (routeId != null) {
                MDC.put(MDC_ROUTE_ID, routeId);
            }
        } finally {
            // muse ensure delegate is invoked
            delegate.done(doneSync);
        }
    }

    @Override
    public String toString() {
        return delegate.toString();
    }
}
