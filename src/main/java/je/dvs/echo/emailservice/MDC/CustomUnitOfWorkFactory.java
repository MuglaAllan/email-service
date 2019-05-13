package je.dvs.echo.emailservice.MDC;

import org.apache.camel.Exchange;
import org.apache.camel.spi.UnitOfWork;
import org.apache.camel.spi.UnitOfWorkFactory;

public class CustomUnitOfWorkFactory implements UnitOfWorkFactory {
    @Override
    public UnitOfWork createUnitOfWork(Exchange exchange) {
        return new CustomUnitOfWork(exchange);
    }
}
