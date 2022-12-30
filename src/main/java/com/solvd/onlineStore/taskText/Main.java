package com.solvd.onlineStore.taskText;


import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Map<String, Integer> dictionary = new HashMap<>();
        List<String> strings = Arrays.asList("Java", "respectively", "random");

        String text = FileUtils.readFileToString(new File("src/main/resources/text.txt"), Charset.defaultCharset());
        strings.forEach(t -> dictionary.put(t, StringUtils.countMatches(text, t)));

        FileUtils.writeLines(new File("src/main/resources/output.txt"), dictionary.entrySet());
    }
}
