/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cibertec.capitulo3.dao;

import edu.cibertec.capitulo3.entity.UsuarioEntity;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Adminfoco
 */
@Repository
public class UsuarioDAO {
    
    public UsuarioEntity validaLogin(UsuarioEntity usuario){
        if (usuario.getUsuario().equalsIgnoreCase("user")&&
                usuario.getClave().equals("12345")){
            usuario.setNombreCompleto("Nombre completo del usuario");
        }
        else usuario=null;
        return usuario;
    }
    
}
