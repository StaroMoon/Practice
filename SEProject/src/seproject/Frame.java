/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seproject;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.util.*;
import java.awt.print.PrinterException;
import java.io.*;
import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import org.tmatesoft.sqljet.core.SqlJetException;
import org.tmatesoft.sqljet.core.SqlJetTransactionMode;
import org.tmatesoft.sqljet.core.table.ISqlJetTransaction;
import org.tmatesoft.sqljet.core.table.SqlJetDb;
/**
 *
 * @author staromoon
 */
public class Frame extends javax.swing.JFrame {
    private Connection con = null,con2=null,con3=null;
    private PreparedStatement pst = null;
    private ResultSet rs=null,rs2=null,rs3=null;
    private Statement st=null,st2=null;
    private static final double VERSION = 1.0;
    String name = "",name2 = "",emPath = "";
    String filename = null,nameEm = "";
    byte[] person_image=null;
    byte[] res=null;
    boolean checkremove = false;
    FileOutputStream fop = null;
    Scanner sc;
    File start = new File("save.txt");
    
    public Frame() {
        initComponents();
        this.setTitle("Finance manager V." + VERSION);
        this.getContentPane().setBackground(Color.WHITE);
        this.setResizable(false);
        employeePath();
        update_Table_Overview();
        if(start.exists()){
            update_Table_Overview();
        }else{
            update_Table_Employee();
        }
    }
    
    public void update_Table_Overview(){
        /*DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<DefaultTableModel>(model);
        jTable1.setRowSorter(sorter);*/
        try{
            sc = new Scanner(start);
            String fi = sc.next();
            WorkDir.setText(fi);
            //if(start.exists()){
                Class.forName("org.sqlite.JDBC");
                con = DriverManager.getConnection("jdbc:sqlite:" + fi);
                pst = con.prepareStatement("select * from Overview");
                rs = pst.executeQuery();
                jTable1.setModel(DbUtils.resultSetToTableModel(rs));
                update_Table_Employee();
            //}
        }catch(Exception e){
            //System.out.println(e.getMessage());
        }finally{
            try {
                pst.close();
                rs.close();
            } catch (Exception ex) {}
        }
    }
    
    public void update_Table_Employee(){
    try{
            //con = DriverManager.getConnection("jdbc:mysql://localhost:3306/TestSE","root","root");
            Class.forName("org.sqlite.JDBC");
            con2 = DriverManager.getConnection("jdbc:sqlite:" + emPath);
            st = con2.createStatement();
            rs2 = st.executeQuery("select Name,Surname from Employee");
            /*ResultSetMetaData rsmd = rs.getMetaData();
            int col = rsmd.getColumnCount();
            Vector<String> columnNames = new Vector<>();
            columnNames.add(rsmd.getColumnName(2));
            columnNames.add(rsmd.getColumnName(3));
            DefaultTableModel model = new DefaultTableModel(columnNames,0);
            while(rs.next()){
                Vector<String> row = new Vector<>();
                row.add(rs.getString(2));
                row.add(rs.getString(3));
                model.addRow(row);
            }*/
            jTable2.setModel(DbUtils.resultSetToTableModel(rs2));
            secret_table();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }finally{
            try {
                pst.close();
                rs2.close();
            } catch (Exception ex) {}
        }
    }
    
    public void secret_table(){
        try{
            Class.forName("org.sqlite.JDBC");
            con3 = DriverManager.getConnection("jdbc:sqlite:" + emPath);
            st2 = con3.createStatement();
            rs3 = st2.executeQuery("select * from Employee");
            jTable3.setModel(DbUtils.resultSetToTableModel(rs3));
        }catch(Exception e){
            System.out.println(e.getMessage());
        }finally{
            try {
                st2.close();
                rs3.close();
            } catch (Exception ex) {}
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable(){
            @Override
            public boolean isCellEditable(int row,int column){
                return false;
            }
        };
        AddOver = new javax.swing.JButton();
        RemoveOver = new javax.swing.JButton();
        EditOver = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        Calendar cal = new GregorianCalendar();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        MoneyBox = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        AmountField = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        RefField = new javax.swing.JTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        EmpField = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        DescripField = new javax.swing.JTextArea();
        DateField = new com.toedter.calendar.JDateChooser();
        jPanel7 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        CalOver = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        LabalBal = new javax.swing.JLabel();
        Income = new javax.swing.JLabel();
        Expenses = new javax.swing.JLabel();
        Balance = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        ClearOver = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        WorkDir = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        AddEm = new javax.swing.JButton();
        DelEm = new javax.swing.JButton();
        EditEm = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable(){
            @Override
            public boolean isCellEditable(int row,int column){
                return false;
            }
        };
        Picture = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        EmpIDField = new javax.swing.JTextField();
        NameField = new javax.swing.JTextField();
        SurnameField = new javax.swing.JTextField();
        SexField = new javax.swing.JTextField();
        AgeField = new javax.swing.JTextField();
        HomeNOField = new javax.swing.JTextField();
        MobileNOField = new javax.swing.JTextField();
        Birth = new com.toedter.calendar.JDateChooser();
        jScrollPane6 = new javax.swing.JScrollPane();
        AddressField = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        EmailField = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        PosField = new javax.swing.JTextField();
        OTHourField = new javax.swing.JTextField();
        SalaryField = new javax.swing.JTextField();
        HireDate = new com.toedter.calendar.JDateChooser();
        jPanel6 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        OTRateField = new javax.swing.JTextField();
        HoursField = new javax.swing.JTextField();
        Total = new javax.swing.JLabel();
        CalButton = new javax.swing.JButton();
        addPic = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jToolBar1 = new javax.swing.JToolBar();
        NewTool = new javax.swing.JButton();
        OpenTool = new javax.swing.JButton();
        jSeparator5 = new javax.swing.JToolBar.Separator();
        pdftool = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        ExitTool = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        NewMenu = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        OpenMenu = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        PdfMenu = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        CloseMenu = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        Help = new javax.swing.JMenuItem();

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable3);
        jTable3.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable3.setColumnSelectionAllowed (false);
        jTable3.setAutoCreateRowSorter(true);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(965, 745));

        jTabbedPane1.setToolTipText("");
        jTabbedPane1.setAutoscrolls(true);
        jTabbedPane1.setPreferredSize(new java.awt.Dimension(900, 700));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 650));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "RefID", "Type", "Amount", "Date", "Employee", "Description"
            }
        ));
        jTable1.setColumnSelectionAllowed(true);
        jTable1.setOpaque(true);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jTable1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTable1KeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        jTable1.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable1.setColumnSelectionAllowed (false);
        jTable1.setAutoCreateRowSorter(true);
        jTable1.setBackground(Color.WHITE);
        Color ivory = new Color(255, 255, 255);
        jTable1.setFillsViewportHeight(true);
        jTable1.setBackground(ivory);
        jTable1.getTableHeader().setReorderingAllowed(false);

        AddOver.setBackground(new java.awt.Color(255, 204, 51));
        AddOver.setText("Add");
        AddOver.setPreferredSize(new java.awt.Dimension(75, 30));
        AddOver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddOverActionPerformed(evt);
            }
        });

        RemoveOver.setBackground(new java.awt.Color(255, 204, 51));
        RemoveOver.setText("Delete");
        RemoveOver.setPreferredSize(new java.awt.Dimension(75, 30));
        RemoveOver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RemoveOverActionPerformed(evt);
            }
        });

        EditOver.setBackground(new java.awt.Color(255, 204, 51));
        EditOver.setText("Edit");
        EditOver.setPreferredSize(new java.awt.Dimension(75, 30));
        EditOver.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                EditOverMousePressed(evt);
            }
        });
        EditOver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditOverActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tempus Sans ITC", 0, 18)); // NOI18N
        jLabel2.setText("Date :");

        int month = cal.get(Calendar.MONTH);
        int year  = cal.get(Calendar.YEAR);
        int day   = cal.get(Calendar.DAY_OF_MONTH);
        jLabel1.setFont(new java.awt.Font("Tempus Sans ITC", 0, 18)); // NOI18N
        jLabel1.setText(day + "/" + (month+1) + "/" + year);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "OverviewInfo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tekton Pro Ext", 0, 18), new java.awt.Color(0, 0, 204))); // NOI18N

        jLabel6.setText("Amount :");
        jLabel6.setPreferredSize(new java.awt.Dimension(95, 20));

        MoneyBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Income", "Expense" }));

        jLabel9.setText("Description :");
        jLabel9.setPreferredSize(new java.awt.Dimension(50, 20));

        jLabel5.setText("TypeOfMoney :");
        jLabel5.setPreferredSize(new java.awt.Dimension(95, 20));

        jLabel8.setText("Employee :");
        jLabel8.setPreferredSize(new java.awt.Dimension(95, 20));

        AmountField.setPreferredSize(new java.awt.Dimension(84, 28));
        AmountField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                AmountFieldMousePressed(evt);
            }
        });

        jLabel23.setText("Date :");
        jLabel23.setPreferredSize(new java.awt.Dimension(95, 20));

        jLabel28.setText("RefID :");

        RefField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                RefFieldMousePressed(evt);
            }
        });

        EmpField.setColumns(5);
        EmpField.setRows(2);
        EmpField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                EmpFieldMousePressed(evt);
            }
        });
        jScrollPane5.setViewportView(EmpField);
        EmpField.getAccessibleContext().setAccessibleName("");

        DescripField.setColumns(10);
        DescripField.setRows(2);
        DescripField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                DescripFieldMousePressed(evt);
            }
        });
        jScrollPane3.setViewportView(DescripField);

        DateField.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(AmountField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(DateField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(MoneyBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(RefField))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(RefField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MoneyBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AmountField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DateField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        DateField.setDateFormatString("yyyy-MM-dd");
        ((JTextField)DateField.getDateEditor().getUiComponent()).setEditable(false);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Balance Calculator", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tekton Pro Ext", 0, 18), new java.awt.Color(0, 0, 204))); // NOI18N

        jLabel4.setText("Income :");
        jLabel4.setPreferredSize(new java.awt.Dimension(85, 16));

        CalOver.setText("Calculate");
        CalOver.setPreferredSize(new java.awt.Dimension(110, 30));
        CalOver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CalOverActionPerformed(evt);
            }
        });

        jLabel3.setText("Expenses :");
        jLabel3.setPreferredSize(new java.awt.Dimension(85, 16));

        LabalBal.setText("Balance :");
        LabalBal.setPreferredSize(new java.awt.Dimension(85, 16));

        jLabel32.setText("Baht");

        jLabel33.setText("Baht");

        jLabel34.setText("Baht");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(Income, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(LabalBal, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(Expenses, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                                    .addComponent(Balance, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel33)
                                    .addComponent(jLabel32)
                                    .addComponent(jLabel34)))))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(CalOver, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Income, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Expenses, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LabalBal, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Balance, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(CalOver, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );

        ClearOver.setBackground(new java.awt.Color(255, 204, 51));
        ClearOver.setText("Clear");
        ClearOver.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ClearOverMousePressed(evt);
            }
        });
        ClearOver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearOverActionPerformed(evt);
            }
        });

        jLabel19.setBackground(new java.awt.Color(102, 255, 102));
        jLabel19.setText("Work directory :");
        jLabel19.setOpaque(true);

        WorkDir.setBackground(new java.awt.Color(255, 255, 153));
        WorkDir.setOpaque(true);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(EditOver, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(AddOver, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(RemoveOver, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ClearOver, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE))
                        .addGap(44, 44, 44)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 633, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(WorkDir, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)))
                .addGap(25, 25, 25))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(AddOver, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(RemoveOver, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(EditOver, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ClearOver, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(WorkDir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Overview", jPanel1);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        AddEm.setText("Add");
        AddEm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddEmActionPerformed(evt);
            }
        });

        DelEm.setText("Delete");
        DelEm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DelEmActionPerformed(evt);
            }
        });

        EditEm.setText("Edit");
        EditEm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditEmActionPerformed(evt);
            }
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Surname"
            }
        ));
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jTable2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTable2KeyReleased(evt);
            }
        });
        jScrollPane4.setViewportView(jTable2);
        //new JScrollPane(jTable2, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        jTable2.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable2.setColumnSelectionAllowed (false);
        jTable2.setAutoCreateRowSorter(true);
        jTable2.setBackground(Color.WHITE);
        Color ivory2 = new Color(255, 255, 255);
        jTable2.setFillsViewportHeight(true);
        jTable2.setBackground(ivory2);

        Picture.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Picture.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "EmployeeInfo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tekton Pro Ext", 0, 18), new java.awt.Color(0, 0, 255))); // NOI18N

        jLabel10.setText("EmployeeID :");

        jLabel11.setText("Name :");

        jLabel12.setText("Address :");

        jLabel13.setText("Home Phone :");

        jLabel14.setText("Mobile NO. :");

        jLabel20.setText("Date of Birth :");

        jLabel21.setText("Age :");

        jLabel22.setText("Surname :");

        jLabel29.setText("Sex :");

        Birth.setBackground(new java.awt.Color(255, 255, 255));
        Birth.setDateFormatString("yyyy-MM-dd");
        Birth.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N

        AddressField.setColumns(20);
        AddressField.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        AddressField.setRows(3);
        jScrollPane6.setViewportView(AddressField);

        jLabel7.setText("Email :");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(NameField, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(139, 139, 139))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addComponent(EmpIDField, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(55, 55, 55)
                                    .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(SexField, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addComponent(MobileNOField, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(AgeField, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addComponent(HomeNOField, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(Birth, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(SurnameField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(EmailField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(SexField)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(EmpIDField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(15, 15, 15)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NameField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SurnameField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(EmailField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(15, 15, 15)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(HomeNOField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Birth, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MobileNOField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AgeField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        AgeField.setEditable(false);
        ((JTextField)Birth.getDateEditor().getUiComponent()).setEditable(false);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "JobInfo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tekton Pro Ext", 0, 18), new java.awt.Color(0, 0, 204))); // NOI18N

        jLabel15.setText("Position :");

        jLabel16.setText("Hire Date :");

        jLabel17.setText("OT Hours :");

        jLabel18.setText("Salary :");

        HireDate.setBackground(new java.awt.Color(255, 255, 255));
        HireDate.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(OTHourField, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PosField, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, 26)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SalaryField, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(HireDate, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(PosField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(HireDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(25, 25, 25)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(OTHourField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SalaryField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        HireDate.setDateFormatString("yyyy-MM-dd");
        ((JTextField)HireDate.getDateEditor().getUiComponent()).setEditable(false);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "OT Calculator", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tekton Pro Ext", 0, 18), new java.awt.Color(0, 0, 255))); // NOI18N

        jLabel25.setText("OT Hours :");

        jLabel26.setText("Total OT Balance :");
        jLabel26.setMinimumSize(new java.awt.Dimension(52, 14));

        jLabel24.setText("OT Rate Per hrs :");
        jLabel24.setMinimumSize(new java.awt.Dimension(52, 14));

        Total.setText("OT Rate x Hrs");

        CalButton.setText("Calculate");
        CalButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CalButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Total, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(OTRateField))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(HoursField)))))
                .addContainerGap())
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(CalButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(OTRateField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(HoursField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(Total, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CalButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        addPic.setText("Change Picture");
        addPic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addPicActionPerformed(evt);
            }
        });

        jButton1.setText("Clear");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Picture, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(addPic)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(AddEm, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addComponent(DelEm, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(EditEm, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(25, 25, 25)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 564, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(Picture, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addPic, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(15, 15, 15)
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(EditEm, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(DelEm, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(AddEm, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(25, 25, 25))
        );

        jTabbedPane1.addTab("Employee", jPanel2);

        jToolBar1.setRollover(true);

        NewTool.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/New_file.png"))); // NOI18N
        NewTool.setFocusable(false);
        NewTool.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        NewTool.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        NewTool.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewToolActionPerformed(evt);
            }
        });
        jToolBar1.add(NewTool);

        OpenTool.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/Open_icon.png"))); // NOI18N
        OpenTool.setFocusable(false);
        OpenTool.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        OpenTool.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        OpenTool.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OpenToolActionPerformed(evt);
            }
        });
        jToolBar1.add(OpenTool);
        jToolBar1.add(jSeparator5);

        pdftool.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/Pdf_icon.png"))); // NOI18N
        pdftool.setFocusable(false);
        pdftool.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        pdftool.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        pdftool.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pdftoolActionPerformed(evt);
            }
        });
        jToolBar1.add(pdftool);
        jToolBar1.add(jSeparator2);

        ExitTool.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/Exit_icon.png"))); // NOI18N
        ExitTool.setFocusable(false);
        ExitTool.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        ExitTool.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        ExitTool.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitToolActionPerformed(evt);
            }
        });
        jToolBar1.add(ExitTool);

        jMenu1.setText("File");

        NewMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        NewMenu.setText("New File");
        NewMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewMenuActionPerformed(evt);
            }
        });
        jMenu1.add(NewMenu);
        jMenu1.add(jSeparator4);

        OpenMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        OpenMenu.setText("Open File");
        OpenMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OpenMenuActionPerformed(evt);
            }
        });
        jMenu1.add(OpenMenu);
        jMenu1.add(jSeparator1);

        PdfMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        PdfMenu.setText("Export as Pdf");
        PdfMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PdfMenuActionPerformed(evt);
            }
        });
        jMenu1.add(PdfMenu);
        jMenu1.add(jSeparator3);

        CloseMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        CloseMenu.setText("close");
        CloseMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CloseMenuActionPerformed(evt);
            }
        });
        jMenu1.add(CloseMenu);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Help");

        Help.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.CTRL_MASK));
        Help.setText("Help file");
        Help.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HelpActionPerformed(evt);
            }
        });
        jMenu2.add(Help);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 950, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 625, Short.MAX_VALUE)
                .addContainerGap())
        );

        jToolBar1.setFloatable(false);

        setBounds(100, 100, 950, 730);
    }// </editor-fold>//GEN-END:initComponents

    private void AddOverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddOverActionPerformed
        if(WorkDir.getText().equals("")){
            JOptionPane.showMessageDialog(null, "You must open file before use \"Overview\" tab.","Can not access file",JOptionPane.ERROR_MESSAGE);
        }else{
            if(!RefField.getText().matches("^[0-9]+")){
                JOptionPane.showMessageDialog(null, "Invalid RefID input. The input must be number.", "Invalid input", JOptionPane.ERROR_MESSAGE);
            }else if(!AmountField.getText().matches("^[0-9]+\\.?[0-9]*")){
                JOptionPane.showMessageDialog(null, "Invalid Amount input. The input must be number(ie. xxx.xx).", "Invalid input", JOptionPane.ERROR_MESSAGE);
            }else{
                try {
                    String sql = "INSERT INTO Overview (RefID,Type,Amount,Date,Employee,Description) VALUES (?,?,?,?,?,?)";
                    pst = con.prepareStatement(sql);
                    pst.setString(1, RefField.getText());
                    pst.setString(2, MoneyBox.getSelectedItem().toString());
                    pst.setString(3, AmountField.getText());
                    pst.setString(4, ((JTextField)DateField.getDateEditor().getUiComponent()).getText());
                    pst.setString(5, EmpField.getText());
                    pst.setString(6, DescripField.getText());

                    pst.execute();
                    update_Table_Overview();
                    JOptionPane.showMessageDialog(null, "Added.");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(),"",JOptionPane.ERROR_MESSAGE);
                }finally{
                    try {
                        pst.close();
                    } catch (Exception ex) {}
                }
            }
        }
    }//GEN-LAST:event_AddOverActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        try{
        int row = jTable1.getSelectedRow();
        
        RefField.setText(jTable1.getValueAt(row, 0).toString());
        AmountField.setText(jTable1.getValueAt(row, 2).toString());
        java.util.Date d;
        String s = jTable1.getValueAt(row, 3).toString();
        DateFormat df = new SimpleDateFormat("yyyy-mm-dd");
        d = df.parse(s);
        DateField.setDate(d);
        EmpField.setText(jTable1.getValueAt(row, 4).toString());
        DescripField.setText(jTable1.getValueAt(row, 5).toString());
        
        if(jTable1.getValueAt(row, 1).toString().equals("Income")){
            MoneyBox.setSelectedIndex(0);
        }else{
            MoneyBox.setSelectedIndex(1);
        }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void ExitToolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitToolActionPerformed
        int p = JOptionPane.showConfirmDialog(null, "Do you want to exit?","Exit",JOptionPane.YES_NO_OPTION);
        if(p==0){
            this.dispose();
        }
    }//GEN-LAST:event_ExitToolActionPerformed

    private void RemoveOverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RemoveOverActionPerformed
        if(WorkDir.getText().equals("")){
            JOptionPane.showMessageDialog(null, "You must open file before use \"Overview\" tab.","Can not access file",JOptionPane.ERROR_MESSAGE);
        }else{
            int p = JOptionPane.showConfirmDialog(null, "Do you really want to delete?","Delete",JOptionPane.YES_NO_OPTION);
            if(p == 0){    
                try{
                    String sql = "Delete from Overview where RefID = ?";
                    pst = con.prepareStatement(sql);
                    pst.setString(1, RefField.getText());
                    pst.execute();
                    update_Table_Overview();
                    RefField.setText("");
                    AmountField.setText("");
                    ((JTextField)DateField.getDateEditor().getUiComponent()).setText("");
                    EmpField.setText("");
                    DescripField.setText("");
                    JOptionPane.showMessageDialog(null, "Deleted.");
                }catch(Exception ex){
                    System.out.println(ex.getMessage());
                }finally{
                    try {
                        pst.close();
                    } catch (Exception ex) {}
                }
            }
        }
    }//GEN-LAST:event_RemoveOverActionPerformed

    private void EditOverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditOverActionPerformed
        try{
            String refID = RefField.getText();
            String type = MoneyBox.getSelectedItem().toString();
            String amount = AmountField.getText();
            String date = ((JTextField)DateField.getDateEditor().getUiComponent()).getText();
            String emp = EmpField.getText();
            String descrip = DescripField.getText();
            String sql = "update Overview set Type = '"+type+"', Amount = '"+amount+"', " +
                    "Date = '"+date+"', Employee = '"+emp+"', Description = '"+descrip+"' where RefID = '"+refID+"' ";
            pst = con.prepareStatement(sql);
            pst.execute();
            update_Table_Overview();
            JOptionPane.showMessageDialog(null, "Edited.");
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try {
                pst.close();
            } catch (Exception ex) {}
        }
    }//GEN-LAST:event_EditOverActionPerformed

    private void CalOverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CalOverActionPerformed
        if(WorkDir.getText().equals("")){
            JOptionPane.showMessageDialog(null, "You must open file before use \"Overview\" tab.","Can not access file",JOptionPane.ERROR_MESSAGE);
        }else{
            try{
                String incomes = "select sum(Amount) from Overview where Type = 'Income'";
                String expenses = "select sum(Amount) from Overview where Type = 'Expense'";
                pst = con.prepareStatement(incomes);
                rs = pst.executeQuery();
                rs.next();
                String income = rs.getString(1);
                Income.setText(income);

                pst = con.prepareStatement(expenses);
                rs = pst.executeQuery();
                rs.next();
                String expense = rs.getString(1);
                Expenses.setText(expense);

                Balance.setText(String.format("%.2f", Double.parseDouble(income) - Double.parseDouble(expense)));
            }catch(Exception ex){
                System.out.println(ex.getMessage());
            }finally{
                try {
                    pst.close();
                    rs.close();
                } catch (Exception ex) {}
            }
        }
    }//GEN-LAST:event_CalOverActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        try{
            int row = jTable2.getSelectedRow();
            java.util.Date d,d2;
            String s = jTable3.getModel().getValueAt(jTable2.convertRowIndexToModel(row), 5).toString();
            String s2 = jTable3.getModel().getValueAt(jTable2.convertRowIndexToModel(row), 10).toString();
            DateFormat df = new SimpleDateFormat("yyyy-mm-dd");
            d = df.parse(s);
            d2 = df.parse(s2);
            pst = con2.prepareStatement("select Pic from Employee where EmployeeID = ?");
            pst.setString(1,jTable3.getValueAt(row, 0).toString());
            rs2 = pst.executeQuery();
            
            EmpIDField.setText(jTable3.getModel().getValueAt(jTable2.convertRowIndexToModel(row), 0).toString());
            NameField.setText(jTable3.getModel().getValueAt(jTable2.convertRowIndexToModel(row), 1).toString());
            SurnameField.setText(jTable3.getModel().getValueAt(jTable2.convertRowIndexToModel(row), 2).toString());
            AddressField.setText(jTable3.getModel().getValueAt(jTable2.convertRowIndexToModel(row), 3).toString());
            SexField.setText(jTable3.getModel().getValueAt(jTable2.convertRowIndexToModel(row), 4).toString());
            Birth.setDate(d);
            EmailField.setText(jTable3.getModel().getValueAt(jTable2.convertRowIndexToModel(row), 6).toString());
            HomeNOField.setText(jTable3.getModel().getValueAt(jTable2.convertRowIndexToModel(row), 7).toString());
            MobileNOField.setText(jTable3.getModel().getValueAt(jTable2.convertRowIndexToModel(row), 8).toString());
            PosField.setText(jTable3.getModel().getValueAt(jTable2.convertRowIndexToModel(row), 9).toString());
            HireDate.setDate(d2);
            OTHourField.setText(jTable3.getModel().getValueAt(jTable2.convertRowIndexToModel(row), 11).toString());
            SalaryField.setText(jTable3.getModel().getValueAt(jTable2.convertRowIndexToModel(row), 12).toString());
            AgeField.setText(age(jTable3.getModel().getValueAt(jTable2.convertRowIndexToModel(row), 5).toString()));
            while(rs2.next()){
                //InputStream is = rs.getBinaryStream(1);
                res = rs2.getBytes("Pic");
                if(res == null){
                    Picture.setIcon(null);
                }else{
                Image bimg = Toolkit.getDefaultToolkit().createImage(res);
                bimg = bimg.getScaledInstance(245, 280, Image.SCALE_SMOOTH);
                ImageIcon n = new ImageIcon();
                n.setImage(bimg);
                Picture.setIcon(n);
                }
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try {
                pst.close();
                rs2.close();
            } catch (Exception ex) {}
        }
    }//GEN-LAST:event_jTable2MouseClicked

    private void AddEmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddEmActionPerformed
        if(!EmpIDField.getText().matches("^[0-9]+")){
            JOptionPane.showMessageDialog(null, "Invalid employeeID input. The input must be number.", "Invalid input", JOptionPane.ERROR_MESSAGE);
        }else if((!SexField.getText().equals("M")) && (!SexField.getText().equals("F"))){
            JOptionPane.showMessageDialog(null, "Invalid sex input. The input must be \"M\" or \"F\".", "Invalid input", JOptionPane.ERROR_MESSAGE);
        }else if(!EmailField.getText().matches("^\\w+\\@\\w+\\.\\w+")){
            JOptionPane.showMessageDialog(null, "Invalid Email input. The input must be only String (ie. \"xxx@xxx.xxx\"). ", "Invalid input", JOptionPane.ERROR_MESSAGE);
        }else if(!HomeNOField.getText().matches("^\\d+")){
            JOptionPane.showMessageDialog(null, "Invalid homeNo. input. The input must be only number (ie. \"xxxxxxx\"). ", "Invalid input", JOptionPane.ERROR_MESSAGE);
        }else if(!MobileNOField.getText().matches("^\\d+")){
            JOptionPane.showMessageDialog(null, "Invalid mobileNo. input. The input must be only number (ie. \"xxxxxxxx\"). ", "Invalid input", JOptionPane.ERROR_MESSAGE);
        }else if(!OTHourField.getText().matches("^\\d+\\.?\\d+")){
            JOptionPane.showMessageDialog(null, "Invalid number of hour input. The input must be only number (ie. \"xx\"). ", "Invalid input", JOptionPane.ERROR_MESSAGE);
        }else if(!SalaryField.getText().matches("^\\d+")){
            JOptionPane.showMessageDialog(null, "Invalid salary input. The input must be only number (ie. \"xxxxx\"). ", "Invalid input", JOptionPane.ERROR_MESSAGE);
        }else{
            try {
                String sql = "INSERT INTO Employee (EmployeeID,Name,Surname,Address,Sex,BirthDate,Email,HomeNO,MobileNO,Position,HireDate,OTHour,Salary,Pic,Age) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                pst = con2.prepareStatement(sql);
                pst.setString(1, EmpIDField.getText());
                pst.setString(2, NameField.getText());
                pst.setString(3, SurnameField.getText());
                pst.setString(4, AddressField.getText());
                pst.setString(5, SexField.getText());
                pst.setString(6, ((JTextField)Birth.getDateEditor().getUiComponent()).getText());
                pst.setString(7, EmailField.getText());
                pst.setString(8, HomeNOField.getText());
                pst.setString(9, MobileNOField.getText());
                pst.setString(10, PosField.getText());
                pst.setString(11, ((JTextField)HireDate.getDateEditor().getUiComponent()).getText());
                pst.setString(12, OTHourField.getText());
                pst.setString(13, SalaryField.getText());
                pst.setBytes(14, person_image);
                pst.setString(15, AgeField.getText());
                pst.execute();
                update_Table_Employee();
                JOptionPane.showMessageDialog(null, "Added.");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(),"",JOptionPane.ERROR_MESSAGE);
            }finally{
                try {
                    pst.close();
                } catch (Exception ex) {}
            }
        }
    }//GEN-LAST:event_AddEmActionPerformed

    private void DelEmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DelEmActionPerformed
        int p = JOptionPane.showConfirmDialog(null, "Do you really want to delete?","Delete",JOptionPane.YES_NO_OPTION);
        if(p == 0){
            try{
                String sql = "Delete from Employee where EmployeeID = ?";
                pst = con2.prepareStatement(sql);
                pst.setString(1, EmpIDField.getText());
                pst.execute();
                update_Table_Employee();
                JOptionPane.showMessageDialog(null, "Deleted.");
            }catch(Exception ex){
                System.out.println(ex.getMessage());
            }finally{
                try {
                    pst.close();
                } catch (Exception ex) {}
            }
            EmpIDField.setText("");
            NameField.setText("");
            SurnameField.setText("");
            AddressField.setText("");
            SexField.setText("");
            ((JTextField)Birth.getDateEditor().getUiComponent()).setText("");
            EmailField.setText("");
            HomeNOField.setText("");
            MobileNOField.setText("");
            PosField.setText("");
            ((JTextField)HireDate.getDateEditor().getUiComponent()).setText("");
            OTHourField.setText("");
            SalaryField.setText("");
            AgeField.setText("");
            Picture.setIcon(null);
            Picture.revalidate();
        }
    }//GEN-LAST:event_DelEmActionPerformed

    private void EditEmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditEmActionPerformed
        try{
            int row = jTable2.getSelectedRow();
            String emp = EmpIDField.getText();
            String name = NameField.getText();
            String surname = SurnameField.getText();
            String address = AddressField.getText();
            String sex = SexField.getText();
            String home = HomeNOField.getText();
            String mobile = MobileNOField.getText();
            String pos = PosField.getText();
            String hireDate = ((JTextField)HireDate.getDateEditor().getUiComponent()).getText();;
            String OT = OTHourField.getText();
            String sal = SalaryField.getText();
            String birth = ((JTextField)Birth.getDateEditor().getUiComponent()).getText();
            String Email = EmailField.getText();
            String sql = "update Employee set Name = '"+name+"',Surname = '"+surname+"', Address = '"+address+"', " +
                     "Sex = '"+sex+"', BirthDate = '"+birth+"', Email = '"+Email+"', HomeNO = '"+home+"', MobileNO = '"+mobile+"', Position = '"+pos+"', " +
                     "HireDate = '"+hireDate+"', OTHour = '"+OT+"', Salary = '"+sal+"', Pic = ? where EmployeeID = '"+emp+"' ";
            pst = con2.prepareStatement(sql);
            if(person_image != null){
                pst.setBytes(1, person_image);
            }else{
                pst.setBytes(1, res);
            }
            pst.executeUpdate();
            update_Table_Employee();
            AgeField.setText(age(jTable3.getModel().getValueAt(jTable2.convertRowIndexToModel(row), 5).toString()));
            JOptionPane.showMessageDialog(null, "Edited.");
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try {
                pst.close();
            } catch (Exception ex) {}
        }
    }//GEN-LAST:event_EditEmActionPerformed

    private void CalButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CalButtonActionPerformed
        int a = Integer.parseInt(OTRateField.getText());
        int b = Integer.parseInt(HoursField.getText());
        Total.setText(String.valueOf(a*b));
    }//GEN-LAST:event_CalButtonActionPerformed

    private void addPicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addPicActionPerformed
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File f = chooser.getSelectedFile();
        filename = f.getAbsolutePath();
        System.out.println(filename.substring(filename.length()-4));
        if((filename.substring(filename.length()-5).equals(".jpeg")) || (filename.substring(filename.length()-4).equals(".png")) || (filename.substring(filename.length()-4).equals(".jpg"))){
            try{
                File image = new File(filename);
                FileInputStream fis = new FileInputStream(image);

                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                byte[] buf = new byte[1024];
                for(int readNum; (readNum=fis.read(buf))!=-1;){
                    bos.write(buf,0,readNum);
                }
                person_image = bos.toByteArray();
                ImageIcon i = new ImageIcon(filename);
                Image im = i.getImage();
                Image newimg = im.getScaledInstance(245, 280, java.awt.Image.SCALE_SMOOTH);
                i = new ImageIcon(newimg);  // transform it back
                Picture.setIcon(i);
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
            }
        }else{
            JOptionPane.showMessageDialog(null, "Please, select file type \".png .jpg or .jpeg\".");
        }
    }//GEN-LAST:event_addPicActionPerformed

    private void jTable1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyReleased
        if((evt.getKeyCode() == KeyEvent.VK_UP) || (evt.getKeyCode() == KeyEvent.VK_DOWN)){
            try{
                int row = jTable1.getSelectedRow();
                java.util.Date d;
                String s = jTable1.getValueAt(row, 3).toString();
                DateFormat df = new SimpleDateFormat("yyyy-mm-dd");
                d = df.parse(s);
                RefField.setText(jTable1.getValueAt(row, 0).toString());
                AmountField.setText(jTable1.getValueAt(row, 2).toString());
                DateField.setDate(d);
                EmpField.setText(jTable1.getValueAt(row, 4).toString());
                DescripField.setText(jTable1.getValueAt(row, 5).toString());
        
                if(jTable1.getValueAt(row, 1).toString().equals("Income")){
                    MoneyBox.setSelectedIndex(0);
                }else{
                    MoneyBox.setSelectedIndex(1);
                }
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
    }//GEN-LAST:event_jTable1KeyReleased

    private void jTable2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable2KeyReleased
        if((evt.getKeyCode() == KeyEvent.VK_UP) || (evt.getKeyCode() == KeyEvent.VK_DOWN)){
            try{
                int row = jTable2.getSelectedRow();
                java.util.Date d,d2;
                String s = jTable3.getModel().getValueAt(jTable2.convertRowIndexToModel(row), 5).toString();
                String s2 = jTable3.getModel().getValueAt(jTable2.convertRowIndexToModel(row), 10).toString();
                DateFormat df = new SimpleDateFormat("yyyy-mm-dd");
                d = df.parse(s);
                d2 = df.parse(s2);
                pst = con2.prepareStatement("select Pic from Employee where EmployeeID = ?");
                pst.setString(1,jTable3.getValueAt(row, 0).toString());
                rs2 = pst.executeQuery();

                EmpIDField.setText(jTable3.getModel().getValueAt(jTable2.convertRowIndexToModel(row), 0).toString());
                NameField.setText(jTable3.getModel().getValueAt(jTable2.convertRowIndexToModel(row), 1).toString());
                SurnameField.setText(jTable3.getModel().getValueAt(jTable2.convertRowIndexToModel(row), 2).toString());
                AddressField.setText(jTable3.getModel().getValueAt(jTable2.convertRowIndexToModel(row), 3).toString());
                SexField.setText(jTable3.getModel().getValueAt(jTable2.convertRowIndexToModel(row), 4).toString());
                Birth.setDate(d);
                EmailField.setText(jTable3.getModel().getValueAt(jTable2.convertRowIndexToModel(row), 6).toString());
                HomeNOField.setText(jTable3.getModel().getValueAt(jTable2.convertRowIndexToModel(row), 7).toString());
                MobileNOField.setText(jTable3.getModel().getValueAt(jTable2.convertRowIndexToModel(row), 8).toString());
                PosField.setText(jTable3.getModel().getValueAt(jTable2.convertRowIndexToModel(row), 9).toString());
                HireDate.setDate(d2);
                OTHourField.setText(jTable3.getModel().getValueAt(jTable2.convertRowIndexToModel(row), 11).toString());
                SalaryField.setText(jTable3.getModel().getValueAt(jTable2.convertRowIndexToModel(row), 12).toString());
                AgeField.setText(age(jTable3.getModel().getValueAt(jTable2.convertRowIndexToModel(row), 5).toString()));
                while(rs2.next()){
                    //InputStream is = rs.getBinaryStream(1);
                    res = rs2.getBytes("Pic");
                    if(res == null){
                        Picture.setIcon(null);
                    }else{
                    Image bimg = Toolkit.getDefaultToolkit().createImage(res);
                    bimg = bimg.getScaledInstance(245, 280, Image.SCALE_SMOOTH);
                    ImageIcon n = new ImageIcon();
                    n.setImage(bimg);
                    Picture.setIcon(n);
                    }
                }
            }catch(Exception ex){
                System.out.println(ex.getMessage());
            }finally{
                try {
                    pst.close();
                    rs2.close();
                } catch (Exception ex) {}
            }
        }
    }//GEN-LAST:event_jTable2KeyReleased

    private void pdftoolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pdftoolActionPerformed
        if(Income.getText().equals("") && Expenses.getText().equals("") && Balance.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Balance doesn't calculate.");
        }else{
            try {
                String x = JOptionPane.showInputDialog(null,"Insert your report name");
                if(x != null && x.length() > 0){
                    int row = jTable1.getRowCount();
                    Document document = new Document();
                    PdfWriter.getInstance(document,new FileOutputStream("Report/" + x + ".pdf"));
                    
                    document.open();
                    Paragraph ph = new Paragraph("Telecom fiber 2009 Limited partnership \n "
                            + "25/6 Village No.5, Suwannasorn Road, \n"
                            + "Tumbon Huai khamin, Amphoe Nong Khae \n"
                            + "Saraburi Province 18230 Fax. 036-389811 \n"
                            + "Tel.085-6611219,086-3285339 \n"
                            + "E-mail bouriano@yahoo.com",FontFactory.getFont(FontFactory.COURIER,10));
                    com.itextpdf.text.Image image =com.itextpdf.text.Image.getInstance("logo.jpg");
                    ph.add(new Chunk(image,200,-30));
                    ph.setAlignment(Element.ALIGN_LEFT);
                    document.add(ph);
                    
                    //image.setAlignment(Element.ALIGN_RIGHT);
                    //document.add(image);
                    //document.add(new Paragraph("Hello World",FontFactory.getFont(FontFactory.TIMES,18,Font.BOLD,BaseColor.BLUE)));
                    PdfPTable table = new PdfPTable(6);
                    document.add(new Paragraph("\n\n"));
                    int m = (new java.util.Date().getMonth()) + 1;
                    int y = (new java.util.Date().getYear()) + 1900;
                    int d = new java.util.Date().getDate();
                    Paragraph date = new Paragraph(String.format("Date %d/%d/%d%-10s", d,m,y,""),FontFactory.getFont(FontFactory.COURIER,14));
                    date.setAlignment(Element.ALIGN_RIGHT);
                    document.add(date);
                    Paragraph topic = new Paragraph("Income/Expense",FontFactory.getFont(FontFactory.HELVETICA_BOLD,18,BaseColor.BLUE));
                    topic.setAlignment(Element.ALIGN_CENTER);
                    document.add(topic);
                    document.add(new Paragraph("\n"));
                    PdfPCell cell1 = new PdfPCell(new Paragraph("RefID"));
                    PdfPCell cell2 = new PdfPCell(new Paragraph("Type"));
                    PdfPCell cell3 = new PdfPCell(new Paragraph("Amount"));
                    PdfPCell cell4 = new PdfPCell(new Paragraph("Date"));
                    PdfPCell cell5 = new PdfPCell(new Paragraph("Employee"));
                    PdfPCell cell6 = new PdfPCell(new Paragraph("Description"));

                    cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
                    cell1.setBackgroundColor(BaseColor.YELLOW);
                    cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
                    cell2.setBackgroundColor(BaseColor.YELLOW);
                    cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
                    cell3.setBackgroundColor(BaseColor.YELLOW);
                    cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
                    cell4.setBackgroundColor(BaseColor.YELLOW);
                    cell5.setHorizontalAlignment(Element.ALIGN_CENTER);
                    cell5.setBackgroundColor(BaseColor.YELLOW);
                    cell6.setHorizontalAlignment(Element.ALIGN_CENTER);
                    cell6.setBackgroundColor(BaseColor.YELLOW);

                    table.addCell(cell1);
                    table.addCell(cell2);
                    table.addCell(cell3);
                    table.addCell(cell4);
                    table.addCell(cell5);
                    table.addCell(cell6);

                    for(int i  =0;i<row;i++){
                        for(int j = 0;j<6;j++){
                            table.addCell(jTable1.getValueAt(i, j).toString());
                        }
                    }
                    document.add(table);

                    Paragraph p1 = new Paragraph(String.format("%-20s%10s%10s","Total Income : ",Income.getText(),"Baht"));
                    p1.setAlignment(Element.ALIGN_RIGHT);
                    Paragraph p2 = new Paragraph(String.format("%-20s%10s%10s","Total Expense : ",Expenses.getText(),"Baht"));
                    p2.setAlignment(Element.ALIGN_RIGHT);
                    Paragraph p3 = new Paragraph(String.format("%-20s%10s%10s","Total Balance : ",Balance.getText(),"Baht"));
                    p3.setAlignment(Element.ALIGN_RIGHT);
                    document.add(p1);
                    document.add(p2);
                    document.add(p3);
                    document.close();
                    JOptionPane.showMessageDialog(null, "Finish make report. File has been saved in folder \"Report\"");
                }else{

                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }
    }//GEN-LAST:event_pdftoolActionPerformed

    private void CloseMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CloseMenuActionPerformed
        int p = JOptionPane.showConfirmDialog(null, "Do you want to exit?","Exit",JOptionPane.YES_NO_OPTION);
        if(p==0){
            this.dispose();
        }
    }//GEN-LAST:event_CloseMenuActionPerformed

    private void PdfMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PdfMenuActionPerformed
        if(Income.getText().equals("") && Expenses.getText().equals("") && Balance.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Balance doesn't calculate.");
        }else{
            try {
                String x = JOptionPane.showInputDialog(null,"Insert your report name");
                if(x != null && x.length() > 0){
                    int row = jTable1.getRowCount();
                    Document document = new Document();
                    PdfWriter.getInstance(document,new FileOutputStream("Report/" + x + ".pdf"));
                    
                    document.open();
                    Paragraph ph = new Paragraph("Telecom fiber 2009 Limited partnership \n "
                            + "25/6 Village No.5, Suwannasorn Road, \n"
                            + "Tumbon Huai khamin, Amphoe Nong Khae \n"
                            + "Saraburi Province 18230 Fax. 036-389811 \n"
                            + "Tel.085-6611219,086-3285339 \n"
                            + "E-mail bouriano@yahoo.com",FontFactory.getFont(FontFactory.COURIER,10));
                    com.itextpdf.text.Image image =com.itextpdf.text.Image.getInstance("logo.jpg");
                    ph.add(new Chunk(image,200,-30));
                    ph.setAlignment(Element.ALIGN_LEFT);
                    document.add(ph);
                    
                    //image.setAlignment(Element.ALIGN_RIGHT);
                    //document.add(image);
                    //document.add(new Paragraph("Hello World",FontFactory.getFont(FontFactory.TIMES,18,Font.BOLD,BaseColor.BLUE)));
                    PdfPTable table = new PdfPTable(6);
                    document.add(new Paragraph("\n\n"));
                    int m = (new java.util.Date().getMonth()) + 1;
                    int y = (new java.util.Date().getYear()) + 1900;
                    int d = new java.util.Date().getDate();
                    Paragraph date = new Paragraph(String.format("Date %d/%d/%d%-10s", d,m,y,""),FontFactory.getFont(FontFactory.COURIER,14));
                    date.setAlignment(Element.ALIGN_RIGHT);
                    document.add(date);
                    Paragraph topic = new Paragraph("Income/Expense",FontFactory.getFont(FontFactory.HELVETICA_BOLD,18,BaseColor.BLUE));
                    topic.setAlignment(Element.ALIGN_CENTER);
                    document.add(topic);
                    document.add(new Paragraph("\n"));
                    PdfPCell cell1 = new PdfPCell(new Paragraph("RefID"));
                    PdfPCell cell2 = new PdfPCell(new Paragraph("Type"));
                    PdfPCell cell3 = new PdfPCell(new Paragraph("Amount"));
                    PdfPCell cell4 = new PdfPCell(new Paragraph("Date"));
                    PdfPCell cell5 = new PdfPCell(new Paragraph("Employee"));
                    PdfPCell cell6 = new PdfPCell(new Paragraph("Description"));

                    cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
                    cell1.setBackgroundColor(BaseColor.YELLOW);
                    cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
                    cell2.setBackgroundColor(BaseColor.YELLOW);
                    cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
                    cell3.setBackgroundColor(BaseColor.YELLOW);
                    cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
                    cell4.setBackgroundColor(BaseColor.YELLOW);
                    cell5.setHorizontalAlignment(Element.ALIGN_CENTER);
                    cell5.setBackgroundColor(BaseColor.YELLOW);
                    cell6.setHorizontalAlignment(Element.ALIGN_CENTER);
                    cell6.setBackgroundColor(BaseColor.YELLOW);

                    table.addCell(cell1);
                    table.addCell(cell2);
                    table.addCell(cell3);
                    table.addCell(cell4);
                    table.addCell(cell5);
                    table.addCell(cell6);

                    for(int i  =0;i<row;i++){
                        for(int j = 0;j<6;j++){
                            table.addCell(jTable1.getValueAt(i, j).toString());
                        }
                    }
                    document.add(table);

                    Paragraph p1 = new Paragraph(String.format("%-20s%10s%10s","Total Income : ",Income.getText(),"Baht"));
                    p1.setAlignment(Element.ALIGN_RIGHT);
                    Paragraph p2 = new Paragraph(String.format("%-20s%10s%10s","Total Expense : ",Expenses.getText(),"Baht"));
                    p2.setAlignment(Element.ALIGN_RIGHT);
                    Paragraph p3 = new Paragraph(String.format("%-20s%10s%10s","Total Balance : ",Balance.getText(),"Baht"));
                    p3.setAlignment(Element.ALIGN_RIGHT);
                    document.add(p1);
                    document.add(p2);
                    document.add(p3);
                    document.close();
                    JOptionPane.showMessageDialog(null, "Finish make report. File has been saved in folder \"Report\"");
                }else{

                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }
        /*MessageFormat header = new MessageFormat("Report Print");
        MessageFormat header2 = new MessageFormat("Report Print");
        MessageFormat footer = new MessageFormat("page{0,number,integer}");
        try{
            jTable2.print(JTable.PrintMode.NORMAL,header2,footer);
            jTable1.print(JTable.PrintMode.FIT_WIDTH,header,footer);

        }catch(PrinterException ex){
            System.err.format("Cannot print %s%n", ex.getMessage());
        }*/
    }//GEN-LAST:event_PdfMenuActionPerformed

    private void OpenMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OpenMenuActionPerformed
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File f = chooser.getSelectedFile();
        filename = f.getAbsolutePath();
        if(filename.substring(filename.length()-7).equals(".sqlite")){
            WorkDir.setText(filename);
            try {
                File file = new File("save.txt");
                fop = new FileOutputStream(file);
                if(!file.exists()){
                    file.createNewFile();
                }
                String o = "\n";
                byte[] content = filename.getBytes();
                fop.write(content);
                fop.flush();
                fop.close();
            } catch (Exception ex) {

            }
            update_Table_Overview();
            filename = "";
        }else{
            JOptionPane.showMessageDialog(null, "Invalid file to open. Only file \".sqlite\" are allow.","Wrong file type",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_OpenMenuActionPerformed

    private void NewMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NewMenuActionPerformed
        try {
            String s = JOptionPane.showInputDialog(null, "Insert your file name", "Insert file name", JOptionPane.INFORMATION_MESSAGE);
            if (s != null && s.length() > 0){
                JOptionPane.showMessageDialog(null, "The file has been saved in folder \"DB\". \nYou must open file before use the program. (File -> Open File)");
                File dbFile = new File("DB/" + s + ".sqlite");
                
                dbFile.delete();

                SqlJetDb db = SqlJetDb.open(dbFile, true);
                db.getOptions().setAutovacuum(true);
                db.runTransaction(new ISqlJetTransaction() {
                    public Object run(SqlJetDb db) throws SqlJetException {
                        db.getOptions().setUserVersion(1);
                        return true;
                    }
                }, SqlJetTransactionMode.WRITE);
                db.beginTransaction(SqlJetTransactionMode.WRITE);
                try {
                    String createTableOverview = "CREATE TABLE 'Overview' (RefID VARCHAR PRIMARY KEY NOT NULL, Type TEXT NOT NULL, Amount DOUBLE NOT NULL,Date DATETIME NOT NULL,"
                    + "Employee TEXT NOT NULL, Description TEXT);";
                    
                    db.createTable(createTableOverview);
                } finally {
                    db.commit();
                }
                db.close();
            }else{
                
            }
        }catch (Exception ex) {
            
        }
    }//GEN-LAST:event_NewMenuActionPerformed
    
    private void HelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HelpActionPerformed
        try{
            File f = new File("Readme.txt");
            filename = f.getAbsolutePath();
            
            if(!f.exists()){
                JOptionPane.showMessageDialog(null, "Error!! cannot find file Help.");
            }
            Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler "+filename);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error!! cannot find \"Readme.txt\".");
        }
    }//GEN-LAST:event_HelpActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        EmpIDField.setText("");
        NameField.setText("");
        SurnameField.setText("");
        AddressField.setText("");
        SexField.setText("");
        ((JTextField)Birth.getDateEditor().getUiComponent()).setText("");
        EmailField.setText("");
        HomeNOField.setText("");
        MobileNOField.setText("");
        PosField.setText("");
        ((JTextField)HireDate.getDateEditor().getUiComponent()).setText("");
        OTHourField.setText("");
        SalaryField.setText("");
        AgeField.setText("");
        Picture.setIcon(null);
        Picture.revalidate();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void RefFieldMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RefFieldMousePressed
        if(WorkDir.getText().equals("")){
            JOptionPane.showMessageDialog(null, "You must open file before use \"Overview\" tab.","Can not access file",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_RefFieldMousePressed

    private void AmountFieldMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AmountFieldMousePressed
        if(WorkDir.getText().equals("")){
            JOptionPane.showMessageDialog(null, "You must open file before use \"Overview\" tab.","Can not access file",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_AmountFieldMousePressed

    private void EmpFieldMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EmpFieldMousePressed
        if(WorkDir.getText().equals("")){
            JOptionPane.showMessageDialog(null, "You must open file before use \"Overview\" tab.","Can not access file",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_EmpFieldMousePressed

    private void DescripFieldMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DescripFieldMousePressed
        if(WorkDir.getText().equals("")){
            JOptionPane.showMessageDialog(null, "You must open file before use \"Overview\" tab.","Can not access file",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_DescripFieldMousePressed

    private void ClearOverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearOverActionPerformed
        RefField.setText("");
        AmountField.setText("");
        ((JTextField)DateField.getDateEditor().getUiComponent()).setText("");
        EmpField.setText("");
        DescripField.setText("");
    }//GEN-LAST:event_ClearOverActionPerformed

    private void EditOverMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EditOverMousePressed
        if(WorkDir.getText().equals("")){
            JOptionPane.showMessageDialog(null, "You must open file before use \"Overview\" tab.","Can not access file",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_EditOverMousePressed

    private void ClearOverMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ClearOverMousePressed
        if(WorkDir.getText().equals("")){
            JOptionPane.showMessageDialog(null, "You must open file before use \"Overview\" tab.","Can not access file",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_ClearOverMousePressed

    private void NewToolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NewToolActionPerformed
        try {
            String s = JOptionPane.showInputDialog(null, "Insert your file name", "Insert file name", JOptionPane.INFORMATION_MESSAGE);
            if (s != null && s.length() > 0){
                JOptionPane.showMessageDialog(null, "The file has been saved in folder \"DB\". \nYou must open file before use the program. (File -> Open File)");
                File dbFile = new File("DB/" + s + ".sqlite");
                dbFile.delete();

                SqlJetDb db = SqlJetDb.open(dbFile, true);
                db.getOptions().setAutovacuum(true);
                db.runTransaction(new ISqlJetTransaction() {
                    public Object run(SqlJetDb db) throws SqlJetException {
                        db.getOptions().setUserVersion(1);
                        return true;
                    }
                }, SqlJetTransactionMode.WRITE);
                db.beginTransaction(SqlJetTransactionMode.WRITE);
                try {
                    String createTableOverview = "CREATE TABLE 'Overview' (RefID VARCHAR PRIMARY KEY NOT NULL, Type TEXT NOT NULL, Amount DOUBLE NOT NULL,Date DATETIME NOT NULL,"
                    + "Employee TEXT NOT NULL, Description TEXT);";
                    
                    db.createTable(createTableOverview);
                } finally {
                    db.commit();
                }
                db.close();
            }else{
                
            }
        }catch (Exception ex) {
            
        }
    }//GEN-LAST:event_NewToolActionPerformed

    private void OpenToolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OpenToolActionPerformed
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File f = chooser.getSelectedFile();
        filename = f.getAbsolutePath();
        if(filename.substring(filename.length()-7).equals(".sqlite")){
            WorkDir.setText(filename);
            try {
                File file = new File("save.txt");
                fop = new FileOutputStream(file);
                if(!file.exists()){
                    file.createNewFile();
                }
                String o = "\n";
                byte[] content = filename.getBytes();
                fop.write(content);
                fop.flush();
                fop.close();
            } catch (Exception ex) {

            }
            update_Table_Overview();
            filename = "";
        }else{
            JOptionPane.showMessageDialog(null, "Invalid file to open. Only file \".sqlite\" are allow.","Wrong file type",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_OpenToolActionPerformed
           
    private String age(String x){
        int a = Integer.parseInt(x.substring(0,4));
        Calendar cal = new GregorianCalendar();
        int year  = cal.get(Calendar.YEAR);
        String b = String.valueOf(year-a);
        return b;
    }
    
    private String employeePath(){
        File ff = new File("Employee.sqlite");
        if(!ff.isFile()){
            JOptionPane.showMessageDialog(null, "File \"Employee.sqlite\" not found. Please move file to the same directory as program.","\"Employee.sqlite\" not found",JOptionPane.ERROR_MESSAGE);
            this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
            return "";
        }else{
            filename = ff.getAbsolutePath();
            emPath = filename;
            System.out.println(emPath);
            return emPath;
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://downopen.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frame().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddEm;
    private javax.swing.JButton AddOver;
    private javax.swing.JTextArea AddressField;
    private javax.swing.JTextField AgeField;
    private javax.swing.JTextField AmountField;
    private javax.swing.JLabel Balance;
    private com.toedter.calendar.JDateChooser Birth;
    private javax.swing.JButton CalButton;
    private javax.swing.JButton CalOver;
    private javax.swing.JButton ClearOver;
    private javax.swing.JMenuItem CloseMenu;
    private com.toedter.calendar.JDateChooser DateField;
    private javax.swing.JButton DelEm;
    private javax.swing.JTextArea DescripField;
    private javax.swing.JButton EditEm;
    private javax.swing.JButton EditOver;
    private javax.swing.JTextField EmailField;
    private javax.swing.JTextArea EmpField;
    private javax.swing.JTextField EmpIDField;
    private javax.swing.JButton ExitTool;
    private javax.swing.JLabel Expenses;
    private javax.swing.JMenuItem Help;
    private com.toedter.calendar.JDateChooser HireDate;
    private javax.swing.JTextField HomeNOField;
    private javax.swing.JTextField HoursField;
    private javax.swing.JLabel Income;
    private javax.swing.JLabel LabalBal;
    private javax.swing.JTextField MobileNOField;
    private javax.swing.JComboBox MoneyBox;
    private javax.swing.JTextField NameField;
    private javax.swing.JMenuItem NewMenu;
    private javax.swing.JButton NewTool;
    private javax.swing.JTextField OTHourField;
    private javax.swing.JTextField OTRateField;
    private javax.swing.JMenuItem OpenMenu;
    private javax.swing.JButton OpenTool;
    private javax.swing.JMenuItem PdfMenu;
    private javax.swing.JLabel Picture;
    private javax.swing.JTextField PosField;
    private javax.swing.JTextField RefField;
    private javax.swing.JButton RemoveOver;
    private javax.swing.JTextField SalaryField;
    private javax.swing.JTextField SexField;
    private javax.swing.JTextField SurnameField;
    private javax.swing.JLabel Total;
    private javax.swing.JLabel WorkDir;
    private javax.swing.JButton addPic;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JToolBar.Separator jSeparator5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JButton pdftool;
    // End of variables declaration//GEN-END:variables
}
