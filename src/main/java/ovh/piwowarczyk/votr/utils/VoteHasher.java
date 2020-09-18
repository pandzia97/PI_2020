package ovh.piwowarczyk.votr.utils;


import com.google.common.hash.Hashing;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ovh.piwowarczyk.votr.model.Answer;
import ovh.piwowarczyk.votr.model.Vote;
import ovh.piwowarczyk.votr.services.HibernateVoteService;

import java.nio.charset.StandardCharsets;

/**
 * <p>Klasa udostępniająca metodę haszującą dla obiektów klasy {@link Vote}</p>
 *
 * @author jpiwowarczyk
 */
public class VoteHasher {

    static Logger logger = LoggerFactory.getLogger(HibernateVoteService.class);

    /**
     * <p>Metoda haszująca obiekt {@link Vote}</p>
     *
     * @param vote obiekt {@link Vote} do zhaszowania.
     * @return Identyfikator heksadecymalny wygenerowany dla obiektu klasy ({@link String}).
     */
    public static String hashVote(Vote vote){

        StringBuilder builder = new StringBuilder();
        builder.append(vote.getVoteID().toString())
                .append(vote.getSurvey().getId())
                .append(vote.getDate().getTime());
        for(Answer answer : vote.getAnswers()){
            builder.append(answer.getId().toString())
                    .append(answer.getQuestion().getQuestion())
                    .append(answer.getOption().getValue())
                    .append(answer.getOption().getId().toString());
        }

        String stringToHash = builder.toString();
        logger.info("Hashing values: " + stringToHash);
        String sha256hex = Hashing.sha256()
                .hashString(stringToHash, StandardCharsets.UTF_8)
                .toString();

        return sha256hex;
    }

}
