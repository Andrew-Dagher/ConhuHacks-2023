module com.example.conuhacks {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.conuhacks to javafx.fxml;
    exports com.example.conuhacks;
}