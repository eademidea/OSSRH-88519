package mask;

import org.junit.Test;

import static mask.DataMask.dataMasking;
import static org.junit.Assert.assertNotNull;

public class MaskDataTest {

    /**
     * Verifica comportamento padrão do método dataMasking.
     */
    @Test
    public void checkMask(){
       dataMasking("Erica Martins Olegario");
    }

    /**
     * Verifica comportamento do método dataMasking com a passagem de parâmetro vazio
     */
    @Test(expected = RuntimeException.class)
    public void checkStringNull(){
        dataMasking("");
    }



    /**
     * Espero que o retorno do método dataMasking não seja nulo.
     */
    @Test
    public void checkReturnDataMasking() {

        assertNotNull(dataMasking("envelope"));

    }
}
