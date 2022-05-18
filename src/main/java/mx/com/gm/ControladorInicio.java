package mx.com.gm;

import lombok.extern.slf4j.Slf4j;
import mx.com.gm.domain.Persona;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@Slf4j
public class ControladorInicio {

    @Value("${index.saludo}")
    private  String saludo;

    @GetMapping("/")
    public String inicio(Model model){
        log.info("ejecutando el controlador inicio");
        log.debug("Mas detalle del controlador");
        Persona persona = new Persona();
        persona.setNombre("Juan");
        persona.setApellido("Perez");
        persona.setEmail("jperez@email.com");
        persona.setTelefono("2223322");

        Persona persona2 = new Persona();
        persona2.setNombre("Karla");
        persona2.setApellido("Gomez");
        persona2.setEmail("gomezk@mail.com");
        persona2.setTelefono("33226600");

        List personas = new ArrayList();
        personas.add(persona);
        personas.add(persona2);


        // List personas = new ArrayList();

        String mensaje = "Hola mundo con Thymeleaf test";
        model.addAttribute("mensaje", mensaje);
        model.addAttribute("saludo",saludo);
        // model.addAttribute("personas",personas);
        model.addAttribute("personas",personas);
        return "index";
    }
}
