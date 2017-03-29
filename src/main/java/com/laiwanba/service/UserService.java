package com.laiwanba.service;

import com.laiwanba.dto.EqibaResult;
import com.laiwanba.entity.User;
import com.laiwanba.exception.*;

/**
 * Created by chunmiao on 17-3-28.
 */
public interface UserService {
    public EqibaResult<Integer> registerService(User user);

    public User loginInService (User loginUser) throws EmptyObjectErrorException,
            CannotFindUserException,
            SystemErrorException,
            ObjectCannotMatchException,
            StatusWrongException,
            UpdateDataBaseException;

    public int loginOutService(User loginOutUser) throws StatusWrongException,
    UpdateDataBaseException;
}
