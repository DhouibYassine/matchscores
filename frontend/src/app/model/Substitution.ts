import {Player} from "./Player";

export interface Substitution {
  id: number;
  playerIn: Player;
  playerOut: Player;
  minute: number;
}
