import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.sql.*;

public class OrderActionButtons extends JPanel implements TableCellRenderer, TableCellEditor, ActionListener {
    private JButton prepareBtn = new JButton("Prepare");
    private JButton cancelBtn = new JButton("Cancel");
    private JButton updateBtn = new JButton("Update");

    // Track contextual attributes across click operations
    private final DefaultCellEditor editorHelper;
    private String currentStatus = "";
    private int currentOrderId = -1;
    private JTable currentTable;

    public OrderActionButtons() {
        setOpaque(true);
        setLayout(new BorderLayout(2, 2));
        setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));

        prepareBtn.setBackground(new Color(255, 193, 7)); 
        prepareBtn.setForeground(Color.BLACK);
        prepareBtn.setFont(new Font("SansSerif", Font.BOLD, 11));
        prepareBtn.setMargin(new Insets(2, 4, 2, 4));

        cancelBtn.setBackground(new Color(220, 53, 69)); 
        cancelBtn.setForeground(Color.WHITE);
        cancelBtn.setFont(new Font("SansSerif", Font.BOLD, 11));
        cancelBtn.setMargin(new Insets(2, 4, 2, 4));

        updateBtn.setBackground(new Color(114, 61, 80)); 
        updateBtn.setForeground(Color.WHITE);
        updateBtn.setFont(new Font("SansSerif", Font.BOLD, 11));
        updateBtn.setMargin(new Insets(2, 4, 2, 4));

        prepareBtn.addActionListener(this);
        cancelBtn.addActionListener(this);
        updateBtn.addActionListener(this);

        JPanel bottomPanel = new JPanel(new GridLayout(1, 2, 4, 0));
        bottomPanel.setOpaque(false); 
        bottomPanel.add(cancelBtn);
        bottomPanel.add(updateBtn);

        add(prepareBtn, BorderLayout.NORTH);
        add(bottomPanel, BorderLayout.CENTER);

        editorHelper = new DefaultCellEditor(new JCheckBox());
    }

    private void updateLayoutState(JTable table, int row) {
        Object statusValue = table.getValueAt(row, 5); 
        currentStatus = (statusValue != null) ? statusValue.toString() : "";
        
        Object idValue = table.getValueAt(row, 1);    
        currentOrderId = (idValue != null) ? Integer.parseInt(idValue.toString()) : -1;
        currentTable = table;

        if ("Pending".equalsIgnoreCase(currentStatus)) {
            prepareBtn.setText("Prepare");
            prepareBtn.setBackground(new Color(255, 193, 7));
            prepareBtn.setForeground(Color.BLACK);
            prepareBtn.setVisible(true);
            cancelBtn.setVisible(true);
            updateBtn.setVisible(true);  
        } else if ("In Progress".equalsIgnoreCase(currentStatus)) {
            prepareBtn.setText("Complete");
            prepareBtn.setBackground(new Color(40, 167, 69)); 
            prepareBtn.setForeground(Color.WHITE);
            prepareBtn.setVisible(true);
            cancelBtn.setVisible(true);
            updateBtn.setVisible(true);  
        } else {
            prepareBtn.setVisible(false);
            cancelBtn.setVisible(false);
            updateBtn.setVisible(false);  
        }
    }
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {
 
        if (isSelected) {
            setBackground(table.getSelectionBackground());
        } else {
            setBackground(table.getBackground());
        }

        updateLayoutState(table, row);
        return this;
    }
    @Override
    public Component getTableCellEditorComponent(JTable table, Object value,
            boolean isSelected, int row, int column) {
        
        setBackground(table.getSelectionBackground());
        updateLayoutState(table, row);
        return this;
    }

    @Override
    public Object getCellEditorValue() {
        return currentStatus;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Window ancestor = SwingUtilities.getWindowAncestor(this);
        OrderManagementPage parentPage = null;
        if (ancestor instanceof OrderManagementPage) {
            parentPage = (OrderManagementPage) ancestor;
        }

        if (e.getSource() == updateBtn) {
            stopCellEditing(); 
            
            if (parentPage != null) {
                UpdateOrderDialog dialog = new UpdateOrderDialog(parentPage, true, currentOrderId);
                dialog.setVisible(true);
                
                parentPage.loadOrdersTableFromDatabase();
                parentPage.HeaderStats();
            }
            return;
        }

        String targetNextStatus = "";
        if (e.getSource() == cancelBtn) {
            targetNextStatus = "Cancelled";
        } else if (e.getSource() == prepareBtn) {
            if ("Pending".equalsIgnoreCase(currentStatus)) {
                targetNextStatus = "In Progress";
            } else if ("In Progress".equalsIgnoreCase(currentStatus)) {
                targetNextStatus = "Completed";
            }
        }

        if (!targetNextStatus.isEmpty() && currentOrderId != -1) {
            String updateSql = "UPDATE orders SET status = ? WHERE order_id = ?";
            try (Connection conn = Database.getConnection();
                 PreparedStatement pstmt = conn.prepareStatement(updateSql)) {
                
                pstmt.setString(1, targetNextStatus);
                pstmt.setInt(2, currentOrderId);
                pstmt.executeUpdate();
                
            } catch (Exception ex) {
                System.out.println("SQL Error updating status: " + ex.getMessage());
                ex.printStackTrace();
            }
        }

        stopCellEditing(); 
        if (parentPage != null) {
            parentPage.loadOrdersTableFromDatabase();
            parentPage.HeaderStats();
        }
    }
    
    // Cell Editing
    @Override public boolean isCellEditable(java.util.EventObject e) { 
        return editorHelper.isCellEditable(e); 
    }
    
    @Override public boolean shouldSelectCell(java.util.EventObject e) { 
        return editorHelper.shouldSelectCell(e); 
    }
    @Override public boolean stopCellEditing() { 
        return editorHelper.stopCellEditing(); 
    }
    @Override public void cancelCellEditing() { 
        editorHelper.cancelCellEditing(); 
    }
    @Override public void addCellEditorListener(javax.swing.event.CellEditorListener l) { 
        editorHelper.addCellEditorListener(l); 
    }
    @Override public void removeCellEditorListener(javax.swing.event.CellEditorListener l) { 
        editorHelper.removeCellEditorListener(l); 
    }
}