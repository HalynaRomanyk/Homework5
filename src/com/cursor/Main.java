package com.cursor;

public class Main {

    public static void main(String[] args) throws WrongLoginException, WrongPasswordException {
        boolean result = validateCredentials("123", "Abc", "Abc");
        System.out.println(result);

    }

    public static boolean validateCredentials(String login, String password, String confirmPasword) throws WrongLoginException,
            WrongPasswordException {
        try {
            if (!login.matches("^[a-zA-Z0-9_]+$") || login.length() >= 20) {
                throw new WrongLoginException("Wrong login");
            }
            if (!password.matches("^[a-zA-Z0-9_]+$") || password.length() >= 20 || !password.equals(confirmPasword)) {
                throw new WrongPasswordException("Wrong password");
            }
        } catch (WrongLoginException e) {
            e.printStackTrace();
            return false;
        } catch (WrongPasswordException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}

