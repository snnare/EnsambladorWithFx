package com.example.ensambladorwithfx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;

import java.io.*;
import java.util.ArrayList;


public class VentanaController {

    @FXML
    private AnchorPane ASM;

    @FXML
    private Label lblASM;

    @FXML
    private Label lblSeparar;

    @FXML
    private Label lblTitulo;

    @FXML
    private TextArea txtArchivoASM;

    @FXML
    public TextArea txtSepararcion;
    private ArrayList<String> archivoCompleto;
    private String archivo;
    private  int total_paginas;
    private  int pagina_actual;
    private byte numLineasAImprimir = 15;


    @FXML
    void btnAtrasPagina(ActionEvent event) {
        if(pagina_actual > 1){
            pagina_actual--;
            mostrarArchivo(this.archivo);
        }
    }
    @FXML
    void btnSiguientePagina(ActionEvent event) {
        if(pagina_actual < total_paginas){
            pagina_actual++;
            mostrarArchivo(this.archivo);
        }
    }

    @FXML
    void btnAtrasSeparar(ActionEvent event) {


    }
    @FXML
    void btnSiguienteSeparar(ActionEvent event) {

    }

    @FXML
    void btnSelectFile(ActionEvent event) throws IOException
    {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Seleccione el archivo");
        fileChooser.setInitialDirectory(new File("C:\\"));
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("ASM","*.asm"),
                new FileChooser.ExtensionFilter("All Files","*.*"));

        File selectFile = fileChooser.showOpenDialog(null);
        if (selectFile.getName().endsWith(".asm")) {

            if (selectFile != null) {
                BufferedReader bufferedReader;
                try {
                    FileReader fileReader = new FileReader(selectFile);
                    bufferedReader = new BufferedReader(fileReader);
                    String aux = bufferedReader.readLine();
                    int valor = fileReader.read();

                    while (aux != null) {
                        archivo += aux + "\n";
                        archivoCompleto.add(archivo);
                        aux = bufferedReader.readLine();
                    }
                    armarArchivo(archivo);
                } catch (Exception e) {
                    Alert alert = new Alert(Alert.AlertType.ERROR, e.toString());
                }
            } else {
                System.out.println("File is not valid");
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Archivo Invalido");
            alert.show();
        }
    }

    @FXML
    void btnSeparar(ActionEvent event) {

    }

    public String getArchivo() {
        return archivo;
    }

    public void setArchivo(String archivo) {
        this.archivo = archivo;
    }

    public void armarArchivo(String archivo) {
        int cont = 1;
        total_paginas = 1;

        for (int i = 0; i < archivo.length(); i++)
        {
            if (archivo.charAt(i) == '\n')
            {
                if (cont == 15)
                {
                    total_paginas++;
                    cont = 1;
                }
                else
                {
                    cont++;
                }
            }
        }

        pagina_actual = 1;
        mostrarArchivo(archivo);
    }
    public void mostrarArchivo(String archivo)
    {
        int cont = 1;
        int renglon_objetivo = pagina_actual;
        int renglon_buscador = 1;
        String pagina = "";
        int i = 0;

        while (renglon_buscador < renglon_objetivo)
        {
            if (archivo.charAt(i) == '\n')
            {
                if (cont == numLineasAImprimir)
                {
                    renglon_buscador++;
                    cont = 1;
                }
                else
                {
                    cont++;
                }
            }
            i++;
        }


        while (renglon_buscador <= renglon_objetivo && i < archivo.length())
        {
            pagina += archivo.charAt(i);
            if (archivo.charAt(i) == '\n')
            {
                if (cont == numLineasAImprimir)
                {
                    renglon_buscador++;
                    cont = 1;
                }
                else
                {
                    cont++;
                }
            }
            i++;
        }
        //System.out.println(pagina);
        txtArchivoASM.setText(pagina);
    }

}
