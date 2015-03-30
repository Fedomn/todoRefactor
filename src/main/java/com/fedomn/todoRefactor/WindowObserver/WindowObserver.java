package com.fedomn.todoRefactor.WindowObserver;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Observable;
import java.util.Observer;

public class WindowObserver implements Observer{

    private TextField startField;
    private TextField endField;
    private TextField lengthField;
    private Subject subject;

    public void init() {
        JFrame f = new JFrame("Observer Test");
        f.setSize(500, 300);
        Container content = f.getContentPane();
        content.setBackground(Color.white);
        content.setLayout(new FlowLayout());

        startField = new TextField("0", 10);
        endField = new TextField("0", 10);
        lengthField = new TextField("0", 10);
        SymFocus listener = new SymFocus();
        startField.addFocusListener(listener);
        endField.addFocusListener(listener);
        lengthField.addFocusListener(listener);

        Label startLabel = new Label("start:");
        Label endLabel = new Label("end:");
        Label lengthLabel = new Label("length:");
        content.add(startLabel);
        content.add(startField);
        content.add(endLabel);
        content.add(endField);
        content.add(lengthLabel);
        content.add(lengthField);

        f.setLocationRelativeTo(null);
        f.setVisible(true);

        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        subject = new Subject();
        subject.addObserver(this);

    }

    @Override
    public void update(Observable o, Object arg) {
        Subject subject = (Subject)o;
        startField.setText(subject.getStart());
        endField.setText(subject.getEnd());
        lengthField.setText(subject.getLength());
    }

    class SymFocus extends FocusAdapter {
        @Override
        public void focusLost(FocusEvent event) {
            Object object = event.getSource();
            if (object == startField)
                StartFieldFocusLost();
            else if (object == endField)
                EndFieldFocusLost();
            else if (object == lengthField)
                LengthFieldFocusLost();
        }
    }

    void StartFieldFocusLost() {
        String start = startField.getText();
        subject.setStart(isInteger(start) ? start : "0");
        subject.calculateLength();
    }

    void EndFieldFocusLost() {
        String end = endField.getText();
        subject.setEnd(isInteger(end) ? end : "0");
        subject.calculateLength();
    }

    void LengthFieldFocusLost() {
        String length = lengthField.getText();
        subject.setLength(isInteger(length) ? length : "0");
        subject.calculateEnd();
    }

    boolean isInteger(String str) {
        return str != null && str.matches("[0-9]+");
    }

}
