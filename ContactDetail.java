import java.io.Serializable;

public class ContactDetail implements Serializable {
	
	
	String name;
	String email;
	String address;
	long phone;
	long userId;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
		public ContactDetail() {
		
	}
	public ContactDetail(long userId,String name,String email,long phone,String address) {
		this.userId = userId;
		this.name=name;
		this.email = email;
		this.phone = phone;
		this.address = address;
		
		
	}
	public String toString()
	{
		return "UserId:"+userId+"\t"+"Name:"+name+"\t"+"Email:"+email+"\t"+"Address:"+address+"\t"+"Phone number:"+phone+"\n";
	}
	
	
}
