package latihan1.test;

// import org.junit.After;
// import org.junit.Before;
// import org.junit.Test;
import org.junit.After;
import Org.junit.Before;
import org.junit.Test;

import latihan1.consumer.Consumer;
import latihan1.consumer.MyDIApplication;
import latihan1.injector.MessageServiceInjector;
import latihan1.service.MessageService;

public class MyDIApplicationJUnitTest {

	private MessageServiceInjector injector;
	
	@Before
	public void setUp(){
		//mock the injector with anonymous class
		injector = new MessageServiceInjector() {
			
			@Override
			public Consumer getConsumer() {
				//mock the message service
				return new MyDIApplication(new MessageService() {
					
					@Override
					public void sendMessage(String msg, String rec) {
						System.out.println("Mock Message Service implementation");
						
					}
				});
			}
		};
	}
	
	@Test
	public void test() {
		Consumer consumer = injector.getConsumer();
		consumer.processMessages("Hi Pankaj", "pankaj@abc.com");
	}
	
	@After
	public void tear(){
		injector = null;
	}

}