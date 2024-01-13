import {Person} from "./Person";

export interface Player extends Person{
  id: number;
  position: string;
  nationality: string
}
