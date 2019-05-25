package wsi.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import wsi.model.GenericResponse;
import wsi.model.Person;
import wsi.service.UserService;

import java.util.List;

import static java.net.URLDecoder.decode;


@RestController
@CrossOrigin
@Slf4j
public class AlphaController {
    @Value("${app.version}")
    String version;

    @Autowired UserService userService;


    @GetMapping(value = "/status")
    public GenericResponse status() {
        return new GenericResponse("Uploader app version: " + version);
    }


    @GetMapping(value = "/users")
    public List<Person> getUsers() {
        return userService.getPersons();
    }



}
