import javax.swing.SwingUtilities;

/**
 * main_class
 */
public class main_class {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() ->{
            simulator sim = new simulator();
            sim.setText("Hello");
        });
    }
}