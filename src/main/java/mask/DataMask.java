package mask;

import java.lang.String;
import static org.apache.commons.lang3.ObjectUtils.isEmpty;
/**
 * @author erica
 */
public class DataMask {
    /**
     * Devolve uma string mascarada, sendo exibidos apenas os dois primeiros e os dois últimos caracteres
     * de maneira íntegra o restante da string é ocultada por um X em seus caracteres.
     * Exemplo:
     * String recebida: Cristina Caldeia
     * String devolvida: CrXXXXXXXXXXXXia
     */
    public String dataMasking(String data) {

        handleWhenStringIsNull(data);
      String firstCharacters=data.substring(0,2);
      String lastCharacters =data.substring(data.length ()-2);

      String middleCharacters= data.substring(2,data.length()-2);
      String middleCharactersMask = insertX(middleCharacters);
      String newData=firstCharacters+middleCharactersMask+lastCharacters;


        return newData;
    }

    /**
     * Devolve uma string com todos os seus caracteres substituídos por X.
     * Exemplo:
     * STring recebida: Envelope
     * String devolvida: XXXXXXXX
     */
    public String insertX(String data) {
        String dataMask = "";
        for (int i = 0; i <data.length(); i++) {

            dataMask+= "X";
        }

        return dataMask;
    }

    private static void handleWhenStringIsNull(String data){
        if(isEmpty(data)){
            throw new RuntimeException("Dado passado é vazio ou nulo");
        }
    }


}
