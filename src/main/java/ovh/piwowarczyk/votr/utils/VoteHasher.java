package ovh.piwowarczyk.votr.utils;


import com.google.common.hash.Hashing;
import ovh.piwowarczyk.votr.model.Answer;
import ovh.piwowarczyk.votr.model.Vote;

import java.nio.charset.StandardCharsets;

public class VoteHasher {

    public static String hashVote(Vote vote){

        StringBuilder builder = new StringBuilder();
        builder.append(vote.getVoteID())
                .append(vote.getSurvey().getId())
                .append(vote.getDate());
        for(Answer answer : vote.getAnswers()){
            builder.append(answer.getId())
                    .append(answer.getOption().getId());
        }
        String sha256hex = Hashing.sha256()
                .hashString(builder.toString(), StandardCharsets.UTF_8)
                .toString();

        return sha256hex;
    }

}
