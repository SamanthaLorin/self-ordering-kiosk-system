import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JCheckBox;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableRowSorter;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;


public class MenuManagementPage extends javax.swing.JFrame {

    public MenuManagementPage() {
        initComponents();
        this.setSize(950, 515);
        this.setLocationRelativeTo(null);
        
        customizeTable();
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        jTable1.setRowHeight(50);
        jTable1.getColumnModel().getColumn(5).setCellRenderer(new ActionButtonRenderer());
        jTable1.getColumnModel().getColumn(5).setCellEditor(new ActionButtonEditor(new JCheckBox(), jTable1, model));
        jTable1.getColumnModel().getColumn(5).setPreferredWidth(150);
        
        loadMenuTableFromDatabase();
    }

    private void customizeTable() {
        // Header Edit
        JTableHeader header = jTable1.getTableHeader();
        header.setPreferredSize(new Dimension(header.getWidth(), 40));
        header.setBackground(new Color(220, 220, 220));
        header.setForeground(Color.DARK_GRAY);
        header.setReorderingAllowed(false);
        header.setOpaque(false);
        
        jTable1.setRowHeight(50);
        
        // Set FoodID details in Left Alignment
        javax.swing.table.DefaultTableCellRenderer leftRenderer = new javax.swing.table.DefaultTableCellRenderer();
        leftRenderer.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        for (int i = 0; i < 5; i++) {
            jTable1.getColumnModel().getColumn(i).setCellRenderer(leftRenderer);
        }
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        yellowBG = new javax.swing.JPanel();
        whiteBG = new javax.swing.JPanel();
        logoImg = new javax.swing.JLabel();
        dashboardBtn = new javax.swing.JButton();
        menuBtn = new javax.swing.JButton();
        ordersBtn = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        menuManagementLbl = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        addItemBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        yellowBG.setBackground(new java.awt.Color(247, 246, 229));
        yellowBG.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        whiteBG.setBackground(new java.awt.Color(255, 255, 255));

        logoImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurantsystemforradmin/Images/Logo.png"))); // NOI18N

        dashboardBtn.setBackground(new java.awt.Color(204, 204, 204));
        dashboardBtn.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        dashboardBtn.setForeground(new java.awt.Color(0, 0, 0));
        dashboardBtn.setText("Dashboard");
        dashboardBtn.setBorderPainted(false);
        dashboardBtn.setContentAreaFilled(false);
        dashboardBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        dashboardBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dashboardBtnActionPerformed(evt);
            }
        });

        menuBtn.setBackground(new java.awt.Color(204, 204, 204));
        menuBtn.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        menuBtn.setForeground(new java.awt.Color(0, 0, 0));
        menuBtn.setText("Menu");
        menuBtn.setBorderPainted(false);
        menuBtn.setContentAreaFilled(false);
        menuBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        ordersBtn.setBackground(new java.awt.Color(204, 204, 204));
        ordersBtn.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        ordersBtn.setForeground(new java.awt.Color(0, 0, 0));
        ordersBtn.setText("Orders");
        ordersBtn.setBorderPainted(false);
        ordersBtn.setContentAreaFilled(false);
        ordersBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ordersBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ordersBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout whiteBGLayout = new javax.swing.GroupLayout(whiteBG);
        whiteBG.setLayout(whiteBGLayout);
        whiteBGLayout.setHorizontalGroup(
            whiteBGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(whiteBGLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(whiteBGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(logoImg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dashboardBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(menuBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ordersBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        whiteBGLayout.setVerticalGroup(
            whiteBGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(whiteBGLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(logoImg, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dashboardBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(menuBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ordersBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        yellowBG.add(whiteBG, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 480));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        menuManagementLbl.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        menuManagementLbl.setForeground(new java.awt.Color(51, 51, 51));
        menuManagementLbl.setText("Menu Management");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(menuManagementLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(510, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menuManagementLbl, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        yellowBG.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 0, 780, 50));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("MENU");
        yellowBG.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 60, 120, 30));

        addItemBtn.setBackground(new java.awt.Color(123, 72, 85));
        addItemBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        addItemBtn.setForeground(new java.awt.Color(255, 255, 255));
        addItemBtn.setText("+ Add Menu");
        addItemBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addItemBtnActionPerformed(evt);
            }
        });
        yellowBG.add(addItemBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 70, 150, -1));

        jTable1.setBackground(new java.awt.Color(245, 243, 232));
        jTable1.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jTable1.setForeground(new java.awt.Color(0, 0, 0));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "FoodID", "Name", "Price", "Category", "Availability", "Actions"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.setFocusable(false);
        jTable1.setSelectionBackground(new java.awt.Color(230, 220, 220));
        jScrollPane1.setViewportView(jTable1);

        yellowBG.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, 730, 350));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(yellowBG, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(yellowBG, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void dashboardBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dashboardBtnActionPerformed
        DashboardPage nextPage = new DashboardPage();
        nextPage.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_dashboardBtnActionPerformed

    private void ordersBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ordersBtnActionPerformed
        OrderManagementPage nextPage = new OrderManagementPage();
        nextPage.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_ordersBtnActionPerformed

    private void addItemBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addItemBtnActionPerformed
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        AddMenuDialog addDialog = new AddMenuDialog(this, true, model);
        addDialog.setVisible(true);
        loadMenuTableFromDatabase();
    }//GEN-LAST:event_addItemBtnActionPerformed
    
    public void loadMenuTableFromDatabase() {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel(); 
        model.setRowCount(0); 

        String sql = "SELECT food_id, item_name, price, category, availability FROM food_items";

        try (Connection conn = Database.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
             
            while (rs.next()) {
                int id = rs.getInt("food_id");
                String name = rs.getString("item_name");
                double price = rs.getDouble("price");
                String category = rs.getString("category");
                String availability = rs.getString("availability");

                Object[] rowData = { id, name, price, category, availability, "" };
                model.addRow(rowData);
            }
        } catch (Exception e) {
            System.out.println("Error loading Admin Menu Table: " + e.getMessage());
            e.printStackTrace();
        }
    }
    public static void main(String args[]) {
      
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuManagementPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addItemBtn;
    private javax.swing.JButton dashboardBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel logoImg;
    private javax.swing.JButton menuBtn;
    private javax.swing.JLabel menuManagementLbl;
    private javax.swing.JButton ordersBtn;
    private javax.swing.JPanel whiteBG;
    private javax.swing.JPanel yellowBG;
    // End of variables declaration//GEN-END:variables
}
