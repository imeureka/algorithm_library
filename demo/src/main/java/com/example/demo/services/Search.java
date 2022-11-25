package com.example.demo.services;

import java.io.*;
import java.util.*;

public class Search
{
    String filePath = "C:\\Users\\user\\source\\demo (1)\\demo\\src\\BookData.csv";

    /**
     * Get data from CSV and store data into an ArrayList
     * @return ArrayList of library data
     */
    public ArrayList<String> readData()
    {
        ArrayList<String> data = new ArrayList<>();

        try
        {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), "euc-kr"));
            String currentLine;
            while((currentLine = reader.readLine()) != null)
            {
                data.add(currentLine);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        return data;
    }

    /**
     * Get an input from users
     * @return user input as String
     */
    public String getUserInput()
    {
        String userInput;
        Scanner scan = new Scanner(System.in);
        System.out.println("도서명 검색");
        userInput = scan.nextLine();

        return userInput;
    }

    /**
     * searchBook
     * @param bookTitle User input as a String (return value from getUserInput())
     * @param libraryData library data as an ArrayList (return value from readData())
     * @return list of books that has the sequence of the longest common substring
     */
    public ArrayList<String[]> searchBook(String bookTitle, ArrayList<String> libraryData)
    {
        int index1;
        int index2;
        int[][] matrix;
        int max = 0;

        ArrayList<String> sequence = new ArrayList<>();
        HashMap<String, Integer> result = new HashMap<>();

        // nested for loop to find sequences of user input
        for(int k = 0; k < bookTitle.length(); k++)
            for(int l = k + 1; l <= bookTitle.length(); l++)
            {
                String subs = bookTitle.substring(k, l);
                if(subs.length() >= 2)
                {
                    sequence.add(subs);
                }
            }


        // sort sequence arraylist in descending order
        sequence.sort(Comparator.comparing(String::length).reversed());

        // 1. LCS algorithm to find length of common substrings
        // 2. store book titles as keys and length of common substrings as values
        for(String seq : sequence)
        {
            for(String book : libraryData)
            {
                index1 = seq.length();
                index2 = book.length();
                matrix = new int[index1][index2];
                for(int i = 0; i < index1; i++)
                    for(int j = 0; j < index2; j++)
                    {
                        int val = -1;
                        if (seq.charAt(i) == book.charAt(j % 8))
                        {
                            if (i == 0 || j == 0)
                            {
                                matrix[i][j] = 1;
                            } else
                            {
                                matrix[i][j] = matrix[i - 1][j - 1] + 1;

                            }
                            if (max < matrix[i][j])
                            {
                                max = matrix[i][j];
                            }
                            val = matrix[i][j];
                            if(val == max)
                            {
                                result.put(book, val);
                            }
                            else if(val >= 2)
                            {
                                if(result.containsKey(book) == false)
                                {
                                    result.put(book, val);
                                }
                            }

                        }

                    }
            }
        }

        List<Map.Entry<String, Integer>> compList = new LinkedList<>(result.entrySet());
        ArrayList<String[]> output = new ArrayList<>();
        String[] tempp = new String[6];

        // comparator method for sorting (in descending order)
        compList.sort(new Comparator<Map.Entry<String, Integer>>()
        {
            @Override
            public int compare(Map.Entry<String, Integer> value1, Map.Entry<String, Integer> value2)
            {
                return value2.getValue() - value1.getValue();
            }

        });

        // print out the hashmap only if the value is larger than 1
        for(Map.Entry<String, Integer> entry : compList)
        {
            if(entry.getValue() > 1)
            {
                for(int i = 0; i < 6; i++)
                {
                    tempp = entry.getKey().split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
                }
                //System.out.println("value: " + entry.getValue() + " key: " + entry.getKey());


                output.add(tempp);

                for(int i = 0; i < output.size(); i++)
                {
                    for (int j = 0; j < 6; j++)
                    {
                        System.out.println(output.get(i)[j]);
                    }

                }
            }

        }
        return output;
    }
}
