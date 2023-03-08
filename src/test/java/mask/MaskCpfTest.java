package mask;

import org.junit.Test;

public class MaskCpfTest {
    @Test
    public void checkCPFMasking(){
        new CPFMask().cpfMasking("12345678910");
    }

    @Test(expected = RuntimeException.class)
    public void testNullParametersCpfMasking(){
        new CPFMask().cpfMasking("");
    }
    @Test(expected = RuntimeException.class)
    public void testInvalidParametersCpfMasking(){
        new CPFMask().cpfMasking("123456789102");

    }

}
