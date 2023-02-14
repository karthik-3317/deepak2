package skill1_Q2;
public class Pen implements Cart
{
private int price;
 private String model;
 
 public Pen(int price, String model) {
 this.price = price;
 this.model = model;
 }
 
 public int getPrice() {
 return price;
 }
 
 public String getModel() {
 return model;
 }
public int accept(Shopper visitor)
{
 return visitor.visit(this);
}
}
