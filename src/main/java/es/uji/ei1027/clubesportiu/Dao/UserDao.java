package es.uji.ei1027.clubesportiu.Dao;

import es.uji.ei1027.clubesportiu.Model.UserDetails;

import java.util.Collection;

public interface UserDao {
    UserDetails loadUserByUsername(String username, String password);
    Collection<UserDetails> listAllUsers();
}
