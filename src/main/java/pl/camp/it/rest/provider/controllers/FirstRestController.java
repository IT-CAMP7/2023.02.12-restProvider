package pl.camp.it.rest.provider.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.camp.it.rest.provider.UsersListResponse;
import pl.camp.it.rest.provider.model.User;

@RestController
public class FirstRestController {

    @RequestMapping(path = "/rest1", method = RequestMethod.GET)
    public User rest1() {
        System.out.println("odpalila sie usluga !!!");
        User user = new User();
        user.setLogin("janusz");
        user.setPassword("janusz123");
        user.setAge(50);
        user.setName("Janusz");
        user.setSurname("Kowalski");

        return user;
    }

    @RequestMapping(path = "/rest2", method = RequestMethod.POST)
    public void rest2(@RequestBody User user) {
        System.out.println(user.getLogin());
        System.out.println(user.getPassword());
        System.out.println(user.getName());
        System.out.println(user.getSurname());
        System.out.println(user.getAge());
    }

    @RequestMapping(path = "/rest3", method = RequestMethod.PUT)
    public void rest3(@RequestHeader String header1,
                      @RequestHeader("next-header") String nextHeader,
                      @RequestHeader String header2) {
        System.out.println(header1);
        System.out.println(nextHeader);
        System.out.println(header2);
    }

    @RequestMapping(path = "/rest4/{name}/{surname}", method = RequestMethod.POST)
    public User rest4(@PathVariable String name,
                      @PathVariable String surname,
                      @RequestParam int age,
                      @RequestParam long pesel,
                      @RequestBody User user,
                      @RequestHeader String header1,
                      @RequestHeader String header2) {
        System.out.println(name);
        System.out.println(surname);
        System.out.println(age);
        System.out.println(pesel);
        System.out.println(user.getLogin());
        System.out.println(user.getPassword());
        System.out.println(header1);
        System.out.println(header2);

        return new User("login", "password",
                "imie", "nazwisko", 324);
    }

    @RequestMapping(path = "/rest5", method = RequestMethod.GET)
    public ResponseEntity<User> rest5() {
        User user = new User("login", "password",
                "imie", "nazwisko", 23);

        ResponseEntity<User> response = ResponseEntity
                .status(HttpStatus.PARTIAL_CONTENT)
                .header("n1", "wartosc pierwsza")
                .header("n2", "kolejna wartosc")
                .body(user);

        return response;
    }

    @RequestMapping(path = "/rest6", method = RequestMethod.GET)
    public UsersListResponse rest6() {
        UsersListResponse response = new UsersListResponse();
        response.getUsers().add(new User("login", "password",
                "imie", "nazwisko", 23));
        response.getUsers().add(new User("login2", "password2",
                "imie2", "nazwisko2", 34));

        return response;
    }
}
