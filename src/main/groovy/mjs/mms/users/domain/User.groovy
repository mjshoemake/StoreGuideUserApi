 package mjs.mms.users.domain

import mjs.common.model.ModelLoggable

 import javax.persistence.Column

 //import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table
import javax.persistence.Transient;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * This is the data object or suitcase for a User. This data object
 * should not contain any business logic. This class is used by the
 * AuthenticationManager.
 */
 @Entity
 @Table(name="user")
 @JsonIgnoreProperties(ignoreUnknown = true)
class User extends ModelLoggable {
     /**
      * The user ID for this user. This is how users should be
      * referenced in the database.
      */
     @Id
     @GeneratedValue
     int user_pk = -1

     /**
      * The user's first name.
      */
     @Column
     String fname = ""

     /**
      * The user's last name.
      */
     @Column
     String lname = ""

     /**
      * The user login ID.
      */
     @Column
     String username = ""

     /**
      * The user's email address.
      */
     @Column
     String email = ""

     /**
      * The user's city.
      */
     @Column
     String city = ""

     /**
      * The user's state.
      */
     @Column
     String state = ""

     /**
      * Is the login enabled for this user?
      */
     @Column
     String login_enabled = "Y"

     @Transient
     public String getName() {
         if (fname != null && !fname.equals("") && lname != null && lname.equals("")) {
             return fname + " " + lname;
         } else if (fname != null && !fname.equals("")) {
             return fname;
         } else if (lname != null && lname.equals("")) {
             return lname;
         } else {
             return "";
         }
     }

     public void setSearchable(String value) {
         // Do nothing.
     }

     @Column
     public String getSearchable() {
         StringBuilder builder = new StringBuilder("|")
         if (name != null) {
             builder.append(name).append('|')
         }
         if (city != null) {
             builder.append(city).append('|')
         }
         if (state != null) {
             builder.append(state).append('|')
         }
         if (email != null) {
             builder.append(email).append('|')
         }
         return builder.toString()
     }


 }
