package gradle_spring_lifecycle_study.assembler;

import gradle_spring_lifecycle_study.spring.ChangePasswordSerivce;
import gradle_spring_lifecycle_study.spring.MemberDao;
import gradle_spring_lifecycle_study.spring.MemberRegisterService;

public class Assembler {
	private MemberDao memberDao;
	private MemberRegisterService regSvc;
	private ChangePasswordSerivce pwdSvc;
	
	//으지ㅗㄴ 객체를 변경하려면 조립기의 코드만 수정하면 됨
	public Assembler() {
		memberDao = new MemberDao();
		regSvc = new MemberRegisterService(memberDao);
		pwdSvc = new ChangePasswordSerivce();
		pwdSvc.setMemberDao(memberDao);
	}


	public MemberDao getMemberDao() {
		return memberDao;
	}


	public MemberRegisterService getMemberRegisterService() {
		return regSvc;
	}


	public ChangePasswordSerivce getChangePasswordSerivce() {
		return pwdSvc;
	}
	
	
}
