package kodlamaiocagri.northwind.api.controllers;

import kodlamaiocagri.northwind.business.abstracts.UserService;
import kodlamaiocagri.northwind.core.entities.User;
import kodlamaiocagri.northwind.core.utilities.results.DataResults;
import kodlamaiocagri.northwind.core.utilities.results.ErrorDataResult;
import kodlamaiocagri.northwind.core.utilities.results.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/users")
public class UsersController {

    private UserService userService;

    public UsersController(UserService userService) {
        super();
        this.userService = userService;
    }

    @GetMapping("/getUsers")
    public DataResults<User> findByEmail(String email){
        return this.userService.findByEmail(email);
    }


    @PostMapping(value = "/addUsers")
    public ResponseEntity<?> add (@RequestBody User user) {
        return ResponseEntity.ok(this.userService.add(user));
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions) {
        Map<String,String> validationErrors = new HashMap<String,String>();
        for (FieldError fieldError : exceptions.getBindingResult().getFieldErrors()){
            validationErrors.put(fieldError.getField(),fieldError.getDefaultMessage());
        }
        ErrorDataResult<Object> errors = new ErrorDataResult<Object>(validationErrors);
        return errors;
    }
 }
