package folder1.Controller;

import folder1.Model.Hero;

import java.io.FileWriter;
import java.io.IOException;

public class WriteToFile {
    public void writeToFile(Hero hero) throws IOException{
        try {
            FileWriter myWriter = new FileWriter("player.txt");
            myWriter.write(hero.toString());
            myWriter.close();
            System.out.println("Successfully created player.txt.");
        } catch (IOException e) {
            System.out.println("Error creating hero file");

        }
    }
}
