package org.sei.main.Java;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;


/**
 * @author Vipin
 *
 */
public class DeDup {

	public static int[] randomArray={1,2,34,34,25,1,45,3,26,85,4,34,86,25,43,2,1};
	public static void main(String[] args) {

		int [] resultArray1=removeUsingLinkedHashSet(randomArray);
		int [] resultArray2=sortAndRemove(randomArray);
		int [] resultArray3=removeUsingHashSet(randomArray);
		
		
		System.out.println("After Linked Hashset Method");
		printArray(resultArray1);
		System.out.println("After sort method");
		printArray(resultArray2);
		System.out.println("After Hashset Method");
		printArray(resultArray3);
		
		
		
	}

	/*This will sort the array and remove the duplicates
	 * 
	 * This has the drawback that we cant determine the size of return array dynamically.
	 * */
	private static int [] sortAndRemove(int[] randomArray) {

		int [] returnArray=new int[17];
		Arrays.sort(randomArray);

		int temp = 0;
		int j=0;
		for (int i = 0; i < randomArray.length; i++) {
			if (temp == randomArray[i])
			{
				continue;
			}
			returnArray[j]=randomArray[i];
			j++;
			temp = randomArray[i];
		}
		
		return returnArray;
	}
	
	/*This will create a set from the array and remove the duplicates
	 * Drawback of sorting is corrected here by dynamically setting the size of returned array
	 * */
	private static int [] removeUsingHashSet(int [] randomArray){
		
		
        Set<Integer> integerSet=new HashSet<Integer>();
		
		for(int i=0; i<randomArray.length; i++)
		{
			integerSet.add(randomArray[i]);
		}
		
		Iterator<Integer> it=integerSet.iterator();
		
		int [] returnArray=new int[integerSet.size()];
		int j=0;
		while(it.hasNext())
		{
			returnArray[j]=it.next();
			j++;
		}
		
		return returnArray;
	}
	
	/*This will create a set from the array and remove the duplicates
	 * 
	 * In addition, this preserves the original order
	 * 
	 * */
	private static int [] removeUsingLinkedHashSet(int [] randomArray){
		
       Set<Integer> integerSet=new LinkedHashSet<Integer>(randomArray.length);
		
		for(int i: randomArray)
		{
			integerSet.add(i);
		}
		
		int [] returnArray=new int[integerSet.size()];
		int j=0;
		for(Integer integer: integerSet)
		{
			returnArray[j++]=integer;
			
		}
		
		return returnArray;
	}
	
	/*This method prints an array*/
	private static void printArray(int [] randomArray){
		
		for (int i=0; i<randomArray.length; i++)
		{
			System.out.println(randomArray[i]);
		}
	}

}
