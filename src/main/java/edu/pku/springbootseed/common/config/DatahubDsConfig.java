package edu.pku.springbootseed.common.config;

import com.zaxxer.hikari.HikariDataSource;
import edu.pku.springbootseed.common.annotation.DatahubDs;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
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
@MapperScan(basePackages = "edu.pku.springbootseed.**.dao1",
        annotationClass = DatahubDs.class,
        sqlSessionTemplateRef = "datahubSqlSessionTemplate",
        sqlSessionFactoryRef = "datahubSqlSessionFactory")
public class DatahubDsConfig {
    @Bean(name = "datahubDataSource")
    @ConfigurationProperties(prefix = "spring.datahub.datasource")
    @Primary
    public DataSource datahubDataSource() {
        return DataSourceBuilder.create().type(HikariDataSource.class).build();
    }

    @Bean(name = "datahubSqlSessionFactory")
    @Primary
    public SqlSessionFactory datahubSqlSessionFactory(
            @Qualifier("datahubDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        return bean.getObject();
    }

    @Bean(name = "datahubTransactionManager")
    @Primary
    public DataSourceTransactionManager datahubTransactionManager(
            @Qualifier("datahubDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "datahubSqlSessionTemplate")
    @Primary
    public SqlSessionTemplate datahubSqlSessionTemplate(
            @Qualifier("datahubSqlSessionFactory") SqlSessionFactory sqlSessionFactory)
            throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
