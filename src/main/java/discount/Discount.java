package discount;

import java.math.BigDecimal;
import java.math.*;
import java.text.DecimalFormat;

import static org.apache.commons.lang3.ObjectUtils.isEmpty;

/**
 * @author erica
 * @version 0.0.1
 */
public class Discount {


    /**
     * Devolve o valor do desconto baseado no valor inicial
     * Exemplo:
     * 10% de 100 = 10
     * Devolve o valor 10
     */

    public BigDecimal getValuePercent(BigDecimal valueInitial,BigDecimal percentDiscount){

        handleWhenValueInitialIsNull(valueInitial);
        handleWhenPercentDiscountIsNull(percentDiscount);
        BigDecimal valueDiscount   = BigDecimal.ZERO;

        BigDecimal resultadoinicial = new BigDecimal(String.valueOf(valueDiscount = valueInitial.multiply(percentDiscount)));
        valueDiscount = resultadoinicial.divide(new BigDecimal(100));
        BigDecimal finishValue = new BigDecimal(String.valueOf(valueDiscount.setScale(2, RoundingMode.FLOOR)));
        return finishValue;


    }

    /**
     * Devolve o valor subtraído do desconto
     * Exemplo:
     * valor inicial = 100
     * 10% de 100 = 10
     * valor com desconto= 90
     * Devolve valor 90
     */

    public BigDecimal getDiscountedValue(BigDecimal valueInitial,BigDecimal percentDiscount){
        handleWhenValueInitialIsNull(valueInitial);
        handleWhenPercentDiscountIsNull(percentDiscount);
        BigDecimal valueDiscount = getValuePercent(valueInitial,percentDiscount);
       BigDecimal discountedValue = valueInitial.subtract(valueDiscount);
       BigDecimal value= new BigDecimal(String.valueOf(discountedValue.setScale(2, RoundingMode.FLOOR)));

        return value;


    }


/**
 * Verifica se parâmetro recebido é válido
 */
    private static void handleWhenValueInitialIsNull(BigDecimal valueInitial) {
        if (isEmpty(valueInitial)) {
            throw new RuntimeException("Valor Inicial informado é vazio ou nulo.");
        }
    }
    private static void handleWhenPercentDiscountIsNull(BigDecimal percentDiscount) {
        if (isEmpty(percentDiscount)) {
            throw new RuntimeException("Porcentagem de desconto informada é vazio ou nulo.");
        }
    }
}
