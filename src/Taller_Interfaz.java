import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Taller_Interfaz extends Application {

    private static final String IMAGE_FILE = "user_icon_001.jpg";
    private static final String LEFT_SIDE_STYLE = "-fx-background-color: #ffffff;";
    private static final String RIGHT_SIDE_STYLE = "-fx-background-color: #0000ff;";
    private static final String ROOT_STYLE = "-fx-background-color: #f0f1f0;";

    @Override
    public void start(Stage stage) {
        try {
            VBox leftSide = new VBox();
            leftSide.setSpacing(10); 

            for (int i = 0; i < 8; i++) {
                HBox hbox = new HBox();
                hbox.setSpacing(5); 

                ImageView imageView = new ImageView(new Image(IMAGE_FILE));
                imageView.setFitWidth(30); 
                imageView.setFitHeight(30); 

                TextField textField = new TextField();
                textField.setPromptText("Nombre y apellido");
                textField.setStyle(LEFT_SIDE_STYLE);

                hbox.getChildren().addAll(imageView, textField);
                leftSide.getChildren().add(hbox);
            }

            ListView<String> listView = new ListView<>();
            listView.setPrefHeight(340); 
            listView.setPrefWidth(200);
            VBox rightSide = new VBox(listView);

            TextField bottomTextField = new TextField();
            bottomTextField.setPrefWidth(420); 
            bottomTextField.setStyle(RIGHT_SIDE_STYLE); 

            AnchorPane root = new AnchorPane(leftSide, rightSide, bottomTextField);

            AnchorPane.setLeftAnchor(leftSide, 10.0);
            AnchorPane.setTopAnchor(leftSide, 10.0);

            AnchorPane.setRightAnchor(rightSide, 10.0);
            AnchorPane.setTopAnchor(rightSide, 10.0);

            AnchorPane.setLeftAnchor(bottomTextField, 10.0);
            AnchorPane.setBottomAnchor(bottomTextField, 10.0);

            root.setStyle(ROOT_STYLE);

            Scene scene = new Scene(root, 600, 400);

            stage.setTitle("Interface Example");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
