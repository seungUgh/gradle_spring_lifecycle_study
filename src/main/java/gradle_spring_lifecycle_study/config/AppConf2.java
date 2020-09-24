package gradle_spring_lifecycle_study.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import gradle_spring_lifecycle_study.spring.ChangePasswordSerivce;
import gradle_spring_lifecycle_study.spring.MemberDao;
import gradle_spring_lifecycle_study.spring.MemberInfoPrinter;
import gradle_spring_lifecycle_study.spring.MemberListPrinter;
import gradle_spring_lifecycle_study.spring.MemberPrinter;
import gradle_spring_lifecycle_study.spring.MemberRegisterService;
import gradle_spring_lifecycle_study.spring.VersionPrinter;

@Configuration
public class AppConf2 {
	@Autowired
	private MemberDao memberDao;
	@Autowired
	private MemberPrinter memberPrinter;
	
	@Bean
	public MemberRegisterService memberRegSvc() {
		return new MemberRegisterService(memberDao);
	}
	
	@Bean
	public ChangePasswordSerivce changePwdSvc() {
		ChangePasswordSerivce pwdSvc = new ChangePasswordSerivce();
		pwdSvc.setMemberDao(memberDao);
		return pwdSvc;
	}
	
	@Bean
	public MemberListPrinter listPrinter() {
		return new MemberListPrinter(memberDao, memberPrinter);
	}
	
	@Bean
	public MemberInfoPrinter infoPrinter() {
		MemberInfoPrinter infoPrinter = new MemberInfoPrinter();
//		infoPrinter.setMemberDao(memberDao);
//		infoPrinter.setPrinter(memberPrinter);
//	 세터 메서드를 사용해서 의존 주입을 하지 않아도 스프링 컨테이너가 @Autowired를 붙인 필드에 자동으로 해당 타입의 빈 객체를 주입
		return infoPrinter;
	}

	@Bean
	public VersionPrinter versionPrinter() {
		VersionPrinter versionPrinter = new VersionPrinter();
		versionPrinter.setMajorVersion(5);
		versionPrinter.setMinoVersion(0);
		return versionPrinter;
	}
	
	
	
	
}
