/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentregister;

import java.io.File;
import java.time.LocalDate;
import java.time.Year;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author ndm3324
 */
public class StudentInfo {
    private String firstName, lastName;
    private String studentID;
    private LocalDate birthDate;
    private String pictureFileLocation;
    private char gender;
    private List<String> enrolledPapers;
    
    public StudentInfo(String studentID)
    {
        this.studentID = studentID;
        firstName = "";
        lastName = "";
        birthDate = LocalDate.of(1990,01,01);
        pictureFileLocation = null;
        gender = 'M';
        enrolledPapers = new ArrayList<>();
    }
    
    public StudentInfo(String studentID, String firstname, String lastname, LocalDate birthdate, char gender)
    {
        this.firstName = firstname;
        this.lastName = lastname;
        this.birthDate = birthdate;
        this.studentID = studentID;
        this.gender = gender;
        enrolledPapers = new ArrayList<>();
    }
    
    public void addPaper(String paper)
    {
        enrolledPapers.add(paper);
    }
    
    public List<String> getEnrolledPapers()
    {
        return enrolledPapers;
    }
    
//    public void setEnrolledPapers(List<String> papers)
//    {
//        enrolledPapers = papers;
//    }
    
    public void setPictureFromFileName(String filename)
    {
        pictureFileLocation = filename;
    }
    
    public String getPictureFileName()
    {
        return pictureFileLocation;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getStudentID() {
        return studentID;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public char getGender() {
        return gender;
    }
    
    public JPanel getStudentPanel(boolean add)
    {
        return new StudentPanel(add);
    }
    
    public class StudentPanel extends JPanel
    {
//        private JTextField firstNameField, lastNameField, studentIDField;
//        private JComboBox birthDateBox, birthMonthBox, birthYearBox;
//        private JRadioButton genderM, genderF;
        private final Integer[] months = new Integer[] {1,2,3,4,5,6,7,8,9,10,11,12};
        private ArrayList<Integer> days = new ArrayList<>();
        private ArrayList<Integer> years = new ArrayList<>();
        
        public StudentPanel(boolean add)
        {
            initComponents();
            studentIDField.setEnabled(add);
        }
        
        private void initYearList()
        {
            int minYear = 1900;
            for (int year = minYear; year <= Year.now().getValue(); year++)
            {
                years.add(year);
            } 
            Integer[] yearsArray = years.toArray(new Integer[0]);
            birthYearBox = new JComboBox(yearsArray);
            birthYearBox.setSelectedItem(birthDate.getYear());
        }
        
        private void initMonthList()
        {
            birthMonthBox = new JComboBox(months);
            birthMonthBox.setSelectedItem(birthDate.getMonthValue());
        }
                
        private void initDaysList()
        {
            updateDaysList();
            birthDateBox.setSelectedItem(birthDate.getDayOfMonth());
        }
        
        private void updateDaysList()
        {
            birthDateBox.removeAllItems();
            YearMonth yearMonthObject = YearMonth.of((int)birthYearBox.getSelectedItem(),(int)birthMonthBox.getSelectedItem());
            for (int days = 1; days<=yearMonthObject.lengthOfMonth(); days++)
            {
                birthDateBox.addItem(days);
            }
//            Integer[] daysArray = days.toArray(new Integer[0]);
//            birthDateBox = new JComboBox(daysArray);
        }

    
    // End of variables declaration       
        private void initComponents() {

        genderGroup = new javax.swing.ButtonGroup();
        studentIDField = new javax.swing.JTextField();
        firstNameField = new javax.swing.JTextField();
        lastNameField = new javax.swing.JTextField();
        birthDateBox = new javax.swing.JComboBox<>();
        birthMonthBox = new javax.swing.JComboBox<>();
        birthYearBox = new javax.swing.JComboBox<>();
        genderM = new javax.swing.JRadioButton();
        genderF = new javax.swing.JRadioButton();
//        selectedPaperButton = new javax.swing.JButton();
        studentIDLable = new javax.swing.JLabel();
        firstNameLable = new javax.swing.JLabel();
        lastNameLable = new javax.swing.JLabel();
        dayLable = new javax.swing.JLabel();
        monthLable = new javax.swing.JLabel();
        yearLable = new javax.swing.JLabel();
        DOBLable = new javax.swing.JLabel();
        studentDetailsLable = new javax.swing.JLabel();
        genderLable = new javax.swing.JLabel();
//        addPaperButton = new javax.swing.JButton();
        changePictureButton = new javax.swing.JButton();
        saveChangesButton = new javax.swing.JButton();
        studentPhotoCanvas = new javax.swing.JLabel();
        
        studentIDField.setText(studentID);

        firstNameField.setText(firstName);

        lastNameField.setText(lastName);
        
        genderGroup.add(genderM);
        genderGroup.add(genderF);
        
        genderM.setSelected(Character.toUpperCase(gender) == 'M');
        genderF.setSelected(Character.toUpperCase(gender) == 'F');

        initYearList();
        birthYearBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                birthYearBoxItemStateChanged(evt);
            }
        });
        
        initMonthList();
        birthMonthBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                birthMonthBoxItemStateChanged(evt);
            }
        });
        
        initDaysList();


        genderM.setText("Male");

        genderF.setText("Female");

//        selectedPaperButton.setText("Selected Papers");
//        selectedPaperButton.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                selectedPaperButtonActionPerformed(evt);
//            }
//        });

        studentIDLable.setText("Student ID");

        firstNameLable.setText("First Name");

        lastNameLable.setText("Last Name");

        dayLable.setText("Day");

        monthLable.setText("Month");

        yearLable.setText("Year");

        DOBLable.setText("Date of Birth:");

        studentDetailsLable.setText("Student Details:");

        genderLable.setText("Gender");

//        addPaperButton.setText("Add Paper");
//        addPaperButton.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                addPaperButtonActionPerformed(evt);
//            }
//        });

        changePictureButton.setText("Change Picture");
        changePictureButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changePictureButtonActionPerformed(evt);
            }
        });

        saveChangesButton.setText("Save Changes");
        saveChangesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveChangesButtonActionPerformed(evt);
            }
        });
        
        studentPhotoCanvas.setBackground(new java.awt.Color(255, 255, 255));
        studentPhotoCanvas.setSize(new java.awt.Dimension(275, 417));
        studentPhotoCanvas.setMaximumSize(new java.awt.Dimension(275, 417));
        studentPhotoCanvas.setMinimumSize(new java.awt.Dimension(275, 417));
        studentPhotoCanvas.setPreferredSize(new java.awt.Dimension(275, 417));
        
        if(studentPhotoCanvas !=null)
        {
            studentPhotoCanvas.setIcon(new ImageIcon(pictureFileLocation));
        }
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(studentPhotoCanvas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(changePictureButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(saveChangesButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(studentIDLable)
                                    .addComponent(firstNameLable, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lastNameLable, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(firstNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lastNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(studentIDField, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(studentDetailsLable)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(monthLable)
                                    .addComponent(dayLable)
                                    .addComponent(yearLable)
                                    .addComponent(genderLable))
                                .addGap(33, 33, 33)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(DOBLable)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(birthYearBox, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(birthMonthBox, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(birthDateBox, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(genderM)
                                        .addGap(18, 18, 18)
                                        .addComponent(genderF)))))
                        .addGap(20, 20, 20))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(studentDetailsLable)
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(studentIDField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(studentIDLable))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(firstNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(firstNameLable))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lastNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lastNameLable))
                        .addGap(50, 50, 50)
                        .addComponent(DOBLable)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(birthDateBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dayLable))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(birthMonthBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(monthLable))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(birthYearBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(yearLable))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(genderM)
                            .addComponent(genderF)
                            .addComponent(genderLable))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(changePictureButton)
                            .addComponent(saveChangesButton)))
                    .addComponent(studentPhotoCanvas, javax.swing.GroupLayout.DEFAULT_SIZE, 429, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>                                                          

    private void changePictureButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                    
        JFileChooser chooser = new JFileChooser(new File("."));
        FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG, GIF and PNG", "jpg","gif","png");
        chooser.setFileFilter(filter);
        int status = chooser.showOpenDialog(this);
        if (status == JFileChooser.APPROVE_OPTION)
        {  
            File fileToOpen = chooser.getSelectedFile();
            pictureFileLocation = fileToOpen.getPath();
            studentPhotoCanvas.setIcon(new ImageIcon(pictureFileLocation));
        }
        
    }                                                   

    private void saveChangesButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                  
        studentID = studentIDField.getText();
        firstName = firstNameField.getText();
        lastName = lastNameField.getText();
        birthDate = LocalDate.of((int)birthYearBox.getSelectedItem(),(int)birthMonthBox.getSelectedItem(),(int)birthDateBox.getSelectedItem());
        if(genderF.isSelected())
        {
            gender = 'F';
        }
        else{
            gender = 'M';
        }
    }                                                 
    
    private void birthMonthBoxItemStateChanged(java.awt.event.ItemEvent evt) {                                               
        updateDaysList();
    }                                              

    private void birthYearBoxItemStateChanged(java.awt.event.ItemEvent evt) {                                              
        updateDaysList();
    }                                             
    
    


    // Variables declaration - do not modify                     
    private javax.swing.JLabel DOBLable;
//    private javax.swing.JButton addPaperButton;
    private javax.swing.JComboBox<Integer> birthDateBox;
    private javax.swing.JComboBox<Integer> birthMonthBox;
    private javax.swing.JComboBox<Integer> birthYearBox;
    private javax.swing.JButton changePictureButton;
    private javax.swing.JLabel dayLable;
    private javax.swing.JTextField firstNameField;
    private javax.swing.JLabel firstNameLable;
    private javax.swing.JRadioButton genderF;
    private javax.swing.ButtonGroup genderGroup;
    private javax.swing.JLabel genderLable;
    private javax.swing.JRadioButton genderM;
    private javax.swing.JTextField lastNameField;
    private javax.swing.JLabel lastNameLable;
    private javax.swing.JLabel monthLable;
    private javax.swing.JButton saveChangesButton;
//    private javax.swing.JButton selectedPaperButton;
    private javax.swing.JLabel studentDetailsLable;
    private javax.swing.JTextField studentIDField;
    private javax.swing.JLabel studentIDLable;
    private javax.swing.JLabel studentPhotoCanvas;
    private javax.swing.JLabel yearLable;
    
//        public void initComponents() {
//            this.setBackground(Color.red);
//            this.setSize(300, 200);
//            GroupLayout layout = new GroupLayout(this);
//            this.setLayout(layout);
//            
//            studentIDField = new JTextField();
//            this.add(studentIDField);
//            studentIDField.setLocation(10,20);
//            studentIDField.setSize(50,20);
//            
//            firstNameField = new JTextField();
//            this.add(firstNameField);
//            firstNameField.setLocation(70,20);
//            firstNameField.setSize(50,20);
//            
//            lastNameField = new JTextField();
//            this.add(lastNameField);
//            lastNameField.setLocation(130,20);
//            lastNameField.setSize(50,20);
//            
//            initYearList();
//            initMonthList();
//            initDaysList();
//            this.add(birthDateBox);
//            birthDateBox.setLocation(10, 50);
//            this.add(birthMonthBox);
//            birthDateBox.setLocation(50, 50);
//            this.add(birthYearBox);
//            birthDateBox.setLocation(90, 50);
////            studentInfoPanel.add(genderM);
////            studentInfoPanel.add(genderF);
//            this.revalidate();
//            
//            
//            
//            
//            
//        }
    }
}
