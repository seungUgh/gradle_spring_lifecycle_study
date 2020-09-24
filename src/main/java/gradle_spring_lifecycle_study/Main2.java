package gradle_spring_lifecycle_study;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main2 {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppContext.class);
		Greeter g1 = ctx.getBean("greeter",Greeter.class);
		Greeter g2 = ctx.getBean("greeter",Greeter.class);
//		System.out.println(g1);
//		System.out.println(g2);
		System.out.println("(g1 == g2) = " + (g1 == g2));
		ctx.close();
	}
}