package ovh.piwowarczyk.votr.api.v1;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/auth")
public class Auth {
    @PostMapping("/register")
    public String registerNewUser(String payload){
        return "result";
    }

}
