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

    @GetMapping("/")
    public String showForm() {
        return "index";
    }

    @PostMapping("/nationalize")
    public String getNationality(@RequestParam String name, Model model) {
        var client = NationalizeClient.newInstance();
        var nationality = client.getNationality(name);
        
        model.addAttribute("name", name);
        model.addAttribute("nationality", nationality);
        
        return "result";
    }

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}
