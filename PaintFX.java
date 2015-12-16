import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
/**
* Class where Paint application is implemented.
* @author Katherine Cabezas
* @version 1.0
*/
public class PaintFX extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("Paint");
        Group root = new Group();
        Canvas canvas = new Canvas(500, 700);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        root.getChildren().add(canvas);
        Pencil pencil = new Pencil();
        Rectangle rect = new Rectangle();
        Paintbrush brush = new Paintbrush();

        ColorPicker colorPicker = new ColorPicker(Color.BLUE);

        Button clearBtn = new Button("Clear");
        clearBtn.setOnAction((ActionEvent event) -> {
                gc.clearRect(1, 1,
                    gc.getCanvas().getWidth() - 2,
                    gc.getCanvas().getHeight() - 2);
            }
        );

        Button pencilBtn = new Button(pencil.getName());
        pencilBtn.setOnAction((ActionEvent event) -> {
                canvas.setOnMousePressed(new EventHandler<MouseEvent>() {
                    public void handle(MouseEvent event) {
                        Color color = colorPicker.getValue();
                        gc.setStroke(color);
                        pencil.onPress(event, gc);
                    }
                });
                canvas.setOnMouseDragged(new EventHandler<MouseEvent>() {
                    public void handle(MouseEvent event) {
                        Color color = colorPicker.getValue();
                        gc.setStroke(color);
                        pencil.onDrag(event, gc);
                    }
                });
                canvas.setOnMouseReleased(new EventHandler<MouseEvent>() {
                    public void handle(MouseEvent event) {
                        Color color = colorPicker.getValue();
                        gc.setStroke(color);
                        pencil.onRelease(event, gc);
                    }
                });
            }
        );

        Button brushBtn = new Button(brush.getName());
        brushBtn.setOnAction((ActionEvent event) -> {
                canvas.setOnMousePressed(new EventHandler<MouseEvent>() {
                    public void handle(MouseEvent event) {
                        Color color = colorPicker.getValue();
                        gc.setStroke(color);
                        brush.onPress(event, gc);
                    }
                });
                canvas.setOnMouseDragged(new EventHandler<MouseEvent>() {
                    public void handle(MouseEvent event) {
                        Color color = colorPicker.getValue();
                        gc.setStroke(color);
                        brush.onDrag(event, gc);
                    }
                });
                canvas.setOnMouseReleased(new EventHandler<MouseEvent>() {
                    public void handle(MouseEvent event) {
                        Color color = colorPicker.getValue();
                        gc.setStroke(color);
                        brush.onRelease(event, gc);
                    }
                });
            }
        );

        VBox tools = new VBox(8);
        tools.setStyle("-fx-background-color: #87CEEB;");
        tools.getChildren().addAll(colorPicker, clearBtn,
                pencilBtn, brushBtn);

        BorderPane borderPane = new BorderPane();
        borderPane.setLeft(tools);
        borderPane.setCenter(canvas);

        root.getChildren().add(borderPane);

        Scene scene = new Scene(root, 400, 400);
        stage.setScene(scene);
        stage.show();

    }

}
