/**
 * Created by Iryna Gnatenko
 * Date 10/27/2020
 * Time 1:32 PM
 * Project untitled1
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

class main {
    
    static Scanner input = new Scanner(System.in);
    static Character hero = null;
    static ArrayList<Character> heroes = new ArrayList<>();
    static String fileName = "data.bin";
    static int choice;

    public static void main(String[] args) {

        menu();

    }

    public static void menu() {
    
        System.out.println("Hej och välkommen till Dungeon Run! Låt äventyret börja!");
        System.out.println("1. Skapa en ny hjälte");
        System.out.println("2. Ladda en befintligt");
        
        choice = input.nextInt();
            switch(choice) {
                case 1:
                    createHero();
                    break;
                case 2:
                    //loadExistingHero()
                    break;
            }
    }
    
    public static void createHero() {
        
        System.out.println("Välj en hjälte: ");

        System.out.print("1. Riddare");
        System.out.print("\t2. Trollkarl");
        System.out.print("\t3. Tjuv");

        choice = input.nextInt();
        input.nextLine();
        
        System.out.println("Ange ett namn för din hjälte: ");
        String name = input.nextLine();

        switch(choice) {
            case 1:
                hero = new Warrior(name,5, 9, 6, 4);
                break;
            
            case 2:
                hero = new Mage(name,6, 4, 9, 5);
                break;
                
            case 3:
                hero = new Thief(name,6, 5, 5, 7);
                break;
        }

        System.out.println("Du har valt: " + hero.toString());

        //Maps mapsObjects = new Maps();  // skapa oblekt av klassen Maps
        //mapsObjects.mapsMenu();         // ropa på objektets metod mapsMenu
    }
    
    public static void saveToFile() { //Jag behöver få in en arrayList eller ett object i metoden. 

        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(fileName));
            os.writeObject(heroes); //Objectet ska in hit. 
            os.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
    
    public static void importFromFile() {
        
        try {
            ObjectInputStream is = new ObjectInputStream(new FileInputStream(fileName));
            heroes = (ArrayList<Character>) is.readObject();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
}

/*
public class main {

    public static void main(String[] args) {


        Character riddaren = new Hero(5,9,6,4);
        Character trollkarl = new Hero(6,4,9,5);
        Character tjuven = new Hero(6,5,5,7);

        Character jättespindel = new Monster(7,1,2,3, 0.2);
        Character skelett = new Monster(4,2,3,3, 0.15);
        Character orc = new Monster(6,3,4,4, 0.1);
        Character troll = new Monster(2,4,7,2, 0.05);

        System.out.println("Du har valt trollkarl. Du har följande attribut: " + trollkarl.toString());
        System.out.println("Du har valt riddaren. Du har följande attribut: " + riddaren.toString());
        System.out.println("Du har valt tjuven. Du har följande attribut: " + tjuven.toString());

        System.out.println();
        System.out.println("Det är spindel. Den har följande attribut: " + jättespindel.toString());
        System.out.println("Det är skelett. Den har följande attribut: " + skelett.toString());
        System.out.println("Det är orc. Den har följande attribut: " + orc.toString());
        System.out.println("Det är troll. Den har följande attribut: " + troll.toString());


    }
}
*/
