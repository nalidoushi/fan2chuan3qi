package exec.service;

import exec.domain.User;
import exec.exception.MsgException;

public interface UserService {
    public void regist(User user) throws MsgException;
}
