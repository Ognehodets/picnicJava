import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Picnic {
    public static void main(String[] args) {
        HashMap<String, Integer> allMealMap = new HashMap<>();
        String filePath = "input.txt";
        try {
            
            File file = new File(filePath);
            Scanner scanner = new Scanner(file);
            String allMealString = scanner.nextLine().toLowerCase().strip();
            allMealString = allMealString.replace("\n", " ").replace("  ", " ").strip();
            allMealString = allMealString.replace("  ", " ").strip();
            // System.out.println(allMealString);

            String[] allMealArray = allMealString.split(" ");
            // System.out.println(Arrays.toString(allMealArray));
            System.out.println(String.format("There are %d words in file named %s.", allMealArray.length, filePath));

            String longestWord = "";
            int longestWordLength = 0;

            for (int i = 0; i < allMealArray.length; i++) {
                if (allMealArray[i].length() > longestWordLength) {
                    longestWordLength = allMealArray[i].length();
                    longestWord = allMealArray[i];
                }
                if (allMealMap.containsKey(allMealArray[i])) {
                    int curQuantity = allMealMap.get(allMealArray[i]);
                    allMealMap.put(allMealArray[i], curQuantity + 1);
                } else {
                    allMealMap.put(allMealArray[i], 1);
                }
            }

            // System.out.println(allMealMap);

            System.out.println(String.format("There longest word is %s, its length is %d letters.", longestWord,
                    longestWordLength));

            for (var meal : allMealMap.entrySet()) {
                System.out.println(
                        String.format("The kind of food %s occurs in file %d times.", meal.getKey(), meal.getValue()));
            }

            scanner.close();
        } catch (IOException e) {
            System.out.println("Some problem with opening/reading file!");
        }
    }

}