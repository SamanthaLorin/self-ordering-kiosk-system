import java.awt.*;
import javax.swing.*;
import javax.swing.table.TableCellRenderer;

public class ActionButtonRenderer extends JPanel implements TableCellRenderer {
    JButton edit = new JButton("✎");
    JButton delete = new JButton("🗑");

    public ActionButtonRenderer() {
        setLayout(new FlowLayout(FlowLayout.CENTER, 5, 10));
        edit.setBackground(Color.YELLOW);

        delete.setBackground(Color.RED);
        delete.setForeground(Color.WHITE);

        add(edit);
        add(delete);
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