package embosse.format_name;

import java.util.List;

import static embosse.utils.EmbosseUtils.getSplitedName;
import static org.apache.commons.lang3.ObjectUtils.isEmpty;
import static org.apache.commons.lang3.StringUtils.stripAccents;

public class NameFormaterImpl implements NameFormater {

    /**
     * Devolve nome formatado por exemplo:
     * <p>
     * "Ricardo Alves Siqueira Neto" passa ser "Ricardo A S Neto"
     */
    @Override
    public String formatName(String name) {
        handleWhenNameIsNull(name);
        StringBuilder newName = new StringBuilder();
        if (name.length() <= 20) {
            return stripAccents(name).toUpperCase();
        }
        List<String> splitedName = getSplitedName(name);
        if (splitedName.get(0).length() >= 18) {
            return splitedName.get(0).substring(0, 20);
        }
        String formatedName = "";
        if (name.length() > 20) {
            switch (splitedName.size()) {
                case 1:
                    formatedName = NameLengthEnum.ONE.getFormatedName(splitedName);
                    break;
                case 2:
                    formatedName = NameLengthEnum.TWO.getFormatedName(splitedName);
                    break;
                default:
                    formatedName = NameLengthEnum.MORE_THAN_TWO.getFormatedName(splitedName);
                    break;
            }
        }
        if (formatedName.toString().length() > 20) {
            List<String> names = getSplitedName(formatedName);

            names.forEach(na -> {

                if (na.equals(names.get(1))) {
                } else if (na.equals(names.get(0))) {
                    newName.append(na);
                } else if (na.equals(names.size() - 1)) {
                    newName.append(na);
                } else {
                    newName.append(" " + na);
                }

            });

            return formatName(newName.toString());
        }
        return newName.toString().equals("") ? formatedName : newName.toString();
    }

    private static void handleWhenNameIsNull(String name) {
        if (isEmpty(name)) {
            throw new RuntimeException("Nome informado é vazio ou nulo.");
        }
    }

}
