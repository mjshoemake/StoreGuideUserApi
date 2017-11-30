package mjs.mms.users

import mjs.mms.users.domain.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

/**
 * This is the Spring Data JPA repository used to interact with the MySQL database.
 */
@Repository
interface UsersRepository extends JpaRepository<User, Integer> {

}
