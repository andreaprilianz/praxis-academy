package latihan1.injector;

import latihan1.consumer.Consumer;
import latihan1.consumer.MyDIApplication;
import latihan1.service.SMSServiceImpl;

public class SMSServiceInjector implements MessageServiceInjector {

	@Override
	public Consumer getConsumer() {
		return new MyDIApplication(new SMSServiceImpl());
	}

}