package com.daw.manuel.vivero.controlers;

import com.daw.manuel.vivero.entities.Usuario;
import com.daw.manuel.vivero.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author mmacho
 */
@Controller
public class UserController {

    @Autowired
    private IUserService iuserService;

    // Go to Registration Page
    @GetMapping("/register")
    public String register() {
        return "registerUser";
    }

    // Read Form data to save into DB
    @PostMapping("/saveUser")
    public String saveUser(
            @ModelAttribute Usuario user,
            Model model
    ) {
        Long id = iuserService.saveuser(user);
        String message = "Usuario '" + id + "' guardado correctamente !";
        model.addAttribute("msg", message);
        return "registerUser";
    }
}
