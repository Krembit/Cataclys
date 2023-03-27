import java.util.Random;
import java.util.Scanner;

public class MainGame {
    public static void main(String args[]) {
        //creates the ability score array to store scores
        int[] abilityScores = new int[6];
        //constant for character armor bonus -  ONLY FOR TESTING, NOT FOR FINAL GAME!!!
        int CHARACTER_ARMOR_BONUS = 7;
        //this sets abilityScores to the values generated during the character creation process
        abilityScores = CharacterCreation();
        //This is the actual game
        Combat(abilityScores, CHARACTER_ARMOR_BONUS);
    }

    //this goes through the whole process including scores and race bonuses
    static int[] CharacterCreation() {
        //creates space to store the ability scores
        int[] abilityScores = new int[6];
        //allows the doneWithCharacter loop to recur
        boolean doneWithCharacter = false;
        //creates scanner
        Scanner sc = new Scanner(System.in);
        //stores the user's race choice
        String raceChoice;
        //allows for die rolls
        Random rd = new Random();
        //allows for race choice and reroll screens to recur
        boolean validChoice = false;
        //this stores the name of the player's Race
        String playerRace = null;

        //this is the meat and potatoes of the process; it goes over race choice and score bonuses
        while (!doneWithCharacter) {
            //allows the race choice and reroll screens to recur
            validChoice = false;
            //this sets the ability scores to their initial rolled values
            abilityScores = RollAbilityScores();

            while (!validChoice) {
                //asks the user for their choice of race
                System.out.println("What Race would you like to be?");
                System.out.println("B) Bugbear  D) Dwarf  E) Elf  G) Goblin  HO) Half-Orc  HT) Half-Troll  HB) Hobbit  " +
                        "HG) Hobgoblin  H) Human  O) Ogrillon");
                raceChoice = sc.nextLine();


                //this statement handles the different options for character race by applying score bonuses
                switch (raceChoice) {
                    case "b":
                    case "B":
                        abilityScores[2] += rd.nextInt(1, 4);
                        abilityScores[1] += rd.nextInt(1, 5);
                        abilityScores[5] -= rd.nextInt(1, 4);
                        validChoice = true;
                        playerRace = "Bugbear";
                        break;
                    case "d":
                    case "D":
                        abilityScores[2] += rd.nextInt(1, 5);
                        abilityScores[4] += rd.nextInt(1, 4);
                        abilityScores[1] -= rd.nextInt(1, 4);
                        validChoice = true;
                        playerRace = "Dwarf";
                        break;
                    case "e":
                    case "E":
                        abilityScores[1] += rd.nextInt(1, 5);
                        abilityScores[3] += rd.nextInt(1, 4);
                        abilityScores[0] -= rd.nextInt(1, 4);
                        validChoice = true;
                        playerRace = "Elf";
                        break;
                    case "g":
                    case "G":
                        abilityScores[2] += rd.nextInt(1, 4);
                        abilityScores[1] += rd.nextInt(1, 5);
                        abilityScores[5] -= rd.nextInt(1, 4);
                        validChoice = true;
                        playerRace = "Goblin";
                        break;
                    case "ho":
                    case "hO":
                    case "Ho":
                    case "HO":
                        abilityScores[0] += rd.nextInt(1, 5);
                        abilityScores[2] += rd.nextInt(1, 5);
                        abilityScores[5] -= rd.nextInt(1, 5);
                        validChoice = true;
                        playerRace = "Half-Orc";
                        break;
                    case "ht":
                    case "hT":
                    case "Ht":
                    case "HT":
                        abilityScores[0] += rd.nextInt(1, 7);
                        abilityScores[2] += rd.nextInt(1, 4);
                        abilityScores[4] += rd.nextInt(1, 5);
                        abilityScores[3] -= rd.nextInt(1, 5);
                        abilityScores[5] -= rd.nextInt(1, 5);
                        validChoice = true;
                        playerRace = "Half-Troll";
                        break;
                    case "hb":
                    case "hB":
                    case "Hb":
                    case "HB":
                        abilityScores[1] += rd.nextInt(1, 5);
                        abilityScores[5] += rd.nextInt(1, 4);
                        abilityScores[2] -= rd.nextInt(1, 4);
                        validChoice = true;
                        playerRace = "Hobbit";
                        break;
                    case "hg":
                    case "hG":
                    case "Hg":
                    case "HG":
                        abilityScores[0] += rd.nextInt(1, 3);
                        abilityScores[1] += rd.nextInt(1, 3);
                        abilityScores[2] += rd.nextInt(1, 4);
                        abilityScores[5] -= rd.nextInt(1, 4);
                        validChoice = true;
                        playerRace = "Hobgoblin";
                        break;
                    case "h":
                    case "H":
                        int scoreChoice;
                        for (int i = 0; i < 3; i++) {
                            validChoice = false;
                            while (!validChoice) {
                                System.out.println("Pick a score to increase. (0:STR, 1:DEX, 2:CON, 3:INT, 4:WIS, 5:CHA)");
                                scoreChoice = sc.nextInt();

                                if (scoreChoice > -1 && scoreChoice < 6) {
                                    abilityScores[scoreChoice] += rd.nextInt(1, 3);
                                    validChoice = true;
                                } else {
                                    System.out.println("Invalid choice.");
                                }
                            }
                        }
                        playerRace = "Human";
                        break;
                    case "o":
                    case "O":
                        abilityScores[0] += rd.nextInt(1, 9);
                        abilityScores[2] += rd.nextInt(1, 7);
                        abilityScores[3] -= rd.nextInt(1, 5);
                        abilityScores[5] -= rd.nextInt(1, 5);
                        validChoice = true;
                        playerRace = "Ogrillon";
                        break;
                    default:
                        System.out.println("Invalid Choice.");
                        break;
                }
            }
            //this displays the user's scores and tells them what they are
            System.out.println("Strength: " + abilityScores[0] + " Dexterity: " + abilityScores[1] +
                    " Constitution: " + abilityScores[2] + " Intelligence: " + abilityScores[3] + " Wisdom: "
                    + abilityScores[4] + " Charisma: " + abilityScores[5]);

            //this is the reroll screen
            validChoice = false;
            while (!validChoice) {
                //allows the whole creation loop to recur
                doneWithCharacter = false;
                //allows this loop to recur
                validChoice = false;
                //sets the choice to reroll to be an invalid value
                String rerollChoice; //= null;

                //asks the user if they want to reroll and pick race again. the race thing was originally a bug but now
                //it's a feature :)
                System.out.println("Reroll ability scores/re-pick Race? (Y/N)");
                //if i don't include this, picking human makes the above line print twice
                if (playerRace.equals("Human")) {
                    sc.nextLine();
                }
                rerollChoice = sc.nextLine();
                //handles the responses for rerolls, including invalid ones
                switch (rerollChoice) {
                    case "y":
                    case "Y":
                        validChoice = true;
                        break;
                    case "n":
                    case "N":
                        doneWithCharacter = true;
                        validChoice = true;
                        break;
                    default:
                        System.out.println("Invalid choice.");
                        break;
                }
            }
        }
        //displays character information to the player
        if (playerRace.equals("Elf") || playerRace.equals("Ogrillon")) {
            System.out.println("Your character is an " + playerRace + " with the scores: ");
        } else {
            System.out.println("Your character is a " + playerRace + " with the scores: ");
        }
        System.out.println("Strength: " + abilityScores[0] + " Constitution: " + abilityScores[1] +
                " Dexterity: " + abilityScores[2] + " Intelligence: " + abilityScores[3] + " Wisdom: "
                + abilityScores[4] + " Charisma: " + abilityScores[5]);

        //this passes ability scores back to the actual game to be used during play
        return abilityScores;
    }

    static int[] RollAbilityScores() {
        Random rd = new Random();

        //declares the array for actual scores and an array for the math for a single score
        int[] scores = new int[6];
        int[] threeRolls = new int[3];

        //this loop generates all six ability scores, which in order are STR, DEX, CON, INT, WIS, and CHA
        for (int i = 0; i < 6; i++) {
            int oneRoll = 0;
            //this makes three randoms and pushes them to threeRolls
            for (int x = 0; x < 3; x++) {
                threeRolls[x] = rd.nextInt(1, 7);
            }
            //this adds together 3d6 to make each ability score
            for (int y = 0; y < 3; y++) {
                oneRoll += threeRolls[y];
            }
            //this assigns each finished score to its proper place
            scores[i] = oneRoll;
        }
        //passes scores to CharacterCreation()
        return scores;
    }

    //this generates a random monster and allows the player to fight it, run away, or exit the dungeon.
    private static void Combat(int[] abilityScores, int CHARACTER_ARMOR_BONUS) {
        Random rd = new Random();
        Scanner sc = new Scanner(System.in);
        //this keeps track of where the character is in the dungeon. After 10 rooms, the character grabs an artifact and
        //wins the game.
        int dungeonRoom = 1;

        //these are the monster's ability scores; 3d6 unmodified
        int[] monsterScores = RollAbilityScores();

        //monster combat stats, variable names are explanatory. Monsters are almost completely random.
        int monsterHP = 10 + monsterScores[2] / 4;
        int monsterToHit = monsterScores[0];
        int monsterArmorBonus = rd.nextInt(1, 11);
        int monsterDexBonus = monsterScores[1] / 4;
        if (monsterDexBonus > 3) {
            for (int i = 0; i < monsterDexBonus - 3; i++) {
                monsterDexBonus--;
            }
        }
        int monsterDamageBonus = monsterScores[0] / 4;
        int monsterArmorClass = 10 + monsterArmorBonus + monsterDexBonus;

        //player combat stats
        int characterConBonus = abilityScores[2] / 4;
        int characterMaxHP = 10 + characterConBonus;
        int characterToHit = abilityScores[0];
        int dexBonus = abilityScores[1] / 4;
        if (dexBonus > 3) {
            for (int i = 0; i < dexBonus - 3; i++) {
                dexBonus--;
            }
        }
        int characterDamageBonus = abilityScores[0] / 4;
        int characterArmorClass = 10 + CHARACTER_ARMOR_BONUS + dexBonus;

        System.out.println("You enter the dungeon...");

        //this sentinel is opposite most others, but it works the same.
        boolean playingGame = true;

        //this loop is the game, and only ends when the player wins or dies.
        while (playingGame) {
            int monsterInitiative = 0;
            int characterInitiative = 0;
            //this keeps track of how many initiative successes are scored
            int initiativeRoll = 0;
            //this keeps track of what the player does on their turn
            int playerTurnChoice;
            //keeps track of the character's attack attempt
            int characterRoll;
            int characterRollSuccesses = 0;
            //keeps track of the monster's defense attempt
            int monsterRoll;
            int monsterRollSuccesses = 0;
            //currently the same number as character/monsterToHit, but in the future this may become its own thing
            int characterToRun = abilityScores[0];
            int monsterToRun = monsterScores[0];
            int characterHP;
            int characterHPLost = 0;
            int daysResting;

            System.out.println("A monster jumps out!");

            //generates character initiative
            for (int i = 0; i < abilityScores[1]; i++) {
                initiativeRoll = rd.nextInt(1, 7);
                if (initiativeRoll > 3) {
                    characterInitiative++;
                }
                initiativeRoll = 0;
            }

            //generates monster initiative
            for (int i = 0; i < monsterScores[1]; i++) {
                initiativeRoll = rd.nextInt(1, 7);
                if (initiativeRoll > 3) {
                    monsterInitiative++;
                }
                initiativeRoll = 0;
            }

            //determines who gets first turn. This entire statement is skipped if the monster has the first turn. I may put
            //some of this code into a function later.
            if (characterInitiative > monsterInitiative) {
                //asks the character what to do on their turn
                System.out.println("Pick an action.");
                System.out.println("1) Attack 2) Run");
                playerTurnChoice = sc.nextInt();

                //this loop ensures the user puts in a valid menu choice
                boolean validChoice = false;
                while (!validChoice) {
                    switch (playerTurnChoice) {
                        //this case handles attacking the monster
                        case 1:
                            //determines outcome of character's to-hit roll
                            for (int i = 0; i < characterToHit; i++) {
                                characterRoll = rd.nextInt(1, 7);
                                if (characterRoll > 3) {
                                    characterRollSuccesses++;
                                }
                                characterRoll = 0;
                            }

                            //determines outcome of monster's to-defend roll
                            for (int i = 0; i < monsterArmorClass; i++) {
                                monsterRoll = rd.nextInt(1, 7);
                                if (monsterRoll > 3) {
                                    monsterRollSuccesses++;
                                }
                                monsterRoll = 0;
                            }

                            //if the character hits the monster, this deals it damage. damage is 1d8 rn because the
                            //character uses a longsword. I'll add more options in the future.
                            if (characterRollSuccesses >= monsterRollSuccesses) {
                                System.out.println("You hit the monster!");
                                monsterHP -= rd.nextInt(1, 8) + characterDamageBonus;
                            } else {
                                //lol
                                System.out.println("You missed!");
                            }
                            validChoice = true;
                            break;
                        //this case handles running away from the monster
                        case 2:
                            //determines character's running successes
                            for (int i = 0; i < characterToRun; i++) {
                                characterRoll = rd.nextInt(1, 7);
                                if (characterRoll > 3) {
                                    characterRollSuccesses++;
                                }
                                characterRoll = 0;
                            }

                            //determines monster's running successes
                            for (int i = 0; i < monsterToRun; i++) {
                                monsterRoll = rd.nextInt(1, 7);
                                if (monsterRoll > 3) {
                                    monsterRollSuccesses++;
                                }
                                monsterRoll = 0;
                            }

                            //determines if character successfully runs away
                            if (characterRollSuccesses >= monsterRollSuccesses) {
                                if (characterHPLost % characterConBonus == 0) {
                                    daysResting = characterHPLost / characterConBonus;
                                } else {
                                    daysResting = (characterHPLost / characterConBonus) + 1;
                                }
                                characterHP = characterMaxHP;
                                System.out.println("You get away! You go back to your village and rest for " + daysResting
                                + "days, and go back to full health.");
                                dungeonRoom = 0;
                            } else {
                                //lol
                                System.out.println("You couldn't get away!");
                            }

                            validChoice = true;
                            break;
                        //this case handles invalid answers
                        default:
                            System.out.println("Invalid Choice.");
                            break;
                    }
                }
            }

            //this loop is for most of the time spent in combat, as well as if the monster takes the first turn.
            boolean inCombat = true;
            while (inCombat) {
                //inCombat = false;
            }
        }
    }
}