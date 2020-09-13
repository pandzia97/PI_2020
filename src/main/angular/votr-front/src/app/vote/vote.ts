import {Survey} from "../survey/survey";
import {Answer} from "../answer/answer";

export class Vote {
    id: number;
    survey: Survey;
    hashedIdentifier: String;
    date: Date;
    answers: Array<Answer>;


    constructor(id?: number, survey?: Survey, hashedIdentifier?: String, date?: Date, answers?: Array<Answer>) {
        this.id = id;
        this.survey = survey;
        this.hashedIdentifier = hashedIdentifier;
        this.date = date;
        this.answers = answers ? answers : [];

    }

}
