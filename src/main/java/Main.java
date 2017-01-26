import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) throws Exception {
//		ApplicationContext ctx = new AnnotationConfigApplicationContext(PrjConfig.class);
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("context.xml");
		
		ctx.getBean(Quoter.class).sayQuote();

//		while(true) {
//			Thread.sleep(100);
//			ctx.getBean(Quoter.class).sayQuote();
//		}
	}
}
