package ContactBook;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import ContactBook.Contact.*;

public class ContactBook {

	public static Contact[] contacts;

	public static void main(String[] args){
		int language = chooseLanguage();
		welcomeMessage(language);
		menu(language);
	}

	public static int chooseLanguage(){
		Scanner scanner = new Scanner(System.in);
		int userInput = -1;
		int languageCount = 5;
		while (userInput < 0 && userInput > languageCount){
			System.out.println("1 to use this application in English");
			System.out.println("2 para usar esta aplicação em português");
			System.out.println("3 pour utiliser cette application en français");
			System.out.println("4 für diese Application in Deutsch nutzen");
			System.out.println("5 を入力するとこのアプリケーションを日本語で使える");
			System.out.println("6 을 입력해면 이 애플리케이션을 한국어로 사용할 수 있다");
			userInput = scanner.nextInt();
			if (userInput >= 0 && userInput < languageCount) return userInput;
		}	
	}

	public static void welcomeMessage(int language){
		;
	}
	public static void menu(int language){
		File contactList = new File("./contactList.txt");
		try (Scanner scanner = new Scanner(System.in)){
			
			
		} catch (FileNotFoundException e){
			System.out.println(e);
		}
	}

	public static void contactAdditionInterface(){}
	public static boolean addContact(String name, Phone[] phones, Email[] emails, Place[] places, File contactList){
		Contact newContact = new Contact(name);
		newContact.setPhones(phones);
		newContact.setEmails(emails);
		newContact.setPlaces(places);
		return saveNewContact(newContact, contactList);
		//return saveChanges();
	}
	public static boolean saveNewContact(Contact newContact, File file){
		try {
			//file.write(newContact);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static boolean listContacts(){
		for (int index = 0; index < contacts.length; index++)
			System.out.println("[" + index + "] " + contacts[index].getName() + contacts[index].getPhones()[0]);
	}

	public static void allContactDeletionInterface(){}
	public static boolean deleteAllContacts(){}

	public static void contactEditionInterface(){}
	public static boolean editContact(){}

	public static void contactDeletionInterface(){}
	public static boolean deleteContact(){}
}