module by.vp.homeremotecontroller {
    requires javafx.controls;
    requires javafx.fxml;
    requires lombok;

    opens by.vp.homeremotecontroller to javafx.fxml;
    exports by.vp.homeremotecontroller;
}