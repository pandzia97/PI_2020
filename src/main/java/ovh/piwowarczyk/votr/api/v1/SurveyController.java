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
    public List<Survey> getAllSurveys() {
        return surveyService.getAllSurveys();
    }

    @PostMapping
    public String createSurvey(@RequestBody Survey survey){
        surveyService.createNew(survey);
        return "survey " + survey.getId() + " created successfully";
    }

    @PutMapping("{surveyId}")
    public String udpateSurvey(@RequestBody Survey survey,@PathVariable long surveyId){
        surveyService.updateExisting(survey);
        return "Survey " + surveyId + " updated sucessfully";
    }
}
