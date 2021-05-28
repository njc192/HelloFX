package hangman;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class DictionaryLoader {

    ArrayList<String> dictionary;
    private final String LOCATION = "src/hangman/dictionary.txt";
    public DictionaryLoader()
    {
        dictionary = new ArrayList<>();
        loadDict();
    }


    private void loadDict()
    {

        try
        {
            Scanner scanner = new Scanner(new File(LOCATION));
            while (scanner.hasNext())
            {
                String currString = scanner.next();
                dictionary.add(currString);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }


    public String getRandomString()
    {
        Random rand = new Random();
        int location = rand.nextInt(dictionary.size());

        return dictionary.get(location);

    }
}
