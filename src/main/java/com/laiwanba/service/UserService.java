package com.laiwanba.service;

import com.laiwanba.dto.EqibaResult;
import com.laiwanba.entity.User;

/**
 * Created by chunmiao on 17-3-28.
 */
public interface UserService {
    public EqibaResult<Integer> registerService(User user);
}
