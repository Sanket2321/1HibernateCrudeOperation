package com.sp.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.sp.entities.User;

public class App {
    public static void main(String[] args) {
        // Create User objects
        User user1 = new User();
        user1.setName("Sanket");
        user1.setEmail("sanket@gmail.com");
        user1.setPassword("sanket1234");
        user1.setGender("male");
        user1.setCity("Pune");

        User user2 = new User();
        user2.setName("Prem");
        user2.setEmail("prem@gmail.com");
        user2.setPassword("prem1234");
        user2.setGender("female");
        user2.setCity("Pune");

        User user3 = new User();
        user3.setName("Sumit");
        user3.setEmail("sumit@gmail.com");
        user3.setPassword("sumit1234");
        user3.setGender("male");
        user3.setCity("Pune");

        // Hibernate configuration
        Configuration cfg = new Configuration();
        cfg.configure("/com/sp/config/hibernate.cfg.xml");
        cfg.addAnnotatedClass(User.class); // Add User entity to the configuration

        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();
        Transaction t = session.beginTransaction();

        // Insert operation
        try {
            session.save(user1); // Save user1 to the database
            session.save(user2); // Save user2 to the database
            session.save(user3); // Save user3 to the database

            t.commit(); // Commit the transaction
            System.out.println("User details saved successfully");
        } catch (Exception e) {
            t.rollback(); // Rollback transaction in case of an error
            e.printStackTrace();
        } finally {
            session.close(); // Close session
            factory.close(); // Close session factory
        }

        // Uncomment the desired operation to perform:

        // Select operation
        /*
        try {
            session = factory.openSession();
            User user = session.get(User.class, 1L);
            if (user != null) {
                System.out.println("User found: " + user.getName());
                System.out.println("Email: " + user.getEmail());
                System.out.println("City: " + user.getCity());
            } else {
                System.out.println("User not found");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        */

        // Update operation
        /*
        try {
            session = factory.openSession();
            t = session.beginTransaction();

            User userToUpdate = session.get(User.class, 2L);
            if (userToUpdate != null) {
                userToUpdate.setCity("Sangamner");
                session.saveOrUpdate(userToUpdate); // Save or update user2 in the database
                t.commit(); // Commit the transaction
                System.out.println("User details updated successfully");
            } else {
                System.out.println("User not found");
            }
        } catch (Exception e) {
            t.rollback(); // Rollback transaction in case of an error
            e.printStackTrace();
        } finally {
            session.close();
            factory.close();
        }
        */

        // Delete operation
        /*
        try {
            session = factory.openSession();
            t = session.beginTransaction();

            User userToDelete = session.get(User.class, 1L);
            if (userToDelete != null) {
                session.delete(userToDelete);
                t.commit(); // Commit the transaction
                System.out.println("User details deleted successfully");
            } else {
                System.out.println("User not found");
            }
        } catch (Exception e) {
            t.rollback(); // Rollback transaction in case of an error
            e.printStackTrace();
        } finally {
            session.close();
            factory.close();
        }
        */
    }
}
