package latihan1.injector;

import latihan1.consumer.Consumer;
import latihan1.consumer.MyDIApplication;
import latihan1.service.EmailServiceImpl;

public class EmailServiceInjector implements MessageServiceInjector {

	@Override
	public Consumer getConsumer() {
		return new MyDIApplication(new EmailServiceImpl());
	}

}
