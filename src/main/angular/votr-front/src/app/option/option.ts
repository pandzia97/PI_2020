export class Option {
    id: number;

    answer: String;


  constructor(id?: number, answer?: String) {
    this.id = id;
    this.answer = answer ? answer : "Podaj odpowiedź";

  }
}

