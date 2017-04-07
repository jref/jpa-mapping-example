package ua.com.codespace.jpa.mapping;

import ua.com.codespace.jpa.mapping.model.Account;
import ua.com.codespace.jpa.mapping.model.AccountGroup;
import ua.com.codespace.jpa.mapping.model.Boss;
import ua.com.codespace.jpa.mapping.model.Company;
import ua.com.codespace.jpa.mapping.model.Employee;
import ua.com.codespace.jpa.mapping.model.Staff;
import ua.com.codespace.jpa.mapping.model.SystemAdministrator;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Company company = prepareCompany();
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("h2-persistence-unit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(company);
        transaction.commit();

        entityManager.close();
        entityManagerFactory.close();
    }

    private static Company prepareCompany() {
        Employee employee1 = new Employee();
        employee1.setName("Ivan");
        employee1.setPhones(Arrays.asList("067352", "098759"));
        Account bossAccount = new Account();
        bossAccount.setLogin("bossAccount");
        bossAccount.setGroup(AccountGroup.USER);
        Account adminAccount = new Account();
        adminAccount.setLogin("admin");
        adminAccount.setGroup(AccountGroup.ADMIN);

        Boss boss = new Boss();
        boss.setName("Bill");
        boss.setPhones(Arrays.asList("+135812", "+155548"));
        boss.setAccount(bossAccount);
        SystemAdministrator systemAdministrator = new SystemAdministrator();
        systemAdministrator.setName("Egor");
        systemAdministrator.setPhones(Arrays.asList("+3806777", "+382"));
        systemAdministrator.setAccount(adminAccount);
        Staff staff = new Staff();
        staff.setName("Petro");

        Company company = new Company();
        company.setName("Google");
        company.setAddress("USA, California");
        company.setPhones(Arrays.asList("+380", "+1907"));
        company.setEmployees(Arrays.asList(employee1, boss, systemAdministrator, staff));
        return company;
    }
}
