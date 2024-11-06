package designGoogleDoc.impl;
import designGoogleDoc.util.TextEditor;

public class InsertTextCommand implements TextEditorCommand {
    private String text;
    private int position;
    public InsertTextCommand(String text, int position) {
        this.text = text;
        this.position = position;
    }
    @Override
    public void execute(TextEditor editor) {
        editor.insertText(text, position);
    }
   

}
