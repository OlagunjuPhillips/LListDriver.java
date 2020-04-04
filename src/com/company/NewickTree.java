package com.company;
import java.util.*;

public class NewickTree {
    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);

        System.out.println("=== Newick Tree Display Program ===");
        System.out.print("Enter you phytogenetic tree here. Make sure to separate all nodes with space. ");

        // TODO Phillips you like user input but when writing code, you shouldn't require all of us to
        // type input and then figure out how to use your code.  Instead this driver should be something like
        // (a) You give a file that has a bunch of Newick trees or
        // (b) Your driver should step through all the Newick trees on the assignment sheet without requiring
        //     user input.
        //

        // TODO this should be a function that validates the semicolon but also checks the parenthesis match
        // remember how to check for matching parenthesis
//        String tree = console.nextLine();
//        while(!tree.endsWith(";")){
//            System.out.println("Wrong format. Enter again: ");
//            tree = console.nextLine();
//        }
//

//        tree = tree.substring(1, tree.length() - 1);
//        String[]  treeList = tree.split(" ");
//
//
//        displayNewickTree(treeList, 0, "");

        // TODO Phillips this code would be easier to use if your method returned a String
        String t1 = "(A);";
        System.out.println("\n" + t1.substring(1, t1.length() - 1) + " ---> ");
        displayNewickTree( t1.split(" "), 0, "" );

        System.out.println("\n(A B); ---> ");
        displayNewickTree( "(A  B);".split(" "), 0, "" );

        System.out.println("\n(A (B C) D); ---> ");
        displayNewickTree( "(A (B C) D);".split(" "), 0, "" );

        System.out.println("\n((A B) C); ---> ");
        displayNewickTree( "((A B) C);".split(" "), 0, "" );

        System.out.println("\n((A  B)  (C  D)); ---> ");
        displayNewickTree( "((A  B)  (C  D));".split(" "), 0, "" );

        System.out.println("\n((raccoon bear) ((sea_lion seal) ((monkey cat) weasel)) dog); ---> ");
        displayNewickTree( "((raccoon bear) ((sea_lion seal) ((monkey cat) weasel)) dog);".split(" "), 0, "" );

        System.out.println("\n(Bovine  (Gibbon  (Orang  (Gorilla  (Chimp  Human)))  Mouse); ---> ");
        displayNewickTree( "(Bovine  (Gibbon  (Orang  (Gorilla  (Chimp  Human)))  Mouse);".split(" "), 0, "" );

        System.out.println("\n(Bovine (Hylobates (Pongo (G._Gorilla (P._paniscus H._sapiens)))) (Rodent)); ---> ");
        displayNewickTree( "(Bovine (Hylobates (Pongo (G._Gorilla (P._paniscus H._sapiens)))) (Rodent));".split(" "), 0, "" );



        System.out.println("Thank for using Newick Tree Display Program");

    }

    static void displayNewickTree(String[] tree, int index, String displayTab){
        if(index < tree.length) {
            String word = tree[index];
            if(word.startsWith("(")  && word.endsWith(")")){
                displayTab += "\t";
                word = word.substring(1);

                int count = 0;

                for(int i = 0; i < word.length(); i++){
                    if(word.charAt(i) == ')'){
                        count++;
                    }
                }
                word = word.substring(0, word.length() - count);
                System.out.println(displayTab + word);

                for(int i = 0; i < count; i++){
                    displayTab = displayTab.replaceFirst("\t", "");
                }


                }else if(word.startsWith("(")){
                    displayTab += "\t";
                    word = word.substring(1);
                    System.out.println(displayTab + word);
                }  else if (word.endsWith(")")){

                    int count = 0;

                    for(int i = 0; i < word.length(); i++){
                        if(word.charAt(i) == ')'){
                            count++;
                        }
                    }
                    word = word.substring(0, word.length() - count);
                    System.out.println(displayTab + word);

                    for(int i = 0; i < count; i++){
                        displayTab = displayTab.replaceFirst("\t", "");
                    }
                } else{
                    System.out.println(displayTab + word);
                }
            index++;
            displayNewickTree(tree, index, displayTab);
        }

    }


}
