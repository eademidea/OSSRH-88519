package embosse.format_name;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class NameFormaterTest {

    private NameFormaterImpl nameFormater;

    @Before
    public void init() {
        nameFormater = new NameFormaterImpl();
    }

    @Test
    public void doTestMethodFormatNameWithOneName() {
        String name = nameFormater.formatName("Nicoangelonatieleodóroliemagnum");
        assertTrue(name.length() <= 20 && name.equals("Nicoangelonatieleodo"));
    }

    @Test
    public void doTestMethodFormatNameWithTwoNames() {
        String name = nameFormater.formatName("Nicoangelonatieleodóroliemagnum Deodóro");
        assertTrue(name.length() <= 20 && name.equals("Nicoangelonatieleodo"));
    }

    @Test
    public void doTestMethodFormatNameWithTwoNamesStep2() {
        String name = nameFormater.formatName("Nicoangelonatiele Deodóro");
        assertTrue(name.length() <= 20 && name.equals("Nicoangelonatiele"));
    }

    @Test
    public void doTestMethodFormatNameWithThreeNames() {
        String name = nameFormater.formatName("Mathìas Ângelo Deodóro");
        assertTrue(name.length() <= 20 && name.equals("Mathias A Deodoro"));
    }

    @Test
    public void doTestMethodFormatNameWithFourNames() {
        String name = nameFormater.formatName("Micaelli Marques Andrade Lithieri");
        assertTrue(name.length() <= 20 && name.equals("Micaelli A Lithieri"));
    }

    @Test
    public void doTestMethodFormatNameWithFiveNames() {
        String name = nameFormater.formatName("Ana Yan Micaelli Marques Lithieri");
        assertTrue(name.length() <= 20 && name.equals("Ana Y M M Lithieri"));
    }

    @Test
    public void doTestMethodFormatNameWithFiveNamesButNameLengthIsLessThan20Characteres() {
        String name = nameFormater.formatName("Ana Yàn Mi Jum Söng");
        assertTrue(name.length() <= 20 && name.equals("Ana Yan Mi Jum Song"));
    }

    @Test(expected = RuntimeException.class)
    public void doThrowErrorWhenCallMethodFormatName() {
        nameFormater.formatName("");
    }

    @Test(expected = RuntimeException.class)
    public void doThrowErrorWhenCallMethodFormatName2() {
        nameFormater.formatName(null);
    }

}
