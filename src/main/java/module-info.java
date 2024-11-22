module firefighter {
  requires javafx.controls;
  requires javafx.fxml;
  requires javafx.graphics;
    requires java.desktop;
    opens controller to javafx.fxml;
  exports app;
  opens app to javafx.fxml;
}
