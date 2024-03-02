#include <stdio.h>
#include <stdlib.h>

int binary_search(int a[],int len,int item)
{
    int end=len-1;
    int beg=0;
    int mid;

    while(end>=beg){
        mid=(beg+end)/2;
        if(a[mid]==item)
            return mid;
        else if(a[mid]>item)
            end=mid-1;
        else
            beg=mid+1;
    }
    return -1;
}
int main()
{
    int len,tmp,item,i,j;
    printf("Enter the length of array: ");
    scanf("%d",&len);
    int a[len];
    printf("Enter the elements: ");
    for(i=0;i<len;i++)
        scanf("%d",&a[i]);
    for(i=0; i<len; i++){
        for(j=i+1; j<len; j++){
            if(a[j]<a[i]){
                tmp=a[i];
                a[i]=a[j];
                a[j]=tmp;
            }
        }
    }
    printf("Sorted array: ");
    for(i=0;i<len;i++)
        printf("%d ",a[i]);
    printf("\nEnter the element to be found: ");
    scanf("%d",&item);
    int res=binary_search(a,len,item);
    if(res==-1)
        printf("Element %d is not present in the array.",item);
    else
        printf("Element %d is present at index %d",item,res);
    return 0;
}
