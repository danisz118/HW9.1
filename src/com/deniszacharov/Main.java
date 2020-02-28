package com.deniszacharov;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    private static final String FILENAME = "/home/DN250194ZDE/IdeaProjects/hilleltask/HW9.1/urls.txt";

    public static void main(String[] args) throws FileNotFoundException {
        scanFile(FILENAME);

    }
    private static void scanFile(String filename) throws FileNotFoundException {
        Map<String, Integer> map = new HashMap<>();
        File file = new File(filename);
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String key = scanner.nextLine();
            Integer value = 1;
            if (map.containsKey(key)) {
                map.put(key, map.get(key) + value);
            } else {
                map.put(key, value);
            }
        }
        scanner.close();
        map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }
}
