package dev.rosen.Daos;

import dev.rosen.Model.Users;

import java.util.List;

public interface UsersDAO {



    interface UsersDAO {

        Users createUser(Users users);



        //Read
        Users getUserById(int id);
        List<Users> getALLUsers();

        //Update
        Users updateUsers(Users users);


        //delete
        void deleteUserByid(int id);





    }

}
