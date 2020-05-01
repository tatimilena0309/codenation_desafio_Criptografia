package challenge;

public class CriptografiaCesariana implements Criptografia {

    String alfabeto = "abcdefghijklmnopqrstuvwxyz";
    int chave = 3;
    StringBuilder retorno;
    char letra;

    @Override
    public String criptografar(String texto) {

        if (validarTexto(texto)) {
            retorno = new StringBuilder();
            texto = texto.toLowerCase();

            for (int i = 0; i < texto.length(); i++) {

                letra = texto.charAt(i);

                if (Character.isAlphabetic(letra)) {

                    for (int j = 0; j < alfabeto.length(); j++) {

                        if (texto.charAt(i) == alfabeto.charAt(j)) {

                            if (j + chave > alfabeto.length() - 1) {
                                retorno.append(alfabeto.charAt(((alfabeto.length() - 1) + (j + chave)) + 1));

                            } else {
                                retorno.append(alfabeto.charAt((j + chave)));
                            }
                        }
                    }
                } else {
                    retorno.append(letra);
                }
            }
        }
        return retorno.toString();
    }

    @Override
    public String descriptografar(String texto) {

        if (validarTexto(texto)) {
            texto = texto.toLowerCase();
            retorno = new StringBuilder();

            for (int i = 0; i < texto.length(); i++) {

                letra = texto.charAt(i);

                if (Character.isAlphabetic(letra)) {

                    for (int j = 0; j < alfabeto.length(); j++) {

                        if (texto.charAt(i) == alfabeto.charAt(j)) {

                            if (j - chave < 0) {
                                retorno.append(alfabeto.charAt(((alfabeto.length() - 1) + (j - chave)) + 1));

                            } else {
                                retorno.append(alfabeto.charAt((j - chave)));
                            }
                        }
                    }
                } else {
                    retorno.append(letra);
                }
            }
        }
        return retorno.toString();
    }

   public boolean validarTexto(String texto){
       if (texto.isEmpty()) {
           throw new IllegalArgumentException("Nenhum texto encontrado!");
       }
       if ((texto.equals(null))) {
           throw new NullPointerException("Erro, objeto nulo!");
       }
       return true;
   }
}

