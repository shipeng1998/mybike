package com.yc.project.mybike.config;








import java.util.ArrayList;
import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.embedded.undertow.UndertowBuilderCustomizer;
import org.springframework.boot.web.embedded.undertow.UndertowServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;

import io.undertow.Undertow;
import io.undertow.UndertowOptions;


@Configuration
@ComponentScan(basePackages="com.yc")
@EnableTransactionManagement //启动事物

public class AppConfig {
	private Logger log=Logger.getLogger(AppConfig.class);
	@Autowired
	private RedisConnectionFactory redisConnectionFactory;
	
	
	 @Bean
	    public UndertowServletWebServerFactory undertowServletWebServerFactory() {
	        UndertowServletWebServerFactory factory = new UndertowServletWebServerFactory();
	        factory.addBuilderCustomizers(new UndertowBuilderCustomizer() {
	            @Override
	            public void customize(Undertow.Builder builder) {
	                builder.setServerOption(UndertowOptions.RECORD_REQUEST_START_TIME, true);
	            }
	        });
	        return factory;
	    }
	

	@Bean
	public RedisTemplate redsiTemplate() {
		JedisConnectionFactory conn = new JedisConnectionFactory();
        conn.setDatabase(0);
        conn.setHostName("116.62.7.223");
        conn.setPort(6379);
        conn.setPassword("");
        conn.setUsePool(true);
        conn.afterPropertiesSet();
		 RedisTemplate<byte[], byte[]> template = new RedisTemplate<>();
	        template.setConnectionFactory(conn);
	        template.afterPropertiesSet();
	        return template;
//        RedisTemplate<byte[], byte[]> template = new RedisTemplate<>();
//        template.setConnectionFactory(redisConnectionFactory);
//        template.afterPropertiesSet();
//        return template;
	}
	
	@Bean
	public StringRedisTemplate stringRedisTemplate() {
		JedisConnectionFactory conn = new JedisConnectionFactory();
        conn.setDatabase(0);
        conn.setHostName("116.62.7.223");
        conn.setPort(6379);
        conn.setPassword("");
        conn.setUsePool(true);
        conn.afterPropertiesSet();
        StringRedisTemplate template = new StringRedisTemplate();
        template.setConnectionFactory(conn);
        template.afterPropertiesSet();
        return template;
        
//        StringRedisTemplate template = new StringRedisTemplate();
//        template.setConnectionFactory(redisConnectionFactory);
//        template.afterPropertiesSet();
//        return template;
	}
	
	
	
	
	
	@Bean    //  MongoTemplate由spring 托管
    @Primary
    public MongoTemplate template() {
        return new MongoTemplate(factory());
    }
	
	 /**
     * 功能描述: 创建数据库名称对应的工厂，数据库名称可以通过配置文件导入
     * @param
     * @return:org.springframework.data.mongodb.MongoDbFactory
     * @since: v1.0
     */
    @Bean("mongoDbFactory")
    public MongoDbFactory factory() {
        return new SimpleMongoDbFactory(client(), "mybike");
    }
    
    /**
     * 功能描述: 配置client，client中传入的ip和端口可以通过配置文件读入
     *
     * @param
     * @return:com.mongodb.MongoClient
     */
    @Bean("mongoClient")
    public MongoClient client() {
//    	List<ServerAddress> list=new ArrayList<ServerAddress>();
//    	ServerAddress sa1=new ServerAddress("node1",23000);
//    	ServerAddress sa2=new ServerAddress("node2",23000);
//    	ServerAddress sa3=new ServerAddress("node3",23000);
//    	list.add( sa1 );
//    	list.add( sa2 );
//    	list.add( sa3 );
//    	
//    	return new MongoClient(   list );
        return new MongoClient("116.62.7.223", 27017);
    }

	
	
	
	
	
	@Bean
	public DriverManagerDataSource dataSource(){
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://116.62.7.223:3306/mybike?serverTimezone=UTC");
		dataSource.setUsername("root");
		dataSource.setPassword("a");
		log.info("创建数据源："+dataSource);
		return dataSource;
		
	}
	
	@Bean
	@Autowired
	public    DataSourceTransactionManager  tx(  DriverManagerDataSource ds    ){
		log.info("创建事务管理器："+ds);
		DataSourceTransactionManager dtm=new DataSourceTransactionManager();
		//AnnotationTransactionAspect.aspectOf().setTransactionManager(dtm);
		dtm.setDataSource(   ds );
		return dtm;
	}


}
