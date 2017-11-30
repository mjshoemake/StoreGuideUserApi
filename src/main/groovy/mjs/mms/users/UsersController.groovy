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
@RequestMapping('/users')
class UsersController {

    @Autowired
    UsersRepository repo

	@RequestMapping(method = RequestMethod.GET, produces = ['application/json'])
    @ResponseBody ResponseEntity getList() {
        try {
            List<User> userList = repo.findAll()
            return ResponseEntity.ok(userList)
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(['message', e.getMessage()])
        }
    }

	@RequestMapping(value = "/{pk}", method = RequestMethod.GET)
	@ResponseBody ResponseEntity getByPK(Model model, @PathVariable int pk) {
        try {
            User user = repo.findOne(pk)
            if (user) {
                return ResponseEntity.ok(user)
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(['message', "The requested user was not found."])
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(['message', e.getMessage()])
        }
	}

/*
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