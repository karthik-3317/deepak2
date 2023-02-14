package skill1_Q2;
import java.util.*;
public class Department_Store
{
 public static void main(String[] args) {
 Scanner sc=new Scanner(System.in);
 System.out.println("Enter Price of Parker pen:");
 int n=sc.nextInt();
 System.out.println("Enter Price of Pilot pen:");
 int m=sc.nextInt();
 System.out.println("Enter Price of Notebook with no of pages:");
 int x=sc.nextInt();
 int y=sc.nextInt();
 Cart[] finalcart=new Cart[]{new Pen(n,"Parker"),new
Pen(m,"Pilot"),new Notebook(x,y)};
 int total = getTotalPrice(finalcart);
 System.out.println("Total price of items: " + total);
 } 
 private static int getTotalPrice(Cart[] finalcart) {
 Shopper visitor = new Final_price();
 int result = 0;
 for(Cart cart : finalcart) {
 result = result + cart.accept(visitor);
 }
 return result;
 }
} 
