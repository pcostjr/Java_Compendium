
public class Package
{
	private String name;
	private double weight;
	private double quantity;
	private String sender;
	private String recipient;
	
	public Package(String name, double weight, double quantity, String sender, String recipient)
	{
		this.setName(name);
		this.setWeight(weight);
		this.setQuantity(quantity);
		this.setSender(sender);
		this.setRecipient(recipient);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getRecipient() {
		return recipient;
	}

	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}
	
	public String toString()
	{
		return "(" + name +"," + weight + "," + quantity + "," + sender + "," + recipient +")";
	}

}
