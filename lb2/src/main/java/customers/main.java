package customers;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Customers[] customers = new Customers[2];

        // Введення даних з клавіатури
        for (int i = 0; i < customers.length; i++) {
            System.out.println("Введіть інформацію про покупця №" + (i + 1));
            System.out.print("ID: ");
            int id = Integer.parseInt(scanner.nextLine());

            System.out.print("Прізвище: ");
            String lastName = scanner.nextLine();

            System.out.print("Ім'я: ");
            String firstName = scanner.nextLine();

            System.out.print("По батькові: ");
            String middleName = scanner.nextLine();

            System.out.print("Адреса: ");
            String address = scanner.nextLine();

            System.out.print("Номер кредитної картки: ");
            String creditCardNumber = scanner.nextLine();

            System.out.print("Баланс рахунку: ");
            double balance = Double.parseDouble(scanner.nextLine());

            customers[i] = new Customers(id, lastName, firstName, middleName, address, creditCardNumber, balance);
        }

        // Викликаємо методи для критеріїв
        System.out.print("\nВведіть ім'я для пошуку: ");
        String nameForSearch = scanner.nextLine();
        printCustomersWithName(customers, nameForSearch);

        System.out.print("\nВведіть початковий діапазон номеру картки: ");
        String startCardRange = scanner.nextLine();
        System.out.print("Введіть кінцевий діапазон номеру картки: ");
        String endCardRange = scanner.nextLine();
        printCustomersWithCardInRange(customers, startCardRange, endCardRange);

        printCustomersWithDebt(customers);
    }

    // a) Список покупців із вказаним іменем
    public static void printCustomersWithName(Customers[] customers, String name) {
        System.out.println("Покупці з іменем: " + name);
        for (Customers customer : customers) {
            if (customer.getFirstName().equalsIgnoreCase(name)) {
                System.out.println(customer);
            }
        }
    }


    // b) Список покупців, у яких номер кредитної картки знаходиться в заданому інтервалі
    public static void printCustomersWithCardInRange(Customers[] customers, String start, String end) {
        System.out.println("\nПокупці з номером кредитної картки у діапазоні від " + start + " до " + end);
        for (Customers customer : customers) {
            if (customer.getCreditCardNumber().compareTo(start) >= 0 && customer.getCreditCardNumber().compareTo(end) <= 0) {
                System.out.println(customer);
            }
        }
    }

    // c) Кількість та список покупців, які мають заборгованість
    public static void printCustomersWithDebt(Customers[] customers) {
        System.out.println("\nПокупці із заборгованістю (негативний баланс):");
        int count = 0;
        double total = 0;
        for (Customers customer : customers) {
            if (customer.getBalance() < 0) {
                System.out.println(customer);
                count++;
                total += Math.abs(customer.getBalance());
            }
        }
        System.out.println("Кількість покупців із заборгованістю: " + count);
        if (count < 0) {
            double AvarageSum = total / count;
            System.out.println(" Середній баланс покупців" + AvarageSum);

        } else {
            System.out.println("Кількість покупців із заборгованістю: ");
        }
    }
}


