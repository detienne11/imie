package fr.imie.emanagerws.entity;

public class Contact {

	private long id;
	private String address;
	private String phone;
	
	public Contact (){
		
	}
	
	public Contact (final long id, final String address, final String phone){
		this.id = id;
		this.address = address;
		this.phone = phone;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		Contact other = (Contact) obj;
		return (this.id == other.id) && (this.address.equals(other.address)) && (this.phone.equals(other.phone));
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Contact : ");
		builder.append(id);
		builder.append(", ");
		builder.append(address);
		builder.append(", ");
		builder.append(phone);
		builder.append(" ");
		return builder.toString();
	}
}
