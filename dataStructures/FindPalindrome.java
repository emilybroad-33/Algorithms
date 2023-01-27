import java.io.*;
import java.util.*;

/*
 This program uses my self-implemented data structures Node, Stack and Queue.
 These data structures are used in finding palindromes in a text file.
 The user must create their own text file(s), or use the test ones provided in the folder.
 */
public class FindPalindrome {

    public static int numPalindromes = 0;//keeps track of the total number of palindromes

    public static ArrayList<String> makeArray(File file, Scanner sc) {

        /*
         This method is for reading all the lines of the text file into an array.
         Because the number is unknown, an ArrayList would work best for this.
         The best way to go about this is to read each line into the ArrayList.
         */

        //create array
        ArrayList<String> fileAL = new ArrayList<String>();

        String str;
       
        while (sc.hasNextLine()) {
            //take current line
            str = sc.nextLine();
           
            //add to ArrayList
            fileAL.add(str);
        }//while

        return fileAL;
    }//makeArray

    
    public static void isPalindrome(ArrayList<String> fileAL) {
        String currentItem;
        for (int i = 0; i < fileAL.size(); i++) {//iterates through every item
            currentItem = fileAL.get(i);

            /*
            In finding palindromes, letter case, spaces, apostrophes, etc should not be taken into account.
            Therefore, they are removed here.
            */

            currentItem = currentItem.toUpperCase();
            currentItem = currentItem.replaceAll("[^A-Z]", "");//ignores everything except letters

            char[] currCharAr = currentItem.toCharArray();//so that each character can be read individually

            Stack palStack = new Stack();
            Queue palQueue = new Queue();
            for (int j = 0; j < currCharAr.length; j++) {//iterates through every char in an element
                char currChar = currCharAr[j];
                palStack.push("" + currChar);//cheat to change to string
                palQueue.enqueue("" + currChar);//see above
            }//for j

            int numSame = 0;
            for (int k = 0; k < currCharAr.length; k++) {//iterates through the length of the char array
                /*
                Pops and dequeues one by one to see if they match.
                Pop takes the last element and dequeue takes the first.
                Therefore, if the chars are equal, the element is a palindrome.
                */
                String charPop = palStack.pop();
                String charDequeue = palQueue.dequeue();

                if (charPop.compareTo(charDequeue) == 0) {
                    numSame++;
                }//if

                //System.out.println();
            }//for k

            if (numSame == currCharAr.length) {//this means that all characters are equal when popped and dequeued
                System.out.println(fileAL.get(i));
                numPalindromes++;
            }//if

        }//for i (loop through magic items)
    }//isPalindrome
    

    public static void main(String[] args) throws Exception {

        //read file
        try {
            Scanner in = new Scanner(System.in);
            System.out.println("Enter the text file name. Do NOT include the .txt: ");
            System.out.println("When formatting your text file, put each item on a new line.");
            String input = in.nextLine() + ".txt";
            File file = new File(input);
            Scanner sc = new Scanner(file);

            //calls a method to read the file into an array
            ArrayList<String> fileAL = makeArray(file, sc);
        
            //beginning of output
            System.out.println("List of palindromes from file:");
                
            //calls a method to find palindromes
            isPalindrome(fileAL);
            in.close();
        }//try

        catch (Exception e) {//file not found
            throw new FileNotFoundException("File not found. \nMake sure:\nYou did NOT include .txt in your input.\nThe file is in the correct folder.\nThe path is correct if inputting a path.");
        }//catch

        //end of output
        if (numPalindromes != 0) {
            System.out.println();
            System.out.println("Total number of palindromes in file: " + numPalindromes);
        }//if
        else {
            System.out.println("No palindromes were found in the file.");
        }//else

    }//main
}
