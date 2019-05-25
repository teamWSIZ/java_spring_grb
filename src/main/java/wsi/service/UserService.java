package wsi.service;

import com.github.javafaker.Faker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import wsi.model.Person;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.*;

import static java.net.URLDecoder.decode;
import static java.nio.charset.StandardCharsets.UTF_8;
import static java.nio.file.Files.copy;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import static org.springframework.util.StringUtils.cleanPath;

@Service
@Slf4j
public class UserService {
    Faker f = new Faker(new Locale("pl")); //pl, en-UK, ru, ...

    Map<Integer,Person> personStorage;

    //konstruktor
    public UserService() {
        generatePersons();
    }

    private void generatePersons() {
        personStorage = new HashMap<>();
        for (int i = 0; i < 30; i++) {
            int id = i;
            Person p = new Person(i, f.name().firstName(), f.name().lastName(), f.address().city());
            personStorage.put(id, p);
        }
    }

    public Iterable<Person> getPersons() {
        return personStorage.values();
    }



}
