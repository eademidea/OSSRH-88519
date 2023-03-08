package mask;
import discount.Discount;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class MaskDataTest {

    /**
     * Verifica comportamento padrão do método dataMasking.
     */
    @Test
    public void checkMask(){
       new DataMask().dataMasking("Erica Martins Olegario");
    }

    /**
     * Verifica comportamento do método dataMasking com a passagem de parâmetro vazio
     */
    @Test(expected = RuntimeException.class)
    public void checkStringNull(){
        new DataMask().dataMasking("");
    }

    /**
     * Verifica comportamento padrão do método insertX
     */
    @Test
    public  void checkInsertX(){
        new DataMask().insertX("Erica Martins Olegario");
    }

    /**
     * Espero que o retorno do método dataMasking não seja nulo.
     */
    @Test
    public void checkReturnDataMasking() {

        Assert.assertNotNull(new DataMask().dataMasking("envelope"));

    }
}
