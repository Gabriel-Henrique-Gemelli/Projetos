module workshopJavaFX {
	requires javafx.controls;
	requires javafx.fxml;
	
	opens application to javafx.graphics, javafx.fxml;
	opens gui to javafx.fxml;  // para permitir reflexão
    exports gui to javafx.fxml; // para que o FXMLLoader acesse as classes
	
}
