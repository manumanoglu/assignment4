import java.util.Scanner;
public class RockPaperScissors {
 public static void main(String[] args) {
        // CS312 Students. Do not change the following line.
        RandomPlayer computerPlayer = buildRandomPlayer(args);
        // CS312 students do no change the following line. Do not create any other Scanners.
        Scanner keyboard = new Scanner(System.in);
        intro();
        String name = getName(keyboard);
        welcome(name);
        int roundNos = getRounds(keyboard);
        int s1=0;
        int s2=0;
        for (int i = 1; i <= roundNos; i++) {
            int computerChoice = computerPlayer.getComputerChoice();
            rounds(name, i);
            int playerChoice= getPlayersChoice(keyboard);

            play(name, playerChoice, computerChoice);
            int result=who_wins(playerChoice, computerChoice);
            if (result==1){
                s1++;
            }else if(result==2){
                s2++;
            }
        }
        results(s1,s2,roundNos,name);
        keyboard.close();
    }

    public static void intro() {
        System.out.println("Welcome to ROCK PAPER SCISSORS. I, Computer, will be your opponent.");
        System.out.print("Please type in your name and press return: ");
    }

    public static String getName(Scanner keyboard) {
        return keyboard.next();
    }

    public static void welcome(String name) {
        System.out.println("Welcome, " + name + ".\nAll right " + name + ". How many rounds would you like to play?");
        System.out.print("Enter the number of rounds you want to play and press return: ");
    }

    public static int getRounds(Scanner keyboard) {
        return keyboard.nextInt();
    }

    public static void rounds(String name, int r) {
        System.out.println("Round " + r + ".");
        System.out.println(name + ", please enter your choice for this round.");
        System.out.print("1 for ROCK, 2 for PAPER, and 3 for SCISSORS: ");
    }
    public static int getPlayersChoice(Scanner keyboard) {
        return keyboard.nextInt();
    }
    public static void play(String name, int player, int enemy) {
        System.out.println("Computer picked " + number_to_word(enemy) + ", " + name + " picked " + number_to_word(player) + ".");
    }

    public static String number_to_word(int x) {
        if (x == 1) {
            return "ROCK";
        } else if (x == 2) {
            return "PAPER";
        } else if(x==3) {
            return "SCISSORS";
        }else{
            return "";
        }
    }
    public static int who_wins(int p1, int p2) {
        if (p1 == 1 && p2 == 1) {
            System.out.println("We picked the same thing! This round is a draw.");
            return 0;
        } else if (p1 == 1 && p2 == 2) {
            System.out.println("PAPER covers ROCK. Computer wins.");
            return 2;
        } else if (p1 == 1 && p2 == 3) {
            System.out.println("ROCK breaks SCISSORS. YOU WIN!");
            return 1;
        } else if (p1 == 2 && p2 == 1) {
            System.out.println("PAPER covers ROCK. YOU WIN!");
            return 1;
        } else if (p1 == 2 && p2 == 2) {
            System.out.println("We picked the same thing! This round is a draw.");
            return 0;
        } else if (p1 == 2 && p2 == 3) {
            System.out.println("SCISSORS cut PAPER. Computer wins.");
            return 2;
        } else if (p1 == 3 && p2 == 1) {
            System.out.println("ROCK breaks SCISSORS. Computer wins.");
            return 2;
        } else if (p1 == 3 && p2 == 2) {
            System.out.println("SCISSORS cut PAPER. YOU WIN!");
            return 1;
        } else if (p1 == 3 && p2 == 3) {
            System.out.println("We picked the same thing! This round is a draw.");
            return 0;
        } else {
            return 3;
        }
    }
    public static void  results(int s1, int s2, int n,String name){
            System.out.println("Number of games of ROCK PAPER SCISSORS: "+ n);
            System.out.println("Number of times Computer won: " + s2);
            System.out.println("Number of times "+ name +" won: " +s1);
            System.out.println("Number of draws: "+ (n-s1-s2));
            if(s1<s2){
                System.out.println("Computer wins.");
            }else if(s1>s2){
                System.out.println("YOU WIN!");
            }else{
                System.out.println("We are evenly matched.");
            }
    }
    public static RandomPlayer buildRandomPlayer(String[] args) {
        if(args.length == 0) {
            return new RandomPlayer();
        } else {
            int seed = Integer.parseInt(args[0]);
            return new RandomPlayer(seed);
        }
    }
}
