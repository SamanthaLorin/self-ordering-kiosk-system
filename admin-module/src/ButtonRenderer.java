import java.awt.*;
import javax.swing.*;
import javax.swing.table.TableCellRenderer;

public class ButtonRenderer extends JPanel implements TableCellRenderer {
    JButton done = new JButton("✔");
    JButton cancel = new JButton("✖");
    public ButtonRenderer() {
        setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        done.setBackground(Color.LIGHT_GRAY);
        done.setPreferredSize(new Dimension(50, 30));
        
        cancel.setBackground(Color.RED);
        cancel.setForeground(Color.WHITE);
        cancel.setPreferredSize(new Dimension(50, 30));
        
        add(done);
        add(cancel);

    }
    @Override
    public Component getTableCellRendererComponent(
            JTable table,
            Object value,
            boolean isSelected,
            boolean hasFocus,
            int row,
            int column) {

        return this;
    }
}