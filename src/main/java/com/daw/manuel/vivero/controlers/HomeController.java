
package com.daw.manuel.vivero.controlers;

import com.daw.manuel.vivero.entities.Productos;
import com.daw.manuel.vivero.services.ProductosService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author mmacho
 */
@Controller
public class HomeController {
    
    @Autowired
    private ProductosService productosService;
    @RequestMapping("/index")
    public String goHome(Model model){
        List<Productos>productos=productosService.getAll();
        model.addAttribute("productos",productos);
        return "index";
    }
}
