package designGoogleDoc.impl;
import designGoogleDoc.util.TextEditor;

public class DeleteTextCommand implements TextEditorCommand {
    private String text;
    private int startPosition;
    private int endPosition;
    public DeleteTextCommand(String text, int startPosition, int endPosition) {
        this.text = text;
        this.startPosition = startPosition;
        this.endPosition = endPosition;
    }
    @Override
    public void execute(TextEditor editor) {
        editor.deleteText(text, startPosition, endPosition);
    }

}
