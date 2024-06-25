# Taller Interfaz

Este proyecto es un ejemplo de una interfaz gráfica creada con JavaFX. La aplicación muestra una ventana con varios componentes gráficos, organizados de la siguiente manera:

## Descripción del Código

1. **Importaciones:** Se incluyen las clases necesarias para trabajar con JavaFX, como `Application`, `Scene`, `ListView`, `TextField`, `Image`, `ImageView`, `AnchorPane`, `HBox`, `VBox`, y `Stage`.

2. **Definición de la Clase:** La clase `Taller_Interfaz` extiende `Application`, permitiendo configurar y mostrar la ventana principal.

3. **Constantes de Estilo:** Se definen varias constantes de estilo para personalizar la apariencia de los componentes de la interfaz, incluyendo los colores de fondo para diferentes secciones y el estilo del `ListView` para que tenga un fondo negro y texto blanco.

4. **Método `start`:** Este método se ejecuta al iniciar la aplicación y configura la interfaz:
   - Se crea un `VBox` llamado `leftSide` que contiene varios `HBox`. Cada `HBox` incluye una imagen (`ImageView`) y un campo de texto (`TextField`).
   - Se crea un `ListView` con un estilo personalizado y se coloca dentro de un `VBox` llamado `rightSide`.
   - Se crea un `TextField` que se posiciona en la parte inferior de la ventana.
   - Se utiliza un `AnchorPane` para organizar los componentes `leftSide`, `rightSide`, y el campo de texto inferior (`bottomTextField`) dentro de la ventana.

5. **Configuración de la Escena y el `Stage`:** Se crea una escena (`Scene`) con el `AnchorPane` como raíz y se configura el `Stage` principal con un título. Finalmente, se muestra la ventana al usuario llamando a `stage.show()`.

6. **Método `main`:** Este método lanza la aplicación JavaFX.

## Captura de Pantalla

![imagen](https://github.com/JansHilaca/Taller-interfaz/assets/168945853/0ac47871-c1c2-4072-8c17-032c037abc6d)


Esta es una captura de pantalla de la interfaz de la aplicación en ejecución.

## Código Fuente

```java
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
    private static final String LISTVIEW_STYLE = "-fx-background-color: #000000; -fx-control-inner-background: #000000; -fx-text-fill: #ffffff;";
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
            listView.setStyle(LISTVIEW_STYLE); // Cambiado a negro con texto blanco
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
