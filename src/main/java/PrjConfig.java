import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
public class PrjConfig {

	
	@Bean
	public InjectRandomIntAnnotationBeanPostProcessor processor(){
		return new InjectRandomIntAnnotationBeanPostProcessor();
	}

	@Bean
	public Quoter terminator() {
		TerminatorQuoter quoter = new TerminatorQuoter();
		quoter.setMessage("I'll be back");
		return quoter;
	}
	
}
