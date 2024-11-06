package designGoogleDoc.impl;

public interface Proxy <T extends PermissionUser> {
    boolean hasAccess(String user);
    void doAction(T permissionUser);
}
