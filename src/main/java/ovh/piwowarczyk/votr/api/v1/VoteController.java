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


/**
 * <p>Kontroler REST dla obiektów klasy {@link Vote}</p>
 *
 * @author jpiwowarczyk
 */
@RestController
@RequestMapping("api/v1/votes")
public class VoteController {
    Logger logger = LoggerFactory.getLogger(VoteController.class);


    @Autowired
    private VoteService voteService;

    /**
     * <p>Endpoint zwracający listę głosów dla danej ankiety</p>
     *
     * @param surveyId {@link Long}
     * @return {@link List}
     */
    @GetMapping("survey/{surveyId}")
    @CrossOrigin
    public List<Vote> getVotesForSurvey(@PathVariable Long surveyId){
        logger.info("Searching for votes assigned to survey " + surveyId);
        return voteService.getVotesForSurveyId(surveyId);
    }

    /**
     * <p>Endpoint zapisujący głosy w BD</p>
     *
     * @param vote {@link Vote}
     * @return {@link String}
     */
    @PostMapping(consumes = "application/json")
    @CrossOrigin
    public String addVote(@RequestBody Vote vote){
//        logger.info("received Answer list size: " + vote.getAnswers().size());
        Vote addedVote = voteService.createNew(vote);
//        logger.info("saved Answer list size: " + addedVote.getAnswers().size());
        return "{\"HASHED_IDENTIFIER\": \"" + addedVote.getHashedIdentifier() + "\"}";
    }

    /**
     * <p>Endpoint zwracający głos dla zadanego hasza</p>
     *
     * @param hash {@link String}
     * @return {@link Vote}
     */
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
