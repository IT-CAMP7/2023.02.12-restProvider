package pl.camp.it.rest.provider;

import pl.camp.it.rest.provider.model.User;

import java.util.ArrayList;
import java.util.List;

public class UsersListResponse {
    private List<User> users = new ArrayList<>();

    public List<User> getUsers() {
        return users;
    }
}
