package config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
@MapperScan(basePackages = "com.spring.account") // mapper 인터페이스 위치
public class MyBatisConfig {
	
	@Bean
	public DataSource dataSource() {
		HikariDataSource ds = new HikariDataSource();
		ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
	    ds.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:xe");
	    ds.setUsername("c##scott");
	    ds.setPassword("tiger");
	    return ds;
	}
	
	@Bean
	public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
		SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
	    factoryBean.setDataSource(dataSource);
	    /*factoryBean.setMapperLocations(
	    			new PathMatchingResourcePatternResolver().getResources("classpath:mapper/*.xml")
	    		);*/
	    factoryBean.getObject().getConfiguration().setMapUnderscoreToCamelCase(true);
	    return (SqlSessionFactory) factoryBean.getObject();
	}
	
	@Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
	
}
