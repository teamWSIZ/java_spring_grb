package wsi.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping(value = "/status")
    public GenericResponse status() {
        log.info("Zapytanie o status aplikacji");
        return new GenericResponse("App version: " + version);
    }

    @GetMapping(value = "/health")
    public String health() {
        log.info("Health heck");
        return "0";
    }



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
