package Modelo;


import java.util.ArrayList;
import java.util.StringTokenizer;

public class Analizar {

    private ArrayList<String> lineas;
    private String archivo;

    public Analizar(ArrayList<String> archivo) {
        this.lineas = archivo;
    }

    public Analizar(String archivo) {
        this.archivo = archivo;
    }

    public ArrayList<String> separarArchivo() {
        lineas =  new ArrayList<>();
        StringTokenizer st = new StringTokenizer(this.archivo);

        while (st != null){
            System.out.println(st.nextToken());
            lineas.add(st.nextToken());
        }
        return lineas;
    }
}
