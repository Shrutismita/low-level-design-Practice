package designGoogleDoc.impl;
import designGoogleDoc.util.Document;
import designGoogleDoc.util.User;

public class CursorPositionObserver implements DocumentObserver {
    private User user;

    public CursorPositionObserver(User user) {
        this.user = user;
    }

    @Override
    public void updateCursorInitialPosition(Document document) {
       // Update cursor position for the user
       System.out.println("Cursor position updated for user " + user.getUsername() + ": " + document.getCursorPosition(user));
       
        
    }

    

}
