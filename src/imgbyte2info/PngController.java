package imgbyte2info;
public class PngController {

    public PngController() {
    }
    
    public String getFormat(byte[] byte_array){
        String stringBuilder = "";
        for(int i=1; i<4; i++ ){
            String t = Integer.toString(byte_array[i],16).replace("-","");

            StringBuilder output = new StringBuilder();
            for (int c = 0; c < t.length(); c+=2) {
                String str = t.substring(c, c+2);
                output.append((char)Integer.parseInt(str, 16));
                stringBuilder += output;
            }
        }
        return stringBuilder;
    }
    
    public String getTipoTons(byte[] byte_array){
    //A posição 25 do cabeçalho indica o tipo de tons.
        String tipo = Integer.toString(byte_array[25],16).replace("-","");
        while(tipo.length()<2){
            tipo = "0"+ tipo;
        }
        if(Integer.parseInt(tipo) == 0){
            return "grayscale";
        }
        else if(Integer.parseInt(tipo) == 2){
            return "rgb";
        }
        else if(Integer.parseInt(tipo) == 3){
            return "palette index";
        }
        else if(Integer.parseInt(tipo) == 4){
            return "grayscale with alpha";
        }
        else if(Integer.parseInt(tipo) == 6){
            return "rgba";
        }
        else{
            return "undefined";
        }
    }
    
    public Integer getAltura(byte[] byte_array){
        String stringBuilder = "";        
        //Os itens presentes entre as posições 21 à 24 indicam a Altura em pixels da imagem.
        for(int i=20; i<24; i++ ){
            String t = Integer.toString(byte_array[i],16).replace("-","");
            while(t.length()<2){
                t="0"+t;
            }
            stringBuilder += t;
        }
        
        return Integer.parseInt(stringBuilder, 16);
    }
    
    public Integer getLargura(byte[] byte_array){
        String stringBuilder = "";
        
        //Os itens presentes entre as posições 16 à 20 indicam a Largura em pixels da imagem.
        for(int i=16; i<20; i++ ){
            String t = Integer.toString(byte_array[i],16).replace("-","");
            while(t.length()<2){
                t="0"+t;
            }
            stringBuilder += t;
        }
        
        return Integer.parseInt(stringBuilder, 16);
    }
}
