import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ListaVuelos{
    private List<Vuelo> vueloList;

    public ListaVuelos(List<Vuelo> vueloList) {
        this.vueloList = vueloList;
    }

    public ListaVuelos() {
        vueloList = new ArrayList<>();
    }

    public List<Vuelo> getVueloList() {
        return vueloList;
    }

    public void listV(){
        String linea;
        String seccion = null;
        Vuelo vuelo;
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
                if ("#Vuelos".equals(seccion)) {
                    String[] tokens = linea.split(";");
                    if (tokens.length >= 9) {
                        String codigo = tokens[0];
                        String aeropuertoSalida = tokens[1];
                        String aeropuertoLlegada = tokens[2];
                        String duracion = tokens[3];
                        String compania = tokens[4];
                        String tipoAvion = tokens[5];
                        String plazas = tokens[6];
                        String opcional;
                        String horario;
                        if (codigo.equals("R")) {
                            opcional = tokens[8];
                            horario = tokens[7];
                        } else {
                            opcional = tokens[7];
                            horario = tokens[8];
                        }

                        vuelo = new Vuelo(codigo, aeropuertoSalida, aeropuertoLlegada, duracion, compania, tipoAvion, Integer.parseInt(plazas), opcional, horario);
                        vueloList.add(vuelo);
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
