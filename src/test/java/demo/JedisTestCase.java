package demo;

import org.junit.Test;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisTestCase {
	@Test
	public void jedisTest(){
		//连接到 Redis
		Jedis jedis = new Jedis(
				"192.168.28.163", 6379);
		System.out.println(jedis);
		//利用api操作Redis
		jedis.set("api", "jedis");
		System.out.println("OK");
	}
	
	@Test 
	public void jedisPool(){
		//创建Redis数据库连接池
		JedisPoolConfig cfg=
				new JedisPoolConfig();
		JedisPool pool=
				new JedisPool(cfg,
				"192.168.28.163", 6379);
		//通过连接池获取数据库连接
		Jedis jedis=pool.getResource();
		String str = jedis.get("api");
		System.out.println(str); 
	}
	
	@Test
	public void testHash(){
		//创建Redis数据库连接池
		JedisPoolConfig cfg=
				new JedisPoolConfig();
		JedisPool pool=
				new JedisPool(cfg,
				"192.168.28.163", 6379);
		//通过连接池获取数据库连接
		Jedis jedis=pool.getResource();
		jedis.hset("product", "name", "汽车");
		jedis.hset("product", "price", "12000");
		jedis.hset("product", "type", "car");
		System.out.println("OK"); 
	}
}






