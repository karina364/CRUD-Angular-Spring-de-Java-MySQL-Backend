package com.pruebatecnica.pruebatecnica.dao;

import com.pruebatecnica.pruebatecnica.models.Usuario;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class UsuarioDaoImp implements UsuarioDao{

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public boolean verificarCredenciales(Usuario usuario) {
        String query = "FROM Usuario WHERE usuario=:usuario AND contrasena = :contrasena";
        List<Usuario> lista = entityManager.createQuery(query)
                .setParameter("usuario", usuario.getUsuario())
                .setParameter("contrasena", usuario.getContrasena())
                .getResultList();

        return !lista.isEmpty();
    }

    @Override
    public List<Usuario> getUsuarios() {
        String query = "FROM Usuario";
        return entityManager.createQuery(query).getResultList();

    }

    @Override
    public void eliminar(Long id) {
        Usuario usuario = entityManager.find(Usuario.class, id );
        entityManager.remove(usuario);
    }

    @Override
    public void agregar(Usuario usuario) {
        entityManager.merge(usuario);
    }

    @Override
    public void editar(Usuario usuario) {
        entityManager.merge(usuario);
    }

    @Override
    public Usuario getUsuariosId(Long id) {
        Usuario usuario = entityManager.find(Usuario.class, id);
        return usuario;
    }





}
