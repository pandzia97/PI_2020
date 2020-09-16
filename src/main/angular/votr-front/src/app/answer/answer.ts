import {Vote} from "../vote/vote";
import {Question} from "../question/question";
import {Option} from "../option/option";

export class Answer {
    id: number;
    vote: Vote;
    question: Question;
    option: Option;


  constructor(id?: number, vote?: Vote, question?: Question, option?: Option) {
    this.id = id;
    this.vote = vote;
    this.question = question;
    this.option = option;
  }
}
