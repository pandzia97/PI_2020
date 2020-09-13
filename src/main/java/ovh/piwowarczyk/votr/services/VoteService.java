package ovh.piwowarczyk.votr.services;

import ovh.piwowarczyk.votr.model.Survey;
import ovh.piwowarczyk.votr.model.Vote;

import java.util.List;

public interface VoteService {
    Vote createNew(Vote vote);
    void updateExisting(Vote vote);
    List<Vote> getVotesForSurveyId(Long surveyId);
    Vote getVoteForHashedIdentifier(String hashedIdentifier);
}
