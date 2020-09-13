package ovh.piwowarczyk.votr.api.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ovh.piwowarczyk.votr.model.Survey;
import ovh.piwowarczyk.votr.model.Vote;
import ovh.piwowarczyk.votr.services.VoteService;

import java.util.List;

@RestController
@RequestMapping("api/v1/votes")
public class VoteController {

    @Autowired
    private VoteService voteService;

    @GetMapping("survey/{id}")
    @CrossOrigin
    public List<Vote> getVotesForSurvey(Long surveyId){
        return voteService.getVotesForSurveyId(surveyId);
    }

    @PostMapping
    @CrossOrigin
    public String addVote(@RequestBody Vote vote){
        Vote addedVote = voteService.createNew(vote);
        return "{\"HASHED_IDENTIFIER\": \"" + addedVote.getHashedIdentifier() + "\"}";
    }

    @GetMapping("{hash}")
    @CrossOrigin
    public Vote getVoteForHash(@PathVariable String hash){
        return voteService.getVoteForHashedIdentifier(hash);
    }
}
