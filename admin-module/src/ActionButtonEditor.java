import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ActionButtonEditor extends DefaultCellEditor {
    private JPanel panel;
    private JButton edit = new JButton("✎");
    private JButton delete = new JButton("🗑");
    private JTable table;
    private DefaultTableModel model;

    public ActionButtonEditor(JCheckBox checkBox, JTable table, DefaultTableModel model) {
        super(checkBox);
        this.table = table;
        this.model = model;

        panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 10));
        edit.setBackground(Color.YELLOW);
        delete.setBackground(Color.RED);
        delete.setForeground(Color.WHITE);

        panel.add(edit);
        panel.add(delete);

        edit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int row = table.getEditingRow(); 
                if (row == -1) return;

                String foodId = String.valueOf(model.getValueAt(row, 0));
                String foodName = String.valueOf(model.getValueAt(row, 1));
                String currentPrice = String.valueOf(model.getValueAt(row, 2));
                String currentCategory = String.valueOf(model.getValueAt(row, 3)); 
                String currentAvail = String.valueOf(model.getValueAt(row, 4)); 

                JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(table);
                EditMenuDialog editDialog = new EditMenuDialog(
                    topFrame, true, foodId, foodName, currentPrice, currentCategory, currentAvail, model, row
                );
                editDialog.setVisible(true);
                fireEditingStopped();
            }
        });
        
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = table.getEditingRow();
                if (row == -1) return;

                String foodId = String.valueOf(model.getValueAt(row, 0));
                String foodName = String.valueOf(model.getValueAt(row, 1));

                int confirm = JOptionPane.showConfirmDialog(
                        null,
                        "Are you sure you want to permanently delete '" + foodName + "'?",
                        "Confirm Deletion",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.WARNING_MESSAGE);

                if (confirm == JOptionPane.YES_OPTION) {
                    String sql = "DELETE FROM food_items WHERE food_id = ?";

                    try (Connection conn = Database.getConnection();
                        PreparedStatement pstmt = conn.prepareStatement(sql)) {

                        pstmt.setInt(1, Integer.parseInt(foodId));
                        pstmt.executeUpdate();

                        model.removeRow(row);
                        JOptionPane.showMessageDialog(null, "Item successfully deleted!");

                    } catch (Exception ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Database Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
                fireEditingStopped();
            }
        });
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        return panel; 
    }

    @Override
    public Object getCellEditorValue() {
        return "";
    }
}