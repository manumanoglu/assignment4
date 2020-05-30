import java.util.Scanner;
public class RockPaperScissors {
    public static void main(String[] args) {
        // CS312 Students. Do not change the following line.
        RandomPlayer computerPlayer = buildRandomPlayer(args);
        // CS312 students do no change the following line. Do not create any other Scanners.
        Scanner keyboard = new Scanner(System.in);
        String name = intro(keyboard);
        int roundNos = getRoundNos(keyboard);
        int player_score=0;
        int computer_score=0;
        for (int i = 1; i <= roundNos; i++) {
            int computerChoice = computerPlayer.getComputerChoice();
            int result=round_play(i, computerChoice, name, keyboard);
            if (result==1){
                player_score++;
            }else if(result==2){
                computer_score++;
            }
        }
        results(player_score,computer_score,roundNos,name);
        keyboard.close();
    }
    public static String intro(Scanner keyboard) {
        System.out.println("Welcome to ROCK PAPER SCISSORS. I, Computer, will be your opponent.");
        System.out.print("Please type in your name and press return: ");
        String name= keyboard.next();
        System.out.print("Welcome, " + name + ".\nAll right " + name + ". ");
        return name;
    }
    public static int getRoundNos(Scanner keyboard) {
        System.out.print("How many rounds would you like to play?\nEnter the number of rounds you want to play and press return: ");
        return keyboard.nextInt();
    }
    public static int round_play (int round_Nos, int computerChoice, String player_name, Scanner keyboard){
            round_announce(player_name, round_Nos);
            int playerChoice= getPlayersChoice(keyboard);
            play_announce(player_name, playerChoice, computerChoice);
            return who_wins(playerChoice, computerChoice);//result of the round
    }
    public static void round_announce(String name, int round_no) {
        System.out.println("Round " + round_no + ".");
        System.out.println(name + ", please enter your choice for this round.");
        System.out.print("1 for ROCK, 2 for PAPER, and 3 for SCISSORS: ");
    }
    public static int getPlayersChoice(Scanner keyboard) {
        return keyboard.nextInt();
    }
    public static void play_announce(String name, int player_pick, int computer_pick) {
        System.out.println("Computer picked " + number_to_word(computer_pick) + ", " + name + " picked " + number_to_word(player_pick) + ".");
    }
    public static String number_to_word(int pick) {
        if (pick == 1) {
            return "ROCK";
        } else if (pick == 2) {
            return "PAPER";
        } else if(pick==3) {
            return "SCISSORS";
        }else{
            return "";
        }
    }
    public static int who_wins(int player_pick, int computer_pick) {
        if (player_pick == computer_pick) {
            System.out.println("We picked the same thing! This round is a draw.");
        } else if ((player_pick == 1 && computer_pick == 2) || (player_pick == 2 && computer_pick == 1) ) {
            System.out.print("PAPER covers ROCK.");
        } else if ((player_pick == 1 && computer_pick == 3) || (player_pick == 3 && computer_pick == 1) ) {
            System.out.print("ROCK breaks SCISSORS.") ;
        } else if ((player_pick == 2 && computer_pick == 3) || (player_pick == 3 && computer_pick == 2)) {
            System.out.print("SCISSORS cut PAPER.");
        }
        if (player_pick != computer_pick) {
            if(computer_pick==2 || player_pick==2){
                if (player_pick>computer_pick) {
                    System.out.println("YOU WIN!");
                    return 1;
                }else{
                    System.out.println("Computer wins.");
                    return 2;
                }
            }else if(player_pick==1) {
                System.out.println("YOU WIN!");
                return 1;
            }else{
                System.out.println("Computer wins.");
                return 2;
            }
        }else{
            return 0; // 0 means draw
        }
    }
    public static void  results(int player_round_wins, int computer_round_wins, int round_numbers,String player_name){
        System.out.println("Number of games of ROCK PAPER SCISSORS: "+ round_numbers);
        System.out.println("Number of times Computer won: " + computer_round_wins);
        System.out.println("Number of times "+ player_name +" won: " +player_round_wins);
        System.out.println("Number of draws: "+ (round_numbers-computer_round_wins-player_round_wins));
        if(player_round_wins<computer_round_wins){
            System.out.println("I, Computer, am a master at ROCK, PAPER, SCISSORS.");
        }else if(player_round_wins>computer_round_wins){
            System.out.println("You, " +player_name+", are a master at ROCK, PAPER, SCISSORS.");
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
