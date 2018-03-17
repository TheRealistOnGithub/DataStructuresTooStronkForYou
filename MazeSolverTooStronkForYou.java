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
public class MazeSolverTooStronkForYou
{
    public Stack<movementTings> newMaze  = new Stack<>(); //movement controls for solving the og maze and then is reffered as new maze for mod. purposes
    public ArrayList<String> mazeList = new ArrayList<>(); //im special and only real hype beasts use char, scan the whole maze into an array list
    public ArrayList<movementTings> ogMaze = new ArrayList(); // used for scanning and size tings
    public int down; //relative integers used for maze state manipulation
    public int left;
    /**
     * Starts the whole jaun by using the constructor 
     */
    public static void main (String [] args) {
        new MazeSolverTooStronkForYou();
    }

    /**
     * Array lists arent static and the whole advantage of them is that they are fluid like my homie.
     * Creating a method that isnt static makes this possible and allows arraylists (way that i learned from tom is to make the process continous instead of static like an array)
     */
    public void MazeSolverTooStronkForYou() {
        for(int a = 0; a < mazeList.size(); a++){ //sets upper limit of the maze size
            for(int b = 0; b < mazeList.get(a).length(); b++){ //loop condition that b must keep going until it is equal to a
                if(mazeList.get(a).substring(b, b+1).equals("@")){
                    newMaze.push(new movementTings(a,b)); //finds the start and does the pushy tings
                }
            }
        }
        if(newMaze.peek() == null){
            System.out.println("Kramer, why tf does the maze not have a start");
        }    
        else{
            try{
                while(!(mazeList.get(newMaze.peek().getYLocation()).substring(newMaze.peek().getXLocation(), newMaze.peek().getXLocation() + 1).equals("$"))){
                    pathSolver();
                }
            }
            catch(NullPointerException iCanDoCustomExceptionNames){
                System.out.println("Kramer, why tf is the maze unsolvable" + "\n" +iCanDoCustomExceptionNames);
            }  
        }

        Stack<MazeLocation> temp = new Stack<>(); //the idea here is to have a temp stack to allow me to use pop and print to print the array (cont)
        //prints in reverse order (rememeber FILO?)
        while(maze.peek() != null){
            temp.push(newMaze.pop()); 
        }
        int x = 0;
        while(temp.peek() != null){
            System.out.println("Step ", x, temp.peek().getyLocation(), temp.peek().getxLocation());
            temp.pop();
            x++; //step counter variable
        }  
        //         try{
        //             Scanner scan = new Scanner( new BufferedReader( new FileReader("maze.txt")));
        //             while(scan.hasNext()){
        //                 mazeList.add(scan.next());
        //             }
        //             scan.close();
        //         }
        //         catch(Exception e){
        //             System.out.println(e);
        //         }    
    }    

    //     /**
    //      * an easier way to print out my cheeky message that something is wrong
    //      */
    //     public static void shitDontWork(){
    //         System.out.println("Kramer, why tf does something here doesnt work");
    // 
    //     }

    /**
     * The actual logic behind the maze (backtracking, and a hell of a lot of if statements)
     * the "return;" means that it spits out the location of the correct solution
     */
    public static void pathSolver () {
        if(down == 0 && left == 0){
            if((mazeList.get(down + 1).substring(left, left + 1).equals(".")) || mazeList.get(down + 1).substring(left, left + 1).equals("$")){
                if(move(down + 1, left)){
                    return;}
            } 
            if((mazeList.get(down).substring(left + 1, left + 2).equals(".")) || mazeList.get(down).substring(left + 1, left + 2).equals("$")){
                if(move(down, left + 1)){
                    return;}
            } 
        }
        //Top Right Corner
        else if(down == 0 && left == mazeList.get(down).length() - 1){
            if((mazeList.get(down + 1).substring(left, left + 1).equals(".")) || mazeList.get(down + 1).substring(left, left + 1).equals("$")){
                if(move(down + 1, left)){
                    return;}
            } 
            if((mazeList.get(down).substring(left - 1, left).equals(".")) || mazeList.get(down).substring(left - 1, left).equals("$")){
                if(move(down, left - 1)){
                    return;}
            } 
        }
        //Bottom Left Corner
        else if(down == mazeList.size() - 1 && left == 0){
            if((mazeList.get(down - 1).substring(left, left + 1).equals(".")) || mazeList.get(down - 1).substring(left, left + 1).equals("$")){
                if(move(down - 1, left)){
                    return;}
            } 
            if((mazeList.get(down).substring(left + 1, left + 2).equals(".")) || mazeList.get(down).substring(left + 1, left + 2).equals("$")){
                if(move(down, left + 1)){
                    return;}
            } 
        }
        //Bottom Right conrner
        else if(down == mazeList.size() - 1 && left == mazeList.get(down).length() - 1){
            if((mazeList.get(down - 1).substring(left, left + 1).equals(".")) || mazeList.get(down - 1).substring(left, left + 1).equals("$")){
                if(move(down - 1, left)){
                    return;}
            } 
            if((mazeList.get(down).substring(left - 1, left).equals(".")) || mazeList.get(down).substring(left - 1, left).equals("$")){
                if(move(down, left - 1)){
                    return;}
            } 
        }    
        //top row
        else if(down == 0  && left > 0){
            if((mazeList.get(down + 1).substring(left, left + 1).equals(".")) || mazeList.get(down + 1).substring(left, left + 1).equals("$")){
                if(move(down + 1, left)){
                    return;}
            }
            if((mazeList.get(down).substring(left - 1, left).equals(".")) || mazeList.get(down).substring(left - 1, left).equals("$")){                    
                if(move(down, left - 1)){
                    return;}
            } 
            if((mazeList.get(down).substring(left + 1, left + 2).equals(".")) || mazeList.get(down).substring(left + 1, left + 2).equals("$")){
                if(move(down, left + 1)){
                    return;}
            }
        }
        //Bottom row
        else if( down == mazeList.size() - 1 && left > 0){
            if((mazeList.get(down - 1).substring(left, left + 1).equals(".")) || mazeList.get(down - 1).substring(left, left + 1).equals("$")){
                if(move(down - 1, left)){
                    return;}
            }
            if((mazeList.get(down).substring(left - 1, left).equals(".")) || mazeList.get(down).substring(left - 1, left).equals("$")){
                if(move(down, left - 1)){
                    return;}
            } 
            if((mazeList.get(down).substring(left + 1, left + 2).equals(".")) || mazeList.get(down).substring(left + 1, left + 2).equals("$")){
                if(move(down, left + 1)){
                    return;}
            }
        }
        //Left row
        else if( left == 0 && down > 0){
            if((mazeList.get(down - 1).substring(left, left + 1).equals(".")) || mazeList.get(down - 1).substring(left, left + 1).equals("$")){
                if(move(down - 1, left)){
                    return;}
            } 
            if((mazeList.get(down + 1).substring(left, left + 1).equals(".")) || mazeList.get(down + 1).substring(left, left + 1).equals("$")){
                if(move(down + 1, left)){
                    return;}
            }
            if((mazeList.get(down).substring(left + 1, left + 2).equals(".")) || mazeList.get(down).substring(left + 1, left + 2).equals("$")){
                if(move(down, left + 1)){
                    return;}
            }
        }
        //Right Row
        else if( left == mazeList.get(down).length() - 1 && down > 0){
            if((mazeList.get(down - 1).substring(left, left + 1).equals(".")) || mazeList.get(down - 1).substring(left, left + 1).equals("$")){
                if(move(down - 1, left)){
                    return;}
            } 
            if((mazeList.get(down + 1).substring(left, left + 1).equals(".")) || mazeList.get(down + 1).substring(left, left + 1).equals("$")){
                if(move(down + 1, left)){
                    return;}
            }
            if((mazeList.get(down).substring(left - 1, left).equals(".")) || mazeList.get(down).substring(left - 2, left - 1).equals("$")){
                if(move(down, left - 1)){
                    return;}
            } 
        }
        //Everything in the middle
        else{
            if((mazeList.get(down - 1).substring(left, left + 1).equals(".")) || mazeList.get(down - 1).substring(left, left + 1).equals("$")){
                if(move(down - 1, left)){
                    return;}
            } 
            if((mazeList.get(down + 1).substring(left, left + 1).equals(".")) || mazeList.get(down + 1).substring(left, left + 1).equals("$")){
                if(move(down + 1, left)){
                    return;}
            }
            if((mazeList.get(down).substring(left - 1, left).equals(".")) || mazeList.get(down).substring(left - 1, left).equals("$")){
                if(move(down, left - 1)){
                    return;}
            } 
            if((mazeList.get(down).substring(left + 1, left + 2).equals(".")) || mazeList.get(down).substring(left + 1, left + 2).equals("$")){
                if(move(down, left + 1)){
                    return;}
            }
        }    
    }
    /**
     * So the whole point of this method 
     */
    /**
     * Scans the doc into an arraylist line by line (was about to do hasNext, but tom told me substring wont work)
     */
    public static void mazeArrayListScanner () {
        try{
            Scanner scan = new Scanner( new BufferedReader( new FileReader("maze.txt")));
            while(scan.hasNextline()){
                mazeList.add(scan.nextline());
            }
            scan.close();
        }
        catch(Exception e){
            System.out.println(e);
        }    
    }
    /**
     * This handy dandy inner class is the brains of the array list manipulatior 
     */
    private class movementTings{ //private because i dont want it to be = to penis (thanks Kramer)
        private int xLocation; //x axis of the location
        private int yLocation; // y axis of the location
        private movementTings(int yLocation, int xLocation){
            yLocation = yLocation; 
            xLocation = xLocation;
        }

        public int getYLocation(){
            return yLocation;
        }

        public int getXLocation(){
            return xLocation;
        }
    }

    private class tomDoesThingsHere{

        /**
         * @author Tomasz Mroz
         * Solves a maze inputted from a text file
         * Prints the path taken excluding any backtracks
         */
        public class MazeSolver{
            private Stack<MazeLocation> maze  = new Stack<>();
            private ArrayList<String> mazeList = new ArrayList<>();
            private ArrayList<MazeLocation> oldMaze = new ArrayList();
            private int down;
            private int left;
            /**
             * Needed a nonstatic way to create the ArrayList
             * Searches for the starting location and starts the game
             * When finished finding the end the game prints the solution set in reverse order
             */
            public MazeSolver(){
                listCreator("maze.txt");
                for(int a = 0; a < mazeList.size(); a++){
                    for(int b = 0; b < mazeList.get(a).length(); b++){
                        if(mazeList.get(a).substring(b, b+1).equals("@")){
                            maze.push(new MazeLocation(a,b));
                        }
                    }
                }
                if(maze.peek() == null){
                    System.out.println("Maze has no starting point");
                }    
                else{
                    try{
                        while(!(mazeList.get(maze.peek().getDownLocation()).substring(maze.peek().getLeftLocation(), maze.peek().getLeftLocation() + 1).equals("$"))){
                            solver();
                        }
                    }
                    catch(NullPointerException e){
                        System.out.println("Maze is impossible");
                    }  
                }

                Stack<MazeLocation> temp = new Stack<>();
                //prints in reverse order
                while(maze.peek() != null){
                    temp.push(maze.pop());
                }
                int x = 0;
                while(temp.peek() != null){
                    System.out.printf("Step #%d: %d, %d \n", x, temp.peek().getDownLocation(), temp.peek().getLeftLocation());
                    temp.pop();
                    x++;
                }  
            }    

            /**
             * Creates the object that runs the program
             */
            public static void main(String[] args){
                new MazeSolver();
            }    

            /**
             * Creates a Scanner object which reads in the maze line by line
             * Stores it in a arraylist
             * @param filename Name of the file that contains the maze
             */
            private void listCreator(String filename){
                try{
                    Scanner scan = new Scanner( new BufferedReader( new FileReader(filename)));
                    while(scan.hasNextLine()){
                        mazeList.add(scan.nextLine());
                    }
                    scan.close();
                }
                catch(Exception e){
                    e.printStackTrace();
                }    
            }    

            /**
             * Tests if a spot up down left or right is either a possible free spot or the end
             * If it has not moved there yet, it pushes the location on the stack
             * returns if finds a potential move
             * if not it pops the stack
             */
            private void solver(){
                down = maze.peek().getDownLocation();
                left = maze.peek().getLeftLocation();
                //Top left corner
                if(down == 0 && left == 0){
                    if((mazeList.get(down + 1).substring(left, left + 1).equals(".")) || mazeList.get(down + 1).substring(left, left + 1).equals("$")){
                        if(move(down + 1, left)){return;}
                    } 
                    if((mazeList.get(down).substring(left + 1, left + 2).equals(".")) || mazeList.get(down).substring(left + 1, left + 2).equals("$")){
                        if(move(down, left + 1)){return;}
                    } 
                }
                //Top Right Corner
                else if(down == 0 && left == mazeList.get(down).length() - 1){
                    if((mazeList.get(down + 1).substring(left, left + 1).equals(".")) || mazeList.get(down + 1).substring(left, left + 1).equals("$")){
                        if(move(down + 1, left)){return;}
                    } 
                    if((mazeList.get(down).substring(left - 1, left).equals(".")) || mazeList.get(down).substring(left - 1, left).equals("$")){
                        if(move(down, left - 1)){return;}
                    } 
                }
                //Bottom Left Corner
                else if(down == mazeList.size() - 1 && left == 0){
                    if((mazeList.get(down - 1).substring(left, left + 1).equals(".")) || mazeList.get(down - 1).substring(left, left + 1).equals("$")){
                        if(move(down - 1, left)){return;}
                    } 
                    if((mazeList.get(down).substring(left + 1, left + 2).equals(".")) || mazeList.get(down).substring(left + 1, left + 2).equals("$")){
                        if(move(down, left + 1)){return;}
                    } 
                }
                //Bottom right conrner
                else if(down == mazeList.size() - 1 && left == mazeList.get(down).length() - 1){
                    if((mazeList.get(down - 1).substring(left, left + 1).equals(".")) || mazeList.get(down - 1).substring(left, left + 1).equals("$")){
                        if(move(down - 1, left)){return;}
                    } 
                    if((mazeList.get(down).substring(left - 1, left).equals(".")) || mazeList.get(down).substring(left - 1, left).equals("$")){
                        if(move(down, left - 1)){return;}
                    } 
                }    
                //top row
                else if(down == 0  && left > 0){
                    if((mazeList.get(down + 1).substring(left, left + 1).equals(".")) || mazeList.get(down + 1).substring(left, left + 1).equals("$")){
                        if(move(down + 1, left)){return;}
                    }
                    if((mazeList.get(down).substring(left - 1, left).equals(".")) || mazeList.get(down).substring(left - 1, left).equals("$")){                    
                        if(move(down, left - 1)){return;}
                    } 
                    if((mazeList.get(down).substring(left + 1, left + 2).equals(".")) || mazeList.get(down).substring(left + 1, left + 2).equals("$")){
                        if(move(down, left + 1)){return;}
                    }
                }
                //Bottom row
                else if( down == mazeList.size() - 1 && left > 0){
                    if((mazeList.get(down - 1).substring(left, left + 1).equals(".")) || mazeList.get(down - 1).substring(left, left + 1).equals("$")){
                        if(move(down - 1, left)){return;}
                    }
                    if((mazeList.get(down).substring(left - 1, left).equals(".")) || mazeList.get(down).substring(left - 1, left).equals("$")){
                        if(move(down, left - 1)){return;}
                    } 
                    if((mazeList.get(down).substring(left + 1, left + 2).equals(".")) || mazeList.get(down).substring(left + 1, left + 2).equals("$")){
                        if(move(down, left + 1)){return;}
                    }
                }
                //Left row
                else if( left == 0 && down > 0){
                    if((mazeList.get(down - 1).substring(left, left + 1).equals(".")) || mazeList.get(down - 1).substring(left, left + 1).equals("$")){
                        if(move(down - 1, left)){return;}
                    } 
                    if((mazeList.get(down + 1).substring(left, left + 1).equals(".")) || mazeList.get(down + 1).substring(left, left + 1).equals("$")){
                        if(move(down + 1, left)){return;}
                    }
                    if((mazeList.get(down).substring(left + 1, left + 2).equals(".")) || mazeList.get(down).substring(left + 1, left + 2).equals("$")){
                        if(move(down, left + 1)){return;}
                    }
                }
                //Right Row
                else if( left == mazeList.get(down).length() - 1 && down > 0){
                    if((mazeList.get(down - 1).substring(left, left + 1).equals(".")) || mazeList.get(down - 1).substring(left, left + 1).equals("$")){
                        if(move(down - 1, left)){return;}
                    } 
                    if((mazeList.get(down + 1).substring(left, left + 1).equals(".")) || mazeList.get(down + 1).substring(left, left + 1).equals("$")){
                        if(move(down + 1, left)){return;}
                    }
                    if((mazeList.get(down).substring(left - 1, left).equals(".")) || mazeList.get(down).substring(left - 2, left - 1).equals("$")){
                        if(move(down, left - 1)){return;}
                    } 
                }
                //Middle Jaunski
                else{
                    if((mazeList.get(down - 1).substring(left, left + 1).equals(".")) || mazeList.get(down - 1).substring(left, left + 1).equals("$")){
                        if(move(down - 1, left)){return;}
                    } 
                    if((mazeList.get(down + 1).substring(left, left + 1).equals(".")) || mazeList.get(down + 1).substring(left, left + 1).equals("$")){
                        if(move(down + 1, left)){return;}
                    }
                    if((mazeList.get(down).substring(left - 1, left).equals(".")) || mazeList.get(down).substring(left - 1, left).equals("$")){
                        if(move(down, left - 1)){return;}
                    } 
                    if((mazeList.get(down).substring(left + 1, left + 2).equals(".")) || mazeList.get(down).substring(left + 1, left + 2).equals("$")){
                        if(move(down, left + 1)){return;}
                    }
                }    
                noMove();
            }  

            /**
             * Called if no move has been made
             * Tries to pop and if it cannot the maze cannot be completed
             * if not pops the stack
             */
            private void noMove(){
                if(maze.peek() == null){
                    System.out.println("Maze is impossible");
                }    
                else{
                    maze.pop();
                } 
            }  

            /**
             * Tests for overlap or places on stack
             * @param nDown New Down var to test or put onto the stack
             * @param nLeft New Left var to test or put onto stack
             * @return If true spot is valid and method returns. If flase, continues to look for spots
             */
            private boolean move(int nDown, int nLeft){
                boolean beenThere = false;
                for(int foo = 0; foo < oldMaze.size(); foo++){
                    if(oldMaze.get(foo).equals(new MazeLocation(nDown, nLeft))) {
                        beenThere = true;
                    }
                }    
                if(!beenThere){
                    oldMaze.add(new MazeLocation(down, left));
                    maze.push(new MazeLocation(nDown,nLeft));
                    return true;
                } 
                return false;
            }    
            /**
             * Inner class that represents a location on the maze
             * Used in the stack and arraylists 
             */
            private class MazeLocation{
                private int downLocation;
                private int leftLocation;
                public MazeLocation(int downLocation, int leftLocation){
                    this.downLocation = downLocation;
                    this.leftLocation = leftLocation;
                }

                public int getDownLocation(){
                    return downLocation;
                }

                public int getLeftLocation(){
                    return leftLocation;
                }

                /**
                 * Modification to the equals method to ensure it working
                 * @param obj Object that is compared to 
                 */
                @Override
                public boolean equals(Object obj){
                    if(obj == this){
                        return true;
                    }
                    if(obj instanceof MazeLocation){
                        MazeLocation location = (MazeLocation) obj;
                        return (downLocation == location.getDownLocation()) && (leftLocation == location.getLeftLocation());
                    }    
                    return false;
                }    

            }   

        }

    }

}
