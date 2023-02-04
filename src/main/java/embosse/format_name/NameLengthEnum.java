package embosse.format_name;

import java.util.List;

/**
 * @author Conrado Jardim de Oliveira
 * @version 0.0.1
 * */
public enum NameLengthEnum implements EmbosseNameFormater {

    ONE {
        @Override
        public String getFormatedName(List<String> splitedName) {
            return splitedName.get(0).substring(0, 20);
        }
    },
    TWO {
        @Override
        public String getFormatedName(List<String> splitedName) {
            return splitedName.get(0).concat(" ").concat(splitedName.get(1).substring(0, 1));
        }
    },
    MORE_THAN_TWO {
        @Override
        public String getFormatedName(List<String> splitedName) {
            StringBuilder formatedName = new StringBuilder();
            splitedName.forEach(name -> {
                if (formatedName.length() < 20) {
                    if (name.equals(splitedName.get(0))) {
                        formatedName.append(name);
                    } else if (!name.equals(splitedName.get(splitedName.size() - 1))) {
                        formatedName.append(" " + name.substring(0, 1));
                    } else {
                        formatedName.append(" " + name);
                    }
                }
            });
            return formatedName.toString();
        }
    };

}
