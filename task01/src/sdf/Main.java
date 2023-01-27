package sdf;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.AbstractMap;

public class Main {

  public static void main(String[] args) throws Exception {
    String fileName = args[0];

    FileReader fr = new FileReader(fileName);
    BufferedReader br = new BufferedReader(fr);

    Integer totalWords = 0;
    Map<String, Integer> wordMap = new HashMap<>();

    for (Integer i = 1; i <= 100; i++) {
      String line = br.readLine();
      if (null == line)
        break;
      String[] words = line.trim().split(" ");
      totalWords += words.length;
      for (String w : words) {
        String clearWord = w.replaceAll(",", "");
        Integer v = wordMap.getOrDefault(clearWord, 0);
        v++;
        wordMap.put(clearWord, v);
      }
    }

    br.close();
    fr.close();

    Set<String> uniqueWords = wordMap.keySet();

    PriorityQueue<Map.Entry<String, Double>> pq = new PriorityQueue<>((a, b) -> (int) (b.getValue() - a.getValue()));

    for (String w : uniqueWords) {
      double termFrequency = (double) wordMap.get(w) / totalWords;
      pq.add(new AbstractMap.SimpleEntry<>(w, termFrequency));
    }

    System.out.println("Top 10 words based on term frequency:");
    for (int i = 1; i <= 10; i++) {
      Map.Entry<String, Double> entry = pq.poll();
      System.out.println(i + ". " + entry.getKey() + " - " + entry.getValue());
    }
  }
}

