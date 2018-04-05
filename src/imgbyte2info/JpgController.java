package imgbyte2info;
public class JpgController {

    public JpgController() {
    }
    
    public String getFormat(byte[] byte_array){
        String strFinal = "";
        
        // os bytes 6, 7, 8 e 9 correspondem ao formato do arquivo
        for(int i=6; i<10; i++ ){
            String t = Integer.toString(byte_array[i],16).replace("-","");
            StringBuilder output = new StringBuilder();
            
            for (int c = 0; c < t.length(); c+=2) {
                String str = t.substring(c, c+2);
                output.append((char)Integer.parseInt(str, 16));
                strFinal += output;
            }
        }
        return strFinal;
    }
    
    public String getTipoTons(byte[] byte_array){
        String tipo = Integer.toString(byte_array[43],16).replace("-","");
        
        if(Integer.parseInt(tipo) == 1){
            return "grayscale";
        }
        else if(Integer.parseInt(tipo) == 3){
            return "rgb";
        }
        else{
            return tipo;
        }
    }
    
    public Integer getAltura(byte[] byte_array){
        String strFinal = "";        
        //Os itens presentes entre as posições 900 e 901 indicam a Altura em pixels da imagem.
        // só consigo pegar quando é menor que 100
        for(int i=900; i<901; i++ ){
            String t = Integer.toString(byte_array[i],16).replace("-","");
            strFinal += t;
        }
        
        return Integer.parseInt(strFinal, 16);
    }
    
    public Integer getLargura(byte[] byte_array){
        String strFinal = "";        
        //Os itens presentes entre as posições 902 e 904 indicam a Altura em pixels da imagem.
        for(int i=902; i<903; i++ ){
            String t = Integer.toString(byte_array[i],16).replace("-","");
            strFinal += t;
        }
        
        return Integer.parseInt(strFinal, 16);
    }
}
