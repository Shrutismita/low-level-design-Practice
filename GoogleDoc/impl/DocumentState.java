package designGoogleDoc.impl;

import designGoogleDoc.util.Document;

public interface DocumentState {
    void AddContext(Document document);
    void EditContext(Document context);
    void DeleteContext(Document context);
    
} 
