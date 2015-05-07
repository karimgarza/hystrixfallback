package demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class HelloController {

	

	@HystrixCommand(fallbackMethod="defaultHello")
	public String sayHelloFromExternalService() throws Exception{
		
		throw new Exception("Exception from external service");
	}	
			
	
	@RequestMapping("/hello")
	public String hello() throws Exception{
		return sayHelloFromExternalService();
	}
	
	private String defaultHello() {	
		return "Hello";
	}
	
}
