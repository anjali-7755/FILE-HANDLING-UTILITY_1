package file.handling;

import java.io.*;
import java.util.Scanner;

public class FileOperations {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Welcome to the File Handling Utility");
		System.out.println("This program demonstrates file operations: Reading, Writing, and Modifying.");

		while (true) {
			System.out.println("\nFile Operations Menu:");
			System.out.println("1. Write to File");
			System.out.println("2. Read from File");
			System.out.println("3. Append to File");
			System.out.println("4. Exit");
			System.out.print("Enter your choice: ");

			int choice = scanner.nextInt();
			scanner.nextLine(); 

			switch (choice) {
			case 1 -> writeToFile(scanner);
			case 2 -> readFromFile(scanner);
			case 3 -> appendToFile(scanner);
			case 4 -> {
				System.out.println("Thank you for using the File Handling Utility. Goodbye!");
				scanner.close();
				return;
			}
			default -> System.out.println("Invalid choice. Please try again.");
			}
		}
	}
	private static void writeToFile(Scanner scanner) {
		System.out.print("Enter the file name (with extension, e.g., example.txt): ");
		String fileName = scanner.nextLine();

		try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
			System.out.print("Enter the content to write to the file: ");
			String content = scanner.nextLine();
			writer.write(content);
			System.out.println("Content written successfully to " + fileName);
		} catch (IOException e) {
			System.err.println("Error writing to the file: " + e.getMessage());
		}
	}
	private static void readFromFile(Scanner scanner) {
		System.out.print("Enter the file name to read from (with extension): ");
		String fileName = scanner.nextLine();

		try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
			System.out.println("\nFile Content:");
			String line;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}
		} catch (FileNotFoundException e) {
			System.err.println("File not found: " + fileName);
		} catch (IOException e) {
			System.err.println("Error reading the file: " + e.getMessage());
		}
	}
	private static void appendToFile(Scanner scanner) {
		System.out.print("Enter the file name to append to (with extension): ");
		String fileName = scanner.nextLine();

		try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
			System.out.print("Enter the content to append: ");
			String content = scanner.nextLine();
			writer.newLine(); // Add a newline before appending new content
			writer.write(content);
			System.out.println("Content appended successfully to " + fileName);
		} catch (IOException e) {
			System.err.println("Error appending to the file: " + e.getMessage());
		}
	}

}

