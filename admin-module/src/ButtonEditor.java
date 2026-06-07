import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ButtonEditor extends DefaultCellEditor {
    protected JPanel panel;
    protected JButton done;
    protected JButton cancel;
    private String label;
    private JTable table;
    private DefaultTableModel model;

    public ButtonEditor(JCheckBox checkBox, JTable table, DefaultTableModel model) {
        super(checkBox);
        this.table = table;
        this.model = model;

        panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
        done = new JButton("✔");
        cancel = new JButton("✖");
        
        done.setBackground(Color.LIGHT_GRAY);
        done.setPreferredSize(new Dimension(50, 30));
        
        cancel.setBackground(Color.RED);
        cancel.setForeground(Color.WHITE);
        cancel.setPreferredSize(new Dimension(50, 30));
        
        panel.add(done);
        panel.add(cancel);

        // Completed Button
        done.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = table.getEditingRow();
                if (row != -1) {
                    int modelRow = table.convertRowIndexToModel(row);
                    int orderId = (int) model.getValueAt(modelRow, 1);
                    updateOrderStatusInDatabase(orderId, "Completed");
                }
                fireEditingStopped();
            }
        });
        
        // Cancel Button
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = table.getEditingRow();
                if (row != -1) {
                    int modelRow = table.convertRowIndexToModel(row);
                    int orderId = (int) model.getValueAt(modelRow, 1);
                    updateOrderStatusInDatabase(orderId, "Cancelled");
                }
                fireEditingStopped();
            }
        });
    }

    private void updateOrderStatusInDatabase(int orderId, String newStatus) {
        String sql = "UPDATE orders SET status = ? WHERE order_id = ?";
        
        try (Connection conn = Database.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, newStatus);
            pstmt.setInt(2, orderId);
            pstmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Order #" + orderId + " has been marked as " + newStatus + "!");
            
            if (table.getTopLevelAncestor() instanceof OrderManagementPage) {
                ((OrderManagementPage) table.getTopLevelAncestor()).loadOrdersTableFromDatabase();
            }
            
        } catch (Exception ex) {
            System.out.println("Error updating order status: " + ex.getMessage());
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Database Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    @Override
    public Component getTableCellEditorComponent(
            JTable table,
            Object value,
            boolean isSelected,
            int row,
            int column) {
        label = (value == null) ? "" : value.toString();
        return panel;
    }
    @Override
    public Object getCellEditorValue() {
        return label;
    }
}