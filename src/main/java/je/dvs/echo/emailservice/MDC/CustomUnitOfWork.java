package je.dvs.echo.emailservice.MDC;

import org.apache.camel.AsyncCallback;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.impl.MDCUnitOfWork;
import org.apache.camel.spi.UnitOfWork;
import org.apache.log4j.MDC;

public class CustomUnitOfWork extends MDCUnitOfWork implements UnitOfWork {
    public static final String MDC_ORDERID = "orderId";
    private final String originalOrderId;

    public CustomUnitOfWork(Exchange exchange) {
        super(exchange);
        this.originalOrderId = MDC.get(MDC_ORDERID).toString();
    }

    @Override
    public UnitOfWork newInstance(Exchange exchange) {
        return new CustomUnitOfWork(exchange);
    }

    @Override
    public AsyncCallback beforeProcess(Processor processor, Exchange exchange, AsyncCallback callback) {
        return new MyMDCCallback(callback);
    }




}