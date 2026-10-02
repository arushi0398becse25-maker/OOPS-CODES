/*QUESTION 1- BANK ACCOUNT MANAGEMENT SYSTEM  

import java.util.*;
class BankAccount {
    private int accountNumber;
    private String accountHolder;
    private double balance;

    static int totalAccounts = 0;
    static String bankName = "Utkarsh Bank";

    BankAccount(String accountHolder, double balance) {
        totalAccounts++;
        this.accountNumber = totalAccounts;
        this.accountHolder = accountHolder;

        if (balance >= 0) {
            this.balance = balance;
        } else {
            this.balance = 0;
        }
    }

    void deposit(double amount) {
        if (amount > 0) {
            balance = balance + amount;
        }
    }

    void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance = balance - amount;
        }
    }

    static int getTotalAccounts() {
        return totalAccounts;
    }

    void displayDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Balance: " + balance);
        System.out.println();
    }

    int getAccountNumber() {
        return accountNumber;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        BankAccount[] accounts = new BankAccount[n];

       
        for (int i = 0; i < n; i++) {
            String name = sc.next();
            double balance = sc.nextDouble();

            accounts[i] = new BankAccount(name, balance);
        }

        int m = sc.nextInt();

       
        for (int i = 0; i < m; i++) {

            int accountNumber = sc.nextInt();
            String type = sc.next();
            double amount = sc.nextDouble();

           
            for (int j = 0; j < n; j++) {

                if (accounts[j].getAccountNumber() == accountNumber) {

                    if (type.equals("DEPOSIT")) {
                        accounts[j].deposit(amount);
                    }
                    else if (type.equals("WITHDRAW")) {
                        accounts[j].withdraw(amount);
                    }

                    break;
                }
            }
        }

      
        for (int i = 0; i < n; i++) {
            accounts[i].displayDetails();
        }

        System.out.println("Total Accounts: " + BankAccount.getTotalAccounts());

        sc.close();
    }
}*/





/*QUESTION 2- E-COMMERCE PRODUCT PRICING SYSTEM 

import java.util.*;

class Product {
    int productId;
    String name;
    double price;

    Product(int productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    double calculateFinalPrice() {
        return price;
    }
}

class Electronics extends Product {
    Electronics(int id, String name, double price) {
        super(id, name, price);
    }

    @Override
    double calculateFinalPrice() {
        return price + (price * 18 / 100) + 1000;
    }
}

class Clothing extends Product {
    Clothing(int id, String name, double price) {
        super(id, name, price);
    }

    @Override
    double calculateFinalPrice() {
        double discountPrice = price - (price * 10 / 100);
        return discountPrice + (discountPrice * 5 / 100);
    }
}

class Book extends Product {
    Book(int id, String name, double price) {
        super(id, name, price);
    }

    @Override
    double calculateFinalPrice() {
        return price + (price * 5 / 100);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Product[] products = new Product[n];

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int id = sc.nextInt();
            String name = sc.next();
            double price = sc.nextDouble();

            if (type.equals("ELECTRONICS")) {
                products[i] = new Electronics(id, name, price);
            } else if (type.equals("CLOTHING")) {
                products[i] = new Clothing(id, name, price);
            } else {
                products[i] = new Book(id, name, price);
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.println(products[i].name + ": " +
                               products[i].calculateFinalPrice());
        }

        sc.close();
    }
}*/





/*QUESTION -3 EMPLOYEE MANAGEMENT SYSTEM

import java.util.*;
class Employee {
    String name;
    String employeeId;
    double baseSalary;

    Employee(String name, String employeeId, double baseSalary) {
        this.name = name;
        this.employeeId = employeeId;
        this.baseSalary = baseSalary;
    }

    
    double calculateSalary() {
        return baseSalary;
    }

    double calculateSalary(double bonus) {
        return baseSalary + bonus;
    }
}

class Manager extends Employee {
    Manager(String name, String id, double salary) {
        super(name, id, salary);
    }

   
    @Override
    double calculateSalary() {
        return baseSalary + (baseSalary * 20 / 100);
    }
}

class Developer extends Employee {
    Developer(String name, String id, double salary) {
        super(name, id, salary);
    }

    @Override
    double calculateSalary() {
        return baseSalary + (baseSalary * 15 / 100);
    }
}

class Intern extends Employee {
    Intern(String name, String id, double salary) {
        super(name, id, salary);
    }

    @Override
    double calculateSalary() {
        return baseSalary + 5000;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Employee[] employees = new Employee[n];

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String id = sc.next();
            String name = sc.next();
            double salary = sc.nextDouble();

            if (type.equals("MANAGER")) {
                employees[i] = new Manager(name, id, salary);
            } 
            else if (type.equals("DEVELOPER")) {
                employees[i] = new Developer(name, id, salary);
            } 
            else {
                employees[i] = new Intern(name, id, salary);
            }
        }

        for (int i = 0; i < n; i++) {
            String role = "";

            if (employees[i] instanceof Manager) {
                role = "Manager";
            } 
            else if (employees[i] instanceof Developer) {
                role = "Developer";
            } 
            else {
                role = "Intern";
            }

            System.out.println(employees[i].name + " - " + role + " - "
                    + employees[i].calculateSalary());
        }

        sc.close();
    }
}*/






/*QUESTION 4- UNIVERSITY COURSE MANAGEMENT SYSTEM

import java.util.*;
abstract class Course {
    String courseCode;
    String courseName;
    int credits;

    Course(String courseCode, String courseName, int credits) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.credits = credits;
    }

    abstract double calculateFee();

    abstract void displayCourseDetails();
}

class RegularCourse extends Course {

    RegularCourse(String code, String name, int credits) {
        super(code, name, credits);
    }

    @Override
    double calculateFee() {
        return credits * 5000;
    }

    @Override
    void displayCourseDetails() {
        System.out.println(courseName + " (" + courseCode +
                ") - RegularCourse - Fee: " + calculateFee());
    }
}

class OnlineCourse extends Course {

    OnlineCourse(String code, String name, int credits) {
        super(code, name, credits);
    }

    @Override
    double calculateFee() {
        return credits * 3000;
    }

    @Override
    void displayCourseDetails() {
        System.out.println(courseName + " (" + courseCode +
                ") - OnlineCourse - Fee: " + calculateFee());
    }
}

class CertificationCourse extends Course {

    CertificationCourse(String code, String name, int credits) {
        super(code, name, credits);
    }

    @Override
    double calculateFee() {
        return (credits * 2000) + 1000;
    }

    @Override
    void displayCourseDetails() {
        System.out.println(courseName + " (" + courseCode +
                ") - CertificationCourse - Fee: " + calculateFee());
    }
}

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Course[] courses = new Course[n];

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            String code = sc.next();
            String name = sc.next();
            int credits = sc.nextInt();

            if (type.equals("REGULAR")) {
                courses[i] = new RegularCourse(code, name, credits);
            }
            else if (type.equals("ONLINE")) {
                courses[i] = new OnlineCourse(code, name, credits);
            }
            else {
                courses[i] = new CertificationCourse(code, name, credits);
            }
        }

        for (int i = 0; i < n; i++) {
            courses[i].displayCourseDetails();
        }

        sc.close();
    }
}*/





/*QUESTION 5 -  PAYMENT GATEWAY SYSTEM

import java.util.*;
interface PaymentMethod {
    void pay(double amount);
    void refund(double amount);
}

class UPIPayment implements PaymentMethod {

    public void pay(double amount) {
        System.out.println("UPI: Payment of " + amount + " successful");
    }

    public void refund(double amount) {
        System.out.println("UPI: Refund of " + amount + " successful");
    }
}

class CreditCardPayment implements PaymentMethod {

    public void pay(double amount) {
        System.out.println("CREDIT: Payment of " + amount + " successful");
    }

    public void refund(double amount) {
        System.out.println("CREDIT: Refund of " + amount + " successful");
    }
}

class DebitCardPayment implements PaymentMethod {

    public void pay(double amount) {
        System.out.println("DEBIT: Payment of " + amount + " successful");
    }

    public void refund(double amount) {
        System.out.println("DEBIT: Refund of " + amount + " successful");
    }
}

class WalletPayment implements PaymentMethod {

    public void pay(double amount) {
        System.out.println("WALLET: Payment of " + amount + " successful");
    }

    public void refund(double amount) {
        System.out.println("WALLET: Refund of " + amount + " successful");
    }
}

class PaymentProcessor {

    void processPayment(PaymentMethod paymentMethod, double amount) {
        paymentMethod.pay(amount);
    }
}

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        PaymentProcessor processor = new PaymentProcessor();

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            double amount = sc.nextDouble();

            PaymentMethod payment;

            if (type.equals("UPI")) {
                payment = new UPIPayment();
            }
            else if (type.equals("CREDIT")) {
                payment = new CreditCardPayment();
            }
            else if (type.equals("DEBIT")) {
                payment = new DebitCardPayment();
            }
            else {
                payment = new WalletPayment();
            }

            processor.processPayment(payment, amount);
        }

        sc.close();
    }
}*/





/*QUESTION 6- FOOD DELIVERY OBJECT MODELING SYSTEM 

import java.util.*;
class Address {
    String address;

    Address(String address) {
        this.address = address;
    }
}

class Customer {
    String name;
    Address address;

    Customer(String name, Address address) {
        this.name = name;
        this.address = address;
    }
}

class Restaurant {
    String name;

    Restaurant(String name) {
        this.name = name;
    }
}

class FoodItem {
    String name;
    double price;
    int quantity;

    FoodItem(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    double getTotal() {
        return price * quantity;
    }
}

class Order {
    ArrayList<FoodItem> items = new ArrayList<>();

    double deliveryCharge = 50;
    double taxRate = 0.05;

    void addItem(FoodItem item) {
        items.add(item);
    }

    double calculateSubtotal() {
        double subtotal = 0;

        for (FoodItem item : items) {
            subtotal += item.getTotal();
        }

        return subtotal;
    }

    double calculateDiscount() {
        double subtotal = calculateSubtotal();

        if (subtotal >= 1000) {
            return subtotal * 0.10;
        }

        return 0;
    }

    double calculateTax() {
        double subtotal = calculateSubtotal();
        double discount = calculateDiscount();

        double amountAfterDiscount = subtotal - discount;

        return amountAfterDiscount * taxRate;
    }

    double calculateFinalBill() {
        double subtotal = calculateSubtotal();
        double discount = calculateDiscount();
        double tax = calculateTax();

        return subtotal - discount + tax + deliveryCharge;
    }

    void displayOrder(Customer customer, Restaurant restaurant) {
        System.out.println("Customer: " + customer.name);
        System.out.println("Restaurant: " + restaurant.name);
        System.out.println("Subtotal: " + calculateSubtotal());
        System.out.println("Discount: " + calculateDiscount());
        System.out.println("Tax: " + calculateTax());
        System.out.println("Delivery Charge: " + deliveryCharge);
        System.out.println("Final Bill: " + calculateFinalBill());
    }
}

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String customerName = sc.nextLine();
        String addressText = sc.nextLine();
        String restaurantName = sc.nextLine();

        int n = sc.nextInt();

        Address address = new Address(addressText);
        Customer customer = new Customer(customerName, address);
        Restaurant restaurant = new Restaurant(restaurantName);

        Order order = new Order();

        for (int i = 0; i < n; i++) {
            String foodName = sc.next();
            double price = sc.nextDouble();
            int quantity = sc.nextInt();

            FoodItem item = new FoodItem(foodName, price, quantity);
            order.addItem(item);
        }

        order.displayOrder(customer, restaurant);

        sc.close();
    }
}*/





/*QUESTION 7- UNIVERSITY STUDENT POLYMORPHYSM SYSTEM 

import java.util.*;
class Person {
    String id;
    String name;
    int age;

    Person(String id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    void displayDetails() {
        System.out.println("Person: " + name + ", ID: " + id + ", Age: " + age);
    }
}

class Student extends Person {

    Student(String id, String name, int age) {
        super(id, name, age);
    }

    @Override
    void displayDetails() {
        System.out.println("Student: " + name + ", ID: " + id + ", Age: " + age);
    }
}

class EngineeringStudent extends Student {
    String branch;

    EngineeringStudent(String id, String name, int age, String branch) {
        super(id, name, age);
        this.branch = branch;
    }

    @Override
    void displayDetails() {
        System.out.println("Engineering Student: " + name +
                ", ID: " + id +
                ", Age: " + age +
                ", Branch: " + branch);
    }
}

class CSEStudent extends EngineeringStudent {
    String specialization;

    CSEStudent(String id, String name, int age, String specialization) {
        super(id, name, age, "CSE");
        this.specialization = specialization;
    }

    @Override
    void displayDetails() {
        System.out.println("CSE Student: " + name +
                ", ID: " + id +
                ", Age: " + age +
                ", Specialization: " + specialization);
    }
}

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Person[] people = new Person[n];

        for (int i = 0; i < n; i++) {

            String type = sc.next();

            String id = sc.next();
            String name = sc.next();
            int age = sc.nextInt();

            if (type.equals("STUDENT")) {
                people[i] = new Student(id, name, age);
            }
            else if (type.equals("ENGINEERING")) {
                String branch = sc.next();
                people[i] = new EngineeringStudent(id, name, age, branch);
            }
            else if (type.equals("CSE")) {
                String specialization = sc.next();
                people[i] = new CSEStudent(id, name, age, specialization);
            }
        }

        for (Person p : people) {
            p.displayDetails();
        }

        
        Person p = new CSEStudent("C104", "Neha", 20, "AI");

        p.displayDetails();

        sc.close();
    }
}*/





/*QUESTION 8- EXTENSIBLE NOTIFICATION SERVICE 

import java.util.*;
interface Notification {
    void send(String message);
}

class EmailNotification implements Notification {

    @Override
    public void send(String message) {
        System.out.println("EMAIL: " + message);
    }
}

class SMSNotification implements Notification {

    @Override
    public void send(String message) {
        System.out.println("SMS: " + message);
    }
}

class PushNotification implements Notification {

    @Override
    public void send(String message) {
        System.out.println("PUSH: " + message);
    }
}

class NotificationService {

    void sendNotification(Notification notification, String message) {
        notification.send(message);
    }
}

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        NotificationService service = new NotificationService();

        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            String message = sc.nextLine().trim();

            Notification notification;

            if (type.equals("EMAIL")) {
                notification = new EmailNotification();
            }
            else if (type.equals("SMS")) {
                notification = new SMSNotification();
            }
            else {
                notification = new PushNotification();
            }

            service.sendNotification(notification, message);
        }

        sc.close();
    }
}*/





/*QUESTION 9- LIBRARY MANAGEMENT SYSTEM 

import java.util.*;
class Book {
    String id;
    String title;
    boolean available;
    Member borrowedBy;

    Book(String id, String title) {
        this.id = id;
        this.title = title;
        this.available = true;
        this.borrowedBy = null;
    }

    boolean isAvailable() {
        return available;
    }

    boolean issue(Member member) {
        if (!available) {
            return false;
        }

        available = false;
        borrowedBy = member;
        return true;
    }

    boolean returnBook(Member member) {
        if (borrowedBy != member) {
            return false;
        }

        available = true;
        borrowedBy = null;
        return true;
    }

    double calculateLateFee(int days) {
        if (days <= 7) {
            return 0;
        }

        return (days - 7) * 5;
    }
}


abstract class Member {
    String id;
    String name;
    ArrayList<Book> borrowedBooks;

    Member(String id, String name) {
        this.id = id;
        this.name = name;
        borrowedBooks = new ArrayList<>();
    }

    abstract int getBorrowingLimit();

    boolean canBorrow() {
        return borrowedBooks.size() < getBorrowingLimit();
    }

    void addBook(Book book) {
        borrowedBooks.add(book);
    }

    void removeBook(Book book) {
        borrowedBooks.remove(book);
    }

    int getBorrowedCount() {
        return borrowedBooks.size();
    }
}


class StudentMember extends Member {

    StudentMember(String id, String name) {
        super(id, name);
    }

    @Override
    int getBorrowingLimit() {
        return 2;
    }
}


class FacultyMember extends Member {

    FacultyMember(String id, String name) {
        super(id, name);
    }

    @Override
    int getBorrowingLimit() {
        return 5;
    }
}


class GuestMember extends Member {

    GuestMember(String id, String name) {
        super(id, name);
    }

    @Override
    int getBorrowingLimit() {
        return 1;
    }
}


class Librarian {

    void issueBook(Book book, Member member) {
        book.issue(member);
    }

    void returnBook(Book book, Member member) {
        book.returnBook(member);
    }
}


class Library {

    ArrayList<Book> books = new ArrayList<>();

    void addBook(Book book) {
        books.add(book);
    }

    Book findBook(String id) {

        for (Book book : books) {
            if (book.id.equals(id)) {
                return book;
            }
        }

        return null;
    }

    String borrowBook(String bookId, Member member) {

        Book book = findBook(bookId);

        if (book == null) {
            return "Borrow failed: Book not found";
        }

        if (!member.canBorrow()) {
            return "Borrow failed: Borrowing limit reached";
        }

        if (!book.isAvailable()) {
            return "Borrow failed: Book unavailable";
        }

        book.issue(member);
        member.addBook(book);

        return "Borrowed: " + book.title;
    }

    String returnBook(String bookId, Member member) {

        Book book = findBook(bookId);

        if (book == null) {
            return "Return failed: Book not found";
        }

        if (!book.returnBook(member)) {
            return "Return failed: Not borrowed by this member";
        }

        member.removeBook(book);

        return "Returned: " + book.title;
    }
}


public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Library library = new Library();

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {

            String bookId = sc.next();
            String title = sc.next();

            Book book = new Book(bookId, title);

            library.addBook(book);
        }

        String type = sc.next();
        String memberId = sc.next();
        String memberName = sc.next();

        Member member;

        if (type.equals("STUDENT")) {
            member = new StudentMember(memberId, memberName);
        }
        else if (type.equals("FACULTY")) {
            member = new FacultyMember(memberId, memberName);
        }
        else {
            member = new GuestMember(memberId, memberName);
        }

        int m = sc.nextInt();

        for (int i = 0; i < m; i++) {

            String operation = sc.next();
            String bookId = sc.next();

            if (operation.equals("BORROW")) {
                System.out.println(
                    library.borrowBook(bookId, member)
                );
            }
            else if (operation.equals("RETURN")) {
                System.out.println(
                    library.returnBook(bookId, member)
                );
            }
        }

        System.out.println("Books Borrowed: " +
                member.getBorrowedCount());

        sc.close();
    }
}*/





/*QUESTION 10- EMPLOYEE BONUS MANAGEMENT 

import java.util.*;
class Employee {
    String name;
    String employeeId;
    double salary;

    Employee(String name, String employeeId, double salary) {
        this.name = name;
        this.employeeId = employeeId;
        this.salary = salary;
    }

    double calculateBonus() {
        return 0;
    }

    void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + employeeId);
        System.out.println("Salary: " + salary);
        System.out.println("Bonus: " + calculateBonus());
        System.out.println();
    }
}

class Developer extends Employee {

    Developer(String name, String employeeId, double salary) {
        super(name, employeeId, salary);
    }

    @Override
    double calculateBonus() {
        return salary * 0.10;
    }
}

class Manager extends Employee {

    Manager(String name, String employeeId, double salary) {
        super(name, employeeId, salary);
    }

    @Override
    double calculateBonus() {
        return salary * 0.15;
    }
}

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Employee[] employees = new Employee[n];

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            String id = sc.next();
            String name = sc.next();
            double salary = sc.nextDouble();

            if (type.equals("DEVELOPER")) {
                employees[i] = new Developer(name, id, salary);
            }
            else {
                employees[i] = new Manager(name, id, salary);
            }
        }

        for (Employee e : employees) {
            e.displayDetails();
        }

        sc.close();
    }
}*/