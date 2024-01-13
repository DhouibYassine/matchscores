import {Player} from "./Player";

export interface Goal {
  id: number;
  scorer: Player;
  minute: number;
}
