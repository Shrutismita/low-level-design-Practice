package designGoogleDoc.impl;

import designGoogleDoc.util.Document;

public interface DocumentObserver {
    void updateCursorInitialPosition(Document document);
}
