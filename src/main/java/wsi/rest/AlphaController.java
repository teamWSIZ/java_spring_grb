package wsi.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import wsi.model.ExecResponse;
import wsi.model.GenericResponse;
import wsi.model.Pass;
import wsi.model.Person;
import wsi.repo.PassRepo;
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
    @Autowired PassRepo passRepo;


    @GetMapping(value = "/pass/change")
    public Pass storePass(
            @RequestParam("user") String user,
            @RequestParam("pass") String pass) {
        Pass p = passRepo.findByUser(user); //sprawdzamy czy juz jest
        if (p==null) {
            p = new Pass(null, user, pass);
            log.info("Zapisuje nowego usera/haslo do bazy: {}", p);
        } else {
            p.setPass(pass);    //update password
            log.info("Updateuje password na {}",p);
        }

        passRepo.save(p); ///teraz haslo juz jest zapisane; nadano mu ID
        return p;
    }

    @GetMapping(value = "/pass/check")
    public String checkPass(
            @RequestParam("user") String user,
            @RequestParam("pass") String pass) {
        Pass p = passRepo.findByUser(user);
        if (p.getPass().equals(pass)) {
            return "Password OK";
        } else {
            return "Wrong password";
        }
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


    @GetMapping(value = "/status")
    public GenericResponse status() {
        log.info("Zapytanie o status aplikacji");
        return new GenericResponse("App version: " + version);
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
