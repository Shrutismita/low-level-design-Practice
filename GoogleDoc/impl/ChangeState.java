package designGoogleDoc.impl;

import designGoogleDoc.util.Document;

public class ChangeState implements DocumentState {
   
    @Override
    public void AddContext(Document document) {
        System.out.println("User is adding new Context in document.");
    }

    @Override
    public void EditContext(Document context) {
        System.out.println("User is editing Context in document.");
    }

    @Override
    public void DeleteContext(Document context) {
        System.out.println("User is deleting Context in document.");
    }

}
