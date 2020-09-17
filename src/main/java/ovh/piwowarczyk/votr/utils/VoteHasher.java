package ovh.piwowarczyk.votr.utils;


import com.google.common.hash.Hashing;
import ovh.piwowarczyk.votr.model.Answer;
import ovh.piwowarczyk.votr.model.Vote;

import java.nio.charset.StandardCharsets;

/**
 * <p>Klasa udostępniająca metodę haszującą dla obiektów klasy {@link Vote}</p>
 *
 * @author jpiwowarczyk
 */
public class VoteHasher {

    /**
     * <p>Metoda haszująca obiekt {@link Vote}</p>
     *
     * @param vote obiekt {@link Vote} do zhaszowania.
     * @return Identyfikator heksadecymalny wygenerowany dla obiektu klasy ({@link String}).
     */
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
