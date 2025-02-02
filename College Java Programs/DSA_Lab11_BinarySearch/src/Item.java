
public class Item extends KeyedItem<String>
{
	public Item(String item)
	{
		super(item);
	}
	public String toString()
	{
		return getKey();
	}
}
