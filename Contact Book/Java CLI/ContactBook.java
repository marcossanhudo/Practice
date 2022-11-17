import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.HashMap;

public class ContactBook {

	public static HashMap<Integer, Contact> contacts = new HashMap<>();
	public static File contactListFile;

	public static void main(String[] args){
		Scanner globalScanner = new Scanner(System.in);
		int language = chooseLanguage(globalScanner);
		welcomeMessage(language);
		int keepAppOpen = 1;
		while (keepAppOpen != 0){
			keepAppOpen = menu(language, globalScanner);
		}
	}

	public static int chooseLanguage(Scanner globalScanner){
		int userInput = -1;
		int languageCount = 1;
		//int languageCount = 6;
		while (userInput < 1 || userInput > languageCount){
			System.out.println("1 to use this application in English");
			/*System.out.println("2 para usar esta aplicação em português");
			System.out.println("3 pour utiliser cette application en français");
			System.out.println("4 für diese Application in Deutsch nutzen");
			System.out.println("5 を入力するとこのアプリケーションを日本語で使える");
			System.out.println("6 을 입력해면 이 애플리케이션을 한국어로 사용할 수 있다");*/

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
	}

	public static int menu(int language, Scanner globalScanner){
		String prompt = "What would you like to do?";
		String[] options = {"End the application", "See all my contacts", "Search for a contact", "Add a contact", "Delete all contacts"};
		System.out.println();
		int option = numberMenu(prompt, options, globalScanner);
		System.out.println();
		switch (option){
			case 0: break;
			case 1: contactListingInterface(language, globalScanner); break;
			case 2: contactSearchInterface(language, globalScanner); break;
			case 3: contactAdditionInterface(language, globalScanner); break;
			case 4: allContactDeletionInterface(language, globalScanner); break;
		}
		return option;
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

	public static void contactListingInterface(int language, Scanner globalScanner){
		int contactsListed = listContacts(language, 1);
		if (contactsListed > 0) {
			System.out.println();
			System.out.println("[0] Exit listing");
			System.out.println("[1 ~ 9] Pick a contact");
			try {
				int option = globalScanner.nextInt();
				if (option == 0) return;
				else contactViewingInterface(option - 1, language, globalScanner);
			} catch (InputMismatchException e){
				System.out.println("To pick an option, use that option's respective number, as listed on the command line.\nTo stop running the application, simply use the Ctrl + C shortcut.");
			}
		}
		
	}
	public static int listContacts(int language){
		return listContacts(language, 0);
	}
	public static int listContacts(int language, int offset){
		if (contacts.size() == 0)
			System.out.println("Your contact list is empty."); 
		else { 
			System.out.println("Your saved contacts");
			for (int index = 0; index < contacts.size(); index++)
				if (contacts.containsKey(index))
					System.out.println("[" + (index + offset) + "] " + contacts.get(index).getName());
		}
		return contacts.size();
	}
	public static void contactViewingInterface(int contactId, int language, Scanner globalScanner){
		String prompt = "What would you like to do with this contact?";
		String[] options = {"Nothing. Go back to listing.",
					"Edit it.",
					"Delete it."};

		int option = -1;
		while (option != 0 && option != 2){
			System.out.println("\n" + generateContactTicket(contactId) + "\n");

			option = numberMenu(prompt, options, globalScanner);
			switch (option){
				case 0: return;
				case 1: contactEditionInterface(contactId, language, globalScanner); break;
				case 2: contactDeletionInterface(contactId, language, globalScanner); break;
			}
		}
	}
	public static void contactAdditionInterface(int language, Scanner globalScanner){
		String[] prompts;
		String[] options = {"No", "Yes"};

		System.out.println("What's your new contact's name?");
		String name = globalScanner.next();

		ArrayList<Phone> phones = new ArrayList<>();
		infoAdditionInterface("Would you like to add a phone?", "What's the number?", language, globalScanner)
			.forEach(info -> phones.add(new Phone(info.getData(), info.getTag())));
		
		ArrayList<Email> emails = new ArrayList<>();
		infoAdditionInterface("Would you like to add an email?", "What's the address?", language, globalScanner)
			.forEach(info -> phones.add(new Phone(info.getData(), info.getTag())));
		
		ArrayList<Place> places = new ArrayList<>();
		infoAdditionInterface("Would you like to add a place?", "What's the address?", language, globalScanner)
			.forEach(info -> phones.add(new Phone(info.getData(), info.getTag())));

		if (addContact(name, phones, emails, places))
			System.out.println("\nYour new contact was successfully added to your contact list.");
		else
			System.out.println("Something happened, and it was not possible to add your new contact to your contact list.");
	}
	public static ArrayList<Info> infoAdditionInterface(String numberMenuPrompt, String whatsTheData, int language, Scanner globalScanner){
		ArrayList<Info> info = new ArrayList<>();
		String[] options = {"No.", "Yes."};
		while (numberMenu(numberMenuPrompt, options, globalScanner) == 1){
			System.out.println(whatsTheData);
			String data = globalScanner.next();
			if (data.equals(""))
				break;
			System.out.println("Add a tag (optional).");
			String tag = globalScanner.next();
			info.add(new Info(data, tag));
		}
		return info;
	}
	/*public static ArrayList<Info> infoEditionInterface(ArrayList<Info> infos, int language, Scanner globalScanner){
		return infos;
	}
	public static ArrayList<Info> infoDeletionInterface(ArrayList<Info> infos, int language, Scanner globalScanner){
		return infos;
	}*/
	public static boolean addContact(String name, ArrayList<Phone> phones, ArrayList<Email> emails, ArrayList<Place> places){
		Contact newContact = new Contact(name);
		newContact.setPhones(phones);
		newContact.setEmails(emails);
		newContact.setPlaces(places);
		System.out.println("\n" + generateContactTicket(newContact));
		return saveNewContact(newContact);
		//return saveChanges();
	}
	public static boolean saveNewContact(Contact newContact){
		try {
			//file.write(newContact);
			contacts.put(contacts.size(), newContact);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	//public static void contactSearchInterface(int language, Scanner globalScanner){}

	public static void contactEditionInterface(int contactId, int language, Scanner globalScanner){
		String prompt = "What would you like to edit?";
		String options[] = {"Nothing. Go back.",
					"Name",
					"Phones",
					"Emails",
					"Places"};
		int editing = numberMenu(prompt, options, globalScanner);
		switch (editing){
			case 0: return;
			case 1: contactNameEditionInterface(contactId, language, globalScanner); break;
			case 2: contactPhoneEditionInterface(contactId, language, globalScanner); break;
			case 3: contactEmailEditionInterface(contactId, language, globalScanner); break;
			case 4: contactPlaceEditionInterface(contactId, language, globalScanner); break;
		}
	}
	public static void contactNameEditionInterface(int contactId, int language, Scanner globalScanner){
		Contact contact = contacts.get(contactId);
		String[] options = {"No.", "Yes."};
		
		System.out.println("What name would you like to save?");
		String name = globalScanner.next();

		if (numberMenu("Save changes?", options, globalScanner) == 1){
			contact.setName(name);
		}		
	}
	public static void contactPhoneEditionInterface(int contactId, int language, Scanner globalScanner){
		Contact contact = contacts.get(contactId);
		String options[] = {"Nothing. Go back.",
					"Add phones.",
					"Remove phones.",
					"Edit phones."};
		int choice = numberMenu("What would you like to do?", options, globalScanner);
		switch (choice){
			case 0: return;
			case 1: {
					ArrayList<Phone> phones = new ArrayList<>();
					phones.addAll(contact.getPhones());
					infoAdditionInterface("Add new phone?", "What's the number?", language, globalScanner)
						.forEach(info -> phones.add(new Phone(info.getData(), info.getTag())));
					contact.setPhones(phones);
					break;
				}
			/*case 2: {
					int toRemove = infoDeletionInterface(
						contact.getPhones(),
						"Which phone would you like to delete?",
						language,
						globalScanner);
					if (toRemove > -1){
						contact.getPhones().remove(toRemove);
					}
					break;
				}
			/*case 3:	contact.setPhones(contact.getPhones().add(phoneAdditionInterface(language, globalScanner)); break;*/
		}
	}
	public static void contactEmailEditionInterface(int contactId, int language, Scanner globalScanner){
		Contact contact = contacts.get(contactId);
		String options[] = {"Nothing. Go back.",
					"Add emails.",
					"Remove emails.",
					"Edit emails."};
		int choice = numberMenu("What would you like to do?", options, globalScanner);
		switch (choice){
			case 0: return;
			case 1: {
					ArrayList<Email> emails = new ArrayList<>();
					emails.addAll(contact.getEmails());
					infoAdditionInterface("Add new email?", "What's the address?", language, globalScanner)
						.forEach(info -> emails.add(new Email(info.getData(), info.getTag())));
					contact.setEmails(emails);
					break;
				}
			/*case 2: contact.setPhones(contact.getPhones()); break;
			case 3:	contact.setPhones(contact.getPhones().add(phoneAdditionInterface(language, globalScanner)); break;*/
		}
	}
	public static void contactPlaceEditionInterface(int contactId, int language, Scanner globalScanner){
		Contact contact = contacts.get(contactId);
		String options[] = {"Nothing. Go back.",
					"Add places.",
					"Remove places.",
					"Edit places."};
		int choice = numberMenu("What would you like to do?", options, globalScanner);
		switch (choice){
			case 0: return;
			case 1: {
					ArrayList<Place> places = new ArrayList<>();
					places.addAll(contact.getPlaces());
					infoAdditionInterface("Add new place?", "What's the address?", language, globalScanner)
						.forEach(info -> places.add(new Place(info.getData(), info.getTag())));
					contact.setPlaces(places);
					break;
				}
			/*case 2: REMOVAL; break;
			case 3:	EDITION; break;*/
		}
	}
	/*public static void infoEditionInterface(ArrayList<Info> infos, String numberMenuPrompt, String whatsTheData, int language, Scanner globalScanner){
		
	}
	public static int infoDeletionInterface(ArrayList<Info> infos, String numberMenuPrompt, int language, Scanner globalScanner){
		String[] options = new String[infos.size() + 1];
		options[0] = "None. Cancel.";
		for (int index = 1; index < options.length; index++)
			options[index] = infos.get(index - 1).getData() + "\t" + infos.get(index - 1).getTag();
		int toRemove = numberMenu(numberMenuPrompt, options, globalScanner);
		
		if (toRemove > 0){
			toRemove--;
			int confirmation = numberMenu("Are you sure you'd like to remove this info?", new String[]{"No.", "Yes."}, globalScanner);
			if (confirmation != 1) toRemove = -1;
			return toRemove;
		}
		else return -1;
	}

	public static boolean editContact(int contactId){
		Contact contactInEdition = contacts.get(contactId);
		contacts.put(contactId, contactInEdition);
		return true;
	}*/

	public static void contactDeletionInterface(int contactId, int language, Scanner globalScanner){
		String[] prompts = {"After deleting this contact, you won't be able to recover it.", generateContactTicket(contactId), "\nDelete this contact?"};
		String[] options = {"No", "Yes"};
		System.out.println();
		if (numberMenu(prompts, options, globalScanner) == 1)
			if (deleteContact(contactId))
				System.out.println("\nYour contact has been successfully deleted.");
			else
				System.out.println("\nSomething wrong happened, and it was not possible to delete that contact from your contact list.");
	}
	public static boolean deleteContact(int contactId){
		contacts.remove(contactId);
		return true;
	}

	public static void allContactDeletionInterface(int language, Scanner globalScanner){
		String[] prompts = {"After deleting all contacts, you won't be able to recover them.", "Delete all contacts?"};
		String[] options = {"No", "Yes"};
		if (deleteAllContacts())
			System.out.println("All your contacts have been successfully deleted.");
		else
			System.out.println("Something wrong happened, and it was not possible to clear your contact list.");
	}
	public static boolean deleteAllContacts(){
		contacts.clear();
		return true;
	}

	public static String generateContactTicket(int contactId){
		return generateContactTicket(contacts.get(contactId));
	}
	public static String generateContactTicket(Contact contact){
		String output = "Contact ====================================================\n";

		output += "Name \t" + contact.getName() + "\n";

		if (contact.getPhones().size() > 0){
			output += "Phones\n";
			for (Phone phone: contact.getPhones())
				output += "\t" + phone.getNumber() + "\t(" + phone.getTag() + ")\n";
		} else output += "No registered phones\n";

		if (contact.getEmails().size() > 0){
			output += "Emails\n";
			for (Email email: contact.getEmails())
				output += "\t" + email.getAddress() + "\t(" + email.getTag() + ")\n";
		} else output += "No registered emails\n";

		if (contact.getPlaces().size() > 0){
			output += "Places\n";
			for (Place place: contact.getPlaces())
				output += "\t" + place.getAddress() + "\t(" + place.getTag() + ")\n";
		} else output += "No registered places\n";

		output += "============================================================";

		return output;
	}

	// Generates menus
	public static int numberMenu(String prompt, String options[], Scanner globalScanner){
		String[] promptArray = {prompt};
		return numberMenu(promptArray, options, globalScanner);
	}
	public static int numberMenu(String[] prompts, String[] options, Scanner globalScanner){
		int option = -1;
		for (String prompt: prompts)
			System.out.println(prompt);
		for (int optionNumber = 0; optionNumber < options.length; optionNumber++){
			System.out.println(optionNumber + "\t" + options[optionNumber]);
		}
		try {
			option = globalScanner.nextInt();
			if (option > -1 && option <= options.length)
				return option;
			else {
				System.out.println("To pick an option, use that option's respective number, as listed on the command line.\nTo stop running the application, simply use the Ctrl + C shortcut.");
				return numberMenu(prompts, options, globalScanner);
			}
		} catch (InputMismatchException e){
			System.out.println("To pick an option, use that option's respective number, as listed on the command line.\nTo stop running the application, simply use the Ctrl + C shortcut.");
			return numberMenu(prompts, options, globalScanner);
		}
	}
}
