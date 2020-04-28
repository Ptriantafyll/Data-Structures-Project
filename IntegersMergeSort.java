
import java.io.*;
import java.util.*;

public class IntegersMergeSort {
	
	public void merge(ArrayList<Integer> leftlist, ArrayList<Integer> rightlist, ArrayList<Integer>finallist)//Method that merges and sorts 2 arraylists and then stores them in a third one
	{
		int left=0;
		int right=0;
		
		finallist.clear(); //clear final list so that we can insert integers from scratch
		while(left < leftlist.size() && right < rightlist.size()) //while there are still numbers - > merge
		{
			if(leftlist.get(left) < rightlist.get(right)) //if both arraylists have elements, append the smaller one to the final
			{
				finallist.add(leftlist.get(left));
				left ++;
			}
			else
			{
				finallist.add(rightlist.get(right));
				right ++;
			}
		}		
				
		if(left >=leftlist.size())  //If there are no more elements in the left arraylist append the elements of the right one to the final
		{
			for(int j=right;j<rightlist.size();j++)
			{
				finallist.add(rightlist.get(j));
			}
		}
		else if(right >=rightlist.size()) //If there are no more elements in the right arraylist append the elements of the left one to the final
		{
			for(int j=left;j<leftlist.size();j++)
			{
				finallist.add(leftlist.get(j));
			}
		}
		
	}
	
	public ArrayList<Integer> MergeSort (ArrayList<Integer> finallist) //Method that does mergesort in an Arraylist
	{
		ArrayList<Integer> leftlist = new ArrayList<Integer>();
		ArrayList<Integer> rightlist = new ArrayList<Integer>();
		int middle;
		
		if(finallist.size()==1) //when you reach 1 element, stop splitting
		{
			return finallist;
		}
		else
		{
			middle=finallist.size()/2;
			for(int i=0;i<middle;i++)
			{
				leftlist.add(finallist.get(i)); //put left part of the whole list in leftlist 
			}
			for(int i=middle;i<finallist.size();i++)
			{
				rightlist.add(finallist.get(i)); //put the right part of the whole list in rightlist
			}
			
			leftlist = MergeSort(leftlist); 	//sort right part
			rightlist = MergeSort(rightlist);	//sort left part
			
			merge(leftlist,rightlist,finallist); //merge sorted parts
				
		}
		
		return finallist;
	}
	
}
