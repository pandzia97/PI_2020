package ovh.piwowarczyk.votr.api.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ovh.piwowarczyk.votr.model.Survey;
import ovh.piwowarczyk.votr.services.SurveyService;

import java.util.List;

@RestController
@RequestMapping("api/v1/surveys")
public class SurveyController {

    @Autowired
    private SurveyService surveyService;

    @GetMapping
    @CrossOrigin
    public List<Survey> getAllSurveys() {
        return surveyService.getAllSurveys();
    }

    @PostMapping
    @CrossOrigin
    public String createSurvey(@RequestBody Survey survey){
        surveyService.createNew(survey);
        return "{\"result\": \"survey " + survey.getId() + " created successfully\"}";
    }

    @PutMapping("{surveyId}")
    @CrossOrigin
    public String updateSurvey(@RequestBody Survey survey,@PathVariable long surveyId){
        if(surveyId == survey.getId()) {
            surveyService.updateExisting(survey);
            return "{\"result\": \"survey " + survey.getId() + " updated successfully\"}";
        }
        return "{\"error\":\"Malformed request\"}";
    }
}
