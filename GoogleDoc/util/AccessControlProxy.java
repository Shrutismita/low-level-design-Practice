package designGoogleDoc.util;

import java.util.List;

import designGoogleDoc.impl.PermissionUser;
import designGoogleDoc.impl.Proxy;

public class AccessControlProxy <T extends PermissionUser> implements Proxy<T>{

    private final T permissionUser;
    private final List<String> allowedUsers;
    
    public AccessControlProxy(T permissionUser, List<String> allowedUsers) {
        this.permissionUser = permissionUser;
        this.allowedUsers = allowedUsers;
    }

    @Override
    public boolean hasAccess(String user) {
        return allowedUsers.contains(user);
    }

    @Override
    public void doAction(T permissionUser) {
        if (hasAccess("admin")) {
            permissionUser.permissionUser();
        } else {
            System.out.println("Access denied");
        }
    }

}
