
package com.daw.manuel.vivero.controlers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author mmacho
 */
@Controller
public class HomeController {
    @GetMapping("/")
    public String goHome(Model model){
        model.addAttribute("titulo","Bienvenid@Pagina de Inicio");
        return "index";
    }
}
