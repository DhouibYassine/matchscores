import {Player} from "./Player";
import {Coach} from "./Coach";

export interface Team {
  id: number;
  name: string;
  players: Player[];
  coach: Coach;
}
