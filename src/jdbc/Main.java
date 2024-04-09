package jdbc;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        DatabaseHandler databaseHandler = new DatabaseHandler();

//        // Create
//        Person newPerson = new Person();
//        newPerson.setName("John Doe");
//        newPerson.setAge(25);
//        databaseHandler.createPerson(newPerson);
//
//        // Read
//        List<Person> allPersons = databaseHandler.readAllPersons();
//        for (Person person : allPersons) {
//            System.out.println(person);
//        }
//
//        // Update
//        Person personToUpdate = allPersons.get(0);
//        personToUpdate.setName("Updated Name");
//        personToUpdate.setAge(30);
//        databaseHandler.updatePerson(personToUpdate);
//
        // Read again to see the changes
        List<Person> updatedPersons = databaseHandler.readAllPersons();
        for (Person person : updatedPersons) {
            System.out.println(person);
        }

//        // Delete
//        int personIdToDelete = updatedPersons.get(0).getId();
//        databaseHandler.deletePerson(personIdToDelete);
//
//        // Delete all
//        databaseHandler.deleteAllPersons();
//
//        // Read again to see the changes
//        List<Person> finalPersons = databaseHandler.readAllPersons();
//        for (Person person : finalPersons) {
//            System.out.println(person);
//        }
    }
}
