/*
 * Gokhan Has - 161044067
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


public class MyHashMap {

    public static void main(String[] args) throws IOException {

        String dir = "./dataset/";
        NLP nlp = new NLP();
        nlp.readDataset(dir);
        System.out.print("//////// nlp.printWordMap \\\\\\\\\\\\\\\\");
        nlp.printWordMap();
        System.out.println("\\\\\\\\\\\\\\\\ end.printWordMap ////////");
        System.out.println();


        test(nlp);
    }

    public static void test(NLP testNLP) throws IOException {

        String fileName = "./src/input.txt";

        BufferedReader readFile = new BufferedReader(new FileReader(fileName));
        try {
            String fileString = new String();
            String tempString = readFile.readLine();
            while(tempString != null) {
                if(!(tempString == null))
                    fileString += tempString + "\n";
                tempString = readFile.readLine();
            }

            fileString = fileString.trim().replaceAll("\\p{Punct}", "");
            fileString = fileString.trim().replaceAll("\n", " ");
            fileString = fileString.trim().replaceAll(" +", " ");

            String[] words = fileString.split(" ");

            for(int i=0;i<words.length;++i) {

                if(words[i].contains("bigram")) {
                    String temp = words[i+1];
                    System.out.println(testNLP.bigrams(temp));
                    ++i;
                }
                else if(words[i].contains("tfidf")){
                    String word = words[i+1];
                    String filePath = words[i+2];
                    System.out.println(testNLP.tfIDF(word,filePath));
                    i += 2;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            readFile.close();
        }
    }
}
