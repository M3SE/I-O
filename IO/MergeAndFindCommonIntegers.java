package IO;

import java.io.*;
import java.util.*;

public class MergeAndFindCommonIntegers {

    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        List<Integer> mergedList = new ArrayList<>();
        Set<Integer> commonSet = new HashSet<>();

        try {

            BufferedReader br1 = new BufferedReader(new FileReader("input1.txt"));
            String line;
            while ((line = br1.readLine()) != null) {
                try {
                    int num = Integer.parseInt(line);
                    list1.add(num);
                } catch (NumberFormatException e) {
                    System.out.println("Caught a NumberFormatException: Skipping invalid number format in input1.txt: " + line);
                }
            }
            br1.close();

            BufferedReader br2 = new BufferedReader(new FileReader("input2.txt"));
            while ((line = br2.readLine()) != null) {
                try {
                    int num = Integer.parseInt(line);
                    list2.add(num);
                } catch (NumberFormatException e) {
                    System.out.println("Caught a NumberFormatException: Skipping invalid number format in input2.txt: " + line);
                }
            }
            br2.close();


            mergedList.addAll(list1);
            mergedList.addAll(list2);


            Set<Integer> set1 = new HashSet<>(list1);
            Set<Integer> set2 = new HashSet<>(list2);
            for (Integer num : set1) {
                if (set2.contains(num)) {
                    commonSet.add(num);
                }
            }


            BufferedWriter bwMerged = new BufferedWriter(new FileWriter("merged.txt"));
            for (Integer num : mergedList) {
                bwMerged.write(num.toString());
                bwMerged.newLine();
            }
            bwMerged.close();


            BufferedWriter bwCommon = new BufferedWriter(new FileWriter("common.txt"));
            for (Integer num : commonSet) {
                bwCommon.write(num.toString());
                bwCommon.newLine();
            }
            bwCommon.close();

            System.out.println("Merging and finding common integers completed successfully.");

        } catch (FileNotFoundException e) {
            System.out.println("One of the input files was not found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("An I/O error occurred: " + e.getMessage());
        }
    }
}
