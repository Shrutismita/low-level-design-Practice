package designGoogleDoc.util;

import java.util.Arrays;

import designGoogleDoc.impl.DeleteTextCommand;
import designGoogleDoc.impl.FormatTextCommand;
import designGoogleDoc.impl.InsertTextCommand;
import designGoogleDoc.impl.PermissionUser;
import designGoogleDoc.impl.PermissionUserImp;
import designGoogleDoc.impl.TextEditorCommand;

public class RealTimeCollaborativeEditor {
    public static void main(String[] args) {
        // Create users
        User user1 = new User("user1");
        User user2 = new User("user2");

        // Create a document
        Document document = new Document();

        // Create a collaborative editor
        CollaborativeEditor collaborativeEditor = new CollaborativeEditor(document);

        // Add collaborators to the document
        collaborativeEditor.addCollaborator(user1);
        collaborativeEditor.addCollaborator(user2);

        // Add Context in the document
        collaborativeEditor.addDocument("\"This is the add document content.");

        // Update cursor position for user1
        document.updateCursorPosition(user1, 10);
         // Edit And Delete the document
        collaborativeEditor.editDocument("This is the edited document content.");
        collaborativeEditor.deleteDocument("This is the deleted document content.");
        // Update cursor position for user2
        document.updateCursorPosition(user2, 15);
        // Edit the document
        collaborativeEditor.editDocument("This is the edited document content.");
        collaborativeEditor.deleteDocument("This is the deleted document content.");


        //Create concrete commands
        TextEditor editor = new TextEditor("This is the initial text.");
        TextEditorCommand insertTextCommand = new InsertTextCommand("new city, ", 5);
        TextEditorCommand deleteTextCommand = new DeleteTextCommand("delete", 12, 16);
        TextEditorCommand formatTextCommand = new FormatTextCommand("lld practice,", "bold");

        editor.executeCommand(insertTextCommand);
        editor.insertText("new city, ", 5);
        editor.executeCommand(deleteTextCommand);
        editor.deleteText("delete", 12, 16);
        editor.executeCommand(formatTextCommand);
        editor.formatText("lld practice,", "bold");
        
        System.out.println("Current document text is : " + editor.getDocumentText());
        
        PermissionUser realObject = new PermissionUserImp();
        AccessControlProxy<PermissionUser> proxy = new AccessControlProxy<>(realObject, Arrays.asList("user"));

        proxy.doAction(realObject); // Admin can access
        
    }
}
