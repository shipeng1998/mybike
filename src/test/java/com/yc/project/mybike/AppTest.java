package com.yc.project.mybike;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yc.project.mybike.bean.Bike;
import com.yc.project.mybike.bean.IdCardResponse;
import com.yc.project.mybike.config.AppConfig;
import com.yc.project.mybike.dao.BikeDao;
import com.yc.project.mybike.service.BikeService;
import com.yc.project.mybike.service.UserService;
import com.yc.project.mybike.utils.HttpClientUtil;

import junit.framework.TestCase;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={AppConfig.class})
public class AppTest  extends TestCase{
	
	@Autowired
	private DataSource dataSource;
	@Autowired
	private BikeDao bikeDao;
	@Autowired
	private BikeService bikeService;
	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Autowired 
	private UserService userService;
	
	@Autowired
	private RedisTemplate redisTemplate;
	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	@Test
	public void testRedisTemplate() {
		 stringRedisTemplate.opsForValue().set("hello", "world");
		 stringRedisTemplate.opsForValue().set("hello2", "world");
	}
	
	@Test
	public void testIdcard() throws Exception{
		  //api url地址
        String server = "https://api.binstd.com/idcard/query?appkey=5fd7d9c4ccefa9f6&idcard=";
       String idCard="430781199802286010";
       String url=server+idCard;
        //发送http请求并返回结果
        String ret = HttpClientUtil.sendHttpPost(url);
    	ObjectMapper objectMapper = new ObjectMapper();
   		try {
			IdCardResponse idCardResponse = objectMapper.readValue(ret, IdCardResponse.class);
			int status=idCardResponse.getStatus();
			String msg=idCardResponse.getMsg();
			Map<String,String> result=idCardResponse.getResult();
			String sex=result.get("sex");
			String birth=result.get("birth");
			String city=result.get("city");
			String town=result.get("town");
			String area=result.get("area");
			System.out.println(status+"--"+msg+sex+city+birth+town+area);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println(ret);

	}
	
	
	
	@Test
	public void tesUserService() throws Exception{
		userService.genVerifyCode("86", "17775632084");
	}
	
	
	@Test
	public void testRedis(){
		System.out.println(redisTemplate);
	}
	
	
	@Test
	public void testNearBikes(){
		Bike b=new Bike();
		//28.189133, 112.943868
		b.setLatitude(28.189133);
		b.setLongitude(112.943868);
		b.setStatus(1);
		List<Bike> list=bikeService.findNear(b);
		System.out.println(list);
	}
	
	
	
	
	@Test
	public void testMongoTemplate(){
		System.out.println(mongoTemplate.getDb().getName());
		System.out.println(mongoTemplate.getCollectionNames());
	}
	
	@Test  // 准备测试数据
	public void test1() {
		double x=28.197871;
		double y=112.957641;
		for (int i = 0; i < 100; i++) {
			x+=0.0020000;
			for (int j = 0; j < 100; j++) {
				y+=0.0003000;
				Double loc[] = new Double[] { Double.valueOf(y),Double.valueOf(x)};
				Bike b=new Bike();
				b.setStatus(1);
				b.setLoc(  loc);
				b.setQrcode("");
				mongoTemplate.insert(b);
			}
		}
	}
	
	
	
	
	@Test
	public void testDataSource() throws SQLException{
		assertNotNull(dataSource);
		assertNotNull(dataSource.getConnection());
	}
	
	//1.新车入库
	@Test
	public void testAddNewBike(){
		Bike b=new Bike();
		Bike result=bikeDao.addBike(b);
		assertNotNull(result.getBid());
		System.out.println(result.getBid());
		
	}
	
	//2.解锁
	@Test
	public void testupdateBike(){
		Bike b=bikeDao.findBike("1");
		b.setLatitude(20.9);
		b.setLongitude(22.2);
		b.setStatus(2);
		
		bikeDao.updateBike(b);
		
	}
	
	@Test
	public void testFindBike(){
		Bike b=bikeDao.findBike("1");
		assertNotNull(b);
	}
	
	@Test
	public void testServiceOpen(){
		Bike b=bikeService.findByBid("1");
		bikeService.open(b);
	}
	@Test
	public void testServiceAddNewBike(){
		Bike b=new Bike();
		Bike result=bikeService.addNewBike(b);
		System.out.println(result.getQrcode());
	}

}
