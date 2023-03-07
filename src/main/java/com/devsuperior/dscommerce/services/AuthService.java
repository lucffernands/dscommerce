package com.devsuperior.dscommerce.services;

import com.devsuperior.dscommerce.entities.User;
import com.devsuperior.dscommerce.services.exceptions.ForbiddenException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserService userService;

    public void validateSelForAdmin(long userId) {
        User me = userService.authenticated(); //busquei o usuario autenticado
        if (!me.hasRole("ROLE_ADMIN") && !me.getId().equals(userId)) { //se o usuario "me" não for admin e também não for o mesmo que "userID" do argumento
            throw new ForbiddenException("Access denied"); //dar acesso negado
        }
    }
}
