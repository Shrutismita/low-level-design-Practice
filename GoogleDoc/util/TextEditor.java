package designGoogleDoc.util;

import designGoogleDoc.impl.TextEditorCommand;

public class TextEditor {
    private String documentText;
        private TextEditorCommand insertTextCommand;
    
        public TextEditor(String initialText) {
            this.documentText = initialText;
        }
    
        public void insertText(String text, int position) {
            StringBuilder newDocumentText = new StringBuilder(documentText);
            newDocumentText.insert(position, text);
            documentText = newDocumentText.toString();
            System.out.println("Inserted text: " + text);
            System.out.println("After Inserted new text is:"+documentText);
        }
    
        public void deleteText(String text, int startPosition, int endPosition) {
            StringBuilder newDocumentText = new StringBuilder(documentText);
            newDocumentText.delete(startPosition, endPosition);
            documentText = newDocumentText.toString();
            System.out.println("Deleted text: " + text);
            System.out.println("After deleted new text is:"+documentText);
        }
    
        public void formatText(String text, String format) {
            // Implement logic for formatting text
            System.out.println("Formatted text: " + text + " with format: " + format);
        }
    
        public String getDocumentText() {
            return documentText;
        }
    
        public void executeCommand(TextEditorCommand insertTextCommand) {        
                this.insertTextCommand = insertTextCommand;      
    }
}
