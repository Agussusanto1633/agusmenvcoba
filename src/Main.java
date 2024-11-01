import java.util.ArrayList;
import java.util.Scanner;

class Patient {
    private String name;
    private int age;
    private String address;

    public Patient(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return String.format("Name: %s, Age: %d, Address: %s", name, age, address);
    }
}

public class Main {
    private static ArrayList<Patient> patients = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            showMenu();
        }
    }

    private static void showMenu() {
        System.out.println("1. Input New Data");
        System.out.println("2. View Patient’s Data");
        System.out.println("3. Exit");
        System.out.print("Choose an option: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (choice) {
            case 1:
                inputNewData();
                break;
            case 2:
                viewPatientsData();
                break;
            case 3:
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice. Try again.");
        }
    }

    private static void inputNewData() {
        System.out.print("Enter name (3-20 characters): ");
        String name = scanner.nextLine();
        while (name.length() < 3 || name.length() > 20) {
            System.out.print("Invalid name. Enter name (3-20 characters): ");
            name = scanner.nextLine();
        }

        System.out.print("Enter age (10-100): ");
        int age = scanner.nextInt();
        while (age < 10 || age > 100) {
            System.out.print("Invalid age. Enter age (10-100): ");
            age = scanner.nextInt();
        }
        scanner.nextLine(); // Consume newline

        System.out.print("Enter address (5-30 characters): ");
        String address = scanner.nextLine();
        while (address.length() < 5 || address.length() > 30) {
            System.out.print("Invalid address. Enter address (5-30 characters): ");
            address = scanner.nextLine();
        }

        patients.add(new Patient(name, age, address));
        System.out.println("Data has been successfully inserted!");
    }

    private static void viewPatientsData() {
        if (patients.isEmpty()) {
            System.out.println("No Data!");
            return;
        }

        while (true) {
            System.out.println("Patient Data:");
            for (int i = 0; i < patients.size(); i++) {
                System.out.println((i + 1) + ". " + patients.get(i));
            }

            System.out.println("1. Sort Data by Name Ascending");
            System.out.println("2. Sort Data by Name Descending");
            System.out.println("3. Sort Data by Age Ascending");
            System.out.println("4. Sort Data by Age Descending");
            System.out.println("5. Back");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    sortByNameAscending();
                    break;
                case 2:
                    sortByNameDescending();
                    break;
                case 3:
                    sortByAgeAscending();
                    break;
                case 4:
                    sortByAgeDescending();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void sortByNameAscending() {
        for (int i = 0; i < patients.size() - 1; i++) {
            for (int j = 0; j < patients.size() - i - 1; j++) {
                if (patients.get(j).getName().compareTo(patients.get(j + 1).getName()) > 0) {
                    Patient temp = patients.get(j);
                    patients.set(j, patients.get(j + 1));
                    patients.set(j + 1, temp);
                }
            }
        }
        System.out.println("Data sorted by name in ascending order.");
    }

    private static void sortByNameDescending() {
        for (int i = 0; i < patients.size() - 1; i++) {
            for (int j = 0; j < patients.size() - i - 1; j++) {
                if (patients.get(j).getName().compareTo(patients.get(j + 1).getName()) < 0) {
                    Patient temp = patients.get(j);
                    patients.set(j, patients.get(j + 1));
                    patients.set(j + 1, temp);
                }
            }
        }
        System.out.println("Data sorted by name in descending order.");
    }

    private static void sortByAgeAscending() {
        for (int i = 0; i < patients.size() - 1; i++) {
            for (int j = 0; j < patients.size() - i - 1; j++) {
                if (patients.get(j).getAge() > patients.get(j + 1).getAge()) {
                    Patient temp = patients.get(j);
                    patients.set(j, patients.get(j + 1));
                    patients.set(j + 1, temp);
                }
            }
        }
        System.out.println("Data sorted by age in ascending order.");
    }

    private static void sortByAgeDescending() {
        for (int i = 0; i < patients.size() - 1; i++) {
            for (int j = 0; j < patients.size() - i - 1; j++) {
                if (patients.get(j).getAge() < patients.get(j + 1).getAge()) {
                    Patient temp = patients.get(j);
                    patients.set(j, patients.get(j + 1));
                    patients.set(j + 1, temp);
                }
            }
        }
        System.out.println("Data sorted by age in descending order.");
    }
}