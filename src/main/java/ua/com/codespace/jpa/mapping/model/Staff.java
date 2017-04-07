package ua.com.codespace.jpa.mapping.model;

import javax.persistence.Entity;

@Entity
public class Staff extends Employee{

    @Override
    public String toString() {
        return "Staff{}";
    }
}
