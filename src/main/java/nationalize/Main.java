package nationalize;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
@Controller
public class Main {

    @PostMapping("/nationalize")
    @ResponseBody
    public String getNationality(@RequestParam String name) {
        var client = NationalizeClient.newInstance();
        var nationality = client.getNationality(name);
        return nationality.toString();
    }

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}
