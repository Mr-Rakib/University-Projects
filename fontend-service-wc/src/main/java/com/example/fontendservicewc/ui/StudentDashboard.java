package com.example.fontendservicewc.ui;

import com.example.fontendservicewc.model.Grade;
import com.example.fontendservicewc.service.StudentService;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;

import javax.persistence.Table;
import javax.validation.constraints.Max;
import java.util.ArrayList;
import java.util.List;

@Route(value = "student")
@Theme(value = Lumo.class,variant = Lumo.DARK)
public class StudentDashboard extends VerticalLayout {

    private StudentService studentService;
    Grid<Grade> studentGrade;
    List<Grade> gradeList;
    Grid<Grade> studentGrade1;

    Image image;

///Initialize all Layouts

    FormLayout formLayout = new FormLayout();
    HorizontalLayout horizontalLayout = new HorizontalLayout();
    VerticalLayout verticalLayout = new VerticalLayout();
    HorizontalLayout setInfo = new HorizontalLayout();



    public StudentDashboard( StudentService studentService) {


//-----------------------------------------------------initialization-------------------------------------------------------------------

        this.studentService = studentService;
        gradeList= new ArrayList<>();
        image = new Image();
        studentGrade = new Grid<>();
        studentGrade1 = new Grid<>();

        setStudentResultGrid(studentGrade);
       // setStudentResultGrid(studentGrade1);


        Label userLabel = new Label("USER NAME : ");
        Label userIdLabel = new Label("2016000000009");
        Label creditLabel = new Label("Credit Complete : ");
        Label creditShowLabel = new Label("135");
        Label cGpaLabel = new Label("CGPA : ");
        Label cGpaShowLabel = new Label(" 3.85 ");

        Button dashboard = new Button("Dashboard");
        Button courseRegistrationButton = new Button("Course Registration");
        Button logout = new Button("Logout");
        Button convocationRegistrationButton = new Button("Convocation");

        image.setSrc("https://seu.edu.bd/images/logo_1.png");

        verticalLayout.add(image);
        setInfo.add(dashboard,courseRegistrationButton,convocationRegistrationButton);
        setInfo.add(creditLabel,creditShowLabel,cGpaLabel,cGpaShowLabel,userLabel, userIdLabel,logout);
        horizontalLayout.add(setInfo);
       // formLayout.add(studentGrade);
        add(verticalLayout,horizontalLayout,studentGrade);

//--------------------------------------------code part----------------------------------------------------------------------------



        Long studentId = Long.parseLong(userIdLabel.getText());
        System.out.println(studentId);
        gradeList=studentService.ViewAllGrade(studentId);
        studentGrade.setItems(gradeList);
//-----------------------------------------Buttons Functionality----------------------------------------------------------

        convocationRegistrationButton.addClickListener(event->
                        UI.getCurrent().navigate("student/convocation")
                );
        dashboard.addClickListener(event->
                UI.getCurrent().navigate("student")
        );



    }

    private void setStudentResultGrid(Grid<Grade> studentGrade) {

        this.studentGrade
                .addColumn(Grade::getStudentId)
                .setHeader("Student ID");
        this.studentGrade
                .addColumn(Grade::getCourseCode)
                .setHeader("Course Code");


        this.studentGrade
                .addColumn(Grade::getGrade)
                .setHeader("Grade");
        this.studentGrade
                .addColumn(Grade::getGpa)
                .setHeader("GPA");

        this.studentGrade
                .addColumn(Grade::getSemesterId)
                .setHeader("Semester ID");


    }
}
