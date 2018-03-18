//Convert me! (base64)
//aHR0cHM6Ly93d3cueW91dHViZS5jb20vd2F0Y2g/dj1tTWZ4STNyX0x5QQ==
import java.io.*;
import java.util.Scanner;
import java.util.*;
/**
 * Takes a maze created in notepad on a .txt file and attempts to solve it using logic, stacks,and some coffee.
 * 
 * @author Nitin Armstrong (The one and Only) 
 * @version 4.20
 */
public class MazeSolver
{  
    //define variables used in program
    static Node newx = new Node(0);
    static Node newy = new Node(0);

    static int i;
    static int x;
    static int counter;
    static int xAxis;
    static String store;
    static String [] mazePositions; //decided to not follow tom and just use a string Array

    public static void main (String [] args) {
        try{            
            Scanner scan;
            scan = new Scanner(new BufferedReader(new FileReader("maze.txt")));

            //variables for xAxis and counter
            counter = 0;
            xAxis = 0;

            //as it reads from file, xAxis number will keep increasing
            while (scan.hasNextLine()){
                xAxis++;
                scan.next();
            }   

            //stores the xAxis number in array
            String [] mazePositions = new String [xAxis];
            scan.close();
            scan = new Scanner(new BufferedReader(new FileReader("maze.txt")));

            //sets up counter
            while (scan.hasNext()){
                mazePositions [counter] = scan.nextLine();
                counter++;
            } 

            for (i = 0; i < counter; i++){
                store = mazePositions [i];

                for (int x = 0; x < store.length(); x++){
                    //looks for starting position
                    if (store.substring(x,x+1).equals("@")){
                        System.out.println("The yAxis is " + x + ", the xAxis is " + i);

                        //pops starting position
                        newx.pop();
                        newy.pop();
                        pushMeHarderJava(x,i);
                    }
                }
            }
        }
        catch (Exception e) {
            System.out.println("Exception" + e.getMessage());
            e.printStackTrace();
        }
    }

    //method used to push current position
    public static void pushMeHarderJava(int a, int b) {
        newx.push(new Node(a));                        
        newy.push(new Node(b));

        System.out.println(a + ", " + b);

        up(a,b);
        down(a,b);
        left(a,b);
        right(a,b);
        done(a,b);
    }

    //method used to check for up possibility
    public static void up(int newx1, int newy1) {

        if (newy1 != 0){
            store = mazePositions[newy1-1];          
            if (store.substring(newx1,newx1+1).equals(".")){
                pushMeHarderJava(newx1,newy1+1);
            } else {
                newx.pop();
                newy.pop();
                down(newx1,newy1);
            }
        } else  {
            System.out.println("F"); 
        }
    }
    //method used to check for down possibility
    public static void down(int newx2, int newy2) {
        if (newy2 < xAxis){
            store = mazePositions[newy2+1];
            if(store.substring(newx2,newx2+1).equals(".")){
                pushMeHarderJava(newx2,newy2+1);
            }  else {
                newx.pop();
                newy.pop();
                left(newx2,newy2);
            }
        }
    }

    //method used to check for left possibility
    public static void left(int newx3, int newy3) {
        if (store.substring(newx3-1,newx3).equals(".")){
            pushMeHarderJava(newx3-1,newy3);
        }   else {
            newx.pop();
            newy.pop();
            right(newx3,newy3);
        }
    }

    //method used to check for right possibility
    public static void right(int newx4, int newy4) {
        if (store.substring(newx4+1,newx4).equals(".")){
            pushMeHarderJava(newx4+1,newy4);
        } else {
            newx.pop();
            newy.pop();
            bossWeStuck(newx4,newy4);
        }
    }

    /**
     * This method is called, when a dead end is occuring 
     */
    public static void bossWeStuck(int checkX, int checkY) {
        boolean dejaVu = false;
    }
    //implement been there  

    /**
     * So we come here if we have a valid solution or not after checking all of the 4 directions if there is a valid move
     * If we do, we call it a day and print it out
     * Else, 
     */
    public static void done (int a, int b) {
        if (store.substring(a,a+1).equals("$")){
            while(newx.getNext() != null){
                while (newy.getNext() != null){
                    int store2 = newx.getValue();
                    int store3 = newy.getValue();
                    System.out.println(store2 + "," + store3);
                    newx = newx.getNext();
                    newy = newy.getNext();
                }
            }
        } else{
            System.out.println("This maze isnt solvable; Kramer WTF");
        }
    }
}
