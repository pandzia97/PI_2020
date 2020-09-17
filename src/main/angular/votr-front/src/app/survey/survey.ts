import {Question} from "../question/question";

export class Survey {
    public questions: Array<Question>;
    public name: String = "nazwa ankiety";
    public id: number;
    public active: boolean;
    public finished: boolean;

    constructor(questions?: Array<Question>, name?: String, id?: number, active?: boolean, finished?: boolean) {
        this.questions = questions ? questions: [];
        this.name = name ? name: "Podaj nazwę ankiety";
        this.id = id;
        this.active = active ? active: false;
        this.finished = finished ? finished: false;
    }
}
