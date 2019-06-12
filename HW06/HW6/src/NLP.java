/*
 * Gokhan Has - 161044067
 */

import jdk.swing.interop.SwingInterOpUtils;

import java.io.*;
import java.util.*;

public class NLP {

    public Word_Map wmap = new Word_Map();

    /*You should not use File_Map class in this file since only word hash map is aware of it.
    In fact, you can define the File_Map class as a nested class in Word_Map,
     but for easy evaluation we defined it separately.
     If you need to access the File_Map instances, write wrapper methods in Word_Map class.
    * */

    /*Reads the dataset from the given dir and created a word map */
    public void readDataset(String dir) throws IOException {

        File folder = new File(dir);
        File[] listOfFiles = folder.listFiles();
        ArrayList<String> fileNames = new ArrayList<String>();

        for (File file : listOfFiles) {
            if (file.isFile())
                fileNames.add(file.getName());
        }
        totalFile = (float) fileNames.size();

        for(int i=0; i< fileNames.size(); ++i) {

            BufferedReader readFile = new BufferedReader(new FileReader(folder.getCanonicalPath()+ "/" + fileNames.get(i)));
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
                for(int index=0; index < words.length; ++index ) {
                    if((wmap.containsKey(words[index])))
                        isSameValues(words,index,i,fileNames);
                    else
                        notSameValues(words,index,i,fileNames);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                readFile.close();
            }
        }
    }

    private void notSameValues(String[] words,int index,int i,ArrayList<String> fileNames) {
        File_Map file_map = new File_Map();
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        arrayList.add(index);
        file_map.put(fileNames.get(i),arrayList);
        wmap.put(words[index],file_map);
    }

    /*Finds all the bigrams starting with the given word*/
    public List<String> bigrams(String word) throws IOException {

        if(wmap == null && !wmap.containsKey(word))
            throw new NullPointerException("Word Does Not Exist In Wmap or Does Not Create");

        List<String> returnList = new ArrayList<String>();
        File_Map file_map = (File_Map) wmap.get(word);
        TreeSet nameArrayList = (TreeSet) file_map.keySet();
        Object[] nameArray = nameArrayList.toArray();
        ArrayList valuesList = (ArrayList) file_map.values();

        int k=0;
        while(k < nameArrayList.size()) {

            ArrayList tempValue = (ArrayList) valuesList.get(k);

            BufferedReader readFile = new BufferedReader(new FileReader("dataset\\" + (String)nameArray[k]));
            try {
                String fileString = new String();
                String tempString = readFile.readLine();
                while (tempString != null) {
                    if (!(tempString == null))
                        fileString += tempString + "\n";
                    tempString = readFile.readLine();
                }

                fileString = fileString.trim().replaceAll("\\p{Punct}", "");
                fileString = fileString.trim().replaceAll("\n", " ");
                fileString = fileString.trim().replaceAll(" +", " ");

                String[] words = fileString.split(" ");
                int count = 0;
                while(count < tempValue.size() && (words.length > (int)tempValue.get(count) + 1)) {
                    if(returnList.contains(word + " " + words[(int) tempValue.get(count) + 1]));
                    else
                        returnList.add(word + " " + words[(int) tempValue.get(count) + 1]);
                    count++;
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                readFile.close();
            }
            ++k;
        }
        return returnList;
    }

    /*Calculates the tfIDF value of the given word for the given file */
    public float tfIDF(String word, String fileName) throws IOException {

        File_Map file_map = (File_Map) wmap.get(word);
        float timesWord = (float)((ArrayList) file_map.get(fileName)).size();
        float timesInFile = (float)file_map.values().size();
        float TFt=0f,IDFt = 0f;

        BufferedReader readFile = new BufferedReader(new FileReader("dataset\\" + fileName));
        try {
            String fileString = new String();
            String tempString = readFile.readLine();
            while (tempString != null) {
                if (!(tempString == null))
                    fileString += tempString + "\n";
                tempString = readFile.readLine();
            }

            fileString = fileString.trim().replaceAll("\\p{Punct}", "");
            fileString = fileString.trim().replaceAll("\n", " ");
            fileString = fileString.trim().replaceAll(" +", " ");

            String[] words = fileString.split(" ");
            float wordsCount = (float) words.length;
            TFt = timesWord / wordsCount;
            IDFt = (float) Math.log(totalFile / timesInFile );

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            readFile.close();
        }
        return TFt * IDFt;
    }

    /*Print the WordMap by using its iterator*/
    public  void printWordMap() {
        Iterator iter = wmap.iterator();
        System.out.println();
        while(wmap.hasNext()) {
            Object temp = (String)iter.next();
            System.out.print(temp + ", ");
        }
        System.out.println();
    }

    private void isSameValues(String[] words,int index,int i,ArrayList<String> fileNames) {
        File_Map file_map = (File_Map) (wmap.get(words[index]));
        if(!file_map.containsKey(fileNames.get(i))) {
            ArrayList<Integer> arrayList = new ArrayList<>();
            arrayList.add(index);
            file_map.put(fileNames.get(i),arrayList);
            wmap.put(words[index],file_map);
            return;
        }
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        arrayList = sameArraylist(words,index,i,fileNames);
        arrayList.add(index);
        file_map.put(fileNames.get(i),arrayList);
        wmap.put(words[index],file_map);
    }

    private boolean ifItHasSpace(String word) {

        char[] stringToCharArray = word.toCharArray();
        boolean control = false;

        for(char index: stringToCharArray) {
            if(index == ' ');
                control = true;
        }
        return control;
    }
    private float totalFile;
    private ArrayList<Integer> sameArraylist(String[] words,int index,int i,ArrayList<String> fileNames) {
        return new ArrayList<Integer>((ArrayList<Integer>) ((File_Map)wmap.get(words[index])).get(fileNames.get(i)));
    }
}
