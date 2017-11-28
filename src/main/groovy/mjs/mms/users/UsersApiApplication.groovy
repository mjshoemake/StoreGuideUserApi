package mjs.mms.users

import groovy.transform.CompileStatic
import groovy.util.logging.Slf4j
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@CompileStatic
@SpringBootApplication
@Slf4j
class UsersApiApplication {

	static void main(String[] args) {
		SpringApplication.run UsersApiApplication, args
	}
}
