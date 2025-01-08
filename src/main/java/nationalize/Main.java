package nationalize;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@SpringBootApplication
@Controller
public class Main {
    private final NationalizeClient nationalizeClient;

    public Main() {
        this.nationalizeClient = NationalizeClient.newInstance();
    }

    @GetMapping("/")
    public String showForm() {
        return "index";
    }

    @PostMapping("/nationalize")
    public String analyzeNationality(@RequestParam("name") String name, Model model) {
        Nationality nationality = nationalizeClient.getNationality(name);
        model.addAttribute("nationality", nationality);
        model.addAttribute("name", name);
        return "result";
    }

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}