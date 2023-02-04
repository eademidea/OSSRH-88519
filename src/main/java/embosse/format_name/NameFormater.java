package embosse.format_name;

import java.util.List;

import static embosse.utils.EmbosseUtils.getSplitedName;
import static org.apache.commons.lang3.ObjectUtils.isEmpty;
import static org.apache.commons.lang3.StringUtils.stripAccents;

/**
 * @author Conrado Jardim de Oliveira
 * @version 0.0.1
 * */
public class NameFormater {

    private static final int INT = 20;

    /**
     * Devolve nome formatado por exemplo:
     * <p>
     * "Ricardo Alves Siqueira Neto" passa ser "RICARDO A NETO"
     */
    public static String formatName(String name) {
        handleWhenNameIsNull(name);
        StringBuilder newName = new StringBuilder();
        if (isLengthNameLessOrEqualMaxLength(name)) {
            return stripAccents(name).toUpperCase();
        }
        List<String> splitedName = getSplitedName(name);
        if (isFirstNameLengthLessThanMaxLengthMinusTwo(splitedName)) {
            return splitedName.get(0).substring(0, INT);
        }
        String formatedName = getFormatedName(name, splitedName);
        if (isFormatedNameLengthGreaterThanMaxLength(formatedName)) {
            List<String> names = getSplitedName(formatedName);
            fillNewName(newName, names);
            return formatName(newName.toString());
        }
        return newName.toString().equals("") ? formatedName : newName.toString();
    }

    private static String getFormatedName(String name, List<String> splitedName) {
        if (name.length() > INT) {
            switch (splitedName.size()) {
                case 1:
                    return NameLengthEnum.ONE.getFormatedName(splitedName);
                case 2:
                    return NameLengthEnum.TWO.getFormatedName(splitedName);
                default:
                    return NameLengthEnum.MORE_THAN_TWO.getFormatedName(splitedName);
            }
        }
        return null;
    }

    private static void fillNewName(StringBuilder newName, List<String> names) {
        names.forEach(name -> {
            if (name.equals(names.get(1))) {
            } else if (name.equals(names.get(0))) {
                newName.append(name);
            } else if (name.equals(names.size() - 1)) {
                newName.append(name);
            } else {
                newName.append(" " + name);
            }
        });
    }

    private static void handleWhenNameIsNull(String name) {
        if (isEmpty(name)) {
            throw new RuntimeException("Nome informado é vazio ou nulo.");
        }
    }

    private static boolean isFormatedNameLengthGreaterThanMaxLength(String formatedName) {
        return formatedName.length() > INT;
    }

    private static boolean isFirstNameLengthLessThanMaxLengthMinusTwo(List<String> splitedName) {
        return splitedName.get(0).length() >= INT - 2;
    }

    private static boolean isLengthNameLessOrEqualMaxLength(String name) {
        return name.length() <= INT;
    }

}
