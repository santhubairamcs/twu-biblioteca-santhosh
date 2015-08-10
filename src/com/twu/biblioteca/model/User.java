package com.twu.biblioteca.model;

public class User {
    private final String name;
    private final String email;
    private final String password;
    private final String libraryNumber;
    private final String phone;
    private final String role;

    public User(String name, String email, String phone, String libraryNumber, String password, String role) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.libraryNumber = libraryNumber;
        this.password = password;
        this.role = role;
    }

    public boolean authenticate(String libraryNumber, String password) {
        return (libraryNumber.equals(this.libraryNumber) && password.equals(this.password));
    }

    @Override
    public String toString() {
        return String.format("%-25s%-25s%-25s", name, email, phone);
    }

    public String getRole() {
        return role;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) return true;
        if (that == null || getClass() != that.getClass())
            return false;
        return (this.hashCode() == that.hashCode());
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (libraryNumber != null ? libraryNumber.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (role != null ? role.hashCode() : 0);
        return result;
    }
}
