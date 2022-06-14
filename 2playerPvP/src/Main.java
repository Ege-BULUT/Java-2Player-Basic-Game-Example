import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static Scanner scan = new Scanner(System.in);
    public static Player playerOne;
    public static Player playerTwo;
    public static List<Player> players = new ArrayList<Player>();
    public static int playerAmount;
    public static void main(String[] args) {
        System.out.println("\n\t*** Welcome to the PvP game! ***\n");
        sleep(1500);
        System.out.println( "( Important Note : )\n( Whenever you make a decision, just write the number of your decision! ) \n");
        sleep(3500);
        setGame();
    }
    
    public static void setGame(){
        System.out.println( "So, you're want to play this game:\n" +
                            "1-> Single Player ( Player vs AI )\n" +
                            "2-> Multi  Player ( Player vs Player )");
        choose(1);
    }

    public static void choose(int index){
        switch (index){
            case 1:
                switch (scan.nextInt()){
                    case 1:
                        scan.nextLine();//Dummy
                        playerAmount = 1;
                        createPlayer();
                        break;
                    case 2:
                        scan.nextLine();//Dummy
                        playerAmount = 2;
                        createPlayer();
                        break;
                    default:
                        System.out.println("Please enter a valid number");
                        choose(1);
                        break;
                }
                break;
            case 2:
                if (playerAmount == 1) {System.out.print("\n\nThere is:\n\nPlayer One : [ "+playerOne.name+" ]");}
                if (playerAmount == 2){System.out.print("\n\nThere is:\n\nPlayer One : [ "+playerOne.name+" ]\n\t\tand\nPlayer Two : [ "+playerTwo.name+" ]");}
                System.out.println("\n\nAre these name(s) correct?\n1-> Yes they are.\n2-> No I want to change a name");
                switch (scan.nextInt()){
                    case 1:
                        players.add(playerOne); players.add(playerTwo);
                        game();
                        break;
                    case 2:
                        System.out.println("\nWhich player do you want to rename:\n1-> Player One ("+playerOne.name+")\n2-> Player Two ("+playerTwo.name+")\n3-> I'm okay with those");
                        changeName(scan.nextInt());
                        break;
                    default:
                        System.out.println("Please enter a valid number");
                        choose(2);
                        break;
                }
                break;

        }

    }

    public static void createPlayer(){
        System.out.println("\n\nPlease choose a name for [Player One] :");
        playerOne = new Player(scan.nextLine());
        if (playerAmount == 2) {
            System.out.println("\nPlease choose a name for [Player Two] :");
            playerTwo = new Player(scan.nextLine());
        }
        choose(2);
    }

    public static void changeName(int playerIndex){
        scan.nextLine();//dummy
        switch (playerIndex){
            case 1:
                System.out.println("\nPlease enter a new name for the Player One ("+playerOne.name+") : \n");
                playerOne.setName(scan.nextLine());
                System.out.println("\nPlayer One's name had successfully changed to "+playerOne.name);
                choose(2);
                break;
            case 2:
                System.out.println("\nPlease enter a new name for the Player One ("+playerTwo.name+") : \n");
                playerTwo.setName(scan.nextLine());
                System.out.println("\nPlayer Two's name had successfully changed to "+playerTwo.name);
                choose(2);
                break;
            case 3:
                players.add(playerOne); players.add(playerTwo);
                game();
                break;
            default:
                System.out.println("Please enter a valid number");
                changeName(playerIndex);
                break;
        }
    }

    public static void game(){

        System.out.println("\n\n\n\t\t### YAPIM AŞAMASINDA ###");
        System.out.println("\n\n***TEST DENEMESİ***");

        scene();
        sleep(1000);

        playerOne.takeDamage(40);
        scene();
        System.out.println("\n("+playerOne.name+" 40 damage aldı)");
        sleep(1000);

        playerTwo.takeDamage(60);
        scene();
        System.out.println("\n("+playerTwo.name+" 60 damage aldı)");
        sleep(1000);

        playerOne.name = "yeniİsim->Player1";
        playerTwo.name = "yeniİsim->Player2";
        scene();
        System.out.println("\n(Playerlerin isimleri değişti)");
    }

    public static void scene(){

        System.out.println("\n" +
                "       /│\\                                                    /│\\\n" +
                "      / ║ \\                                                  / ║ \\\n" +
                "      │ ║ │                                                  │ ║ │\n" +
                "      │ ║ │                                                  │ ║ │\n" +
                "      │ ║ │ └┼┴┴┴┼┘                                  └┼┴┴┴┼┘ │ ║ │\n" +
                "      │ ║ │  │  ▀│                                    │▀  │  │ ║ │\n" +
                "      │ ║ │  └─┬─┘   ╔═╗                        ╔═╗   └─┬─┘  │ ║ │\n" +
                "     ╠══╬══╣  /│\\   ║║ ║                        ║ ║║   /│\\  ╠══╬══╣\n" +
                "       ██■▄▄_/ │ \\_/║║ ║║                      ║║ ║║\\_/ │ \\_▄▄■██\n" +
                "        ║      │    ║║ ║                        ║ ║║    │      ║\n" +
                "      ╚═╩═╝    │     ╚═╝                        ╚═╝     │    ╚═╩═╝\n" +
                "              / \\                                      / \\\n" +
                "             /   \\                                    /   \\\n" +
                "             │   │                                    │   │\n" +
                "             ├   ├                                    ├   ├\n" +
                "             /   /                                    \\   \\\n" +
                "            /   /                                      \\   \\\n" +
                "           ╚═  ╚═                                      ═╝  ═╝");
        String HPs[] = drawHP();
        System.out.print("\n" + HPs[0]);
        for(int i=1; i<5; i++) {
            System.out.print("\n" + HPs[i] + "\t\t\t\t" + HPs[i+4]);
        }
    }

    private static String[] drawHP() {
        String names = playerOne.name;
        for(int i = 0; i<44-playerOne.name.length(); i++){ names += " "; }
        names += (playerTwo.name);
        String[] lines = {names,"","","","","","","",""};
        int lc = 1; //linecount
        for (int p = 0; p < players.size(); p++) {
            int maxHP = (players.get(p).maxHp) / 5;
            int currHP = (players.get(p).hp) / 5;
            String text = "HP : " + currHP + "/" + maxHP;
            lines[lc] += "╔";
            //System.out.print("╔");
            for (int i = 0; i < maxHP + 9; i++) {
                lines[lc] += "═";
               // System.out.print("═");
            }
            lines[lc] += "╗";
            lc++;
           // System.out.print("╗");
            lines[lc] += "║ " + text;
           // System.out.print("\n║ " + text);
            int digitMax = digits(maxHP);
            int digitCurr = digits(currHP);
            int digitDifference = digitMax - digitCurr;
            for (int i = 0; i < maxHP + 8 - (text.length()); i++) {
                lines[lc] += " ";
               // System.out.print(" ");
            }
            lines[lc] += "║";
            lc++;
         //   System.out.print("║\n");
            lines[lc] += "║  | ";
         //   System.out.print("║  | ");
            for (int i = 0; i < maxHP; i++) {
                if (i < currHP) {
                    if (i == 0) {
                        lines[lc] += "[";
                   //     System.out.print("[");
                    }
                    lines[lc] += "=";
                   // System.out.print("=");
                    if (i == currHP - 1) {
                        lines[lc] += "]";
                    //    System.out.print("]");
                    }
                } else {
                    lines[lc] += " ";
                  //  System.out.print(" ");
                }
            }
            lines[lc] += " | ║";
            lc++;
           // System.out.print(" | ║");
            lines[lc] += "╚";
            //System.out.print("\n╚");
            for (int i = 0; i < maxHP + 9; i++) {
                lines[lc] += "═";
               //System.out.print("═");
            }
            lines[lc] += "╝";
            lc++;
            //System.out.print("╝");
            //System.out.println("\nDigit difference -> " + digitDifference+"\n");
        }

        return lines;
    }
        private static int digits(int Val){
            int digitVal = ("" + Math.abs(Val)).length();
            return digitVal;
        }

    public static void sleep(int milis){
        try {Thread.sleep(milis);} catch (InterruptedException e) {e.printStackTrace();}
    }
}