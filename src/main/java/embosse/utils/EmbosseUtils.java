package embosse.utils;

import java.util.Arrays;
import java.util.List;

import static org.apache.commons.lang3.StringUtils.split;
import static org.apache.commons.lang3.StringUtils.stripAccents;

/**
 * @author Conrado Jardim de Oliveira
 * @version 0.0.1
 * */
public class EmbosseUtils {
    public static List<String> getSplitedName(String name) {
        return Arrays.asList(split(stripAccents(name).toUpperCase(), " "));
    }
}
