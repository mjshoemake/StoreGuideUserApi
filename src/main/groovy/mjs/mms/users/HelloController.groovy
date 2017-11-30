package mjs.mms.users

import groovy.transform.CompileStatic
import groovy.util.logging.Slf4j
import mjs.common.core.BaseController
import mjs.common.core.BaseService
import mjs.mms.users.UsersService
import mjs.mms.users.domain.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
//import org.springframework.stereotype.Controller
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.support.ServletUriComponentsBuilder

@CompileStatic
@RestController
@RequestMapping('/hello')
@Slf4j
class HelloController {

    HelloController() {
    }

    @RequestMapping(method = RequestMethod.GET)//, produces =  ['application/json'])
    ResponseEntity<?> hello(@RequestParam(required = false) String message) {
        log.info("Hello!!!!");
        if (! message) {
            return ResponseEntity.ok(["Hello", "World"])
        } else {
            return ResponseEntity.ok(["Hello", "World", message])
        }
    }

    @RequestMapping(value = "/json", method = RequestMethod.GET, produces =  ['application/json'])
    ResponseEntity<?> hellojson(@RequestParam(required = false) String message) {
        log.info("Hello!!!!");
        if (! message) {
            return ResponseEntity.ok(["Hello", "World"])
        } else {
            return ResponseEntity.ok(["Hello", "World", message])
        }
    }

    @RequestMapping(value = "/error500", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity getList(Model model) {
        ResponseEntity response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(["message", "This is a test error message."])
        return response
    }

/*
	@RequestMapping(value = "/users/{pk}", method = RequestMethod.GET)
	@ResponseBody public ResponseEntity getByPK(Model model, @PathVariable int pk) {
		return super.getByPK(model, pk, service as BaseService);
	}

	@RequestMapping(value = "/users/{pkList}", method = RequestMethod.DELETE)
	@ResponseBody public ResponseEntity delete(Model model, @PathVariable String pkList) {
		return super.delete(model, pkList, service as BaseService);
	}

	@RequestMapping(value = "/users", method = RequestMethod.POST)
	@ResponseBody public ResponseEntity save(Model model, @RequestBody User entity) {
		return super.update(model, entity, service as BaseService);
	}

	@RequestMapping(value = "/users", method = RequestMethod.PUT)
	@ResponseBody public ResponseEntity update(Model model, @RequestBody User entity) {
		return super.update(model, entity, service as BaseService);
	}
*/
/*
    @RequestMapping(value = "/users/login/{username}/{password}", method = RequestMethod.POST)
    @ResponseBody public ResponseEntity login(Model model, @RequestBody String username, String password) {
        try {
            log.debug("REST Call: login (username=" + username + ")");
            log.debug("   Logging in user " + username + "...");
            User loggedInUser = service.login(username, password);
            log.debug("   Logging in user " + username + "... Done.   Name: " + loggedInUser.getName());
            return new ResponseEntity(loggedInUser, HttpStatus.OK);
        } catch (LoginException e) {
            log.error(e.getMessage(), e);
            return new ResponseEntity(e.getMessage(), HttpStatus.UNAUTHORIZED);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return new ResponseEntity("Login failed for user " + username +". " + e.getMessage(), HttpStatus.UNAUTHORIZED);
        }
    }
*/
}