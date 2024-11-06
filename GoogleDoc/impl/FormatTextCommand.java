package designGoogleDoc.impl;
import designGoogleDoc.util.TextEditor;

public class FormatTextCommand implements TextEditorCommand {
    private String text;
    private String format;
    public FormatTextCommand(String text, String format) {
        this.text = text;
        this.format = format;
    }
    @Override
    public void execute(TextEditor editor) {
        editor.formatText(text, format);
    }


}
