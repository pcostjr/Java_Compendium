import java.util.Random;
import java.util.Scanner;
/***
 * @name Hangman
 * @description: A simple Java Program that simulates the game "Hangman" using Strings.
 * @author: pcostjr
 * @created: 11.14.2024
 * @last_update: 11.14.2024
 */
public class Main {

    public static void main(String[] args) {
        // list of words that we'll use
        String[] words = { "cat", "whale", "bunny", "giraffe", "koala",
                "lobster", "penguin", "kangaroo", "tarantula", "alligator",
                "chameleon", "dragonfly", "hummingbird", "hippopotamus",
                "rhinoceros", "chimpanzee", "hedgehog", "grasshopper",
                "salamander", "armadillo", "porcupine", "warthog",
                "scorpion", "anaconda", "orangutan" };

        // build a new random number generator, choose a word
        Random random = new Random();
        String word = words[random.nextInt(words.length)];

        // since we're not going to be using arrays yet, we'll make a StringBuilder that
        // is the length of the target word, replaced with underscores.
        StringBuilder guesses = new StringBuilder(word.replaceAll(".","_"));

        Scanner scanner = new Scanner(System.in);
        // the amount of guessess is double the length of the word
        int remaining = word.length() * 2;
        while (remaining > 0) {
            System.out.println("Word: " + guesses);
            System.out.println("Guesses left: " + remaining);
            System.out.print("Guess a letter: ");
            // target the next character
            char guess = scanner.nextLine().charAt(0);
            // if the guess is incorrect, simply reduce the number of guesses
            if (word.indexOf(guess) == -1) {
                System.out.println("Incorrect. Try Again.");
                remaining--;
            } else {
                // otherwise, replace the character
                for (int i = 0; i < word.length(); i++) {
                    if (word.charAt(i) == guess) {
                        guesses.setCharAt(i, guess);
                    }
                }
            }
            // check win condition
            if (guesses.toString().equals(word)) {
                System.out.println("You win! The word was " + word);
                return;
            }
        }
        // if we make it to here, the user has lost
        System.out.println("You lose. The word was " + word);
    }
}