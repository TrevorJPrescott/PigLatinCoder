package com.trevorpc.piglatincoder;

import android.text.TextUtils;
import android.util.Log;

import java.util.Arrays;
import java.util.List;

public class WordConverter
{
    String input;

    public WordConverter(String input) {
        this.input = input;
    }

    public String getInput() {
        return input;
    }
    public void setInput(String input) {
        this.input = input;
    }

    public String pigLatin()
    {
        input = input.toLowerCase();
        String[] words = input.split(" ");
        input ="";

        for(int x = 0; x < words.length; x++)
        {
            Log.d("TAG", "pigLatin: "+words[x]);

            if (words[x].length() ==1)
            {
                words[x] = words[x].concat("ay ");
            }
            else
                {
                int cluster = CombinedSound(words[x]);
                String start = words[x].substring(0,cluster);
                String end = words[x].substring(cluster);
                end = end.substring(0,1).toUpperCase().concat(end.substring(1));
                words[x] = end.concat(start).concat("ay ");

                }
            Log.d("TAG", "pigLatin: "+words[x]);
            input = input + words[x];
        }

        return input;
    }

    public int CombinedSound(String word)
    {   String[] Three = {"str","thr","shr","skr","spl","spr","str","skw","squ"};
        String[] Two = {"pl","pr","bl","br","tr","dr","kl","kr","gl","gr"
        ,"fl","fr","sk","sl","sm","sn","sp","st","sw","tw","dw","kw","gw","qu"};


        if(word.length()<3) { return 1;}
        List<String> LThree = Arrays.asList(Three);
        if(word.length()<2) { return 1;}
        List<String> LTwo = Arrays.asList(Two);

        if(LThree.contains(word.substring(0,3))) {return 3;}

        if(LTwo.contains(word.substring(0,2))) {return 2;}

        return 1;
    }




}
