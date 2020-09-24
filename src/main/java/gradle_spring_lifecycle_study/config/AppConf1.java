package gradle_spring_lifecycle_study.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import gradle_spring_lifecycle_study.spring.MemberDao;
import gradle_spring_lifecycle_study.spring.MemberPrinter;

@Configuration
public class AppConf1 {
	
	@Bean
	public MemberDao memberDao() {
		return new MemberDao();
	}
	
	@Bean
	public MemberPrinter memberPrinter() {
		return new MemberPrinter();
	}
	
}
