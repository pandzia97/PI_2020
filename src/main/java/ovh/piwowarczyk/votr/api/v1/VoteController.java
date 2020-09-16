package ovh.piwowarczyk.votr.api.v1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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
        return voteService.getVotesForSurveyId(surveyId);
    }

    @PostMapping
    @CrossOrigin
    public String addVote(@RequestBody Vote vote){
        logger.info("received Answer list size: " + vote.getAnswers().size());
        Vote addedVote = voteService.createNew(vote);
        logger.info("saved Answer list size: " + addedVote.getAnswers().size());
        return "{\"HASHED_IDENTIFIER\": \"" + addedVote.getHashedIdentifier() + "\"}";
    }

    @GetMapping("{hash}")
    @CrossOrigin
    public Vote getVoteForHash(@PathVariable String hash){
        return voteService.getVoteForHashedIdentifier(hash);
    }
}
