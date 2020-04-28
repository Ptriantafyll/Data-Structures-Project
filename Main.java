import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
	
	public static void main(String Args[]) 
	{
	/*
	 * 
	 * MERGESORT
	 * 
	 * 
		FileClass f = new FileClass();
		IntegersMergeSort m = new IntegersMergeSort();
		SearchClass s = new SearchClass();
		ArrayList<Integer> Integer_List = new ArrayList<Integer>();
		
		
		f.OpenFile("integers.txt");
		f.SetIntegerListFromFile(Integer_List);
		f.CloseFile();
		
		m.MergeSort(Integer_List); 
		

		System.out.println(Integer_List);
	
	*
	*
	* MERGESORT	
	*	
	*/
		
	//	int result,x;
		
	/*
	 * 
	 * LINEAR SEARCH 
	 * 
	 * 
		x=51;
		result = s.Linear_Search(Integer_List, x);
		if(result==-1)
			System.out.println("Number " + x + " not in list");
		else
			System.out.println("Number " + x + " found in list at index " +result);
	*
	*
	*LINEAR SEARCH 
	*	
	*/
		
	/*
	 * 
	 * BINARY SEARCH
	 * 
	 * 
		x=47397;
		result =s.Binary_Search(Integer_List,x);
		if(result==-1)
			System.out.println("Number " + x + " not in list");
		else
			System.out.println("Number " + x + " found in list at index " +result);
		*/
		
	
		/*
		x=184873;
		result = s.Interpolation_Search(Integer_List, x, 0, Integer_List.size()-1);
		if(result==-1)
			System.out.println("Number " + x + " not in list");
		else
			System.out.println("Number " + x + " found in list at index " +result);
	*
	*
	*BINARY SEARCH
	*	
	*/
		
		
	/*	
	 * 
	 *  RED BLACK TREE
	 * 
	 * 
		RedBlackTree tree = new RedBlackTree();
				
		FileClass f = new FileClass();
		ArrayList<Integer> Integer_List = new ArrayList<Integer>();
			
		f.OpenFile("integers.txt");
		f.SetIntegerListFromFile(Integer_List);
		f.CloseFile();
		
		System.out.println(Integer_List);
					
		for(int i =0;i<Integer_List.size();i++)
		{
			tree.insert(Integer_List.get(i));
		}		
		
		tree.printTree(tree.getRoot());
		System.out.println("Root: " +tree.getRoot().getValue());
	*
	*
	*RED BLACK TREE
	*	
	*/
		

	 
	/*
	 * 
	 * 
	 * DIGITAL TREE
	 * 
	 * 
	 
		DigitalTree trie = new DigitalTree();
		
		FileClass f=new FileClass();
		ArrayList<String> String_List = new ArrayList<String>();
		
		f.OpenFile("Words.txt");
		f.setStringListFromFile(String_List);
		f.CloseFile();
			
		System.out.println(String_List);
		
		for(int i=0; i<String_List.size(); i++)
		{
			trie.insert(String_List.get(i));
		}
		
		boolean search;
		String word;
		
		search = trie.search("Yavin");
		word = "Yavin";
		
		if(search)
		{
			System.out.println("Word : " + word +" is present in trie" );
		}
		else
		{
			System.out.println("Word : " + word +" is not present in trie" );
		}
		
		trie.delete("Jedi");
		
		search = trie.search("Jedi");
		word = "Jedi";
		
		if(search)
		{
			System.out.println("Word : " + word +" is present in trie" );
		}
		else
		{
			System.out.println("Word : " + word +" is not present in trie" );
		}
	
	
	*
	*
	*
	*TRIE
	*
	*
	*/	
		
	
		
		FileClass f = new FileClass();
		IntegersMergeSort m = new IntegersMergeSort();
		SearchClass s = new SearchClass();
		ArrayList<Integer> Integer_List = new ArrayList<Integer>();
		RedBlackTree tree=new RedBlackTree();
		
		

		f.OpenFile("integers.txt");
		f.SetIntegerListFromFile(Integer_List);
		f.CloseFile();
		
		for(int i =0;i<Integer_List.size();i++)
		{
			tree.insert(Integer_List.get(i));
		}		
		System.out.println("Root: " +tree.getRoot().getValue());
		
		m.MergeSort(Integer_List); 
		
		Scanner scan=new Scanner(System.in); 
		Random rand=new Random();
		
		System.out.println("How many searches would you like to do?");
		int searches=scan.nextInt();
		scan.nextLine();
		
		int x;
		long finaltime;
		
		
		long starttime=System.nanoTime();
		
		for(int i=0;i<searches;i++)
		{
			x=rand.nextInt(499990) +10;	
			s.Linear_Search(Integer_List, x );
		}
		finaltime = System.nanoTime();
		
		System.out.println("total time for linear search : " + (finaltime - starttime) );

	
		starttime = System.nanoTime();
		for(int i=0;i<searches;i++)
		{
			x=rand.nextInt(499990) +10;
			s.Binary_Search(Integer_List, x );
		}
		finaltime = System.nanoTime();
				
		System.out.println("total time for binary search : " + (finaltime - starttime) );

		
		starttime = System.nanoTime();
		for(int i=0;i<searches;i++)
		{
			x=rand.nextInt(499990) +10;			
			s.Interpolation_Search(Integer_List, x);
		}
	
		finaltime = System.nanoTime();
		System.out.println("total time for interpolation search : " + (finaltime - starttime) );
	
		starttime = System.nanoTime();
		for(int i=0;i<searches;i++)
		{
			x=rand.nextInt(499990) +10;
			tree.Access(x);
		}
	
		finaltime = System.nanoTime();
		System.out.println("total time for Red-Black Tree search : " + (finaltime - starttime) );

		
		scan.close();
		
		

		

		
	}
}
