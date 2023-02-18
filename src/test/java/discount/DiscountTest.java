package discount;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;


public class DiscountTest {


    /**
     * Espero que o comportamento do método returnValueDiscount não seja nulo
     * */
    @Test
    public void deveTestarOMetodoReturnValueDiscount() {

        Assert.assertNotNull(new Discount().getValuePercent(new BigDecimal(1000),new BigDecimal(10)));

    }

    @Test
    public void deveTestarOMetodoReturnDiscountedValue(){
        Assert.assertNotNull(new Discount().getDiscountedValue(new BigDecimal(1000),new BigDecimal(10)));
    }




}
