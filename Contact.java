import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Contact implements Serializable {
	
	static Scanner scan = new Scanner(System.in);
	

	public static void createContact(Map<String, Long> eMap, Map<String, Long> nMap, Map<Long, ContactDetail> uid)

	{
		try {
			String name;
			String email;
			String address;
			long phone;
			long userId;
			System.out.println("Enter Name:");
			name = scan.nextLine();
			System.out.println("Enter Email:");
			email = scan.nextLine();
			if(!email.contains("@"))
			{
				System.out.println("Enter a valid email");
				email = scan.nextLine();
			}
			System.out.println("Enter Address:");
			address = scan.nextLine();
			System.out.println("Enter Phone number:");
			phone = scan.nextLong();
			scan.nextLine();
			userId = (long)(email+name).hashCode();
			ContactDetail cd = new ContactDetail(userId, name, email, phone, address);
			eMap.put(email, userId);
			// long id = eMap.get(email);
			nMap.put(name, userId);
			uid.put(userId, cd);
			System.out.println("Contact is successfully added");
		} catch (Exception e) {
			System.out.println("Enter a valid input");
		}

	}

	public static void searchContact(Map<String, Long> eMap, Map<String, Long> nMap, Map<Long, ContactDetail> uid) {
		try {
			System.out.println("1. Search by Name:\n 2.Search by Email:\n");
			int choice = scan.nextInt();
			scan.nextLine();
			if (choice == 1) {
				String searchName = scan.nextLine();
				if (nMap.containsKey(searchName)) {
					long sid = nMap.get(searchName);
					System.out.println(uid.get(sid));
				} else {
					System.out.println("No record found");
				}

			} else if (choice == 2) {
				String searchEmail = scan.nextLine();
				if (eMap.containsKey(searchEmail)) {
					long sid = eMap.get(searchEmail);
					System.out.println(uid.get(sid));
				} else {
					System.out.println("No record found");
				}

			}
			if (choice > 2) {
				System.out.println("Enter a valid input please!!");
			}
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public static void updateContact(Map<String, Long> eMap, Map<String, Long> nMap, Map<Long, ContactDetail> uid) {
		try {
			System.out.println("Update using Email:");
			System.out.println("Enter email to update:");
			String emailUpdate = scan.next();
			if (eMap.containsKey(emailUpdate)) {
				long updid = eMap.get(emailUpdate);
				ContactDetail cd = uid.get(updid);
				String uname = cd.name;
				eMap.remove(emailUpdate);
				nMap.remove(uname);
				uid.remove(updid);
				scan.nextLine();
				System.out.println("Enter name to update:");
				String updateName = scan.nextLine();
				System.out.println("Enter address to update:");
				String updateAddress = scan.nextLine();
				System.out.println("Enter email to update:");
				String updateEmail = scan.nextLine();
				cd.name = updateName;
				cd.email = updateEmail;
				cd.address = updateAddress;
				eMap.put(updateEmail, updid);
				nMap.put(updateName, updid);
				uid.put(updid, cd);
			} else {
				System.out.println("No record is found to update");
			}

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static void deleteContact(Map<String, Long> eMap, Map<String, Long> nMap, Map<Long, ContactDetail> uid) {
		try {
			System.out.println("Enter Email to delete:");
			String emailDelete = scan.nextLine();
			if (eMap.containsKey(emailDelete)) {
				long delid = eMap.get(emailDelete);
				ContactDetail cd = uid.get(delid);
				String dname = cd.name;
				eMap.remove(emailDelete);
				nMap.remove(dname);
				uid.remove(delid);
				System.out.println("Contact is deleted successfully");
			} else {
				System.out.println("No such record to delete");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static void display(Map<Long, ContactDetail> uid) {
		if (uid.isEmpty()) {
			System.out.println("No records to display");
		} else {
			for (Long values : uid.keySet())
				System.out.println(uid.get(values));
		}

	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Map<String, Long> eMap = new LinkedHashMap<>();
		Map<String, Long> nMap = new LinkedHashMap<>();
		Map<Long, ContactDetail> uid = new LinkedHashMap<>();
		try {
			FileInputStream fis1=new FileInputStream("C:\\Myproject\\src\\eMap.txt");
			FileInputStream fis2=new FileInputStream("C:\\Myproject\\src\\nMap.txt");
			FileInputStream fis3=new FileInputStream("C:\\Myproject\\src\\uid.txt");
			ObjectInputStream ois1=new ObjectInputStream(fis1);
			ObjectInputStream ois2=new ObjectInputStream(fis2);
			ObjectInputStream ois3=new ObjectInputStream(fis3);
			eMap=(LinkedHashMap)ois1.readObject();
			nMap=(LinkedHashMap)ois2.readObject();
			uid=(LinkedHashMap)ois3.readObject();
			
		}
		catch(Exception e) {
			System.out.println("There is no file!!");
		}
		FileOutputStream fos1=new FileOutputStream("C:\\Myproject\\src\\eMap.txt");
		FileOutputStream fos2=new FileOutputStream("C:\\Myproject\\src\\nMap.txt");
		FileOutputStream fos3=new FileOutputStream("C:\\Myproject\\src\\uid.txt");
		ObjectOutputStream oos1=new ObjectOutputStream(fos1);
		ObjectOutputStream oos2=new ObjectOutputStream(fos2);
		ObjectOutputStream oos3=new ObjectOutputStream(fos3);
		
		
		
		while (true) {
			System.out.println(
					"Enter an option below:\n 1.Create contact\n 2.Search contact\n 3.Update contact\n 4.Delete contact\n 5.List all contact\n 6.Exit\n");
			int option = scan.nextInt();
			scan.nextLine();
			switch (option) {
			case 1:
				createContact(eMap, nMap, uid);
				break;
			case 2:
				searchContact(eMap, nMap, uid);
				break;
			case 3:
				updateContact(eMap, nMap, uid);
				break;
			case 4:
				deleteContact(eMap, nMap, uid);
				break;
			case 5:
				display(uid);
				break;
			case 6:
				System.out.println("Exit Successfully");
				oos1.writeObject(eMap);
				oos2.writeObject(nMap);
				oos3.writeObject(uid);
				System.exit(0);
				break;
			default:
				if (option > 6) {
					System.out.println("Enter a option between 1-6");
				}

			}
		}

	}

}
