/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cibertec.capitulo3.controller;

import edu.cibertec.capitulo3.entity.UsuarioEntity;
import edu.cibertec.capitulo3.service.UsuarioService;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
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
            mv = new ModelAndView("usuarioLista", "lista", usuarioService.getListaUsuarios());         
        }         
        return mv;     
    }
    
    @RequestMapping("usuarioCrear")
    public ModelAndView usuarioCrear(){
        return new ModelAndView("usuarioDatos","usuarioBean",new UsuarioEntity());
        
    }
    
    @RequestMapping("usuarioGrabar")
    public ModelAndView usuarioGrabar(@Valid @ModelAttribute("usuarioBean") UsuarioEntity usuarioValida,
            BindingResult result,ModelMap modelMap){
        
        ModelAndView mv=null;
        
        if (result.hasErrors()){
            mv=new ModelAndView("usuarioDatos","usuarioBean",usuarioValida);
        } else {
            usuarioService.insertaUsuario(usuarioValida);
            mv= new ModelAndView("usuarioLista","lista",usuarioService.getListaUsuarios());
        }
        
        return mv;
    }
    
}
