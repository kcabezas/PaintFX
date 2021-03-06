import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
/**
* Class for Paintbrush tool. Rectangle tool produces thick
* strokes when mouse is clicked and dragged.
* @author Katherine Cabezas
* @version 1.0
*/
public class Paintbrush implements Tool {

    private String name = "Paintbrush";

    /*
    * No-argument constructor for Paintbrush
    */
    public Paintbrush() {

    }

    /*
    * Constructor for Paintbrush.
    * @param name The name the tool is referred to as
    */
    public Paintbrush(String name) {
        this.name = name;
    }

    /**
    * Called when the mouse is pressed.
    * Begins to draw path.
    *
    * @param e The mouseevent that fired this onPress.
    * @param g The current graphics context.
    */
    @Override
    public void onPress(MouseEvent e, GraphicsContext g) {
        g.beginPath();
        g.moveTo(e.getX(), e.getY());
        g.setLineWidth(20);
        g.stroke();
    }

    /**
    * Called when the mouse is dragged.
    * Updates drawing location.
    *
    * @param e The mouseevent that fired this onDrag.
    * @param g The current graphics context.
    */
    @Override
    public void onDrag(MouseEvent e, GraphicsContext g) {
        g.lineTo(e.getX(), e.getY());
        g.setLineWidth(20);
        g.stroke();
    }

    /**
    * Called when the mouse is released.
    * Completes stroke.
    *
    * @param e The mouseevent that fired this onRelease.
    * @param g The current graphics context.
    */
    @Override
    public void onRelease(MouseEvent e, GraphicsContext g) {

    }

    /**
    * The name of this tool.
    *
    * @return This tool's name.
    */
    @Override
    public String getName() {
        return name;
    }

}
