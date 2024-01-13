import {Team} from "./Team";
import {Goal} from "./Goal";
import {Refree} from "./Refree";
import {Stadium} from "./Stadium";

export interface Match {
  id: number;
  date: Date;
  homeTeam: Team;
  awayTeam: Team;
  goals: Goal[];
  refree: Refree;
  stadium: Stadium;
  spectator: number;
}
