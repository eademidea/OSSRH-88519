package mask;

public class CPFMask extends DataMask{

    public String cpfMasking(String cpf){
        String newCpf ="";
        boolean isNumeric = (cpf != null && cpf.matches("[0-9]+"));
        if (isNumeric = false){
            throw new RuntimeException("CPF nulo, ou não contém somente números");
        }

        if(cpf.length()!= 11){
            throw new RuntimeException("CPF inválido.Número de algarismos menor que 11.");
        }else{
           newCpf=dataMasking(cpf);
        }
        System.out.println(newCpf);
        return newCpf;
    }
    @Override
    public String dataMasking(String data) {
        return super.dataMasking(data);
    }

    @Override
    public String insertX(String data) {
        return super.insertX(data);
    }
}
