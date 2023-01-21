module com.example.conuhacks {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.jfoenix;


    opens com.example.conuhacks to javafx.fxml;
    exports com.example.conuhacks;

}
