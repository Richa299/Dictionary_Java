import java.util.HashMap;
import java.io.*;

class Words{
    String wordname, meaning;
    Words(String wordname, String meaning){
        this.wordname=wordname;
        this.meaning=meaning;
    }
}


class Dictionary{
    HashMap<String, Words> map=new HashMap<String, Words>();
  public void loadRecords() throws Exception{
     BufferedReader br= new BufferedReader(new FileReader("Dictionary.txt"));
     for (String line=br.readLine(); line!=null; line=br.readLine()){
        String [] parsedLine=line.split(",");
        String wordname=parsedLine[0];
        String meaning=parsedLine[1];
        Words word=new Words(wordname, meaning);
        this.map.put(wordname, word);
     }
     br.close();
    }
    public String findWord(String Word){
        for(String i:map.keySet()){
            if(i.equals(Word)){
                Words newWord=map.get(i);
                return newWord.meaning;
            }
        }

     return null;
    }

    public void SaveRecords() throws Exception{
        BufferedWriter bw=new BufferedWriter(new FileWriter("newDictionary.txt"));
        for(String i:map.keySet()){
            Words w=map.get(i);
            bw.write(w.wordname);
            bw.write(",");
             bw.write(w.meaning);
              bw.write("\n");
        }
        bw.close();
    }
}



class Driver{
  public static void main(String args[]) throws Exception{
    Dictionary obj=new Dictionary();
    obj.loadRecords();
    System.out.print(obj.findWord("snooze"));
    obj.SaveRecords();
  }
}