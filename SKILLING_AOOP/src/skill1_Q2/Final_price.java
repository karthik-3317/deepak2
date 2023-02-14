package skill1_Q2;
public class Final_price implements Shopper
{
 public int visit(Pen pen)
 {
 int price = pen.getPrice();
 System.out.println(pen.getModel() + " costs " + price);
 return price;
 }
 public int visit(Notebook notebook) {
 int price = 0;
 if(notebook.getNumberOfPages() < 250) {
 price = notebook.getPrice()-5;
 } else {
 price = notebook.getPrice();
 }
 System.out.println("Notebook costs " + price);
 
 return price;
 }
}

