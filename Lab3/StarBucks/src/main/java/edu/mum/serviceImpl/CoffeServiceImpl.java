package edu.mum.serviceImpl;

import edu.mum.dao.DAO;
import edu.mum.domain.Coffee;
import edu.mum.service.CoffeService;
import org.springframework.stereotype.Service;

@Service
public class CoffeServiceImpl implements CoffeService {
    public Coffee findBreed(String roast) {
        DAO dao = new DAO();
        dao.setDb_name("star_bucks");
        dao.setDb_collection("coffee");
        return dao.findBreed(roast);
    }

    public String[] findRoast() {
        System.out.println("inside find roast");
        DAO dao = new DAO();
        dao.setDb_name("star_bucks");
        dao.setDb_collection("coffe");
        return dao.findRoast();
    }
}
