package mask;
import org.junit.Test;

public class MaskDataTest {

    @Test
    public void checkMask(){
       new DataMask().dataMasking("Erica Martins Olegario");


    }
    @Test
    public  void checkInsertX(){
        new DataMask().insertX("Erica Martins Olegario");
    }
}
