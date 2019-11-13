package edu.pku.springbootseed.common.config;

import com.zaxxer.hikari.HikariDataSource;
import edu.pku.springbootseed.common.annotation.MainDs;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * desc
 *
 * @author wangyc
 * @since 2019/11/12
 */
@Configuration
@EnableTransactionManagement
@MapperScan(basePackages = "edu.pku.springbootseed.**.dao2",
        annotationClass = MainDs.class,
        sqlSessionTemplateRef = "mainSqlSessionTemplate",
        sqlSessionFactoryRef = "mainSqlSessionFactory")
public class MainDsConfig {
    @Bean(name = "mainDataSource")
    @ConfigurationProperties(prefix = "spring.main.datasource")
    public DataSource mainDataSource() {
        return DataSourceBuilder.create().type(HikariDataSource.class).build();
    }

    @Bean(name = "mainSqlSessionFactory")
    public SqlSessionFactory mainSqlSessionFactory(
            @Qualifier("mainDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        return bean.getObject();
    }

    @Bean(name = "mainTransactionManager")
    public DataSourceTransactionManager mainTransactionManager(
            @Qualifier("mainDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "mainSqlSessionTemplate")
    public SqlSessionTemplate mainSqlSessionTemplate(
            @Qualifier("mainSqlSessionFactory") SqlSessionFactory sqlSessionFactory)
            throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
