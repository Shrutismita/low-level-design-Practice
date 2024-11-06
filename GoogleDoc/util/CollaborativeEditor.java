package designGoogleDoc.util;

import designGoogleDoc.impl.DocumentState;

public class CollaborativeEditor {
    private Document document;

    public CollaborativeEditor(Document document) {
        this.document = document;
    }

    public void addCollaborator(User user) {
        document.addCollaborator(user);
    }

    public void removeCollaborator(User user) {
        document.removeCollaborator(user);
    }

    
    public void addDocument(String newText) {
        document.addDocumet(newText);
    }
    public void editDocument(String newText) {
        document.editDocument(newText);
    }
    public void deleteDocument(String newText) {
        document.deleteDocument(newText);
    }
    
    
}
