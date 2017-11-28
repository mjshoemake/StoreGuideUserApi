package mjs.mms.users

import groovy.transform.CompileStatic
import groovy.util.logging.Slf4j
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.support.ServletUriComponentsBuilder

@CompileStatic
@RestController
@RequestMapping('/hello')
@Slf4j
class UsersGateway {

	@RequestMapping(method = RequestMethod.GET, produces =  ['application/json'])
	ResponseEntity<?> list(@RequestParam(required = false) String message) {
		log.info("Hello!!!!");
		log.error("Hello!!!!");
		return ResponseEntity.ok(["Hello", "World"])
	}

	@RequestMapping(path= '/{id}', method = RequestMethod.GET, produces = 'application/json')
	ResponseEntity<?> getById(@PathVariable String id) {
		//Greeting greeting = greetings.find { it.id == id.toInteger() }
		//if (!greeting) {
			return ResponseEntity.noContent().build()
		//}
		//return ResponseEntity.ok(greeting)
	}

/*
	@SuppressWarnings('SpaceAroundOperator') // false positive when elvis is followed by a newline
	@RequestMapping(method = RequestMethod.POST, produces = 'application/json', consumes = 'application/json')
	ResponseEntity<?> post(@RequestBody User user) {
		Greeting existingGreeting = greetings.find { it.id == example.id } ?:
				greetings.find { it.message == example.message }
		if (!existingGreeting) {
			greetings << example
			if (!example.id) {
				example.id = counter
				counter++
			}
			URI location = ServletUriComponentsBuilder
					.fromCurrentRequest().path('/{id}')
					.buildAndExpand(example.id).toUri()
			return ResponseEntity.created(location).build()
		}
		return ResponseEntity.noContent().build()
	}
*/
}