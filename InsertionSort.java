import java.util.*;
import java.util.Arrays;

public class InsertionSort{

  void insertionsort(int arr[]){
	System.out.println(arr[0]);
    int size = arr.length;
    for (int i = 1; i < size; i++){
      int key = arr[i];
      int j = i-1;

      while (j >= 0 && key < arr[j]){
        arr[j+1] = arr[j];
        j=j-1;
	  }
      arr[j+1] = key;
	  pa(arr,0,i);
    }
	System.out.println("Sorted Array: ");
    System.out.println(Arrays.toString(arr));
  }
  public void pa(int arr[],int s,int n){
	for(int i=s;i<=n;i++)
		  System.out.print(arr[i]+" ");
		System.out.println();
	}
	
  public static void main(String args[]) {
	InsertionSort is = new InsertionSort();
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter the length of the array: ");
    int n=sc.nextInt();
    int[] arr=new int[n];
	System.out.println("Enter the elements: ");
    for(int i=0;i<n;i++)
        arr[i]=sc.nextInt();
		
	long start = System.nanoTime();
    is.insertionsort(arr);
	long end = System.nanoTime();
	long elapsedTime = end - start; 
	System.out.println("CPU Time for insertion sort: "+elapsedTime+"nsec");
  }
}