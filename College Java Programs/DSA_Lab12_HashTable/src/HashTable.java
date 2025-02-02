// ********************************************************
// Hash table implementation.
// Assumption: A table contains unique items(at most one 
//             item with a given search key at any time)
// *********************************************************
@SuppressWarnings("unchecked")
public class HashTable<K, V> implements HashTableInterface<K,V> {
  private ChainNode[] table;     // hash table
  private int size = 0;          // size of table, i.e. number of entries ((key,value) associations)

  public HashTable() {
    table = new ChainNode[3];
  }  // end default constructor

// table operations
  public boolean tableIsEmpty() {
    return size==0;
  }  // end tableIsEmpty

  public int tableLength() {
    return size;
  }  // end tableLength


//implement the following 4 methods

public boolean tableInsert(K key, V value) //inserts  association (key,value) only if key is not already in HashTable and returns true; returns false if the key already has an associated value in HashTable and does not insert
{
	boolean inserted = false;
	ChainNode node = new ChainNode(key, value, null);
	if(tableRetrieve(key) == null)
	{		
		int hashindex = hashIndex(key); //gets the hashed value
		if(table[hashindex] == null)
		{
			table[hashindex] = node;
			inserted = true;
		}
		else
		{
			ChainNode findopen = table[hashindex];
			while(findopen.getNext() != null)
			{
				System.out.println("code check 2");
				System.out.println("findopen");
				findopen = findopen.getNext();
			}
			findopen.setNext(node); //chains the nodes together
			inserted = true;
		}
	}
	return inserted;	
}

public boolean tableDelete(K searchKey) //deletes the key and its association from the HashTable if it is in the table and returns true; returns false if key is not in the HashTable
{	
	boolean deleted = false;
	if(tableRetrieve(searchKey) != null)
	{	//at this point we'll have already confirmed that this portion exists
		int index = hashIndex(searchKey);
		ChainNode node = table[index];
		if(node != null)
		{	
			if(node.getNext() == null)//we already know that it exists here, it has to
			{
				table[index] = null;
				deleted = true;
			}
				else
			{
				ChainNode parent;
				ChainNode child;
				while(node.getNext() != null)
				{
					parent = node;
					node = node.getNext();
					if(node.getKey().equals(searchKey))
					{
						parent.setNext(node.getNext());
						deleted = true;
					}
				}
			}
		}
	}
	return deleted;	
}

public V tableRetrieve(K searchKey) //returns the value associated with searchkey in HashTable or null if there is no association
{
	int index = hashIndex(searchKey);
	V value = null;
	ChainNode node = table[index];
	if(node != null)
	{
		boolean stop = false;
		while(node != null && stop == false)
		{
			if(node.getKey().equals(searchKey))
			{
					stop = true;
					value = (V) node.getValue(); 
			}
			node = node.getNext();			
		}
	}
		return value;
}

/**
 * 
 */
public int hashIndex(K key) 
{
	String hash = (String)key;
	int hashed = 0; 
	int temp, length = hash.length();
	int exponent;
	for(int i = 0; i < length; i++)
	{
		temp = ((int)hash.charAt(i) - 'A' + 1);
		exponent = 1;
		for(int j = 0; j < length-i-1; j++)
			exponent <<=5; //gets us the 32 bitshift power
		hashed += (temp * exponent);
	}
	return hashed%table.length;
}

public String toString()
{
	String str = "";
	for(int i = 0; i < table.length; i ++)
	{
		if(table[i] != null)
		{
			ChainNode node = table[i];
			while(node != null)
			{
				str = str + " Key: " + node.getKey() + " Value: " + node.getValue() + "\n";
				node = node.getNext();
			}
		}
	}
	return str;
}


}  // end HashTable
