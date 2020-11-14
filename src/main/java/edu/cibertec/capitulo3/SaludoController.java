/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cibertec.capitulo3;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Adminfoco
 */
@Controller
public class SaludoController {
    
    @RequestMapping("saludo")
    public String saludar(){
        return "saludo.jsp";
    }
    
}
