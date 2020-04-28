import java.util.ArrayList;

public class SearchClass {

	public int Linear_Search(ArrayList<Integer> a, int number) //Method that does linear search in an arraylist of integets
	{
		int i;
		for(i=0;i<a.size();i++)
		{
			if(number==a.get(i))
				return i; //if you find the number, return it's position
		}	
		return -1; //if you dount find the number, return -1
		
	}

	public int Binary_Search(ArrayList<Integer> a, int x) //Method that does binary search in an arraylist of integers
	{
		int next;		
		int left=0;  
		int right=a.size()-1;
		//search in range ( left,right )
		while(right-left>=0) //if range is <0 it means the number is not in the arraylist
		{
			next=(left+right)/2;	
			if(x==a.get(next)) //If the number is the middle one, we're done
				return next;
			else if(x<a.get(next))//If the number is lower than the middle search in the left half	
				right = next-1;//next-1 -> we don't need to include the middle number again
			else //If the bigger is lower than the middle search in the left half	
				left = next +1 ; //next+1 -> we don't need to include the middle number again
		}
		
		return -1;
	}
		
	public int Interpolation_Search(ArrayList<Integer> a,int x) //Method that does interpolation search in an arraylist of integers
	{
		double next;
		int left=0;
		int right = a.size()-1;
		int nextint;
		while(left<=right && x>=a.get(left) && x<=a.get(right))
		{
			next = ( ( ((double)x - a.get(left) ) / ( a.get(right) - a.get(left) ) ) * ( right - left  ) ) + left  ;//τύπος αναζήτησης παρεμβολής
			nextint = (int)next;
			if(x==a.get(nextint)) // If you find the numberm return 
				return nextint;
			else if(x< a.get(nextint)) //if the number is bigger than nextint, search again in range (next+1 ,right)
				right = nextint-1;
			else
				left = nextint+1;	//if the number is lower than nextint, search again in range (left, next-1)
		}
		
		return -1;
	}
	
}
