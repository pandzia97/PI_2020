export class Option {
    id: number;
    value: String;


  constructor(id?: number, value?: String) {
    this.id = id;
    this.value = value ? value : "Podaj odpowiedź";

  }
}

