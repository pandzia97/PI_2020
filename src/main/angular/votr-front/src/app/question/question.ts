import {Option} from "../option/option";


export class Question {

    id: number;
    question: String;
    options: Array<Option>;


  constructor(id?: number, question?: String, options?: Array<Option>) {
    this.id = id;
    this.question = question ? question: "Podaj treść pytania";
    this.options = options ? options: [];
  }


}
