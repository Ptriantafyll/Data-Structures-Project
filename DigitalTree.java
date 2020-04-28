
public class DigitalTree {

	
	private class TrieNode
	{
		TrieNode[] children;//children of each node (array of nodes that have one character)
		boolean isword; //boolean variable that checks if we are at an end of a word  
		
		TrieNode() 
		{
			isword = false;
			this.children = new TrieNode[26];
		}
	}
	
	private TrieNode root; 
	
	public DigitalTree(){ this.root = new TrieNode(); }
	
	public void insert(String word)
	{
		int index;
		TrieNode n=this.root;
		
		for(int i=0;i<word.length();i++)
		{
			char c = word.charAt(i); // = each character of the word
			if(Character.isUpperCase(c)) //if it is a capital letter
			{
				index = c-'A' ;     // 'A' to 'Z' in ASCII are 65-90, so doing c -'a' makes the
									// range for index is 0-25 so that it can get in the array
									// values of index : if c = 'Á'-'Æ', index = 0 - 25
								    // meaning index shows in which position of the 
								    // alphabet the current letter is 
			}
			else						//if it is not a capital letter
			{
				index = c-'a'; 	   // 'a' to 'z' in ASCII are 97-122, so doeing c -'a' makes the
								   // range for index is 0-25 so that it can get in the array
								   // values of index : if c = 'a'-'z', index = 0 - 25
								   // meaning index shows in which position of the 
								   // alphabet the current letter is 
			}
			
			if(n.children[index]==null) //if the letter does not exist in the ndode's array, make a new node and put it there 
			{
				TrieNode temp = new TrieNode();
				n.children[index] = temp;
				n=temp;
			}
			else //if it exists go to the node with this letter 
			{
				n=n.children[index];
			}//keep going until the end of the word
			
		}
		n.isword=true; //isword = true for the last node of the word
	}

	
	public boolean search(String word)
	{
		TrieNode n = root;
		int index;
		for(int i=0; i<word.length();i++)
		{
			char c = word.charAt(i); // = each character of the word
			
			if(Character.isUpperCase(c))//if it is a capital letter
			{
				index = c-'A' ;     
			}
			else						//if it is a not capital letter
			{
				index = c-'a'; 	 
			}
			
			if(n.children[index]!=null)//if the letter exists in the array of the node go there and keep going
			{
				n=n.children[index];
			} 
			else //if it doues not exist, the word does not exist -> stop 
			{
				return false;
			}
		}
		
		return n.isword; 
	}
	
	public void delete(String word)
	{
	
		int index;
		TrieNode n = root;
		
		for(int i=0 ; i<word.length() ; i++)
		{
			char c = word.charAt(i); // = each character of the word
			if(Character.isUpperCase(c)) //if it is a capital letter
				index = c-'A' ;
			}
			else						//if it is not a capital letter
			{
				index = c-'a';
			}
			
			if(n.children[index]!=null) //if the next letter exists go there 
			{
				n=n.children[index];
			}
			else // else the word does not exists - > stop
			{
				System.out.println("Word : " +word +" not in Trie");
				return;
			}					
		}
		
				
		boolean isleaf=true;
		for(int i=0; i<26 ; i++)
		{
			
			if(n.children[i]!=null)//if even one child is not null this node is not a leaf 
			{
				isleaf=false;
				break;
			}			
		}
		
		if(isleaf) //if it is a leaf jsut remove the node
		{
			n=null;
		}
		else //if it is not a leaf, just don't count it as a word 
		{
			n.isword = false;
		}
	}
}
