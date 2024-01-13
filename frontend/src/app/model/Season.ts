import {League} from "./League";

export interface Season {
  id: number;
  startingDate: Date;
  endingDate: Date;
  league: League
}
