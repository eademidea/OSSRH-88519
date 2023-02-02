import java.util.List;

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
            return null;
        }
    },
    MORE_THAN_TWO {
        @Override
        public String getFormatedName(List<String> splitedName) {
            return null;
        }
    };

}
