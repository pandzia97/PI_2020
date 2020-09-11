import {Option} from "../option/option";


export class Question {

    id: number;
    value: String;
    answers: Array<Option>;


  constructor(id?: number, value?: String, answers?: Array<Option>) {
    this.id = id;
    this.value = value ? value: "Podaj treść pytania";
    this.answers = answers ? answers: [];
  }


}
