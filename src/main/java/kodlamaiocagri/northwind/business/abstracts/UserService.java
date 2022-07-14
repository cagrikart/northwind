package kodlamaiocagri.northwind.business.abstracts;

import kodlamaiocagri.northwind.core.entities.User;
import kodlamaiocagri.northwind.core.utilities.results.DataResults;
import kodlamaiocagri.northwind.core.utilities.results.Results;
import org.springframework.stereotype.Service;

public interface UserService {
    Results add(User user);
    DataResults<User> findByEmail(String email);
}
