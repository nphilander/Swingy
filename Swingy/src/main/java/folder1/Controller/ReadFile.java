package folder1.Controller;

import folder1.Model.Hero;

import java.io.*;


public class ReadFile {
    public void serializePlayer(Hero hero) {
        try {
            FileOutputStream fileOut = new FileOutputStream("player.txt");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(hero);
            out.close();
            fileOut.close();
            System.out.println("Player data is saved in player.txt as an object");
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    public Hero deserializePlayer() {
        try {
            FileInputStream fileIn = new FileInputStream("player.txt");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            Hero hero = (Hero) in.readObject();
            in.close();
            fileIn.close();
            return hero;
        } catch (IOException i) {
            i.printStackTrace();
            return null;
        } catch (ClassNotFoundException c) {
            System.out.println("Hero class not found");
            c.printStackTrace();
            return null;
        }
    }
}
