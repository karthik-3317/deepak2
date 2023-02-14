package Skil1_Q3;
public class Bubblesort {
void bubbleSort(int a[])
{
int n = a.length;
for (int i = 0; i < n - 1; i++)
for (int j = 0; j < n - i - 1; j++)
if (a[j] > a[j + 1]) {
int temp = a[j];
a[j] = a[j + 1];
a[j + 1] = temp;
}
}
void printArray(int arr[])
{
int n = arr.length;
for (int i = 0; i < n; ++i)
System.out.print(arr[i] + " ");
System.out.println();
}
public static void main(String args[])
{
Bubblesort ob = new Bubblesort();
int a[] = {34,12,67,10,7};
ob.bubbleSort(a);
System.out.println("Sorted array");
ob.printArray(a);
} 
}