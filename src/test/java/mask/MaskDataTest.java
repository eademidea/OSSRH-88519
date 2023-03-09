package mask;

import org.junit.Assert;
import org.junit.Test;

import static mask.DataMask.dataMasking;
import static org.junit.Assert.assertNotNull;

public class MaskDataTest {

    /**
     * Verifica comportamento padrão de mascaramento de dado do método dataMasking.
     */
    @Test
    public void checkMask(){
       String nameMask = "Er**mo";

        Assert.assertTrue(dataMasking("Erasmo").equals(nameMask));;
    }

    /**
     * Verifica comportamento do método dataMasking com a passagem de parâmetro vazio
     */
    @Test(expected = RuntimeException.class)
    public void checkStringNull(){
        dataMasking("");
    }



}
