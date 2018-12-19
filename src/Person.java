
	public class Person implements Comparable<Person> {

		private String firstName;
		private String lastName;
		private String phoneNumber;
		// Declaring a new subclass <Address>= the name of the subclass, <address>
		// variable
		private Address address = new Address();

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public String getPhoneNumber() {
			return phoneNumber;
		}

		public void setPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
		}

		public Address getAddress() {
			return address;
		}

		public void setAddress(Address address) {
			this.address = address;
		}

		public String toString() {
			return this.firstName + "/" + this.lastName + "/" + this.phoneNumber + "/" + this.address;

		}

		@Override
		public int compareTo(Person o) {
			return this.firstName.trim().compareTo(o.firstName.trim());
		}
}
