package ovh.piwowarczyk.votr.api.v1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class ApiStatus {
    @GetMapping("/status")
    public String statusDisplay(){
        return "API Active";
    }
}
