package imgbyte2info;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class ImgByte2Info {
    public static void main(String[] args) throws IOException {
        PngController ctrl_png = new PngController();
        File png_image_file = new File("great.png");
        byte[] byte_array = Files.readAllBytes(png_image_file.toPath());
        
        System.out.println("Formato: " + ctrl_png.getFormat(byte_array));
        System.out.println("Tons: " + ctrl_png.getTipoTons(byte_array));
        System.out.println("Altura: " + ctrl_png.getAltura(byte_array));
        System.out.println("Largura: " + ctrl_png.getLargura(byte_array));
    }
}
