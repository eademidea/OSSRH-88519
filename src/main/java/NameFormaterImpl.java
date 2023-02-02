import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.apache.commons.lang3.ObjectUtils.isEmpty;
import static org.apache.commons.lang3.StringUtils.*;

public class NameFormaterImpl implements NameFormater {

    /**
     * Devolve nome formatado por exemplo:
     * <p>
     * "Ricardo Alves Siqueira Neto" passa ser "Ricardo A. S. Neto"
     */
    public String formatName(String name) {
        if (isEmpty(name)) {
            throw new RuntimeException("Nome informado é vazio ou nulo.");
        }
        List<String> splitedName = Arrays.asList(split(stripAccents(name), " "));
        switch (splitedName.size()) {
            case 1:
                return NameLengthEnum.ONE.getFormatedName(splitedName);
            case 2:
                return NameLengthEnum.TWO.getFormatedName(splitedName);
            default:
                return NameLengthEnum.MORE_THAN_TWO.getFormatedName(splitedName);
        }
    }

}
