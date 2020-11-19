/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cibertec.capitulo3.controller;

import edu.cibertec.capitulo3.entity.UsuarioEntity;
import edu.cibertec.capitulo3.service.UsuarioService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Adminfoco
 */
@Controller
public class UsuarioController {
    @Autowired     
    private UsuarioService usuarioService; 
 
    @RequestMapping("loginMostrar")     
    public String loginMostrar() {         
        return "login";     
    }
    
    @RequestMapping("loginAccion")     
    public ModelAndView loginAccion(UsuarioEntity usuarioValida) {         
        ModelAndView mv = null;         
        
        UsuarioEntity ue = usuarioService.validarLogin(usuarioValida);         
        if (ue == null) {             
            mv = new ModelAndView("login", "msgError", "Usuario y clave no existen. Vuelva a intentar!");         
        } else {             
            mv = new ModelAndView("saludo", "mensaje", "Bienvenido " + ue.getNombreCompleto());         
        }         
        return mv;     }
    
}
