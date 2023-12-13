public class Aeropuerto {
    private String codigo;
    private String nombre;
    private String poblacion;
    private String pais;
    private String GMT;

    public Aeropuerto(String codigo, String nombre, String poblacion, String pais, String GMT) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.poblacion = poblacion;
        this.pais = pais;
        this.GMT = GMT;
    }

    public String getCode() {
        return codigo;
    }

    public void setCode(String code) {
        this.codigo = code;
    }

    public String getName() {
        return nombre;
    }

    public void setName(String name) {
        this.nombre = name;
    }

    public String getPopulation() {
        return poblacion;
    }

    public void setPopulation(String population) {
        this.poblacion = population;
    }

    public String getCountry() {
        return pais;
    }

    public void         setCountry(String country) {
        this.pais = country;
    }

    public String getGMT() {
        return GMT;
    }

    public void setGMT(String GMT) {
        this.GMT = GMT;
    }

    public void showInfo(){
        System.out.println(getCode());
    }
}
