# PhoneBookApplication
This application saves contacts to a text file further enabling editing or updating the contacts with the following options :-
Option: 1 Check for any existing files

	search for any existing files
	If file is found use the option for appending more contacts to the list or creating a new file

Option: 2 Add new entries:

	create a new file
	Create an arraylist with the desired number of contacts to be input and add them to the arraylist
	receive the phone number in the proper format

Option:3 Appending more contacts to the list

	Import the entire data from the file as an arraylist
	add more contacts to the existing list

Option:4 Search for an existing entry ( Search by first name, Search by last name, Search by city or state)

	Import the entire data from the file as an arraylist
	Read from the existing file – import the data into obj.getFirstNmae, Lastname, phonenNumber…..order
	match the input word with the object.getName . If iis matched add the entire object to a new temporary arraylist and display all the elements after the iteration is over.

Option:5 Delete a record for a given telephone number

	Import the entire data from the file as an arraylist
	match the phone number with the existing entries by object.getPhone number 
	Display the entire object List and use the arraylist Remove option for deleting the record
	Replace / save the updated data to a new file

Option:6 Update a person's address for a given telephone number

	Import the entire data from the file as an arraylist
	match the phone number with the existing entries by object.getPhone number 
	get the index number of each address entry and replace the details by using object.setAdrdress
	Save the entire data to an arraylist 
	Replace/save the updated data to a new file

Option:7 Show all records in asc order of their First Name

	Import the entire data from the file as an arraylist
	use the Compare to option and Collections.sort methods 

Option:8  

	exit the program

