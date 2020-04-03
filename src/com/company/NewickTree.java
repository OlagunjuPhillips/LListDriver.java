package com.company;
import java.util.*;

public class NewickTree {
    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);

        System.out.println("=== Newick Tree Display Program ===");
        System.out.print("Enter you phytogenetic tree here. Make sure to separate all nodes with space. ");
        String tree = console.nextLine();
        while(!tree.endsWith(";")){
            System.out.println("Wrong format. Enter again: ");
            tree = console.nextLine();
        }

        tree = tree.substring(1, tree.length() - 1);
        String[]  treeList = tree.split(" ");


        displayNewickTree(treeList, 0, "");

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
