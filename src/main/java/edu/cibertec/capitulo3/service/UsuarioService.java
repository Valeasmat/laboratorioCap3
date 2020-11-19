/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cibertec.capitulo3.service;

import edu.cibertec.capitulo3.dao.UsuarioDAO;
import edu.cibertec.capitulo3.entity.UsuarioEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Adminfoco
 */
@Service
public class UsuarioService {
    
    @Autowired
    private UsuarioDAO usuarioDAO;
    
    public UsuarioEntity validarLogin(UsuarioEntity usuario){
        return usuarioDAO.validaLogin(usuario);
    }
}
