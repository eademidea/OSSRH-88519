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
        assertTrue(name.length() <= 20 && name.equals("Nicoangelonatieleodo".toUpperCase()));
    }

    @Test
    public void doTestMethodFormatNameWithTwoNames() {
        String name = nameFormater.formatName("Nicoangelonatieleodóroliemagnum Deodóro");
        assertTrue(name.length() <= 20 && name.equals("Nicoangelonatieleodo".toUpperCase()));
    }

    @Test
    public void doTestMethodFormatNameWithTwoLastNameBig() {
        String name = nameFormater.formatName("Tatiane Nicoangelonatieleodóroliemagnum");
        assertTrue(name.length() <= 20 && name.equals("TATIANE N"));
    }

    @Test
    public void doTestMethodFormatNameWithTwoNamesStep2() {
        String name = nameFormater.formatName("Nicoangelonatiele Deodóro");
        assertTrue(name.length() <= 20 && name.equals("Nicoangelonatiele D".toUpperCase()));
    }

    @Test
    public void doTestMethodFormatNameWithThreeNames() {
        String name = nameFormater.formatName("Mathìas Ângelo Deodóro");
        assertTrue(name.length() <= 20 && name.equals("Mathias A Deodoro".toUpperCase()));
    }

    @Test
    public void doTestMethodFormatNameWithThreeBigNames() {
        String name = nameFormater.formatName("Nicoangelonatieleodóroliemagnum Damine Nicoangelonatieleodóroliemagnum");
        assertTrue(name.length() <= 20 && name.equals("Nicoangelonatieleodo".toUpperCase()));
    }

    @Test
    public void doTestMethodFormatNameWithFourBigNames() {
        String name = nameFormater.formatName("Nicoangelonatieleodóroliemagnum Nicoangelonatieleodóroliemagnum " +
                "Nicoangelonatieleodóroliemagnum Nicoangelonatieleodóroliemagnum");
        assertTrue(name.length() <= 20 && name.equals("Nicoangelonatieleodo".toUpperCase()));
    }


    @Test
    public void doTestMethodFormatNameWithFourNames() {
        String name = nameFormater.formatName("Micaelli Marques Andrade Lithieri");
        assertTrue(name.length() <= 20 && name.equals("MICAELLI A LITHIERI"));
    }

    @Test
    public void doTestMethodFormatNameWithFiveNames() {
        String name = nameFormater.formatName("Ana Yan Micaelli Marques Lithieri");
        assertTrue(name.length() <= 20 && name.equals("ANA Y M M LITHIERI"));
    }

    @Test
    public void doTestMethodFormatNameWithFiveNamesButNameLengthIsLessThan20Characteres() {
        String name = nameFormater.formatName("Ana Yàn Mi Jum Söng");
        assertTrue(name.length() <= 20 && name.equals("ANA YAN MI JUM SONG"));
    }

    @Test
    public void doTestMethodFormatNameWithSixNames() {
        String name = nameFormater.formatName("Anabicalho Yan Micaelli Marques Lithiericurirthcup");
        assertTrue(name.length() <= 20 && name.equals("ANABICALHO L"));
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
