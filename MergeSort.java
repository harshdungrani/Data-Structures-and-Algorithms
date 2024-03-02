import java.util.*;

class MergeSort{
    static void merge(int[] arr,int l,int mid,int h){
        int n1=mid-l+1;
        int n2=h-mid;

        int[] left=new int[n1];
        int[] right=new int[n2];
        for (int i=0;i<n1;i++)
            left[i] = arr[l+i];
        for (int j=0;j<n2;j++)
            right[j] = arr[mid + 1 + j];

        int i=0;
        int j=0;
        int k=l;
        while(i<n1 && j<n2){
            if (left[i] <= right[j]){
                arr[k] = left[i];
                i++;
            }
            else{
                arr[k] = right[j];
                j++;
            }
            k++;
        }
        while (i<n1){
            arr[k] = left[i];
            i++;
            k++;
        }

        while (j<n2){
            arr[k] = right[j];
            j++;
            k++;
        }
        System.out.println();
        pa(left);	
        pa(right);
        System.out.println();
        System.out.print("--- ");
		pa(arr);
        System.out.println();
    }

   static void sort(int[] arr, int l, int h){
        if (l < h){
            int m = (l + h) / 2;
            sort(arr, l, m);    
            sort(arr, m + 1, h);
            merge(arr, l, m, h);
        }
    }

   static void pri(int arr[],int l,int h){ 
        if(l<h){
           int m=(h+l)/2 ;
            System.out.println();
            for(int i=l;i<=h;i++){
                System.out.print(arr[i]+" ");
                if(i==m)
                    System.out.print("        ");
            }
            System.out.println();
        } 
        
    }

    static void pa(int arr[]){
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.print("         ");
    }

    static void printarr(int arr[]){
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void main(String args[]){
		System.out.println("Enter the length of the array: ");
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
		System.out.println("Enter the elements: ");
        for(int i=0;i<n;i++)
            arr[i]=sc.nextInt();
        printarr(arr);
        pri(arr,0,n-1);
        sort(arr,0,n-1);
        System.out.println("Sorted Array: ");
        printarr(arr);
    }
}