package web.dao;

import org.springframework.stereotype.Component;
import web.model.User;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserDAO {
    private static int USER_COUNT;
    private List<User>  users;

    {
        users = new ArrayList<>();

        users.add(new User(++USER_COUNT,"",0));
        users.add(new User(++USER_COUNT,"",0));
        users.add(new User(++USER_COUNT,"",0));
        users.add(new User(++USER_COUNT,"",0));
    }

    public List<User> index(){
        return  users;
    }

    public User show(int id){
        return users.stream().filter(allUsers -> allUsers.getId() == id).findAny().orElse(null);
    }

    public void save(User user){
        user.setId(++USER_COUNT);
        users.add(user);
    }

    public void update(int id, User updatedUser) {
        User userToBeUpdated = show(id);
        userToBeUpdated.setName(updatedUser.getName());

        //userToBeUpdated.getAge(updatedUser.getAge());
    }
    public void delete(int id) {
        users.removeIf(p -> p.getId() == id);
    }
}
