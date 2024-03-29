/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package Interfaces;

/**
 *
 * @author Steve Roger
 */
public class Report extends javax.swing.JFrame {

    /**
     * Creates new form Report
     */
    public Report() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        TitleReport = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableBookInfo = new javax.swing.JTable();
        btnAll = new javax.swing.JButton();
        btnWeek = new javax.swing.JButton();
        btnYear = new javax.swing.JButton();
        btnMonth = new javax.swing.JButton();
        Categories = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableBorrowingReturning = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        BorrowingReturning = new javax.swing.JLabel();

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setPreferredSize(new java.awt.Dimension(1200, 720));
        jPanel1.setLayout(null);

        TitleReport.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        TitleReport.setText("Report");
        jPanel1.add(TitleReport, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 110, 40));

        tableBookInfo.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tableBookInfo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tableBookInfo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Existed Books", null, null},
                {"New Books", null, null},
                {"Borrowed Books", null, null},
                {"Remained Books", null, null},
                {"Total Book", null, null}
            },
            new String [] {
                "", "Number of Books", "Other"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableBookInfo);
        if (tableBookInfo.getColumnModel().getColumnCount() > 0) {
            tableBookInfo.getColumnModel().getColumn(1).setResizable(false);
            tableBookInfo.getColumnModel().getColumn(2).setResizable(false);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 360, 110));

        btnAll.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnAll.setText("All");
        jPanel1.add(btnAll, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 80, 50, 30));

        btnWeek.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnWeek.setText("Week");
        jPanel1.add(btnWeek, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 80, -1, 30));

        btnYear.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnYear.setText("Year");
        jPanel1.add(btnYear, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 80, 60, 30));

        btnMonth.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnMonth.setText("Month");
        btnMonth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMonthActionPerformed(evt);
            }
        });
        jPanel1.add(btnMonth, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 80, 70, 30));

        Categories.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        Categories.setText("Categories: ");
        jPanel1.add(Categories, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 80, 80, 30));

        tableBorrowingReturning.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tableBorrowingReturning.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tableBorrowingReturning.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"1", "e20150016", "Born Seanghort", "", "", null},
                {"2", "e20150017", "Steve Roger", null, null, null},
                {"3", "e20150018", "Tony Stark", null, null, null},
                {"4", "e20150019", "Steve Job", null, null, null},
                {"5", "e20150020", "Bill Gate", null, null, null},
                {"6", "e20150021", "Jack Ma", null, null, null},
                {"7", "e20150022", "Larry Page", null, null, null},
                {"8", "e20150023", "Warren Buffet", null, null, null},
                {"", null, "Total", null, null, null}
            },
            new String [] {
                "No.", "ID", "Name", "Borrowed", "Returned", "Other"
            }
        ));
        jScrollPane3.setViewportView(tableBorrowingReturning);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 150, 730, 530));

        jLabel1.setBackground(new java.awt.Color(0, 204, 204));
        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setText("Book Information");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 170, 40));

        BorrowingReturning.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        BorrowingReturning.setText("Borrowing & Returning Information");
        jPanel1.add(BorrowingReturning, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 110, 320, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnMonthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMonthActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnMonthActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Report().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BorrowingReturning;
    private javax.swing.JLabel Categories;
    private javax.swing.JLabel TitleReport;
    private javax.swing.JButton btnAll;
    private javax.swing.JButton btnMonth;
    private javax.swing.JButton btnWeek;
    private javax.swing.JButton btnYear;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable tableBookInfo;
    private javax.swing.JTable tableBorrowingReturning;
    // End of variables declaration//GEN-END:variables
}
