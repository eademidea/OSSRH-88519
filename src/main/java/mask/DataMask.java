package mask;

import java.lang.String;

public class DataMask {

    public String dataMasking(String data) {


      String firstCharacters=data.substring(0,2);
      String lastCharacters =data.substring(data.length ()-2);

      String middleCharacters= data.substring(2,data.length()-2);
      String middleCharactersMask = insertX(middleCharacters);
      String newData=firstCharacters+middleCharactersMask+lastCharacters;


        return newData;
    }

    public String insertX(String data) {
        String dataMask = "";
        for (int i = 0; i <data.length(); i++) {

            dataMask+= "X";
        }

        return dataMask;
    }


}
