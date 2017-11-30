package mjs.mms.users

import groovy.util.logging.Slf4j
import mjs.common.model.ModelLoggable
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.orm.jpa.JpaTransactionManager
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean
import org.springframework.transaction.PlatformTransactionManager
import org.springframework.transaction.annotation.EnableTransactionManagement

//import javax.persistence.Column;
import javax.persistence.Entity
import javax.persistence.EntityManagerFactory;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table
import javax.persistence.Transient;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties

import javax.sql.DataSource;
/**
 * This is the DB config object used to interact with the MySQL database.
 */
@Configuration
//@EnableTransactionManagement
//@EnableJpaRepositories(
//        entityManagerFactoryRef = "usersEntityManagerFactory",
//        transactionManagerRef = "usersTransactionManager",
//        basePackages = ["mjs.mms.users"]
//)
@Slf4j
class UsersDbConfig {

    @Bean(name = "usersDataSource")
    //@ConfigurationProperties(prefix = "users.datasource")  // Only use this prefix if you need to switch between two databases.
    public DataSource dataSource() {
        return DataSourceBuilder.create().build()
    }

    @Bean(name = "entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean usersEntityManagerFactory (EntityManagerFactoryBuilder builder, @Qualifier("usersDataSource") DataSource datasource) {
        log.info("Builder: " + builder);
        LocalContainerEntityManagerFactoryBean mgrFactory = builder
                .dataSource(datasource)
                .packages("mjs.mms.users.domain")
                .persistenceUnit("users")
                .build()
        log.info("EntityManagerFactory: " + mgrFactory)
        return mgrFactory
    }

    @Bean(name = "transactionManager")
    public PlatformTransactionManager usersTransactionManager (@Qualifier("entityManagerFactory") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory)
    }
}
