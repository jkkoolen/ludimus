package eu.ludimus.domain.config;

import com.googlecode.flyway.core.Flyway;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.LazyConnectionDataSourceProxy;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.util.HashMap;
import java.util.Map;


@Configuration
@PropertySource("classpath:${env}/application.properties")
@ComponentScan(basePackages = "eu.ludimus.domain")
@EnableJpaRepositories(value = "eu.ludimus.domain.repository"
 ,transactionManagerRef = "transactionManager")
@EnableTransactionManagement()
public class LudimusDomainConfig {

    public static final String PERSISTENCE_UNIT_NAME = "ludimus";
    @Value("${hibernate.show_sql}")
    private boolean showSql;

    @Value("${jdbc.url}")
    private String jdbcUrl;

    @Value("${jdbc.username}")
    private String username;

    @Value("${jdbc.password}")
    private String password;

    @Value("${jdbc.driver}")
    private String driverClass;

    @Value("${jdbc.idle_connection_test_period}")
    private int jdbcIdleConnectionTestPeriod;

    @Value("${jdbc.max_pool_size}")
    private int jdbcMacPoolSize;

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public ComboPooledDataSource comboPooledDataSource()  {
        final ComboPooledDataSource source = new ComboPooledDataSource();
        source.setJdbcUrl(jdbcUrl);
        source.setUser(username);
        source.setPassword(password);
        try {
            source.setDriverClass(driverClass);
        } catch (PropertyVetoException e) {
            e.printStackTrace();
            source.close();
        }

        source.setPreferredTestQuery("select 1");
        source.setIdleConnectionTestPeriod(jdbcIdleConnectionTestPeriod);
        source.setMaxPoolSize(jdbcMacPoolSize);
        source.setTestConnectionOnCheckin(true);
        source.setTestConnectionOnCheckout(true);
        
        return source;
    }

    @Bean(name="dataSource")
    public DataSource dataSource() {
        Flyway flyway = new Flyway();
        final LazyConnectionDataSourceProxy lazyConnectionDataSourceProxy = new LazyConnectionDataSourceProxy();
        lazyConnectionDataSourceProxy.setTargetDataSource(comboPooledDataSource());
        flyway.setDataSource(lazyConnectionDataSourceProxy);
        flyway.migrate();
        return lazyConnectionDataSourceProxy;
    }

    public LocalValidatorFactoryBean validator() {
        return new LocalValidatorFactoryBean();
    }

    @Bean(name = "entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(@Qualifier("dataSource") final DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
        hibernateJpaVendorAdapter.setShowSql(showSql);
        hibernateJpaVendorAdapter.setGenerateDdl(false);
        hibernateJpaVendorAdapter.setDatabasePlatform("org.hibernate.dialect.MySQL5InnoDBDialect");
        entityManagerFactoryBean.setJpaVendorAdapter(hibernateJpaVendorAdapter);
        Map<String, Object> jpaPropertyMap = new HashMap<>();
        jpaPropertyMap.put("javax.persistence.validation.factory", validator());
        entityManagerFactoryBean.setJpaPropertyMap(jpaPropertyMap);
        entityManagerFactoryBean.setPersistenceUnitName(PERSISTENCE_UNIT_NAME);
        entityManagerFactoryBean.setDataSource(dataSource);
        return entityManagerFactoryBean;
    }

    @Bean(name="transactionManager")
    public JpaTransactionManager transactionManager(@Qualifier("entityManagerFactory") final EntityManagerFactory factory) {
        return new JpaTransactionManager(factory);
    }
}
