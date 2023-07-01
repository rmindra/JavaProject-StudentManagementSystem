package studentdatabaseapp;

import java.util.Scanner;

public class Student {
	
	private String firstName;
	private String lastName;
	private int gradeYear;
	private String studentID;
	private String courses = "";
	private int tuitionBalance = 0;
	private static int costOfCourse = 600;
	private static int id = 1000;

	// Constructor prompt user to enter student's name and year
	public Student() {
		Scanner in = new Scanner(System.in);
		System.out.print("\nEnter student first name: ");
		this.firstName = in.nextLine();
		
		System.out.print("Enter student last name: ");
		this.lastName = in.nextLine();
		
		System.out.print("1 - Freshmen\n2 - Sophmore\n3 - Junior\n4 - Senior\nEnter student class level: ");
		this.gradeYear = in.nextInt();
		
		setStudentID();
	}
	
	// Generate 5-digit ID
	private String setStudentID() {
		// Grade level + ID
		id++;
		return this.studentID =  gradeYear + "" + id;
	}
	
	// Enroll in courses
	public void enroll() {
		// Get inside a loop, user hits 0
		do {
			System.out.print("Emter course to enroll (Q to quit): ");
			Scanner in = new Scanner(System.in);
			String course = in.nextLine();
			if(!course.equalsIgnoreCase("Q")) {
				courses += "\n\t" + course;
				tuitionBalance += costOfCourse;
			}
			else { break; }
		}while(true);
	}
	
	// View Balance
	public void viewBalance() {
		System.out.println("Your balance is: $" + tuitionBalance);
	}
	
	// Pay Tuition
	public void payTuition() {
		viewBalance();
		Scanner in = new Scanner(System.in);
		System.out.print("Enter your payment: $");
		int payment = in.nextInt();
		tuitionBalance -= payment;
		System.out.println("Thank you  for your payment of $" + payment);
		viewBalance();
	}
	
	// Show status
	@Override
	public String toString() {
		return "\nName: " + firstName + " " + lastName +
				"\nGrade level: " + gradeYear +
				"\nStudent ID: " + studentID +
				"\nCourse Enrolled: " + courses +
				"\nBalance: $" + tuitionBalance;
	}
}
