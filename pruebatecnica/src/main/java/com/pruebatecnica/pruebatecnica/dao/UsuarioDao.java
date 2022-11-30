package com.pruebatecnica.pruebatecnica.dao;

import com.pruebatecnica.pruebatecnica.models.Usuario;

import java.util.List;


public interface UsuarioDao {


    boolean verificarCredenciales(Usuario usuario);

    List<Usuario> getUsuarios();

    void eliminar(Long id);

    void agregar(Usuario usuario);

    void editar(Usuario usuario);

    Usuario getUsuariosId(Long id);




}
