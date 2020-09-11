import {Component, Input, OnInit} from '@angular/core';
import {Option} from "./option";
import {faEdit} from "@fortawesome/free-solid-svg-icons/faEdit";
import {faCheck} from "@fortawesome/free-solid-svg-icons/faCheck";
import {faTimes} from "@fortawesome/free-solid-svg-icons/faTimes";

@Component({
  selector: 'app-option',
  templateUrl: './option.component.html',
  styleUrls: ['./option.component.css']
})
export class OptionComponent implements OnInit {

  @Input()
  option: Option;
  editEnabled: boolean = true;
  faTimes = faTimes;
  faCheck = faCheck;
  faEdit = faEdit;

  constructor() {

  }


  ngOnInit(): void {
  }

  enableEdit() {
    if (this.editEnabled == false) {
      this.editEnabled = true;
    }
  }

  accept(value: string) {
    if (this.editEnabled == true) {
      this.option.value = value;
      this.editEnabled = false;
    }
  }

  discard() {
    if (this.editEnabled == true) {
      this.editEnabled = false;
    }
  }
}

