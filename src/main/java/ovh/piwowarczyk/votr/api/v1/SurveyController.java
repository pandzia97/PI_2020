package ovh.piwowarczyk.votr.api.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ovh.piwowarczyk.votr.model.Survey;
import ovh.piwowarczyk.votr.services.SurveyService;

import java.util.List;

/**
 * <p>Kontroler REST dla obiektów klasy {@link Survey}</p>
 *
 * @author jpiwowarczyk
 */
@RestController
@RequestMapping("api/v1/surveys")
public class SurveyController {

    @Autowired
    private SurveyService surveyService;

    /**
     * <p>Endpoint zwracający listę ankiet</p>
     *
     * @return {@link List}
     */
    @GetMapping
    @CrossOrigin
    public List<Survey> getAllSurveys() {
        return surveyService.getAllSurveys();
    }

    /**
     * <p>Endpoint zwracający pojedynczą ankietę dla zadanego id</p>
     *
     * @param surveyId long.
     * @return {@link Survey}
     */
    @GetMapping("{surveyId}")
    @CrossOrigin
    public Survey getSurvey(@PathVariable long surveyId){
        return surveyService.getSurveyForId(surveyId);
    }

    /**
     * <p>Endpoint zapisujący ankietę do BD</p>
     *
     * @param survey {@link Survey}
     * @return {@link String}
     */
    @PostMapping
    @CrossOrigin
    public String createSurvey(@RequestBody Survey survey){
        surveyService.createNew(survey);
        return "{\"result\": \"survey " + survey.getId() + " created successfully\"}";
    }
}
