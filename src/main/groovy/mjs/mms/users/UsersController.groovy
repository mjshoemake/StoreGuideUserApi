package mjs.home.users

import groovy.transform.CompileStatic
import groovy.util.logging.Slf4j
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.support.ServletUriComponentsBuilder

@CompileStatic
//@RestController
@Controller
@RequestMapping('/users')
@Slf4j
class UsersGateway {

	@RequestMapping(method = RequestMethod.GET)
	ResponseEntity<?> list(@RequestParam(required = false) String message) {
		log.info("Users!!!!");
		return ResponseEntity.ok(["Hello", "World", message])
	}

}