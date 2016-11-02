/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javapiramida;
import java.util.Scanner;
/**
 *
 * @author Anna
 */
public class JavaPiramida {

  /**
   * @param args the command line arguments
   */
public double W (int row, int pos) {
        double piramida[][] = new double[row+1][row+1];
            int i, j;
            piramida[0][0] = 1.0;
            piramida[1][0] = piramida[1][1]=0.5;
            for (i=2; i<row+1; i++) {
                piramida [i][0] = piramida[i][i] = (piramida [0][0]+ piramida [i-1][0])/2;//заполняем значениями первые и последние элементы ряда
                //System.out.println(i+" "+ "0" + " "+piramida[i][0]);
                for (j=1; j<i; j++){
                    piramida [i][j] = (piramida[0][0] + piramida[i-1][j-1])/2 + (piramida[0][0]+piramida[i-1][j])/2; // заполняем середину
                    // System.out.println(i+" "+ j + " "+piramida[i][j]);
                }
            }
        return piramida[row-1][pos-1];
}
    public static void main(String[] args) {
      try {
      System.out.println("\nLets calculate block in pyramid\n");
      System.out.println("How many rows in your pyramid?(max 1000):");
      Scanner sc = new Scanner(System.in);
      int InRow = sc.nextInt();
      System.out.println("Whitch block calculate?(max 1000):");
      int InCol = sc.nextInt();
      
      

//      int InRow = 1000;
//      int InCol = 500;
      if ((InCol > InRow)||InRow<=0||InCol<=0||InRow>1000||InCol>1000)
        System.out.printf("%d:%d - Error in input values\n",InRow,InCol);
      else {
        
          JavaPiramida app = new JavaPiramida();
          System.out.printf("Result: %f kg\n", app.W(InRow,InCol));
        }
        
        }
      catch(Throwable e){
          System.out.println("Something gonna wrong.");
      }
    }
}
