package edu.mum.serviceImpl;

import edu.mum.dao.DAO;
import edu.mum.domain.User;
import edu.mum.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    public User getUser(String userName, String password) {
        DAO dao = new DAO();
        dao.setDb_name("star_bucks");
        dao.setDb_collection("users");
        return dao.findUser(userName, password);
    }

    public void getAllUsers(){
        DAO dao = new DAO();
        dao.setDb_name("star_bucks");
        dao.setDb_collection("users");

        dao.getAll();
    }
}
