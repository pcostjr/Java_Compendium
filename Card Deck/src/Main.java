
import java.util.Scanner;
import java.util.Random;

public class Main
{
    public static void main(String[] args) {

        Random rand = new Random();
        Scanner scan = new Scanner(System.in);
        arrDeck deck = new arrDeck();
        boolean game = true;
        while(game) {
           int games = 0, player = 0, cpu = 0;
           System.out.println("Welcome to Game of Cut!");
           deck.populateDeck();
           System.out.println("Deck populated");
           deck.shuffleDeck();
           System.out.println("Deck shuffled");
           boolean subMenu = true;
           int choice = 0;
           while(subMenu) {
                System.out.println("Player, choose a card (1-52)");
                choice = scan.nextInt();
                if(choice >= 1 && choice <= 52)
                    subMenu = false;
                else
                    System.out.println("Error. Please choose a number between 1 and 52");
           }
           Card playerChoice = deck.selectCard(choice - 1);
           System.out.println("CPU Choosing...");
           Card cpuChoice = deck.selectCard(rand.nextInt(choice, deck.getDeckSize()) - 1);

           // tie game
           if(playerChoice.getFace() == cpuChoice.getFace()) {
                if(playerChoice.getSuit() > cpuChoice.getSuit()) {
                    System.out.println("CPU Wins!");
                    cpu++;
                }
                else {
                    System.out.println("Player Wins!");
                    player++;
                }
           }
           else if(playerChoice.getFace() > cpuChoice.getFace()) {
               System.out.println("Player Wins!");
               player++;
           }
           else {
               System.out.println("CPU Wins!");
               cpu++;
           }

           // overall winner after five games or winner of three
           if(games == 5) {
               System.out.println("Game Over.");
               if(player > cpu) {
                   System.out.println("Player Wins!");
               }
               else
                   System.out.println("CPU Wins!");
           }

           games++;
        }




    }
}