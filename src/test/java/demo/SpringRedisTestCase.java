package demo;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;

public class SpringRedisTestCase {
	ClassPathXmlApplicationContext ctx;
	@Before
	public void init(){
		ctx=new ClassPathXmlApplicationContext(
		"spring-redis.xml");
	}
	@Test
	public void testTempalte(){
		RedisTemplate<String, String> tpl=
				ctx.getBean("redisTempalte",
				RedisTemplate.class);
		System.out.println(tpl); 
	}
}






