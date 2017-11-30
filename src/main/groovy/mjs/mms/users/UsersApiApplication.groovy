package mjs.mms.users

import groovy.transform.CompileStatic
import groovy.util.logging.Slf4j
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.PropertySource

@CompileStatic
@SpringBootApplication
@PropertySource("classpath:application.yml")
@Slf4j
class UsersApiApplication {

	static void main(String[] args) {
		SpringApplication.run UsersApiApplication, args
	}
}
