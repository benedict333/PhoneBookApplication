import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

	public class Application {

		
		
		
		public static void main(String[] args) {
					
					Scanner sc= new Scanner(System.in);
					int input;
					do
					{
						System.out.println("  Select the action that you want to perform:");
						System.out.println("   1. Check for any existing contact-list files.");
						System.out.println("   2. Create a new contact-lsit file with all the details(Name, Phone Number and Address.)");
						System.out.println("   3. Add more entries to an existing contact-list" );
						System.out.println("   4. Search for an existing contct by names/city/state/ phone numbers." );
						System.out.println("   5. Delete a record for a given telephone number.");
						System.out.println("   6. Update a person's full details or the address for a given telephone number.");
						System.out.println("   7. Show all records in asc order of their Last Name.");					
						System.out.println("   8. Exit from the program.");
						System.out.println("      Enter an action number (1-8):  ");
			    	
					 input = sc.nextInt();
										
					switch(input) {
					  
					case 1:
						checkRecord ();
						break;
					case 2:						
						addRecord ();
						break;
					case 3:					
						appendContacts();
						break;
					case 4:					
						searchRecord();
						break;
					case 5:
						deleteRecord();					
						break;
					case 6:					
						updateDetails();
						break;
					case 7:					
						sortList ();
						break;
					}
					
					}while (input != 8);	
				}
				
		
		public static void checkRecord () {
			File file = new File("C:\\Users\\admin\\Desktop\\Stream\\Contact_List.txt");
				if (file.exists()) {
				System.out.println("  An existing contact-list file is found!");
				}
			else {
				System.out.println(" No file is found!");
			}
	}
		
		private static void addRecord () {		
			 final String path = "C:\\Users\\admin\\Desktop\\Stream\\";
				
				String fileName = path+"Contact_List.txt";			
				
						
					System.out.print("\n How many contacts do you want to add? Enter a number here: ");
					Scanner num = new Scanner(System.in);
					int count = num.nextInt();												
					 								
					ArrayList<Person> contact = new ArrayList<Person> (count);
					 for ( int i=0; i<count; i++)
					 {
						 Scanner sc = new Scanner(System.in);										 
						 Person person = new Person();					
						 Address address = new Address();
						 
						 	person.setAddress(address);	
							System.out.print("Enter the First Name: " );
							person.setFirstName(sc.nextLine());
							
							System.out.print("Enter the Last Name: " );
							person.setLastName(sc.nextLine());
							
							System.out.print("Enter the Phone Number: " );
							String format = sc.nextLine().replaceFirst("(\\d{3})(\\d{3})(\\d+)", "($1) $2-$3");
							person.setPhoneNumber(format);	
																		
							System.out.print("Enter the Street Address: " );
							address.setStreet(sc.nextLine());	
							
							System.out.print("Enter the City: " );
							address.setCity(sc.nextLine());	
							
							System.out.print("Enter the State: " );
							address.setState(sc.nextLine());						
							
							System.out.print("Enter the Zip Code: " );
							address.setZipCode(sc.nextLine());		
							contact.add(person);
							
							System.out.println("The contact has been added successfully.");	
																							
					 		}				 
					 System.out.println("A new file with the entered contacts has been created successfully.");
					 // Remove the brackets while saving to a text-file
					 
					 String list = Arrays.toString(contact.toArray()).replace("[", "").replace("]", "");				 
					
					 try {
							BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
							bw.write(list.toString());
							bw.close();
							
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					 return ;	 
		}
		
		private static void appendContacts() {		
			 final String path = "C:\\Users\\admin\\Desktop\\Stream\\";
				
				String fileName = path+"Contact_List.txt";					
					 
					try {
					Scanner scanner = new Scanner(new File(fileName));
					StringBuilder importContact = new StringBuilder();
										
					while(scanner.hasNext()) {
						importContact.append(scanner.nextLine());						
												
						String str=importContact.toString();
						ArrayList<String> contactList= new ArrayList<String>(Arrays.asList(str.split(",")));
												
						
						ArrayList<Person> existingContact = new ArrayList<Person> ();
						
						for(int i=0; i<contactList.size(); i++)
						{
						 Person person = new Person();
								
						Address address = new Address();
						
						person.setAddress(address);
						String line = contactList.get(i);
						String [] parseLine = line.split("/");
						person.setFirstName(parseLine[0]);
						person.setLastName(parseLine[1]);
						person.setPhoneNumber(parseLine[2]);							
						address.setStreet(parseLine[3]);
						address.setCity(parseLine[4]);
						address.setState(parseLine[5]);
						address.setZipCode(parseLine[6]);
						
						existingContact.add(i,person);								
						
						}
						//to test
						System.out.println("The existing contactlist is shown below:-");
						
						for(int i=0;i<existingContact.size();i++) {
						System.out.println("(" + (i+1) + ") "+existingContact.get(i).toString());
						}
					
					System.out.print("\n How many more contacts do you want to add? Enter a number here: ");
					Scanner num = new Scanner(System.in);
					int count = num.nextInt();												
					 								
					 for ( int i=0; i<count; i++)
					 {
						 Scanner sc = new Scanner(System.in);										 
						 Person person = new Person();					
						 Address address = new Address();
						 
						 	person.setAddress(address);	
							System.out.print("Enter the First Name: " );
							person.setFirstName(sc.nextLine());
							
							System.out.print("Enter the Last Name: " );
							person.setLastName(sc.nextLine());
							
							System.out.print("Enter the Phone Number: " );
							String format = sc.nextLine().replaceFirst("(\\d{3})(\\d{3})(\\d+)", "($1) $2-$3");
							person.setPhoneNumber(format);	
																		
							System.out.print("Enter the Street Address: " );
							address.setStreet(sc.nextLine());	
							
							System.out.print("Enter the City: " );
							address.setCity(sc.nextLine());	
							
							System.out.print("Enter the State: " );
							address.setState(sc.nextLine());						
							
							System.out.print("Enter the Zip Code: " );
							address.setZipCode(sc.nextLine());	
							
							existingContact.add(person);
							
							System.out.println("The contact has been added successfully.");	
																							
					 		}
					 
					 System.out.println("The final ontact list is shown below:-");
						for(int i=0;i<existingContact.size();i++) {
						System.out.println("(" + (i+1) + ") "+existingContact.get(i).toString());
						}
					 // Remove the brackets while saving to a text-file
					 
					 String list = Arrays.toString(existingContact.toArray()).replace("[", "").replace("]", "");
					 				
					 try  {
							BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
							bw.write(list.toString());
							bw.close();
					 
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					} 
						
					
					}catch(FileNotFoundException e) {
						System.out.println("Error reading file: "+fileName);
											
					}	
					return ;
				}
				
										
					
		public static void searchRecord () { 
				 
			 //Read from the text file containing contacts
			
			 final String path = "C:\\Users\\admin\\Desktop\\Stream\\";
											
					String fileName = path+"Contact_List.txt";				
						
						 
						try {
						Scanner scanner = new Scanner(new File(fileName));
						StringBuilder importContact = new StringBuilder();
											
						while(scanner.hasNext()) {
							//Entire contacts will be saved to a StringBuilder
							importContact.append(scanner.nextLine());						
							
							//convert the string into an arraylist
							
							String str=importContact.toString();
							ArrayList<String> contactList= new ArrayList<String>(Arrays.asList(str.split(",")));												
							
							ArrayList<Person> existingContact = new ArrayList<Person> ();
							
							for(int i=0; i<contactList.size(); i++)
							{
							 Person person = new Person();//the objects should be constructed inside side the loop to hold the changing value
									
							Address address = new Address();
							
							person.setAddress(address);
							String line = contactList.get(i);
							String [] parseLine = line.split("/");
							person.setFirstName(parseLine[0]);
							person.setLastName(parseLine[1]);
							person.setPhoneNumber(parseLine[2]);							
							address.setStreet(parseLine[3]);
							address.setCity(parseLine[4]);
							address.setState(parseLine[5]);
							address.setZipCode(parseLine[6]);	
							
							existingContact.add(i,person);						
							}
							
							//for searching
							
							System.out.println("Enter First Name/ Last Name / City/ State / Phone Number to search: ");
							Scanner search= new Scanner(System.in);
							 String searchWord = search.next().trim();
							
							 for(int i=0;i<existingContact.size();i++)	

									 {
									if (existingContact.get(i).getFirstName().trim().equals(searchWord) ||
										existingContact.get(i).getPhoneNumber().trim().equals (searchWord)|| 
										existingContact.get(i).getLastName().trim().equals (searchWord)|| 
										existingContact.get(i).getAddress().getCity().trim().equals(searchWord)||
										existingContact.get(i).getAddress().getState().trim().equals(searchWord))										
									{
										System.out.println(existingContact.get(i).toString());								
									}													
								}			
						}
																													
						}catch(FileNotFoundException e) {
							System.out.println("Error reading file: "+fileName);
												
						}						
								
						return ;
		}
						
					 	
	public static void deleteRecord () { 			 
			 
					final String path = "C:\\Users\\admin\\Desktop\\Stream\\";
											
					String fileName = path+"Contact_List.txt";
															 
						try {
						Scanner scanner = new Scanner(new File(fileName));
						StringBuilder importContact = new StringBuilder();
											
						while(scanner.hasNext()) {
							importContact.append(scanner.nextLine());						
													
							String str=importContact.toString();
							ArrayList<String> contactList= new ArrayList<String>(Arrays.asList(str.split(",")));												
							
							ArrayList<Person> existingContact = new ArrayList<Person> ();
							
							for(int i=0; i<contactList.size(); i++)
							{
							 Person person = new Person();								
							Address address = new Address();						
							person.setAddress(address);
							String line = contactList.get(i);
							String [] parseLine = line.split("/");
							person.setFirstName(parseLine[0]);
							person.setLastName(parseLine[1]);
							person.setPhoneNumber(parseLine[2]);							
							address.setStreet(parseLine[3]);
							address.setCity(parseLine[4]);
							address.setState(parseLine[5]);
							address.setZipCode(parseLine[6]);
							
							existingContact.add(i,person);						
							}
													
							System.out.println("Enter a Phone Number[in the format(314) 555-7890] or a name to delete an existing record: ");
							Scanner search= new Scanner(System.in);
							 String searchWord = search.next().trim();
							 
							 for(int i=0;i<existingContact.size();i++)
										
									 {
								 int deleteIndex ;								

									if (existingContact.get(i).getPhoneNumber().trim().equals (searchWord)||
											(existingContact.get(i).getFirstName().trim().equals (searchWord))||
											(existingContact.get(i).getLastName().equals (searchWord)))										
																					
									{									
										System.out.println("The matching contact is shown below. Enter '1' to delete / enter 2 to exit" );
										System.out.println(existingContact.get(i));
										deleteIndex = existingContact.indexOf(existingContact.get(i));
										Scanner search2= new Scanner(System.in);
										 int option = search2.nextInt();
										if (option == 1)
										{								
										existingContact.remove(deleteIndex);
										 String list = Arrays.toString(existingContact.toArray()).replace("[", "").replace("]", "");
										 
										 System.out.println("The updated Contact-List:-" +"\n" + list);
										 
										 try {
												BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
												bw.write(list.toString());
												bw.close();
												
											} catch (IOException e) {
												// TODO Auto-generated catch block
												e.printStackTrace();
											}
										  }																						
															
										}
										
									 }
								}
							 }catch(FileNotFoundException e) {
									System.out.println("Error reading file: "+fileName);										
								}
							 
							
						return ;
					}
								
	public static void updateDetails () { 	 
		 
				final String path = "C:\\Users\\admin\\Desktop\\Stream\\";
										
				String fileName = path+"Contact_List.txt";				
					 
					try {
					Scanner scanner = new Scanner(new File(fileName));
					StringBuilder importContact = new StringBuilder();
										
					while(scanner.hasNext()) {
						importContact.append(scanner.nextLine());						
												
						String str=importContact.toString();
						ArrayList<String> contactList= new ArrayList<String>(Arrays.asList(str.split(",")));											
						
						ArrayList<Person> existingContact = new ArrayList<Person> ();
						
						for(int i=0; i<contactList.size(); i++)
						{
						 Person person = new Person();//the objects should be constructed inside side the loop to hold the changing value
								
						Address address = new Address();
						
						person.setAddress(address);
						String line = contactList.get(i);
						String [] parseLine = line.split("/");
						person.setFirstName(parseLine[0]);
						person.setLastName(parseLine[1]);
						person.setPhoneNumber(parseLine[2]);							
						address.setStreet(parseLine[3]);
						address.setCity(parseLine[4]);
						address.setState(parseLine[5]);
						address.setZipCode(parseLine[6]);
						
						existingContact.add(i,person);								
						
						}
						//to test
						System.out.println("The Existing Contact List is shown below:-");
						
						for(int i=0;i<existingContact.size();i++) {
						System.out.println("(" + (i+1) + ") "+existingContact.get(i).toString());
						}
						
						System.out.println("Enter a Name / Phone Number to update the existing record: ");
						Scanner search= new Scanner(System.in);
						 String searchWord = search.next().trim();
						 Scanner word = new Scanner(System.in);
						 for(int i=0;i<existingContact.size();i++)								
								 {
							 int updateIndex ;								

								if (existingContact.get(i).getPhoneNumber().trim().equals (searchWord)||
										(existingContact.get(i).getFirstName().trim().equals(searchWord) ||
												existingContact.get(i).getLastName().trim().equals (searchWord)	))
										
								{									
									updateIndex = existingContact.indexOf(existingContact.get(i));
									System.out.println("The reord for updating is shown below -: " );
									System.out.println(existingContact.get(i).toString());
									
									System.out.println("Enter an option shown below for updating the record:-" );
									System.out.println("   1. Update the entire information.");
									System.out.println("   2. Update the Address only." );									
									Scanner sc = new Scanner(System.in);
									int input = sc.nextInt();								
									
									switch(input) {
									 
									case 1:
										Person newPerson = new Person();
										Address newAddress = new Address();
										Scanner word1 = new Scanner(System.in); 
										System.out.println("Enter First Name-: " );
										newPerson.setFirstName(word1.nextLine());
										System.out.println("Enter Last Name-: " );
										newPerson.setLastName(word1.nextLine());
										System.out.println("Enter Phone Number-: " );
										String format = sc.nextLine().replaceFirst("(\\d{3})(\\d{3})(\\d+)", "($1) $2-$3");
										newPerson.setPhoneNumber(format);	
										newPerson.setPhoneNumber(word1.nextLine());
										
										newPerson.setAddress(newAddress);
										System.out.println("Enter Street-: " );
										newAddress.setStreet(word1.nextLine());
										System.out.println("Enter City-: " );
										newAddress.setCity(word1.nextLine());
										System.out.println("Enter State-: " );
										newAddress.setState(word1.nextLine());
										System.out.println("Enter Zip Code-: " );
										newAddress.setZipCode(word1.nextLine());
										
										existingContact.set(updateIndex, newPerson);
										System.out.println("The updated record is shown below -: "); 
										System.out.println(newPerson); 
										
										break;
									case 2:
										Person newPerson2 = new Person();
										Address newAddress2 = new Address();
										Scanner word2 = new Scanner(System.in);
										newPerson2.setFirstName(existingContact.get(i).getFirstName());
										newPerson2.setLastName(existingContact.get(i).getLastName());
										newPerson2.setPhoneNumber(existingContact.get(i).getPhoneNumber());
										newPerson2.setAddress(newAddress2);
										System.out.println("Enter Street-: " );
										newAddress2.setStreet(word2.nextLine());
										System.out.println("Enter City-: " );
										newAddress2.setCity(word2.nextLine());
										System.out.println("Enter State-: " );
										newAddress2.setState(word2.nextLine());
										System.out.println("Enter Zip Code-: " );
										newAddress2.setZipCode(word2.nextLine());
										
										existingContact.set(updateIndex, newPerson2);
										System.out.println("The updated record is shown below -: "); 
										System.out.println(newPerson2); 
										
										break;	
									}
							}	
						}
						 String list = Arrays.toString(existingContact.toArray()).replace("[", "").replace("]", "");					 
											 
						 try {
								BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
								bw.write(list.toString());
								bw.close();
								
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}					 					
					}																
					}catch(FileNotFoundException e) {
						System.out.println("Error reading file: "+fileName);										
					}					
					return ;	 
		}

		public static void sortList () { 	
			 final String path = "C:\\Users\\admin\\Desktop\\Stream\\";
				
				String fileName = path+"Contact_List.txt";				
					 
					try {
					Scanner scanner = new Scanner(new File(fileName));
					StringBuilder importContact = new StringBuilder();
										
					while(scanner.hasNext()) {
						importContact.append(scanner.nextLine());						
												
						String str=importContact.toString();
						ArrayList<String> contactList= new ArrayList<String>(Arrays.asList(str.split(",")));
												
						
						ArrayList<Person> existingContact = new ArrayList<Person> ();
						
						for(int i=0; i<contactList.size(); i++)
						{
						 Person person = new Person();
								
						Address address = new Address();
						
						person.setAddress(address);
						String line = contactList.get(i);
						String [] parseLine = line.split("/");
						person.setFirstName(parseLine[0]);
						person.setLastName(parseLine[1]);
						person.setPhoneNumber(parseLine[2]);							
						address.setStreet(parseLine[3]);
						address.setCity(parseLine[4]);
						address.setState(parseLine[5]);
												
						existingContact.add(i,person);						
						}					
								
			Collections.sort(existingContact);
			
			for (Person person : existingContact)
				{
				System.out.println(person); 
				}								
					}				
					
					}catch(FileNotFoundException e) {
						System.out.println("Error reading file: "+fileName);										
					}						
					return ;
					}
	}
				 	
				      




