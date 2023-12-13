import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ListaAeropuerto{
    private List<Aeropuerto> aeropuertoList;

    public ListaAeropuerto(List<Aeropuerto> aeropuertoList) {
        this.aeropuertoList = aeropuertoList;
    }

    public ListaAeropuerto() {
        aeropuertoList = new ArrayList<>();
    }

    public List<Aeropuerto> getAeropuertoList() {
        return aeropuertoList;
    }

    public void listA(){
            String linea;
            String seccion = null;
            Aeropuerto aeropuerto;
            try (BufferedReader br = new BufferedReader(new FileReader("vuelos.txt"))) {
                while ((linea = br.readLine()) != null) {
                    linea = linea.trim();
                    if (linea.isEmpty()) {
                        continue;
                    }
                    if (linea.startsWith("#")) {
                        seccion = linea;
                        continue;
                    }
                    if ("#Aeropuertos".equals(seccion)) {
                        String[] tokens = linea.split(";");
                        if (tokens.length >= 5) {
                            String codigo = tokens[0];
                            String nombre = tokens[1];
                            String poblacion = tokens[2];
                            String pais = tokens[3];
                            String GMT = tokens[4];
                            aeropuerto = new Aeropuerto(codigo, nombre, poblacion, pais, GMT);
                            aeropuertoList.add(aeropuerto);
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
    }


    public String getNameByCode(String codigo){
        String nombre = "";
        for(Aeropuerto aeropuerto : aeropuertoList){
            if(codigo.equals(aeropuerto.getCode())){
                nombre = aeropuerto.getName();
            }
        }
        return nombre;
    }
}