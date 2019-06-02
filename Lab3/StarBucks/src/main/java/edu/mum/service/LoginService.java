package edu.mum.service;

import edu.mum.domain.User;

public interface LoginService {
    public User getUser(String userName, String password);
}
