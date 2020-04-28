import java.io.*;
import java.util.*;

public class FileClass {

	
	private Scanner x;
	
	public void OpenFile(String filepath) //Method that opens a file
	{
		try
		{
			x = new Scanner(new File(filepath));
		}
		catch(Exception e)
		{
			System.out.println("Could not find file");
		}
	}
	
	public void SetIntegerListFromFile(ArrayList<Integer> intlist) //Method that passes all integers of the file to intlist  
	{
		while(x.hasNext())
		{
			try
			{
				intlist.add(x.nextInt());
				x.nextLine();
			}
			catch(Exception e){}
		}
	}

	public void setStringListFromFile(ArrayList<String> strlist)//Method that passes all the words of a file to strlist
	{
		while(x.hasNext())
		{
			try
			{
				strlist.add(x.next());
				x.nextLine();
			}
			catch(Exception e){}
		}
	}
	
	public void CloseFile(){ x.close(); } //Method that closes a file
}
