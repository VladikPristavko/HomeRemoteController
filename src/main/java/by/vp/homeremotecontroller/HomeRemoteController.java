package by.vp.homeremotecontroller;

import by.vp.homeremotecontroller.Buildings.*;
import by.vp.homeremotecontroller.Devices.*;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import lombok.Setter;

import java.io.IOException;
import static by.vp.homeremotecontroller.CommandCreator.*;
@Setter
public class HomeRemoteController extends Application{
    private Label label = new Label();
    @Override
    public void start(Stage stage) throws IOException {
        FlowPane root = new FlowPane();

        labelsAndButtons.keySet().forEach(key->{
            root.getChildren().add(newFlowPane(key, labelsAndButtons.get(key)));
        });

        this.label.setWrapText(true);
        this.label.setTextAlignment(TextAlignment.JUSTIFY);
        this.label.setMaxWidth(300);
        FlowPane pane = new FlowPane(10, 10, this.label);
        pane.setVgap(10);
        pane.setPrefSize(380, 80);
        pane.setStyle("-fx-border-color: black");

        root.getChildren().add(pane);
        Scene scene = new Scene(root, pane.getPrefWidth(), root.getChildren().size() * 40 + 40);

        stage.setTitle("Home remote controller");
        stage.setScene(scene);
        stage.show();
    }
    private GridPane newFlowPane(String labelText, String[] buttons){
        Label label = new Label();
        label.setText(labelText);
        GridPane pane = new GridPane();
        GridPane.setConstraints(label, 0, 0);
        pane.getColumnConstraints().add(new ColumnConstraints(160));
        pane.getChildren().add(label);
        pane.setPrefSize(380, 40);
        int length = buttons.length;
        for (int i = 0; i < length; i++) {
            Button button = new Button(buttons[i]);
            GridPane.setConstraints(button, i + 1, 0);
            button.setPrefWidth(60);
            button.setOnAction(e-> {
                String command = labelText.replace(" ","") + button.getText();
                this.label.setText(commands.get(command).execute());
            });
            pane.getChildren().add(button);
        }
        pane.setAlignment(Pos.CENTER_LEFT);
        pane.setStyle("-fx-border-color: black");
        return pane;
    }
    private static void create(){
        Light garageLight = new Light("Garage light");
        Light kitchenLight = new Light("Kitchen light");
        Light livingRoomLight = new Light("Living room light");
        Light recreationRoomLight = new Light("Recreation room light");
        Garage garage = new Garage(new GarageDoor("Garage gates"), garageLight);
        Home home = new Home(new Door("Home entry door"));
        Kitchen kitchen = new Kitchen(kitchenLight);
        LivingRoom livingRoom = new LivingRoom(new CeilingFan("Living room ceiling fan"), livingRoomLight);
        RecreationRoom recreationRoom = new RecreationRoom(recreationRoomLight, new Stereo("Recreation room stereo"));
        All all = new All(kitchenLight, livingRoomLight, recreationRoomLight, garageLight);
    }

    public static void main(String[] args) {
        create();
        launch();
    }
}