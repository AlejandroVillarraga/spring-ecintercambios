package com.eci.cosw.springbootsecureapi.controller;

import com.eci.cosw.springbootsecureapi.model.Objeto;
import com.eci.cosw.springbootsecureapi.model.ObjetoOfrecido;
import com.eci.cosw.springbootsecureapi.model.User;
import com.eci.cosw.springbootsecureapi.service.UserService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import java.util.Date;
import java.util.List;

/**
 * @author Santiago Carrillo
 * 8/21/17.
 */
@RestController
@RequestMapping( "user" )
public class UserController
{

    @Autowired
    private UserService userService;

    @CrossOrigin
    @RequestMapping( value = "/getAll", method = RequestMethod.GET )
    public List<User> getAllObjetosOfrecidos() {
        return userService.getUsers();
    }

    @CrossOrigin
    @RequestMapping( value = "/byEmail/{email}", method = RequestMethod.GET )
    public User getUserByEmail(@PathVariable String email) {
        return userService.getUser(email);
    }

    @CrossOrigin
    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public ResponseEntity<?> newUser(@RequestBody User user) {
        return new ResponseEntity<>(userService.createUser(user), HttpStatus.ACCEPTED);
    }

    @CrossOrigin
    @RequestMapping(value = "/addObjetoOfrecido/{email}", method = RequestMethod.POST)
    public ResponseEntity<?> addObjetoOfrecido(@PathVariable String email, @RequestBody ObjetoOfrecido obof) {
        return new ResponseEntity<>(userService.addObjetoOfrecido(obof, email), HttpStatus.ACCEPTED);
    }

    @CrossOrigin
    @RequestMapping( value = "/login", method = RequestMethod.POST )
    public ResponseEntity<?> login(@RequestBody User login ) {


        String jwtToken = "";

        if ( login.getUsername() == null || login.getPassword() == null )
        {
            return new ResponseEntity<>( "Please fill in username and password", HttpStatus.FORBIDDEN );
        }

        String username = login.getUsername();
        String password = login.getPassword();

        System.out.println(username+" "+password);

        User user = userService.getUser(username);


        if ( user != null )
        {
            String pwdNur = user.getPassword();

            if ( !password.equals( pwdNur ) )
            {
                System.out.println("clave mal 2");
                return new ResponseEntity<>( "Invalid login. Please check your name and password.", HttpStatus.FORBIDDEN );
            }
            jwtToken = Jwts.builder().setSubject( username ).claim( "roles", "user" ).setIssuedAt( new Date() ).signWith(
                    SignatureAlgorithm.HS256, "secretkey" ).compact();
            System.out.println(jwtToken+" TOkern");
            return new ResponseEntity<>( new Token (jwtToken) ,HttpStatus.ACCEPTED);

        }

        return new ResponseEntity<>("User username not found." ,HttpStatus.FORBIDDEN);

    }

    public class Token
    {

        String access_token;


        public Token( String access_token )
        {
            this.access_token = access_token;
        }


        public String getAccessToken()
        {
            return access_token;
        }

        public void setAccessToken( String access_token )
        {
            this.access_token = access_token;
        }
    }

}
