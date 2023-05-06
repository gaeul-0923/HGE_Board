package com.classboard.common;

import java.util.*;

public class CommUtill {
  public static String separateParticle(String word, List<String> particles) {
    //String[] particles = {"은", "는", "이", "가", "을", "를", "으로", "에서"};
    String particle = "";

    for (String p : particles) {
      if (word.endsWith(p)) {
        particle = p;
        break;
      }
    }

    return particle;
  }

  public static Map<String, Integer> findDuplicateElements(String[] array1, String[] array2) {
    Map<String, Integer> frequencyMap1 = createFrequencyMap(array1);
    Map<String, Integer> frequencyMap2 = createFrequencyMap(array2);

    Map<String, Integer> duplicateElements = new HashMap<>();

    // array1의 요소를 기준으로 중복된 요소와 중복된 빈도를 추출
    for (Map.Entry<String, Integer> entry : frequencyMap1.entrySet()) {
      String element = entry.getKey();
      int frequency1 = entry.getValue();
      int frequency2 = frequencyMap2.getOrDefault(element, 0);

      if (frequency2 > 0) {
        int duplicateFrequency = Math.min(frequency1, frequency2);
        duplicateElements.put(element, duplicateFrequency);
      }
    }

    return duplicateElements;
  }

  public static Map<String, Integer> createFrequencyMap(String[] array) {
    Map<String, Integer> frequencyMap = new HashMap<>();

    for (String element : array) {
      frequencyMap.put(element, frequencyMap.getOrDefault(element, 0) + 1);
    }

    return frequencyMap;
  }
}
