package com.pruebatecnica.pruebatecnica.controllers;

import com.pruebatecnica.pruebatecnica.dao.UsuarioDao;
import com.pruebatecnica.pruebatecnica.models.Usuario;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600,allowedHeaders = "*")
@RestController
public class UsuarioController {
    private List<Usuario> usuario;
    @Autowired
    private UsuarioDao usuarioDao;

    @RequestMapping(value = "usuarios")
    public List<Usuario> getUsuarios(){
        return usuarioDao.getUsuarios();
    }

    @RequestMapping(value = "usuarios/{id}")
    public Usuario getUsuariosId(@PathVariable("id")Long id){
        return usuarioDao.getUsuariosId(id);
    }

    @RequestMapping(value = "usuarios", method=RequestMethod.POST)
    public void agregarUsuario(@RequestBody Usuario usuario){
        usuarioDao.agregar(usuario);
    }

    @RequestMapping(value = "usuarios/{id}", method=RequestMethod.PUT)
    public void editarUsuario(@RequestBody Usuario usuario, @PathVariable("id")Long id){
        usuario.setId(id);
        usuarioDao.editar(usuario);
    }

    @RequestMapping(value = "usuarios/{id}", method=RequestMethod.DELETE)
    public void eliminarUsuario(@PathVariable("id")Long id){
        usuarioDao.eliminar(id);
    }

    @SneakyThrows
    @RequestMapping(value = "usuarios/upload", method=RequestMethod.POST)
    public void uploadUsuarios(@RequestBody List<Usuario> usuario){

        for (Usuario string : usuario) {
            usuarioDao.agregar(string);
        }
    }

    @SneakyThrows
    @RequestMapping(value = "usuarios/uploadEdit", method=RequestMethod.POST)
    public void uploadEditUsuarios(@RequestBody List<Usuario> usuario){

        for (Usuario string : usuario) {
            string.getId();
            usuarioDao.editar(string);
        }
    }

    @RequestMapping(value = "usuarios/login", method = RequestMethod.POST)
    public String login(@RequestBody Usuario usuario){

        usuarioDao.verificarCredenciales(usuario);
        if(usuarioDao.verificarCredenciales(usuario)){
            return "1";
        }else{
            return "0";
        }
    }
}
