package designGoogleDoc.util;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import designGoogleDoc.impl.ChangeState;
import designGoogleDoc.impl.CursorPositionObserver;
import designGoogleDoc.impl.DocumentObserver;
import designGoogleDoc.impl.DocumentState;
import designGoogleDoc.impl.TextEditorCommand;

public class Document {
    private User user;
    private String content;
    private List<User> collaborators;
    private List<String> versionHistory;
    private Map<User, Integer> cursorPositions;
    private List<DocumentObserver> observers;
    private DocumentState currentState;
    
    public Document() {
         this.content = "";
        this.collaborators = new ArrayList<>();
        this.versionHistory = new ArrayList<>();
        this.cursorPositions = new HashMap<>();
        this.observers = new ArrayList<>();
        currentState = new ChangeState();            
    }
    public void setCurrentState(DocumentState currentState) {
        this.currentState = currentState;
    }
    public void addDocumet(String newText) {
        currentState.AddContext(this);
        // Notify observers about the document update
        notifyObservers();
    }

    public void editDocument(String newText) {
        currentState.EditContext(this);
        // Notify observers about the document update
        notifyObservers();
    }

    public void deleteDocument(String newText) {
        
        currentState.DeleteContext(this);

        // Notify observers about the document update
        notifyObservers();
    }
   
    public void addCollaborator(User user) {
        collaborators.add(user);
        cursorPositions.put(user, 0);

        // Add cursor position observer for the new collaborator
        CursorPositionObserver observer = new CursorPositionObserver(user);
        observers.add(observer);
    }
    public void removeCollaborator(User user) {
        collaborators.remove(user);
        cursorPositions.remove(user);

        // Remove cursor position observer for the collaborator
        DocumentObserver observer = new CursorPositionObserver(user);
        observers.remove(observer);
    }

    public void updateCursorPosition(User user, int newPosition) {
       // System.out.println("Cursor position updated for user " + user.getUsername() + ": " + newPosition);
        cursorPositions.put(user, newPosition);
    }

    public int getCursorPosition(User user) {
        return cursorPositions.get(user);
    }

    public void subscribeObserver(DocumentObserver observer) {
        observers.add(observer);
    }

    public void unsubscribeObserver(DocumentObserver observer) {
        observers.remove(observer);
    }

    private void notifyObservers() {
        for (DocumentObserver observer : observers) {
            observer.updateCursorInitialPosition(this);
        }
    }

    
}
