package discount;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;


public class DiscountTest {


    /**
     * Deve testar se a possibilidade de passagem de parâmetros nulos no método getValuePercent()
     */
    @Test(expected = RuntimeException.class)
    public void testNullParametersGetValuePercent() {
        new Discount().getValuePercent(null, new BigDecimal(3.2)) ;
    }

    /**
     * Deve testar a lógica aplicada para gerar o valor de desconto
     * Exemplo:
     * 15 % de 1000 = 150
     **/
    @Test
    public void testGetValuePercent() {
        BigDecimal value = new BigDecimal(150.00);
        Assert.assertTrue (new Discount().getValuePercent(new BigDecimal(1000), new BigDecimal(15)).compareTo(value) == 0);
    }

    /**
     * Deve testar a possibilidade de passagem de parÂmetros nulos no método getDiscountedValue
     */

    @Test(expected = RuntimeException.class)
    public void testNullParametersGetDiscountedValue() {
         new Discount().getValuePercent(null, new BigDecimal(3.2) );
    }

    /**
     * Deve testar a lógica de cálculo para aplicação de desconto sobre um valor
     * 10% de 100 = 10
     * devolve 90 = 100 - 10
     */
    @Test
    public void testGetDiscountedValue() {
        BigDecimal value = new BigDecimal(90.00);
        Assert.assertTrue(new Discount().getDiscountedValue(new BigDecimal(100), new BigDecimal(10)).compareTo(value) == 0);
    }
}
