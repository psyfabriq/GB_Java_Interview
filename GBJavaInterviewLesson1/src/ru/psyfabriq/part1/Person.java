package ru.psyfabriq.part1;

import ru.psyfabriq.exeption.BuilderExeption;

public class Person {
	 String firstName,  lastName,  middleName,  country,  address,  phone,  gender;
	 int age;
	 
	
	private Person () {}
	
	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public String getCountry() {
		return country;
	}

	public String getAddress() {
		return address;
	}

	public String getPhone() {
		return phone;
	}

	public String getGender() {
		return gender;
	}

	public int getAge() {
		return age;
	}

	
    public static Builder getBuilder() {
        return new Person().new Builder();
    }
    
    public static Builder getBuilder(Person p) {
        return p.new Builder();
    }
    
    @Override
	public String toString() {
		return "Person [firstName=" + firstName + ", lastName=" + lastName + ", middleName=" + middleName + ", country="
				+ country + ", address=" + address + ", phone=" + phone + ", gender=" + gender + ", age=" + age + "]";
	}

	public class Builder {
    	
    	public Builder() {}
    	
    	public Builder setAge(int age) {
    		Person.this.age = age;
    		return this;
    	}
    	
    	public Builder setGender(String gender) {
    		Person.this.gender = gender;
    		return this;
    	}
    	
    	public Builder setAddress(String address) {
    		Person.this.address = address;
    		return this;
    	}
    	
    	public Builder setCountry(String country) {
    		Person.this.country = country;
    		return this;
    	}
    	
    	public Builder setMiddleName(String middleName) {
    		Person.this.middleName = middleName;
    		return this;
    	}
    	
    	public Builder setFirstName(String firstName) {
    		Person.this.firstName = firstName;
    		return this;
    	}
    	
    	public Builder setLastName(String lastName) {
    		Person.this.lastName = lastName;
    		return this;
    	}
    	
    	public Builder setPhone(String phone) {
    		Person.this.phone = phone;
    		return this;

    	}
    	
		public Person build() throws BuilderExeption {
			
			if ("".equals(Person.this.getFirstName())||Person.this.getFirstName() == null) {
				throw new BuilderExeption("Name Person coud`t  be empty!");
			}
			
			if ("".equals(Person.this.getLastName())||Person.this.getLastName() == null) {
				throw new BuilderExeption("Last name Person coud`t  be empty!");
			}
			
			if ("".equals(Person.this.getPhone())||Person.this.getPhone() == null) {
				throw new BuilderExeption("Phone Person coud`t  be empty!");
			}
			
			 return Person.this;
		}
    	
    }
	 
	 
}
