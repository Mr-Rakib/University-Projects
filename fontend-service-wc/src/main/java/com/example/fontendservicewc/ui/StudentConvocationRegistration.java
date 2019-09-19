package com.example.fontendservicewc.ui;

import com.example.fontendservicewc.model.Grade;
import com.example.fontendservicewc.model.RegistrationConvocation;
import com.example.fontendservicewc.service.StudentService;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.converter.StringToLongConverter;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.time.temporal.ChronoUnit.DAYS;

@Route(value = "student/convocation")
public class StudentConvocationRegistration extends VerticalLayout{


    private StudentService studentService;
    private Binder<RegistrationConvocation> registrationConvocationBinder;

    Image image;

///Initialize all Layouts

    FormLayout formLayout = new FormLayout();
    HorizontalLayout horizontalLayout = new HorizontalLayout();
    VerticalLayout setButtonField = new VerticalLayout();
    HorizontalLayout setInfo = new HorizontalLayout();



    public StudentConvocationRegistration( StudentService studentService) {

//-----------------------------------------------------initialization-------------------------------------------------------------------

        this.studentService = studentService;
        image = new Image();
        registrationConvocationBinder = new Binder<>();


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
        image.setMaxWidth("1000px");




        //----------------------------------------------set all i form----------------------------------------------//

        List<String> programList = new ArrayList<>();
        programList.add("BSc in CSE");
        programList.add("BSc in EEE");
        programList.add("BSc in BBA");


        TextField idField = new TextField("Student ID");
        idField.setValue(userIdLabel.getText());
        idField.setReadOnly(true);

        TextField totalCredit = new TextField("Credit Hour");
        totalCredit.setValue(creditShowLabel.getText());
        totalCredit.setReadOnly(true);
        TextField gpaField = new TextField("Cgpa");
        gpaField.setValue(cGpaShowLabel.getText());
        gpaField.setReadOnly(true);

        ComboBox programCombobox = new ComboBox("Program Name",programList);


        Label convocationLabel = new Label("Register For Convocation");
        TextField feesField = new TextField("Paid Amount");
        TextField referenceField = new TextField("Reference Code");

        Button convocationRegisterSubmitButton = new Button("Register");
        convocationRegisterSubmitButton.setIcon(VaadinIcon.BUTTON.create());




        formLayout.add(convocationLabel,idField,programCombobox,gpaField,totalCredit,feesField,referenceField,convocationRegisterSubmitButton);


        setInfo.add(dashboard,courseRegistrationButton,convocationRegistrationButton);
        setInfo.add(creditLabel,creditShowLabel,cGpaLabel,cGpaShowLabel,userLabel, userIdLabel,logout);
        horizontalLayout.add(setInfo);
        // formLayout.add(studentGrade);
        add(image,horizontalLayout,formLayout);

//--------------------------------------------code part----------------------------------------------------------------------------






//-----------------------------------------Buttons Functionality----------------------------------------------------------

        convocationRegistrationButton.addClickListener(event->
                UI.getCurrent().navigate("student/convocation")
        );
        dashboard.addClickListener(event->
                UI.getCurrent().navigate("student")
        );
        convocationRegisterSubmitButton.addClickListener(e -> {


            Long studentId = Long.parseLong(idField.getValue());
            String programName = (String) programCombobox.getValue();
            float cgpa = Float.parseFloat(gpaField.getValue());
            int credit = Integer.parseInt(totalCredit.getValue());

            float amount = Float.parseFloat(feesField.getValue());
            String referenceCode = referenceField.getValue();


            RegistrationConvocation reg = new RegistrationConvocation(studentId,programName,credit,cgpa,amount,referenceCode);
            studentService.RegisterForConvocation(reg);

        });

    }


}
