package kodlamaiocagri.northwind.business.concretes;

import kodlamaiocagri.northwind.business.abstracts.UserService;
import kodlamaiocagri.northwind.core.dataAccess.UserDao;
import kodlamaiocagri.northwind.core.entities.User;
import kodlamaiocagri.northwind.core.utilities.results.DataResults;
import kodlamaiocagri.northwind.core.utilities.results.Results;
import kodlamaiocagri.northwind.core.utilities.results.SuccessDataResult;
import kodlamaiocagri.northwind.core.utilities.results.SuccessResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserManager implements UserService {
    private UserDao userDao;

    @Autowired
    public UserManager(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public Results add(User user) {
        this.userDao.save(user);
        return new SuccessResult("kullanıcı  eklendi");
    }

    @Override
    public DataResults<User> findByEmail(String email) {
        return new SuccessDataResult<User>(this.userDao.findByEmail(email),"kullanıcı listelendi ");
    }
}
