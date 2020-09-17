package ovh.piwowarczyk.votr.api.v1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import ovh.piwowarczyk.votr.model.Vote;
import ovh.piwowarczyk.votr.services.VoteService;

import java.util.List;


@RestController
@RequestMapping("api/v1/votes")
public class VoteController {
    Logger logger = LoggerFactory.getLogger(VoteController.class);


    @Autowired
    private VoteService voteService;

    @GetMapping("survey/{surveyId}")
    @CrossOrigin
    public List<Vote> getVotesForSurvey(@PathVariable Long surveyId){
        logger.info("Searching for votes assigned to survey " + surveyId);
        return voteService.getVotesForSurveyId(surveyId);
    }

    @PostMapping(consumes = "application/json")
    @CrossOrigin
    public String addVote(@RequestBody Vote vote){
//        logger.info("received Answer list size: " + vote.getAnswers().size());
        Vote addedVote = voteService.createNew(vote);
//        logger.info("saved Answer list size: " + addedVote.getAnswers().size());
        return "{\"HASHED_IDENTIFIER\": \"" + addedVote.getHashedIdentifier() + "\"}";
    }

    @GetMapping("{hash}")
    @CrossOrigin
    public Vote getVoteForHash(@PathVariable String hash){
        Vote vote = voteService.getVoteForHashedIdentifier(hash);
        if(vote.getHashedIdentifier()==null || vote.getHashedIdentifier().isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Hash conflict found - POSSIBLE UNWANTED DATABASE MANIPULATION!");
        }
        return vote;
    }
}
