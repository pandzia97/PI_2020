package ovh.piwowarczyk.votr.api.v1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>Kontroler REST dla do testowania działania api</p>
 *
 * @author jpiwowarczyk
 */
@RestController
@RequestMapping("api/v1")
public class ApiStatus {
    /**
     * <p>Endpoint zwraca stałą wartość "API Active" - do testowania dostępności API</p>
     *
     * @return {@link String}
     */
    @GetMapping("/status")
    public String statusDisplay(){
        return "API Active";
    }
}
