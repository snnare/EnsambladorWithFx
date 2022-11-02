module com.example.ensambladorwithfx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.ensambladorwithfx to javafx.fxml;
    exports com.example.ensambladorwithfx;
}