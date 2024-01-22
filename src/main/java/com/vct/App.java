package com.vct;

import com.auth0.jwt.algorithms.Algorithm;
import com.vct.entity.User;
import com.vct.infra.security.TokenService;

import java.util.Scanner;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Insira seu nome: ");
        String name = sc.nextLine();
        System.out.println("Insira seu email: ");
        String email = sc.nextLine();
        System.out.println("Insira sua senha: ");
        String password = sc.nextLine();
        User user = new User(name, email, password);
        System.out.println("Seu token JWT: ");
        System.out.println(TokenService.generateToken(user));
    }
}
