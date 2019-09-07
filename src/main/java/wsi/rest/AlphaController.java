package wsi.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import wsi.model.CarResponse;
import wsi.model.ExecResponse;
import wsi.model.GenericResponse;
import wsi.model.Person;
import wsi.service.ExecService;
import wsi.service.UserService;

import java.util.List;

import static java.net.URLDecoder.decode;


@RestController
@CrossOrigin
@Slf4j
public class AlphaController implements InitializingBean {
    @Value("${app.version:nieustawiona}")
    String version;

    @Value("${admin.password:123}")
    String passwd;

    @Autowired UserService userService;
    @Autowired ExecService execService;


    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("Using admin password: {}", passwd);
    }

    @GetMapping(value = "/exec")
    public ExecResponse executeCommand(
            @RequestParam("cmd") String cmd, @RequestParam("pass") String pass) {
        if (!pass.equals(passwd)) throw new RuntimeException("Unauthorized");
        return execService.executeCommand(cmd);
    }


    @GetMapping(value = "/status")
    public GenericResponse status() {
        log.info("Zapytanie o status aplikacji");
        return new GenericResponse("App version: " + version);
    }

    @GetMapping(value = "/hello")
    public GenericResponse hello() {
        return new GenericResponse("Hello World");
    }

    @GetMapping(value = "/add")
    public GenericResponse add(
            @RequestParam("a") Integer a,
            @RequestParam("b") Integer b) {
        int wynik = a + b;
        return new GenericResponse(a + " + " + b + " = " + wynik);
    }

    @GetMapping(value = "/cars")
    public CarResponse cars(
            @RequestParam("wheels") Integer wheels,
            @RequestParam("shields") Integer shields) {
        int wynik = Math.min(wheels/4, shields/2);
        return new CarResponse(wynik, "OK");
    }





    @GetMapping(value = "/users")
    public Iterable<Person> getUsers() {

        log.debug("Zapytanie o wszystkich userów");
        return userService.getPersons();
    }

    @PostMapping(value = "/users")
    public Person addUser(@RequestBody Person p) {
        return userService.addUser(p);
    }




}
