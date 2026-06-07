import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Menu extends javax.swing.JFrame {
    // stores the prices and unique ID numbers for each dish para alam ni system which is which kapag gagamitin siya. 
    private float priceDinuguan = 60.00f; 
    private float priceChickenAdobo = 60.00f;
    private float pricePorkAdobo = 60.00f;
    private float priceBeefKaldereta = 60.00f;
    private float priceSisig = 60.00f;
    private float priceSinigang = 60.00f;
    private float priceChopsuey = 60.00f;
    private float priceKareKare = 60.00f;
    private float priceFriedChicken = 60.00f;
    
    private int idBeefCaldereta = 1001;
    private int idChickenAdobo = 1002;
    private int idChopsuey = 1003;
    private int idDinuguan = 1004;
    private int idFriedChicken = 1005;
    private int idKareKare = 1006;
    private int idPorkAdobo = 1007;
    private int idSinigang = 1008;
    private int idSisig = 1009;
    
    public Menu() {
        initComponents();
        this.setSize(445, 835);
        this.setLocationRelativeTo(null);
        updateFooterTotal();
        updateKioskMenuFromDatabase();
    }
    
    private void updateFooterTotal() {
        float runningTotal = CartManager.getInstance().calculateTotal(); // pang call kay runningTotal (na nasa CartManager, doon kasi sinosolve) 
        totalLbl.setText(String.format("₱%.2f", runningTotal));         // Display ni total :>
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Background = new javax.swing.JPanel();
        ulamPrice1 = new javax.swing.JLabel();
        ulamPrice2 = new javax.swing.JLabel();
        ulamPrice3 = new javax.swing.JLabel();
        ulamPrice4 = new javax.swing.JLabel();
        ulamPrice5 = new javax.swing.JLabel();
        ulamPrice6 = new javax.swing.JLabel();
        ulamPrice7 = new javax.swing.JLabel();
        ulamPrice8 = new javax.swing.JLabel();
        ulamPrice9 = new javax.swing.JLabel();
        ulamItem1 = new javax.swing.JLabel();
        ulamItem2 = new javax.swing.JLabel();
        ulamItem3 = new javax.swing.JLabel();
        ulamItem4 = new javax.swing.JLabel();
        ulamItem5 = new javax.swing.JLabel();
        ulamItem6 = new javax.swing.JLabel();
        ulamItem7 = new javax.swing.JLabel();
        ulamItem8 = new javax.swing.JLabel();
        ulamItem9 = new javax.swing.JLabel();
        Header = new javax.swing.JLabel();
        ulamBtn = new javax.swing.JButton();
        silogBtn = new javax.swing.JButton();
        addOnsBtn = new javax.swing.JButton();
        drinksBtn = new javax.swing.JButton();
        DinuguanBtn = new javax.swing.JButton();
        ChickenAdoboBtn = new javax.swing.JButton();
        PorkAdoboBtn = new javax.swing.JButton();
        BeefKalderetaBtn = new javax.swing.JButton();
        SisigBtn = new javax.swing.JButton();
        SinigangBtn = new javax.swing.JButton();
        ChopsueyBtn = new javax.swing.JButton();
        KareKareBtn = new javax.swing.JButton();
        FriedChickenBtn = new javax.swing.JButton();
        TotalTxt = new javax.swing.JLabel();
        totalLbl = new javax.swing.JLabel();
        CheckoutBtn = new javax.swing.JButton();
        ViewCartBtn = new javax.swing.JButton();
        goBackBtn = new javax.swing.JButton();
        greyRectangle = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Background.setBackground(new java.awt.Color(255, 255, 255));
        Background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ulamPrice1.setBackground(new java.awt.Color(239, 239, 239));
        ulamPrice1.setFont(new java.awt.Font("Segoe UI", 1, 9)); // NOI18N
        ulamPrice1.setForeground(new java.awt.Color(0, 0, 0));
        ulamPrice1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ulamPrice1.setText("₱60.00");
        ulamPrice1.setOpaque(true);
        Background.add(ulamPrice1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 270, 80, -1));

        ulamPrice2.setBackground(new java.awt.Color(239, 239, 239));
        ulamPrice2.setFont(new java.awt.Font("Segoe UI", 1, 9)); // NOI18N
        ulamPrice2.setForeground(new java.awt.Color(0, 0, 0));
        ulamPrice2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ulamPrice2.setText("₱60.00");
        ulamPrice2.setOpaque(true);
        Background.add(ulamPrice2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 270, 80, -1));

        ulamPrice3.setBackground(new java.awt.Color(239, 239, 239));
        ulamPrice3.setFont(new java.awt.Font("Segoe UI", 1, 9)); // NOI18N
        ulamPrice3.setForeground(new java.awt.Color(0, 0, 0));
        ulamPrice3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ulamPrice3.setText("₱60.00");
        ulamPrice3.setOpaque(true);
        Background.add(ulamPrice3, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 270, 80, -1));

        ulamPrice4.setBackground(new java.awt.Color(239, 239, 239));
        ulamPrice4.setFont(new java.awt.Font("Segoe UI", 1, 9)); // NOI18N
        ulamPrice4.setForeground(new java.awt.Color(0, 0, 0));
        ulamPrice4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ulamPrice4.setText("₱60.00");
        ulamPrice4.setOpaque(true);
        Background.add(ulamPrice4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 380, 80, -1));

        ulamPrice5.setBackground(new java.awt.Color(239, 239, 239));
        ulamPrice5.setFont(new java.awt.Font("Segoe UI", 1, 9)); // NOI18N
        ulamPrice5.setForeground(new java.awt.Color(0, 0, 0));
        ulamPrice5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ulamPrice5.setText("₱60.00");
        ulamPrice5.setOpaque(true);
        Background.add(ulamPrice5, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 380, 80, -1));

        ulamPrice6.setBackground(new java.awt.Color(239, 239, 239));
        ulamPrice6.setFont(new java.awt.Font("Segoe UI", 1, 9)); // NOI18N
        ulamPrice6.setForeground(new java.awt.Color(0, 0, 0));
        ulamPrice6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ulamPrice6.setText("₱60.00");
        ulamPrice6.setOpaque(true);
        Background.add(ulamPrice6, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 380, 80, -1));

        ulamPrice7.setBackground(new java.awt.Color(239, 239, 239));
        ulamPrice7.setFont(new java.awt.Font("Segoe UI", 1, 9)); // NOI18N
        ulamPrice7.setForeground(new java.awt.Color(0, 0, 0));
        ulamPrice7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ulamPrice7.setText("₱60.00");
        ulamPrice7.setOpaque(true);
        Background.add(ulamPrice7, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 490, 80, -1));

        ulamPrice8.setBackground(new java.awt.Color(239, 239, 239));
        ulamPrice8.setFont(new java.awt.Font("Segoe UI", 1, 9)); // NOI18N
        ulamPrice8.setForeground(new java.awt.Color(0, 0, 0));
        ulamPrice8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ulamPrice8.setText("₱60.00");
        ulamPrice8.setOpaque(true);
        Background.add(ulamPrice8, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 490, 80, -1));

        ulamPrice9.setBackground(new java.awt.Color(239, 239, 239));
        ulamPrice9.setFont(new java.awt.Font("Segoe UI", 1, 9)); // NOI18N
        ulamPrice9.setForeground(new java.awt.Color(0, 0, 0));
        ulamPrice9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ulamPrice9.setText("₱60.00");
        ulamPrice9.setOpaque(true);
        Background.add(ulamPrice9, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 490, 80, -1));

        ulamItem1.setBackground(new java.awt.Color(239, 239, 239));
        ulamItem1.setFont(new java.awt.Font("Trebuchet MS", 1, 11)); // NOI18N
        ulamItem1.setForeground(new java.awt.Color(0, 0, 0));
        ulamItem1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ulamItem1.setText("Dinuguan");
        ulamItem1.setOpaque(true);
        Background.add(ulamItem1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 250, 80, 20));

        ulamItem2.setBackground(new java.awt.Color(239, 239, 239));
        ulamItem2.setFont(new java.awt.Font("Trebuchet MS", 1, 11)); // NOI18N
        ulamItem2.setForeground(new java.awt.Color(0, 0, 0));
        ulamItem2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ulamItem2.setText("Chicken Adobo");
        ulamItem2.setOpaque(true);
        Background.add(ulamItem2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 250, 80, 20));

        ulamItem3.setBackground(new java.awt.Color(239, 239, 239));
        ulamItem3.setFont(new java.awt.Font("Trebuchet MS", 1, 11)); // NOI18N
        ulamItem3.setForeground(new java.awt.Color(0, 0, 0));
        ulamItem3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ulamItem3.setText("Pork Adobo");
        ulamItem3.setOpaque(true);
        Background.add(ulamItem3, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 250, 80, 20));

        ulamItem4.setBackground(new java.awt.Color(239, 239, 239));
        ulamItem4.setFont(new java.awt.Font("Trebuchet MS", 1, 11)); // NOI18N
        ulamItem4.setForeground(new java.awt.Color(0, 0, 0));
        ulamItem4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ulamItem4.setText("Beef Caldereta");
        ulamItem4.setOpaque(true);
        Background.add(ulamItem4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 364, 80, 20));

        ulamItem5.setBackground(new java.awt.Color(239, 239, 239));
        ulamItem5.setFont(new java.awt.Font("Trebuchet MS", 1, 11)); // NOI18N
        ulamItem5.setForeground(new java.awt.Color(0, 0, 0));
        ulamItem5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ulamItem5.setText("Sizzling Sisig");
        ulamItem5.setOpaque(true);
        Background.add(ulamItem5, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 360, 80, 20));

        ulamItem6.setBackground(new java.awt.Color(239, 239, 239));
        ulamItem6.setFont(new java.awt.Font("Trebuchet MS", 1, 11)); // NOI18N
        ulamItem6.setForeground(new java.awt.Color(0, 0, 0));
        ulamItem6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ulamItem6.setText("Pork Sinigang");
        ulamItem6.setOpaque(true);
        Background.add(ulamItem6, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 360, 80, 20));

        ulamItem7.setBackground(new java.awt.Color(239, 239, 239));
        ulamItem7.setFont(new java.awt.Font("Trebuchet MS", 1, 11)); // NOI18N
        ulamItem7.setForeground(new java.awt.Color(0, 0, 0));
        ulamItem7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ulamItem7.setText("Chopsuey");
        ulamItem7.setOpaque(true);
        Background.add(ulamItem7, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 470, 80, 20));

        ulamItem8.setBackground(new java.awt.Color(239, 239, 239));
        ulamItem8.setFont(new java.awt.Font("Trebuchet MS", 1, 11)); // NOI18N
        ulamItem8.setForeground(new java.awt.Color(0, 0, 0));
        ulamItem8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ulamItem8.setText("Kare Kare");
        ulamItem8.setOpaque(true);
        Background.add(ulamItem8, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 470, 80, 20));

        ulamItem9.setBackground(new java.awt.Color(239, 239, 239));
        ulamItem9.setFont(new java.awt.Font("Trebuchet MS", 1, 9)); // NOI18N
        ulamItem9.setForeground(new java.awt.Color(0, 0, 0));
        ulamItem9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ulamItem9.setText("2pcs Fried Chicken");
        ulamItem9.setMaximumSize(new java.awt.Dimension(80, 11));
        ulamItem9.setOpaque(true);
        Background.add(ulamItem9, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 470, 100, 20));

        Header.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant/Header.png"))); // NOI18N
        Background.add(Header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 160));

        ulamBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant/UlamBtn.png"))); // NOI18N
        ulamBtn.setBorderPainted(false);
        ulamBtn.setContentAreaFilled(false);
        ulamBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ulamBtnActionPerformed(evt);
            }
        });
        Background.add(ulamBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 80, 80));

        silogBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant/SilogBtn.png"))); // NOI18N
        silogBtn.setBorderPainted(false);
        silogBtn.setContentAreaFilled(false);
        silogBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                silogBtnActionPerformed(evt);
            }
        });
        Background.add(silogBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 80, 80));

        addOnsBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant/Add-OnsBtn.png"))); // NOI18N
        addOnsBtn.setBorderPainted(false);
        addOnsBtn.setContentAreaFilled(false);
        addOnsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addOnsBtnActionPerformed(evt);
            }
        });
        Background.add(addOnsBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 370, 80, 80));

        drinksBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant/DrinksBtn.png"))); // NOI18N
        drinksBtn.setBorderPainted(false);
        drinksBtn.setContentAreaFilled(false);
        drinksBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                drinksBtnActionPerformed(evt);
            }
        });
        Background.add(drinksBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 460, 80, 80));

        DinuguanBtn.setBackground(new java.awt.Color(239, 239, 239));
        DinuguanBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant/DinuguanIcon.png"))); // NOI18N
        DinuguanBtn.setBorderPainted(false);
        DinuguanBtn.setContentAreaFilled(false);
        DinuguanBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DinuguanBtnActionPerformed(evt);
            }
        });
        Background.add(DinuguanBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 190, 100, 100));

        ChickenAdoboBtn.setBackground(new java.awt.Color(239, 239, 239));
        ChickenAdoboBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant/ChickenAdoboIcon.png"))); // NOI18N
        ChickenAdoboBtn.setBorderPainted(false);
        ChickenAdoboBtn.setContentAreaFilled(false);
        ChickenAdoboBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChickenAdoboBtnActionPerformed(evt);
            }
        });
        Background.add(ChickenAdoboBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 190, 100, 100));

        PorkAdoboBtn.setBackground(new java.awt.Color(239, 239, 239));
        PorkAdoboBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant/PorkAdoboIcon.png"))); // NOI18N
        PorkAdoboBtn.setBorderPainted(false);
        PorkAdoboBtn.setContentAreaFilled(false);
        PorkAdoboBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PorkAdoboBtnActionPerformed(evt);
            }
        });
        Background.add(PorkAdoboBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 190, 100, 100));

        BeefKalderetaBtn.setBackground(new java.awt.Color(239, 239, 239));
        BeefKalderetaBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant/BeefCalderetaIcon.png"))); // NOI18N
        BeefKalderetaBtn.setBorderPainted(false);
        BeefKalderetaBtn.setContentAreaFilled(false);
        BeefKalderetaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BeefKalderetaBtnActionPerformed(evt);
            }
        });
        Background.add(BeefKalderetaBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 300, 100, 100));

        SisigBtn.setBackground(new java.awt.Color(239, 239, 239));
        SisigBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant/SisigIcon.png"))); // NOI18N
        SisigBtn.setBorderPainted(false);
        SisigBtn.setContentAreaFilled(false);
        SisigBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SisigBtnActionPerformed(evt);
            }
        });
        Background.add(SisigBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 300, 100, 100));

        SinigangBtn.setBackground(new java.awt.Color(239, 239, 239));
        SinigangBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant/PorkSinigangIcon.png"))); // NOI18N
        SinigangBtn.setBorderPainted(false);
        SinigangBtn.setContentAreaFilled(false);
        SinigangBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SinigangBtnActionPerformed(evt);
            }
        });
        Background.add(SinigangBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 300, 100, 100));

        ChopsueyBtn.setBackground(new java.awt.Color(239, 239, 239));
        ChopsueyBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant/ChopsueyIcon.png"))); // NOI18N
        ChopsueyBtn.setBorderPainted(false);
        ChopsueyBtn.setContentAreaFilled(false);
        ChopsueyBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChopsueyBtnActionPerformed(evt);
            }
        });
        Background.add(ChopsueyBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 410, 100, 100));

        KareKareBtn.setBackground(new java.awt.Color(239, 239, 239));
        KareKareBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant/KareKareIcon.png"))); // NOI18N
        KareKareBtn.setBorderPainted(false);
        KareKareBtn.setContentAreaFilled(false);
        KareKareBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KareKareBtnActionPerformed(evt);
            }
        });
        Background.add(KareKareBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 410, 100, 100));

        FriedChickenBtn.setBackground(new java.awt.Color(239, 239, 239));
        FriedChickenBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant/FriedChickenIcon.png"))); // NOI18N
        FriedChickenBtn.setBorderPainted(false);
        FriedChickenBtn.setContentAreaFilled(false);
        FriedChickenBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FriedChickenBtnActionPerformed(evt);
            }
        });
        Background.add(FriedChickenBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 410, 100, 100));

        TotalTxt.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        TotalTxt.setForeground(new java.awt.Color(0, 0, 0));
        TotalTxt.setText("Total:");
        Background.add(TotalTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 770, 50, -1));

        totalLbl.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        totalLbl.setForeground(new java.awt.Color(0, 0, 0));
        totalLbl.setText("₱0.00");
        Background.add(totalLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 760, 120, 40));

        CheckoutBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant/Checkout.png"))); // NOI18N
        CheckoutBtn.setBorderPainted(false);
        CheckoutBtn.setContentAreaFilled(false);
        CheckoutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckoutBtnActionPerformed(evt);
            }
        });
        Background.add(CheckoutBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 700, 140, 100));

        ViewCartBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant/ViewCartBtn (1).png"))); // NOI18N
        ViewCartBtn.setBorderPainted(false);
        ViewCartBtn.setContentAreaFilled(false);
        ViewCartBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ViewCartBtnActionPerformed(evt);
            }
        });
        Background.add(ViewCartBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 700, 140, 100));

        goBackBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant/GoBackBtn.png"))); // NOI18N
        goBackBtn.setBorderPainted(false);
        goBackBtn.setContentAreaFilled(false);
        goBackBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goBackBtnActionPerformed(evt);
            }
        });
        Background.add(goBackBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 700, 100, 40));

        greyRectangle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant/GreyRectangle.png"))); // NOI18N
        Background.add(greyRectangle, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 690, -1, 110));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Background, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Background, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void DinuguanBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DinuguanBtnActionPerformed
        ItemPopUpDialog popUp = new ItemPopUpDialog(this, true, idDinuguan, "DINUGUAN", priceDinuguan, "dinuguan.png"); //Dito kinukuha ni ItemPopUpDialog yung mga variables para sa pang 'display' niya.
        popUp.setVisible(true);
        updateFooterTotal();
    }//GEN-LAST:event_DinuguanBtnActionPerformed

    private void goBackBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goBackBtnActionPerformed
        ModeOfOrderPage nextPage = new ModeOfOrderPage();
        nextPage.setVisible(true);
        dispose();
        CartManager.getInstance().clearCart();  // clearCart is important! Since babalik siya sa order method, mawawala na yung previous order niya. Back to start. 
    }//GEN-LAST:event_goBackBtnActionPerformed

    private void silogBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_silogBtnActionPerformed
        SilogMenu nextPage = new SilogMenu();
        nextPage.setVisible(true);
        dispose();
    }//GEN-LAST:event_silogBtnActionPerformed

    private void addOnsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addOnsBtnActionPerformed
        AddOnsPage nextPage = new AddOnsPage();
        nextPage.setVisible(true);
        dispose();
    }//GEN-LAST:event_addOnsBtnActionPerformed

    private void drinksBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_drinksBtnActionPerformed
        DrinksPage nextPage = new DrinksPage();
        nextPage.setVisible(true);
        dispose();
    }//GEN-LAST:event_drinksBtnActionPerformed

    private void ViewCartBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ViewCartBtnActionPerformed
        CartPopUpView cart = new CartPopUpView(this, true);
        cart.setVisible(true);
        updateFooterTotal();
    }//GEN-LAST:event_ViewCartBtnActionPerformed

    private void CheckoutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckoutBtnActionPerformed
        Checkout nextPage = new Checkout();
        nextPage.setVisible(true);
        dispose();
    }//GEN-LAST:event_CheckoutBtnActionPerformed

    private void ulamBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ulamBtnActionPerformed
       // TODO add your handling code here:
    }//GEN-LAST:event_ulamBtnActionPerformed

    private void ChickenAdoboBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChickenAdoboBtnActionPerformed
        ItemPopUpDialog popUp = new ItemPopUpDialog(this, true, idChickenAdobo, "Chicken Adobo", priceChickenAdobo, "chicken_adobo.png");
        popUp.setVisible(true);
        updateFooterTotal(); 
    }//GEN-LAST:event_ChickenAdoboBtnActionPerformed

    private void PorkAdoboBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PorkAdoboBtnActionPerformed
        ItemPopUpDialog popUp = new ItemPopUpDialog(this, true, idPorkAdobo, "Pork Adobo", pricePorkAdobo, "pork_adobo.png");
        popUp.setVisible(true);
        updateFooterTotal();
    }//GEN-LAST:event_PorkAdoboBtnActionPerformed

    private void BeefKalderetaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BeefKalderetaBtnActionPerformed
        ItemPopUpDialog popUp = new ItemPopUpDialog(this, true, idBeefCaldereta, "Beef Kaldereta", priceBeefKaldereta, "beef_kaldereta.png");
        popUp.setVisible(true);
        updateFooterTotal();
    }//GEN-LAST:event_BeefKalderetaBtnActionPerformed

    private void SisigBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SisigBtnActionPerformed
        ItemPopUpDialog popUp = new ItemPopUpDialog(this, true, idSisig, "Sizzling Sisig", priceSisig, "sizzling_sisig.png");
        popUp.setVisible(true);
        updateFooterTotal();
    }//GEN-LAST:event_SisigBtnActionPerformed

    private void SinigangBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SinigangBtnActionPerformed
        ItemPopUpDialog popUp = new ItemPopUpDialog(this, true, idSinigang, "Pork Sinigang", priceSinigang, "pork_sinigang.png");
        popUp.setVisible(true);
        updateFooterTotal();
    }//GEN-LAST:event_SinigangBtnActionPerformed

    private void ChopsueyBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChopsueyBtnActionPerformed
        ItemPopUpDialog popUp = new ItemPopUpDialog(this, true, idChopsuey, "Chopsuey", priceChopsuey, "chopsuey.png");
        popUp.setVisible(true);
        updateFooterTotal();
    }//GEN-LAST:event_ChopsueyBtnActionPerformed

    private void KareKareBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KareKareBtnActionPerformed
        ItemPopUpDialog popUp = new ItemPopUpDialog(this, true, idKareKare, "Kare-kare", priceKareKare, "beef_kare_kare.png");
        popUp.setVisible(true);
        updateFooterTotal();
    }//GEN-LAST:event_KareKareBtnActionPerformed

    private void FriedChickenBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FriedChickenBtnActionPerformed
        ItemPopUpDialog popUp = new ItemPopUpDialog(this, true, idFriedChicken, "2pcs Fried Chicken", priceFriedChicken, "fried_chicken.png");
        popUp.setVisible(true);
        updateFooterTotal();
    }//GEN-LAST:event_FriedChickenBtnActionPerformed

    
    public void updateKioskMenuFromDatabase() {
        String sql = "SELECT food_id, item_name, price, availability FROM food_items WHERE category = 'ULAM'";  // Call the needed variables from the database.
        String dbUrl = "jdbc:mysql://localhost:3306/ordering_kiosk_db"; 
        String dbUser = "root";
        String dbPass = "";

        try (Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPass);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
             
            // LOOP! Checks the row of the database to find an Item (+ yung other variables needed)
            while (rs.next()) {
                int foodId = rs.getInt("food_id"); 
                String name = rs.getString("item_name");
                double price = rs.getDouble("price");
                String status = rs.getString("availability");
                boolean isAvailable = status.equalsIgnoreCase("Available"); // Once na maidentify ni Database na Hindi Available yung item, mad-declare siya as false. Magiging Gray yung button.
                String buttonText = name + " - ₱" + price;  
                
                switch (foodId) {
                    case 1004: 
                        idDinuguan = foodId;
                        priceDinuguan = (float) price;
                        ulamItem1.setText(name);
                        ulamPrice1.setText(String.format("₱%.2f", price));
                        DinuguanBtn.setEnabled(isAvailable);
                        break;
                    case 1002: 
                        idChickenAdobo = foodId;
                        priceChickenAdobo = (float) price; 
                        ulamItem2.setText(name);
                        ulamPrice2.setText(String.format("₱%.2f", price));
                        ChickenAdoboBtn.setEnabled(isAvailable);
                        break;
                    case 1007: 
                        idPorkAdobo = foodId;
                        pricePorkAdobo = (float) price;
                        ulamItem3.setText(name);
                        ulamPrice3.setText(String.format("₱%.2f", price));
                        PorkAdoboBtn.setEnabled(isAvailable);
                        break;
                    case 1001: 
                        idBeefCaldereta = foodId; 
                        priceBeefKaldereta = (float) price; 
                        ulamItem4.setText(name); 
                        ulamPrice4.setText(String.format("₱%.2f", price)); 
                        BeefKalderetaBtn.setEnabled(isAvailable);
                        break;
                    case 1009: 
                        idSisig = foodId;
                        priceSisig = (float) price;
                        ulamItem5.setText(name);
                        ulamPrice5.setText(String.format("₱%.2f", price));
                        SisigBtn.setEnabled(isAvailable);
                        break;
                    case 1008: 
                        idSinigang = foodId;
                        priceSinigang = (float) price;
                        ulamItem6.setText(name);
                        ulamPrice6.setText(String.format("₱%.2f", price));
                        SinigangBtn.setEnabled(isAvailable);
                        break;
                    case 1003: 
                        idChopsuey = foodId;
                        priceChopsuey = (float) price;
                        ulamItem7.setText(name);
                        ulamPrice7.setText(String.format("₱%.2f", price));
                        ChopsueyBtn.setEnabled(isAvailable);
                        break;
                    case 1006: 
                        idKareKare = foodId;
                        priceKareKare = (float) price;
                        ulamItem8.setText(name);
                        ulamPrice8.setText(String.format("₱%.2f", price));
                        KareKareBtn.setEnabled(isAvailable);
                        break;
                    case 1005: 
                        idFriedChicken = foodId;
                        priceFriedChicken = (float) price;
                        ulamItem9.setText(name);
                        ulamPrice9.setText(String.format("₱%.2f", price));
                        FriedChickenBtn.setEnabled(isAvailable);
                        break;
                }
            }
        } catch (Exception e) {
            System.out.println("Error loading menu changes from DB: " + e.getMessage());
        }
    }
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Background;
    private javax.swing.JButton BeefKalderetaBtn;
    private javax.swing.JButton CheckoutBtn;
    private javax.swing.JButton ChickenAdoboBtn;
    private javax.swing.JButton ChopsueyBtn;
    private javax.swing.JButton DinuguanBtn;
    private javax.swing.JButton FriedChickenBtn;
    private javax.swing.JLabel Header;
    private javax.swing.JButton KareKareBtn;
    private javax.swing.JButton PorkAdoboBtn;
    private javax.swing.JButton SinigangBtn;
    private javax.swing.JButton SisigBtn;
    private javax.swing.JLabel TotalTxt;
    private javax.swing.JButton ViewCartBtn;
    private javax.swing.JButton addOnsBtn;
    private javax.swing.JButton drinksBtn;
    private javax.swing.JButton goBackBtn;
    private javax.swing.JLabel greyRectangle;
    private javax.swing.JButton silogBtn;
    private javax.swing.JLabel totalLbl;
    private javax.swing.JButton ulamBtn;
    private javax.swing.JLabel ulamItem1;
    private javax.swing.JLabel ulamItem2;
    private javax.swing.JLabel ulamItem3;
    private javax.swing.JLabel ulamItem4;
    private javax.swing.JLabel ulamItem5;
    private javax.swing.JLabel ulamItem6;
    private javax.swing.JLabel ulamItem7;
    private javax.swing.JLabel ulamItem8;
    private javax.swing.JLabel ulamItem9;
    private javax.swing.JLabel ulamPrice1;
    private javax.swing.JLabel ulamPrice2;
    private javax.swing.JLabel ulamPrice3;
    private javax.swing.JLabel ulamPrice4;
    private javax.swing.JLabel ulamPrice5;
    private javax.swing.JLabel ulamPrice6;
    private javax.swing.JLabel ulamPrice7;
    private javax.swing.JLabel ulamPrice8;
    private javax.swing.JLabel ulamPrice9;
    // End of variables declaration//GEN-END:variables
}
