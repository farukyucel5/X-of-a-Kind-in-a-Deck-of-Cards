package deck;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class X__of_a_Kind {
    public static void main(String[] args) {
        /*
You are given an integer array deck where deck[i] represents the number written on the ith card.

Partition the cards into one or more groups such that:

Each group has exactly x cards where x > 1, and
All the cards in one group have the same integer written on them.
Return true if such partition is possible, or false otherwise.



Example 1:

Input: deck = [1,2,3,4,4,3,2,1]
Output: true
Explanation: Possible partition [1,1],[2,2],[3,3],[4,4].
Example 2:

Input: deck = [1,1,1,2,2,2,3,3]
Output: false
Explanation: No possible partition.
         */

        int[] deck={1,2,3,4,4,3,2,1,1,2,3,4};
        Arrays.sort(deck);

        List<Integer>parsed_form=conver_to_list(deck);

        partition_check(parsed_form);
    }

    public static void partition_check(List<Integer> parsed_form) {
        int count=0;
        List<List>  list_of_parts=new ArrayList<>();
        for (int i = 0; i < parsed_form.size(); i++) {

            List<Integer> partition=new ArrayList<>();

            for (int j = 0; j < parsed_form.size(); j++) {
                if (parsed_form.get(i).equals(parsed_form.get(j))) {
                    partition.add(parsed_form.get(j));
                }
            }

            if (!list_of_parts.contains(partition))
                    list_of_parts.add(partition);
        }
        int flag1=0;

        for (int i = 0; i < list_of_parts.size(); i++) {
            for (int j = 1; j < list_of_parts.size(); j++) {
                if (list_of_parts.get(i).size()!=list_of_parts.get(j).size())
                    flag1++;
            }
        }
        if (flag1==0)
            System.out.println("Possible partition: "+list_of_parts);
        else
            System.out.println(" No possible partition!!");
    }
    public static List<Integer> conver_to_list(int[] deck) {

        List<Integer> deck_list=new ArrayList<>();
        for (int each:deck) {
            deck_list.add(each);
        }
       return deck_list;
    }
}
