package edu.escuelaing.arsw;

import jdk.nashorn.internal.ir.CaseNode;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@SpringBootApplication
@RestController
public class WebSiteController {
    public static void main(String[] args) {
        SpringApplication.run(WebSiteController.class, args);
    }
    @Resource
    private HttpServletRequest servlet;

    @GetMapping("/status")
    public String status() {
        return "{\"status\":\"Greetings from Spring Boot. " +
                java.time.LocalDate.now() + ", " +
                java.time.LocalTime.now() +
                ". " + "The server is Runnig!\"}";
    }
    @GetMapping("/setname")
    public String name(@RequestParam(value = "name",defaultValue = "none") String name){
        servlet.getSession().setAttribute("name ",name);
        Usuario user = new Usuario(name);
        Cache.getcache().adduser(user);
        return String.format("Holas %s!",name);
    }
    @PostMapping("/pixel")
    public void guardarPixeles(@RequestBody  List<Integer> listapixel){
        Cache.getcache().addPixel(listapixel);
    }
    @GetMapping("/pixel")
    public List<List<Integer>> returnTablero(){
        return Cache.getcache().getPixeles();
    }
    @GetMapping("/color")
    public Color color (){
        String user = (String) servlet.getSession().getAttribute("name");
        return Cache.getcache().getuserColor(user);


    }
    @PostMapping("/reiniciar")
    public void reiniciar(){
        Cache.getcache().reiniciar();
    }
}
