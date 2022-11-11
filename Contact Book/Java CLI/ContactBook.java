import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.time.LocalDate;

public class ContactBook {

	public static ArrayList<Contact> contacts = new ArrayList<>();
	public static File contactListFile;

	public static void main(String[] args){
		Scanner globalScanner = new Scanner(System.in);
		int language = chooseLanguage(globalScanner);
		welcomeMessage(language);
		menu(language, globalScanner);
	}

	public static int chooseLanguage(Scanner globalScanner){
		int userInput = -1;
		int languageCount = 6;
		while (userInput < 1 || userInput > languageCount){
			System.out.println("1 to use this application in English");
			System.out.println("2 para usar esta aplicação em português");
			System.out.println("3 pour utiliser cette application en français");
			System.out.println("4 für diese Application in Deutsch nutzen");
			System.out.println("5 を入力するとこのアプリケーションを日本語で使える");
			System.out.println("6 을 입력해면 이 애플리케이션을 한국어로 사용할 수 있다");

			userInput = globalScanner.nextInt();

			if (userInput >= 1 && userInput < languageCount) return userInput;
		}
		return 0;	
	}

	public static void welcomeMessage(int language){
		System.out.println();
		System.out.println("Welcome.");
		System.out.println("Today is " + LocalDate.now() + ".");
		System.out.println("You have " + contacts.size() + " contacts saved.");
		System.out.println();
	}

	public static void menu(int language, Scanner globalScanner){
		int userInput = -1;
		while (userInput != 0){
			System.out.println("What would you like to do?");
			System.out.println("0\tEnd the application");
			System.out.println("1\tSee all my contacts");
			System.out.println("2\tSearch for a contact");
			System.out.println("3\tAdd a contact");
			System.out.println("4\tDelete all my contacts");

			userInput = globalScanner.nextInt();

			switch (userInput){
				case 0: break;
				case 1: listContacts(language); break;
				case 2: contactSearchInterface(language, globalScanner); break;
				case 3: contactAdditionInterface(language, globalScanner); break;
				case 4: allContactDeletionInterface(language, globalScanner); break;
			}
		}
	}

	public static void findsContactsInLocalDirectory(){
		/*contactListFile = new File("./contactList.txt");
		try (Scanner localScanner = new Scanner(System.in)){
			while (localScanner.hasNextLine()){
				String[] strings = localScanner.nextLine().split("\t");
				// contact info extraction
			}
		} catch (FileNotFoundException e){
			System.out.println(e);
		}*/
	}

	
	public static boolean listContacts(int language){
		for (int index = 0; index < contacts.size(); index++)
			System.out.println("[" + index + "] " + contacts.get(index).getName());
		return true;
	}
	public static void contactAdditionInterface(int language, Scanner globalScanner){
		System.out.println("Inform your new contact's name.");
		String name = globalScanner.nextLine();

		int option = -1;

		Phone[] phones = new Phone[1];
		ArrayList<Phone> p = new ArrayList<>();
		while (option < 0 || option > 1){
			System.out.println("Would you like to add a phone?\n0\tNo\n1\tYes");
			option = globalScanner.nextInt();
			if (option == 1){
				System.out.println("What's the number?");
				String phoneNumber = globalScanner.nextLine();
				System.out.println("Add a tag");
				String tag = globalScanner.nextLine();
				p.add(new Phone(phoneNumber, tag));
			}	
		}

		System.out.println("Would you like to add an email?");
		Email[] emails = new Email[0];

		System.out.println("Would you like to add a place?");
		Place[] places = new Place[0];
		
		if (addContact(name, phones, emails, places))
			System.out.println("\nYour new contact was successfully added to your contact list.");
		else
			System.out.println("Something happened, and it was not possible to add your new contact to your contact list.");
	}

	public static boolean addContact(String name, Phone[] phones, Email[] emails, Place[] places){
		Contact newContact = new Contact(name);
		newContact.setPhones(phones);
		newContact.setEmails(emails);
		newContact.setPlaces(places);
		return saveNewContact(newContact);
		//return saveChanges();
	}
	public static boolean saveNewContact(Contact newContact){
		try {
			//file.write(newContact);
			contacts.add(newContact);
			return true;
		} catch (Exception e) {
			return false;
		}
	}


	public static void allContactDeletionInterface(int language, Scanner globalScanner){
		
	}
	public static boolean deleteAllContacts(){
		contacts.clear();
		return true;
	}

	public static void contactSearchInterface(int language, Scanner globalScanner){}

	public static void contactEditionInterface(int language, Scanner globalScanner){}
	public static boolean editContact(){
		return true;
	}

	public static void contactDeletionInterface(int language, Scanner globalScanner){}
	public static boolean deleteContact(){
		return true;
	}
}