package skill1_Q2;
public class Notebook implements Cart
{
private int price;
 private int numberOfPages;
 
 public Notebook(int price, int numberOfPages) {
 this.price = price;
 this.numberOfPages = numberOfPages;
 }
 
 public int getPrice() {
 return price;
 }
 
 public int getNumberOfPages() {
 return numberOfPages;
 }
 public int accept(Shopper visitor) {
 return visitor.visit(this);
 }
}