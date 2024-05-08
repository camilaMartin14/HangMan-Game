package hangmangame;

import java.util.Scanner;

public class HangmanGame {
/*
Let's play a game of hangman.
We are going to make an array with words that you choose. You must show the
word taken with dashes and ask for letters.
The user wins when the word is complete. If he fails 6 times, the user loses.
*/
 

 public static void main(String[] args) {
    
     final int FAIL_MAX_NUMBER = 6; 
     
     final String [] WORDS = {
         "argentina",
         "elefante",
         "auto",
         "naranja",
         "destreza",
         "arcoiris"
     };
     Scanner sc = new Scanner (System.in);
     
     String wordChoosen = WORDS[generateRandomNumber (0,WORDS.length-1)];
     
     char[] characters = wordChoosen.toCharArray();
     boolean[] right = new boolean [characters.length];
     
     int failsNumber = 0;
     boolean winUser = false;
    
     
     
     char character;
     while (!rightWord(right) && failsNumber < FAIL_MAX_NUMBER ) {
    
        showCharacters(characters, right);
         System.out.println("Write a letter");
         character = sc.next().toLowerCase().charAt(0);
         
         
     if(revealCharacters(character, characters, right)> 0){
         System.out.println("You are right with the character");  
     }else{
         failsNumber++;
         if (failsNumber !=FAIL_MAX_NUMBER ) {
                  System.out.println("You have failed, you have "+(FAIL_MAX_NUMBER-failsNumber)+" attempts left");
         }
      }
    }
     if(rightWord(right)){
         System.out.println("You Won! :D ");
     }else{
         System.out.println("You loose :(");
     }
   
     }
 public static int generateRandomNumber (int min, int max) {
     return (int) ((Math.random() * (max - min + 1)) + min);
     
 
 
 
    }
 public static void showCharacters(char[] characters, boolean[] right) {
     for (int i = 0; i < characters.length; i++) {
         if (right[i]) {
             System.out.print(characters[i]);
         }else {
             System.out.print("_");
             
         }
     }
     System.out.println(""); 
 }
 public static boolean rightWord (boolean[] right){
     for (int i = 0; i < right.length; i++) {
         if(!right[i]){
             return false;
         }
     }
    return true;
 }
 public static int revealCharacters (char character, char[] characters, boolean[] right) {
     
     int correctLetters = 0;
     for (int i = 0; i < characters.length; i++) {
         if (characters[i]==character) {
             right[i]=true;
             correctLetters ++;
         }
     }
     return correctLetters;
     
     
 }
}