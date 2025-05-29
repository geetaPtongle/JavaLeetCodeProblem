package array;

import java.util.ArrayList;
import java.util.List;

public class FindWordsContaining {
    public List<Integer> findWordsContaining(String[] words, char targetChar) {
        List<Integer> indicesWithTargetChar = new ArrayList<>();

        // Iterate over the array of words.
        for (int index = 0; index < words.length; ++index) {
            // Check if the current word contains the target character.
            if (words[index].indexOf(targetChar) != -1) {
                // If it does, add the index of this word to the list.
                indicesWithTargetChar.add(index);
            }
        }
        // Return the list of indices.
        return indicesWithTargetChar;
    }

    public static void main(String[] args) {
        String[] words = {"leet", "code"};
        FindWordsContaining fwc = new FindWordsContaining();
        System.out.println(fwc.findWordsContaining(words, 'e'));
    }
}
